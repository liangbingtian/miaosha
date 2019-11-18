package com.yonyou.einvoice.common.metadata.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.interfaces.Compare;
import com.baomidou.mybatisplus.core.conditions.interfaces.Func;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yonyou.einvoice.common.metadata.element.SourceCondition;
import com.yonyou.einvoice.common.metadata.entity.IMetaVO;
import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import com.yonyou.einvoice.common.metadata.visitor.AbstractPermissionVisitor;
import graphql.language.Field;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * 在基础service之上，封装权限service类
 *
 * @param <T> 实体类
 * @param <Q> 实体类对应的Mapper类
 * @author liuqiangm
 */
@Slf4j
public abstract class AbstractMybatisPermissionService<T extends IMetaVO, Q extends IMetaMapper> extends
    AbstractMybatisService<T, Q> implements
    IPermissionCommonService {

  /**
   * 用于保存T类型中属性property -> java中的反射Field映射。 该映射用于通过反射，对java bean对象进行权限字段赋值操作。
   */
  private final Map<String, java.lang.reflect.Field> fieldMap = new ConcurrentHashMap<>();

  @Autowired
  protected ApplicationContext applicationContext;

  /**
   * 重写父类方法。用于在查询条件动态拼接的基础之上，添加权限控制。
   * @param condition
   * @param field
   * @return
   */
  @Override
  public List<T> selectByDynamicCondition(@GraphQLArgument(name = "condition") SourceCondition condition, @GraphQLEnvironment Field field) {
    addPermissionConditions(condition, getPermissionVisitorList(applicationContext));
    return super.selectByDynamicCondition(condition, field);
  }

  /**
   * 重写父类方法。用于在查询条件动态拼接的基础之上，添加权限控制。
   * @param condition
   * @return
   */
  @Override
  public int countAllByDynamicCondition(@GraphQLArgument(name = "condition") SourceCondition condition) {
    addPermissionConditions(condition, getPermissionVisitorList(applicationContext));
    return super.countAllByDynamicCondition(condition);
  }

  /**
   * 插入操作，需要添加访问权限字段的强制赋值。
   * @param entity
   * @return
   */
  @Override
  public int insert(T entity) {
    if(entity == null) {
      return 0;
    }
    Object[][] permissionPairArray = getPermissionPairArray();
    // 未设置权限参数，则直接插入
    if(permissionPairArray == null || permissionPairArray.length == 0 || permissionPairArray[0] == null || permissionPairArray[0].length == 0) {
      return super.insert(entity);
    }
    // 设置权限参数，则设置权限参数的值
    for(Object[] permissionPair : permissionPairArray) {
      addPermissionField2Entity(entity, permissionPair);
    }
    return super.insert(entity);
  }

  /**
   * 批量插入，针对插入列表中的每个对象的权限字段进行强制赋值
   * @param entityList
   * @return
   */
  @Override
  public int insertBatchSomeColumn(List<T> entityList) {
    if(CollectionUtils.isEmpty(entityList)) {
      return 0;
    }
    Object[][] permissionPairArray = getPermissionPairArray();
    // 未设置权限参数，直接插入
    if(permissionPairArray == null || permissionPairArray.length == 0 || permissionPairArray[0] == null || permissionPairArray[0].length == 0) {
      return super.insertBatchSomeColumn(entityList);
    }
    // 设置了权限参数，强制赋权限参数属性值
    entityList.forEach(entity -> {
      for(Object[] permissionPair : permissionPairArray) {
        addPermissionField2Entity(entity, permissionPair);
      }
    });
    return super.insertBatchSomeColumn(entityList);
  }

  /**
   * 根据id进行删除，需要保证删除的数据除了id一致，还要在该用户的权限范围之内
   *
   * @param id
   * @return
   */
  @Override
  public int deleteById(Serializable id) {
    // 添加权限控制参数
    QueryWrapper<T> queryWrapper = getQueryWrapper(null);
    String keyColumn = getKeyColumn();
    // 添加id参数
    queryWrapper.eq(keyColumn, id);
    return super.delete(queryWrapper);
  }

  /**
   * 根据key-value进行删除。
   * 首先，将map转换到queryWrapper当中，然后添加权限，然后删除
   * @param columnMap
   * @return
   */
  @Override
  public int deleteByMap(Map<String, Object> columnMap) {
    // 生成带权限wrapper
    QueryWrapper<T> queryWrapper = getQueryWrapper(null);
    // 加入columnMap中的属性
    columnMap.entrySet().forEach(entry -> queryWrapper.eq(entry.getKey(), entry.getValue()));
    return super.delete(queryWrapper);
  }

  @Override
  public int delete(Wrapper<T> wrapper) {
    // 补充权限属性
    QueryWrapper<T> queryWrapper = getQueryWrapper(wrapper);
    return super.delete(queryWrapper);
  }

  @Override
  public int deleteBatchIds(Collection<? extends Serializable> idList) {
    if (CollectionUtils.isEmpty(idList)) {
      throw new RuntimeException("根据主键批量删除，则主键列表不能为空!");
    }
    // 补充权限属性
    QueryWrapper<T> queryWrapper = getQueryWrapper(null);
    String keyColumn = getKeyColumn();
    // 补充in语句
    queryWrapper.in(keyColumn, idList);
    return super.delete(queryWrapper);
  }

  /**
   * 根据id和权限进行更新
   * @param entity
   * @return
   */
  @Override
  public int updateById(T entity) {
    UpdateWrapper updateWrapper = getUpdateWrapper(null);
    String keyColumn = getKeyColumn();
    Object keyValue = getKeyPropertyValueOfEntity(entity);
    updateWrapper.eq(keyColumn, keyValue);
    return super.update(entity, updateWrapper);
  }

  /**
   * 添加权限进行更新
   * @param entity
   * @param updateWrapper
   * @return
   */
  @Override
  public int update(T entity, Wrapper<T> updateWrapper) {
    UpdateWrapper<T> wrapper = getUpdateWrapper(updateWrapper);
    return super.update(entity, wrapper);
  }

  /**
   * 添加权限进行查询
   * @param id
   * @return
   */
  @Override
  public T selectById(Serializable id) {
    QueryWrapper<T> queryWrapper = getQueryWrapper(null);
    String keyColumn = getKeyColumn();
    queryWrapper.eq(keyColumn, id);
    return super.selectOne(queryWrapper);
  }

  /**
   * 添加权限进行批量查询
   * @param idList
   * @return
   */
  @Override
  public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
    // id列表为空，则返回空列表。
    if (CollectionUtils.isEmpty(idList)) {
      return Collections.emptyList();
    }
    // 添加权限控制
    QueryWrapper<T> queryWrapper = getQueryWrapper(null);
    String keyColumn = getKeyColumn();
    queryWrapper.in(keyColumn, idList);
    return super.selectList(queryWrapper);
  }

  /**
   * 根据key -> value映射进行权限查询
   * @param columnMap
   * @return
   */
  @Override
  public List<T> selectByMap(Map<String, Object> columnMap) {
    QueryWrapper<T> queryWrapper = getQueryWrapper(null);
    columnMap.entrySet().forEach(entry -> queryWrapper.eq(entry.getKey(), entry.getValue()));
    return super.selectList(queryWrapper);
  }

  /**
   * 添加权限查询
   * @param queryWrapper
   * @return
   */
  @Override
  public T selectOne(Wrapper<T> queryWrapper) {
    QueryWrapper<T> wrapper = getQueryWrapper(queryWrapper);
    return super.selectOne(wrapper);
  }

  /**
   * 添加权限查询数量
   * @param queryWrapper
   * @return
   */
  @Override
  public Integer selectCount(Wrapper<T> queryWrapper) {
    QueryWrapper<T> wrapper = getQueryWrapper(queryWrapper);
    return super.selectCount(wrapper);
  }

  /**
   * 添加权限查询列表
   * @param queryWrapper
   * @return
   */
  @Override
  public List<T> selectList(Wrapper<T> queryWrapper) {
    QueryWrapper<T> wrapper = getQueryWrapper(queryWrapper);
    return super.selectList(wrapper);
  }

  /**
   * 添加权限查询
   * @param queryWrapper
   * @return
   */
  @Override
  public List<Map<String, Object>> selectMaps(Wrapper<T> queryWrapper) {
    QueryWrapper<T> wrapper = getQueryWrapper(queryWrapper);
    return super.selectMaps(wrapper);
  }

  /**
   * 添加权限查询objs
   * @param queryWrapper
   * @return
   */
  @Override
  public List<Object> selectObjs(Wrapper<T> queryWrapper) {
    QueryWrapper<T> wrapper = getQueryWrapper(queryWrapper);
    return super.selectObjs(wrapper);
  }

  /**
   * 添加权限查询分页
   * @param page
   * @param queryWrapper
   * @return
   */
  @Override
  public IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper) {
    QueryWrapper<T> wrapper = getQueryWrapper(queryWrapper);
    return super.selectPage(page, wrapper);
  }

  /**
   * 添加权限查询分页
   * @param page
   * @param queryWrapper
   * @return
   */
  @Override
  public IPage<Map<String, Object>> selectMapsPage(IPage<T> page, Wrapper<T> queryWrapper) {
    QueryWrapper<T> wrapper = getQueryWrapper(queryWrapper);
    return super.selectMapsPage(page, wrapper);
  }

  /**
   * 针对T类型的对象entity，使用权限key->value键值对强制权限字段赋值。
   * @param entity
   * @param permissionPair
   */
  private void addPermissionField2Entity(T entity, Object[] permissionPair) {
    // 获取权限的java bean属性字段
    String property = this.getPropertyOfColumn(permissionPair[0].toString());
    if(StringUtils.isEmpty(property)) {
      throw new RuntimeException("权限属性设置有误，请检查权限属性设置是否正确: " + permissionPair[0]);
    }
    if(!fieldMap.containsKey(property)) {
      addField(entity.getClass(), property);
    }
    if ((permissionPair[1] instanceof Collection)
        || (permissionPair[1] instanceof SourceCondition)) {
      return;
    }
    try {
      fieldMap.get(property).set(entity, permissionPair[1]);
    } catch (IllegalAccessException e) {
      log.error("", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 获取实体entity中的主键值
   *
   * @param entity
   * @return
   */
  private Object getKeyPropertyValueOfEntity(T entity) {
    String keyProperty = getKeyProperty();
    if (!fieldMap.containsKey(keyProperty)) {
      addField(entity.getClass(), keyProperty);
    }
    try {
      return fieldMap.get(keyProperty).get(entity);
    } catch (IllegalAccessException e) {
      log.error("", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 使用java反射，获取clazz对象的property属性的Field，并添加到fieldMap中缓存
   * @param clazz
   * @param property
   */
  private void addField(Class clazz, String property) {
    try {
      java.lang.reflect.Field field = clazz.getDeclaredField(property);
      field.setAccessible(true);
      fieldMap.put(property, field);
    } catch (NoSuchFieldException e) {
      log.error("", e);
      throw new RuntimeException(e);
    }
  }


  /**
   * 根据源wrapper，查找权限参数，拼接目标queryWrapper
   *
   * @param wrapper
   * @return
   */
  private QueryWrapper<T> getQueryWrapper(Wrapper<T> wrapper) {
    QueryWrapper<T> queryWrapper = null;
    if (wrapper != null) {
      queryWrapper = (QueryWrapper) wrapper;
    } else {
      queryWrapper = new QueryWrapper<>();
    }
    addPermission2Wrapper(queryWrapper);
    return queryWrapper;
  }

  /**
   * 根据源wrapper，查找权限参数，拼接目标updateWrapper
   *
   * @param wrapper
   * @return
   */
  private UpdateWrapper<T> getUpdateWrapper(Wrapper<T> wrapper) {
    UpdateWrapper<T> updateWrapper = null;
    if (wrapper != null) {
      updateWrapper = (UpdateWrapper) wrapper;
    } else {
      updateWrapper = new UpdateWrapper<>();
    }
    addPermission2Wrapper(updateWrapper);
    return updateWrapper;
  }


  private void addPermission2Wrapper(Wrapper<T> wrapper) {
    Object[][] permissionPairArray = getPermissionPairArray();
    if (permissionPairArray == null || permissionPairArray.length == 0
        || permissionPairArray[0] == null || permissionPairArray[0].length == 0) {
      log.error("当前未设置用户权限参数，建议请检查是否符合预期！");
      return;
    }
    for (Object[] permissionPair : permissionPairArray) {
      if (permissionPair[1] instanceof List && wrapper instanceof Func) {
        ((Func) wrapper).in(permissionPair[0].toString(), (List) permissionPair[1]);
      } else if(permissionPair[1] != null && wrapper instanceof Compare) {
        ((Compare) wrapper).eq(permissionPair[0].toString(), permissionPair[1]);
      } else if (wrapper instanceof Func) {
        ((Func) wrapper).isNull(permissionPair[0].toString());
      }
    }
  }

  @Override
  public Object[][] getPermissionPairArray() {
    Collection<AbstractPermissionVisitor> permissionVisitors = getPermissionVisitorList(
        applicationContext);
    List<Object[]> list = new ArrayList<>();
    if (CollectionUtils.isEmpty(permissionVisitors)) {
      Object[][] permissionPairArray = new Object[][]{};
      return permissionPairArray;
    }
    String tableName = getTableName();
    for (AbstractPermissionVisitor permissionVisitor : permissionVisitors) {
      Map<String, Object[][]> permissionConditionMap = permissionVisitor
          .getPermissionConditionMap();
      if (permissionConditionMap != null && permissionConditionMap.containsKey(tableName)) {
        Object[][] tmpPairArray = permissionConditionMap.get(tableName);
        if (tmpPairArray == null) {
          continue;
        }
        for (Object[] tmpPair : tmpPairArray) {
          list.add(tmpPair);
        }
      }
    }
    Object[][] permissionPairArray = list.toArray(new Object[list.size()][]);
    return permissionPairArray;
  }
}
