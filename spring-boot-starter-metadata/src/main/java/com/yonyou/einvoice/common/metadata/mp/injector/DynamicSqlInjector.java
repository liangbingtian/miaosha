package com.yonyou.einvoice.common.metadata.mp.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.extension.injector.methods.additional.InsertBatchSomeColumn;
import com.yonyou.einvoice.common.metadata.mp.anno.InsertBatchIgnore;
import com.yonyou.einvoice.common.metadata.mp.methods.CountAllDynamicMethod;
import com.yonyou.einvoice.common.metadata.mp.methods.SelectDynamicMethod;
import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * sql注入器。用于增强mapper
 * @author liuqiangm
 */
@Setter
@Getter
@Component
public class DynamicSqlInjector extends DefaultSqlInjector {

  private static final Log logger = LogFactory.getLog(DynamicSqlInjector.class);

  public static final String SELECT_FIELDS = "selectFields";

  public static final String CONDITION_SQL = "conditionSql";

  public static final String DISTINCT= "distinct";

  /**
   * 表column到属性property的映射。key为表名，value为column->property映射
   */
  public static final Map<String, Map<String, String>> column2PropertyMapOfEntity = new HashMap<>();
  /**
   * 属性property到表column的映射。key为表名，value为property->column映射
   */
  public static final Map<String, Map<String, String>> property2ColumnMapOfEntity = new HashMap<>();

  /**
   * 实体名 -> 主键列名映射
   */
  public static final Map<String, String> keyColumnMap = new HashMap<>();

  /**
   * 实体名 -> 主键实体属性名映射
   */
  public static final Map<String, String> keyPropertyMap = new HashMap<>();

  public static final Map<String, String> beanToTableMap = new HashMap();

  @Override
  public void inspectInject(MapperBuilderAssistant builderAssistant, Class<?> mapperClass) {
    Class<?> modelClass = extractModelClass(mapperClass);
    if (modelClass != null) {
      String className = mapperClass.toString();
      Set<String> mapperRegistryCache = GlobalConfigUtils.getMapperRegistryCache(builderAssistant.getConfiguration());
      /**
       * 如果mapper继承了DynamicConditionMapper
       */
      if (!mapperRegistryCache.contains(className)
          && IMetaMapper.class.isAssignableFrom(mapperClass)) {
        Set<String> ignoreSet = getInsertBatchIgnorePropertySet(modelClass);
        List<AbstractMethod> methodList = this.getDynamicMethodList(mapperClass, ignoreSet);
        if (CollectionUtils.isNotEmpty(methodList)) {
          TableInfo tableInfo = TableInfoHelper.initTableInfo(builderAssistant, modelClass);
          // 将当前表与实体的映射关系进行缓存
          cacheTableInfo(tableInfo);
          // 循环注入自定义方法
          methodList.forEach(m -> m.inject(builderAssistant, mapperClass, modelClass, tableInfo));
        } else {
          logger.debug(mapperClass.toString() + ", No effective injection method was found.");
        }
        mapperRegistryCache.add(className);
      }
    }
    super.inspectInject(builderAssistant, mapperClass);
  }

  /**
   * 在原有insert方法的基础上，注入selectDynamic和countAllDynamic方法。
   * @param mapperClass
   * @return
   */
  public List<AbstractMethod> getDynamicMethodList(Class<?> mapperClass, Set<String> ignoreSet) {
    List<AbstractMethod> methods = new LinkedList<>();
    methods.addAll(getMethodList(mapperClass));
    methods.add(new SelectDynamicMethod());
    methods.add(new CountAllDynamicMethod());
    InsertBatchSomeColumn batchSomeColumn = new InsertBatchSomeColumn();
    batchSomeColumn.setPredicate((column) -> {
      boolean result = !ignoreSet.contains(column.getProperty());
      return result;
    });
    methods.add(batchSomeColumn);
    return methods;
  }

  /**
   * 将表字段信息缓存到Map当中
   * @param tableInfo
   */
  private void cacheTableInfo(TableInfo tableInfo) {
    String entityName = tableInfo.getEntityType().getName();
    String keyColumn = tableInfo.getKeyColumn();
    String keyProperty = tableInfo.getKeyProperty();
    List<TableFieldInfo> tableFieldInfoList = tableInfo.getFieldList();
    if(CollectionUtils.isEmpty(tableFieldInfoList)) {
      return;
    }
    Map<String, String> column2PropertyMap = new HashMap<>((int) ((tableFieldInfoList.size() + 1) / 0.75) + 1);
    Map<String, String> property2ColumnMap = new HashMap<>((int) ((tableFieldInfoList.size() + 1) / 0.75) + 1);
    column2PropertyMap.put(keyColumn, keyProperty);
    property2ColumnMap.put(keyProperty, keyColumn);
    for(TableFieldInfo tableFieldInfo : tableFieldInfoList) {
      column2PropertyMap.put(tableFieldInfo.getColumn(), tableFieldInfo.getProperty());
      property2ColumnMap.put(tableFieldInfo.getProperty(), tableFieldInfo.getColumn());
    }
    /**
     * 将当前表信息存入从table相关的映射当中
     */
    column2PropertyMapOfEntity.put(entityName, column2PropertyMap);
    property2ColumnMapOfEntity.put(entityName, property2ColumnMap);
    keyColumnMap.put(entityName, tableInfo.getKeyColumn());
    keyPropertyMap.put(entityName, tableInfo.getKeyProperty());
    beanToTableMap.put(entityName, tableInfo.getTableName());
  }

  private Set<String> getInsertBatchIgnorePropertySet(Class modelClass) {
    Set<String> ignoreSet = new HashSet<>();

    java.lang.reflect.Field[] fields = modelClass.getDeclaredFields();
    for(java.lang.reflect.Field field : fields) {
      Annotation insertAnnotation = field.getAnnotation(InsertBatchIgnore.class);
      if(insertAnnotation != null) {
        ignoreSet.add(field.getName());
      }
    }
    return ignoreSet;
  }
}
