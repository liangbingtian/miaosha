package com.yonyou.einvoice.common.metadata.graphql.config;

import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.DefaultExecutionStrategyProvider;
import graphql.servlet.SimpleGraphQLServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * graphql的servlet配置类。 每个新的graphql服务url，都要配置一个相应的SimpleGraphQLServlet
 *
 * @author liuqiangm
 */
@Configuration
public class GraphQLServletConfig {

  /**
   * 注入graphqlSchema，生成graphQLServlet 使用批量查询策略，可以提升图查询性能
   *
   * @param graphQLSchema
   * @return
   */
  @Bean
  public SimpleGraphQLServlet graphQLServlet(
      @Qualifier("graphQLSchema") GraphQLSchema graphQLSchema,
      ExecutionStrategy executionStrategy) {
    return SimpleGraphQLServlet
        .builder(graphQLSchema)
        .withGraphQLErrorHandler(new GraphQLErrorHandlerImpl())
        .withExecutionStrategyProvider(
            new DefaultExecutionStrategyProvider(executionStrategy))
        .build();
  }

  /**
   * 注入graphqlSchema，生成graphQLServlet 使用批量查询策略，可以提升图查询性能
   *
   * @param testGQLSchema
   * @return
   */
  @Bean
  public SimpleGraphQLServlet testGQLServlet(
      @Qualifier("testGQLSchema") GraphQLSchema testGQLSchema,
      ExecutionStrategy executionStrategy) {
    return SimpleGraphQLServlet
        .builder(testGQLSchema)
        .withGraphQLErrorHandler(new GraphQLErrorHandlerImpl())
        .withExecutionStrategyProvider(
            new DefaultExecutionStrategyProvider(executionStrategy))
        .build();
  }
}
