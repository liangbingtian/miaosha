package com.yonyou.einvoice.common.metadata.graphql.config;

import com.yonyou.einvoice.common.metadata.MetadataProperties;
import com.yonyou.einvoice.common.metadata.graphql.IGraphQLService;
import com.yonyou.einvoice.common.metadata.graphql.ITestGQLService;
import com.yonyou.einvoice.common.metadata.graphql.interceptor.EinvoiceGraphQLExceptionInterceptor;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaPrinter;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.execution.ResolverInterceptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * graphql的Schema配置类。 每个新的graphql服务url，都要配置一个相应的GraphQLSchema
 *
 * @author liuqiangm
 */
@Configuration
@Slf4j
@Setter
@Getter
public class GraphQLSchemaConfig {

//  /**
//   * properties配置文件中，可以添加除了com.yonyou之外的其他包名。
//   */
//  @Value(("#{'${graphql.basepackages:com.yonyou}'.split(',')}"))
//  private List<String> basePackages = new ArrayList<>(0);

  @Autowired
  private MetadataProperties metadataProperties;

  @Bean
  @SuppressWarnings("all")
  public GraphQLSchema graphQLSchema(Map<String, IGraphQLService> graphqlServiceMap,
      ResolverInterceptor resolverInterceptor) {
    List<ResolverInterceptor> interceptorList = new ArrayList<>();
    interceptorList.add(new EinvoiceGraphQLExceptionInterceptor());
    List<String> packageList = new ArrayList<>();
    packageList.add("com.yonyou");
    if (StringUtils.isNotBlank(metadataProperties.getBasepackages())) {
      String[] packages = metadataProperties.getBasepackages().split(",");
      packageList.addAll(Arrays.asList(packages));
    }
    if (resolverInterceptor != null) {
      interceptorList.add(resolverInterceptor);
    }
    GraphQLSchema schema = new GraphQLSchemaGenerator()
        .withBasePackages(packageList.toArray(new String[packageList.size()]))
        .withOperationsFromSingletons(graphqlServiceMap.values().toArray())
        .withResolverInterceptors(
            interceptorList.toArray(new ResolverInterceptor[interceptorList.size()]))
        .generate();
    String schemaStr = new SchemaPrinter().print(schema);
    log.info("GraphQL Schema : \n{} ", schemaStr);
    return schema;
  }

  @Bean
  @SuppressWarnings("all")
  public GraphQLSchema testGQLSchema(Map<String, ITestGQLService> testGLQServiceMap,
      ResolverInterceptor resolverInterceptor) {
    List<ResolverInterceptor> interceptorList = new ArrayList<>();
    interceptorList.add(new EinvoiceGraphQLExceptionInterceptor());
    List<String> packageList = new ArrayList<>();
    packageList.add("com.yonyou");
    if (StringUtils.isNotBlank(metadataProperties.getBasepackages())) {
      String[] packages = metadataProperties.getBasepackages().split(",");
      packageList.addAll(Arrays.asList(packages));
    }
    if (resolverInterceptor != null) {
      interceptorList.add(resolverInterceptor);
    }
    GraphQLSchema schema = new GraphQLSchemaGenerator()
        .withBasePackages(packageList.toArray(new String[packageList.size()]))
        .withOperationsFromSingletons(testGLQServiceMap.values().toArray())
        .withResolverInterceptors(
            interceptorList.toArray(new ResolverInterceptor[interceptorList.size()]))
        .generate();
    String schemaStr = new SchemaPrinter().print(schema);
    log.info("GraphQL Schema : \n{} ", schemaStr);
    return schema;
  }
}
