package com.yonyou.einvoice.common.metadata.graphql.config;

import graphql.GraphQLError;
import graphql.servlet.DefaultGraphQLErrorHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * graphql异常合并，返回给前端
 *
 * @author liuqiangm
 */
public class GraphQLErrorHandlerImpl extends DefaultGraphQLErrorHandler {

  @Override
  public List<GraphQLError> processErrors(List<GraphQLError> errors) {
    List<GraphQLError> resultList = new ArrayList<>(errors.size());
    errors.forEach(error -> {
      GraphQLErrorImpl error1 = new GraphQLErrorImpl();
      error1.setPath(error.getPath());
      error1.setMessage(error.getMessage());
      resultList.add(error1);
    });
    return resultList;
  }
}
