package com.yonyou.einvoice.common.metadata.service;

import com.yonyou.einvoice.common.metadata.element.SourceCondition;
import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import com.yonyou.einvoice.common.metadata.visitor.MybatisCountAllSqlVisitor;
import com.yonyou.einvoice.common.metadata.visitor.MybatisSqlVisitor;
import com.yonyou.einvoice.common.metadata.visitor.SecureVisitor;
import graphql.language.Field;
import graphql.language.SelectionSet;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

public abstract class AbstractService<T, Q extends IMetaMapper> extends AbstractCommonService {

  @Autowired
  @SuppressWarnings("all")
  protected Q mapper;

  /**
   * 根据传入的参数列表，返回需要在实体所对应的数据库表中实际查询的字段
   *
   * @param fieldList
   * @return
   */
  protected abstract List<String> getSelectFields(List<String> fieldList);


  /**
   * 用于根据GraphQL请求时传递的当前查询层次的field，获取实际需要在数据库中进行查询所需的字段列表
   * @param field
   * @return
   */
  public List<String> getSelectFields(Field field) {
    SelectionSet selectionSet = field.getSelectionSet();
    if (selectionSet != null && !CollectionUtils.isEmpty(selectionSet.getSelections())) {
      List<String> selectFields = new ArrayList<>(selectionSet.getSelections().size());
      selectionSet.getSelections().forEach(selection -> {
        Field subField = (Field) selection;
        selectFields.add(subField.getName());
      });
      return getSelectFields(selectFields);
    }
    return Collections.emptyList();
  }

  /**
   * 查询条件动态拼接。用于获取符合条件的记录（可分页）
   * @param condition
   * @param field
   * @return
   */
  public List<T> selectByDynamicCondition(
      SourceCondition condition, @GraphQLEnvironment Field field) {
    List<String> selectFields = getSelectFields(field);
    return innerSelect(condition, selectFields);
  }

  protected List<T> innerSelect(SourceCondition condition, List<String> selectFields) {
    Map<String, Object> map = new TreeMap<>();
    if (!CollectionUtils.isEmpty(selectFields)) {
      map.put("selectFields", selectFields);
    }
    if (condition.getDistinct()) {
      map.put("distinct", true);
    }
    SecureVisitor secureVisitor = new SecureVisitor();
    secureVisitor.visit(condition);
    // 检查是否存在sql注入情形
    MybatisSqlVisitor visitor = new MybatisSqlVisitor();
    visitor.visit(condition);
    map.put("tableName", getTableName());
    // 针对本次查询所生成的sql
    map.put("conditionSql", visitor.getSql());
    // 本次查询生成的sql中，包含的mybatis变量。
    map.putAll(visitor.getMybatisParamMap());
    return ((IMetaMapper<T>) mapper).selectByDynamicCondition(map);
  }

  /**
   * 查询条件动态拼接。用于获取符合条件的记录总数
   * @param condition
   * @return
   */
  public int countAllByDynamicCondition(
      SourceCondition condition) {
    Map<String, Object> map = new TreeMap<>();
    SecureVisitor secureVisitor = new SecureVisitor();
    secureVisitor.visit(condition);
    // 检查是否存在sql注入情形
    MybatisCountAllSqlVisitor visitor = new MybatisCountAllSqlVisitor();
    visitor.visit(condition);
    map.put("tableName", getTableName());
    // 对于本次分页查询，获取其查询的总数。
    map.put("conditionSql", visitor.getSql());
    // 本次查询生成的sql中，包含的mybatis变量。
    map.putAll(visitor.getMybatisParamMap());
    return ((IMetaMapper) mapper).countAllByDynamicCondition(map);
  }

  /**
   * 用于获取当前service对应实体的数据库表名
   *
   * @return
   */
  protected abstract String getTableName();
}
