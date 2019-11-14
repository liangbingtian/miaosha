package com.yonyou.einvoice.common.metadata.graphql.node;


import graphql.ExecutionResult;
import graphql.GraphQLError;
import graphql.Internal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Internal
@Setter
@Getter
public class BatchedAsyncExecutionResult implements ExecutionResult {

  private Object data = new LinkedHashMap();
  private List<GraphQLError> errors = new ArrayList<>();
  private boolean dataPresent;
  private Map<Object, Object> extensions;

  @Override
  public Map<String, Object> toSpecification() {
    return null;
  }
}
