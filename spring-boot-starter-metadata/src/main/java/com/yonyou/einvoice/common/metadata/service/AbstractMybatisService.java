package com.yonyou.einvoice.common.metadata.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Lists;
import com.yonyou.einvoice.common.metadata.entity.IMetaVO;
import com.yonyou.einvoice.common.metadata.mp.injector.DynamicSqlInjector;
import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Slf4j
public class AbstractMybatisService<T extends IMetaVO, Q extends IMetaMapper> extends
    AbstractService<T, Q> {

  /**
   * 分批大小。例如，批量插入时每1000个插一次。 根据id查询实体时，每次查1000个id，然后拼接返回结果。
   */
  private final int batchSize = 1000;

  /**
   * bean类型T所对应的数据库表名
   */
  private String tableName;

  /**
   * 主键column
   */
  private String keyColumn;

  /**
   * 主键的java property
   */
  private String keyProperty;

  /**
   * 用于保存T数据类型的 数据库字段 -> java属性字段映射
   */
  private Map<String, String> column2PropertyMap;
  /**
   * 用于保存T数据类型的 java属性字段 -> 数据库字段映射
   */
  private Map<String, String> property2ColumnMap;

  /**
   * GraphQL的类型验证器，用于在执行插入之前进行字段验证
   */
  @Autowired
  @Qualifier("graphqlValidator")
  private Validator graphqlValidator;

  /**
   * 初始化方法。用于初始化T数据类型的数据库字段 <--> java属性映射
   */
  private void init() {
    // 获取泛型类型
    Class<T> rClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
    column2PropertyMap = DynamicSqlInjector.column2PropertyMapOfEntity.get(rClass.getName());
    property2ColumnMap = DynamicSqlInjector.property2ColumnMapOfEntity.get(rClass.getName());
    keyColumn = DynamicSqlInjector.keyColumnMap.get(rClass.getName());
    keyProperty = DynamicSqlInjector.keyPropertyMap.get(rClass.getName());
    tableName = DynamicSqlInjector.beanToTableMap.get(rClass.getName());
  }

  /**
   * 根据当前层次传入的field列表，返回需要从数据库表中查询出的实际field列表。 由于@Batched/@GraphQLContext等注解的因素，从前端传入的当前层的查询字段，可能不全是数据库中的表字段。
   * 也可能是逻辑字段。因此，需要在此处进行过滤/转换。
   *
   * @param fieldList
   * @return
   */
  @Override
  public List<String> getSelectFields(List<String> fieldList) {
    if(column2PropertyMap == null || property2ColumnMap == null) {
      init();
    }
    List<String> resultList = new ArrayList<>(fieldList.size());
    fieldList.forEach(field -> {
      String targetField = column2PropertyMap.get(field);
      if(targetField != null) {
        resultList.add(String.format("`%s`", field));
        return;
      }
      targetField = property2ColumnMap.get(field);
      if(targetField != null) {
        resultList.add(String.format("`%s`", targetField));
      }
    });
    /**
     * 如果外层无从数据库中查询的字段，
     * 则使用id字段或property2ColumnMap中任取一个value
     */
    if (resultList.isEmpty()) {
      return Arrays.asList(keyColumn);
    }
    return resultList;
  }

  /**
   * 根据返回结果List转换为与stream流相同大小的List<List>
   *
   * @param tList
   * @param function
   * @param stream
   * @param <T>
   * @param <R>
   * @return
   */
  public <T, R> List<List<T>> getSubFieldListOfList(List<T> tList, Function<T, R> function,
      Stream<R> stream) {
    Map<R, List<T>> map = tList.stream().collect(Collectors.groupingBy(function));
    List<List<T>> resultList = new LinkedList<>();
    stream.forEach(robj -> resultList.add(map.getOrDefault(robj, Collections.emptyList())));
    return resultList;
  }

  /**
   * 获取数据库的column字段所对应的java实体属性字段
   *
   * @param column
   * @return
   */
  public String getPropertyOfColumn(String column) {
    if(column2PropertyMap == null || property2ColumnMap == null) {
      init();
    }
    return this.column2PropertyMap.get(column);
  }

  /**
   * 获取当前实体对应的数据库主键列名
   * @return
   */
  public String getKeyColumn() {
    if (StringUtils.isEmpty(keyColumn)) {
      init();
    }
    return keyColumn;
  }

  /**
   * 获取当前实体对应的java property名
   *
   * @return
   */
  public String getKeyProperty() {
    if (StringUtils.isEmpty(keyProperty)) {
      init();
    }
    return keyProperty;
  }

  @Override
  public String getTableName() {
    if (StringUtils.isEmpty(tableName)) {
      init();
    }
    return tableName;
  }

  /**
   * 根据返回结果List转换为与stream流相同大小的List
   *
   * @param tList
   * @param function
   * @param stream
   * @param <T>
   * @param <R>
   * @return
   */
  public <T, R> List<T> getSubFieldList(List<T> tList, Function<T, R> function, Stream<R> stream) {
    List<T> resultList = new LinkedList<>();
    Map<R, T> map = tList.stream().collect(Collectors.toMap(function, t -> t));
    stream.forEach(robj -> resultList.add(map.getOrDefault(robj, null)));
    return resultList;
  }

  public int insert(T entity) {
    // 添加validator校验
    this.validateInsertEntity(entity);
    return mapper.insert(entity);
  }

  public int deleteById(Serializable id) {
    return mapper.deleteById(id);
  }

  public int deleteByMap(Map<String, Object> columnMap) {
    return mapper.deleteByMap(columnMap);
  }

  public int delete(Wrapper<T> wrapper) {
    return mapper.delete(wrapper);
  }

  public int deleteBatchIds(Collection<? extends Serializable> idList) {
    if (CollectionUtils.isEmpty(idList)) {
      return 0;
    }
    return mapper.deleteBatchIds(idList);
  }

  public int updateById(T entity) {
    return mapper.updateById(entity);
  }

  public int update(T entity, Wrapper<T> updateWrapper) {
    return mapper.update(entity, updateWrapper);
  }

  public T selectById(Serializable id) {
    return (T) mapper.selectById(id);
  }

  public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
    // 根据id列表批量查找
    if (CollectionUtils.isEmpty(idList)) {
      return Collections.emptyList();
    }
    List<List<? extends Serializable>> lists = partionCollection(idList);
    // id列表切割。
    List<T> resultList = new LinkedList<>();
    Iterator<List<? extends Serializable>> iterator = lists.iterator();
    while (iterator.hasNext()) {
      List<? extends Serializable> list = iterator.next();
      iterator.remove();
      resultList.addAll(mapper.selectBatchIds(list));
    }
    return resultList;
  }

  public List<T> selectByMap(Map<String, Object> columnMap) {
    if (columnMap == null) {
      columnMap = Collections.emptyMap();
    }
    return mapper.selectByMap(columnMap);
  }

  public T selectOne(Wrapper<T> queryWrapper) {
    return (T) mapper.selectOne(queryWrapper);
  }

  public Integer selectCount(Wrapper<T> queryWrapper) {
    return mapper.selectCount(queryWrapper);
  }

  public List<T> selectList(Wrapper<T> queryWrapper) {
    return mapper.selectList(queryWrapper);
  }

  public List<Map<String, Object>> selectMaps(Wrapper<T> queryWrapper) {
    return mapper.selectMaps(queryWrapper);
  }

  public List<Object> selectObjs(Wrapper<T> queryWrapper) {
    return mapper.selectObjs(queryWrapper);
  }

  public IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper) {
    return mapper.selectPage(page, queryWrapper);
  }

  public IPage<Map<String, Object>> selectMapsPage(IPage<T> page, Wrapper<T> queryWrapper) {
    return mapper.selectMapsPage(page, queryWrapper);
  }

  /**
   * 批量插入要回滚！
   * @param entityList
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public int insertBatchSomeColumn(List<T> entityList) {
    if (CollectionUtils.isEmpty(entityList)) {
      return 0;
    }
    entityList.forEach(this::validateInsertEntity);
    List<List<T>> batchList = partionList(entityList);
    int sum = 0;
    // 分批插入
    for (List<T> list : batchList) {
      sum += mapper.insertBatchSomeColumn(list);
    }
    return sum;
  }

  private void validateInsertEntity(T entity) {
    Set<ConstraintViolation<Object>> results = graphqlValidator.validate(entity);
    if (!CollectionUtils.isEmpty(results)) {
      StringBuilder stringBuilder = new StringBuilder();
      Iterator<ConstraintViolation<Object>> iterator = results.iterator();
      while (iterator.hasNext()) {
        stringBuilder.append(iterator.next().getMessage());
        if (iterator.hasNext()) {
          stringBuilder.append(",");
        }
      }
      throw new RuntimeException(stringBuilder.toString());
    }
  }

  /**
   * 将实体列表根据分批大小进行分割
   *
   * @param entityList
   * @return
   */
  private List<List<T>> partionList(List<T> entityList) {
    if (CollectionUtils.isEmpty(entityList)) {
      return Collections.emptyList();
    }
    if (entityList.size() <= batchSize) {
      return Arrays.asList(entityList);
    }
    return Lists.partition(entityList, batchSize);
  }

  public List partionCollection(Collection idList) {
    if (CollectionUtils.isEmpty(idList)) {
      return Collections.emptyList();
    }
    if (idList.size() <= batchSize) {
      return Arrays.asList(idList);
    }
    List list = null;
    if (idList instanceof List) {
      list = (List) idList;
    } else {
      list = new ArrayList<>(idList);
    }
    int size = list.size();
    int batchNum = (int) Math.ceil((1.0 * size) / batchSize);
    List<List> lists = new ArrayList<>(batchNum);
    for (int i = 0; i < batchNum; i++) {
      int start = i * batchSize;
      int end = Math.min(((i + 1) * batchSize), size);
      lists.add(list.subList(start, end));
    }
    return lists;
  }
}
