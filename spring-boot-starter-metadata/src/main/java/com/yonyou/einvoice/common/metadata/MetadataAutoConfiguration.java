package com.yonyou.einvoice.common.metadata;

import com.yonyou.einvoice.common.metadata.config.EinvoiceConfig;
import com.yonyou.einvoice.common.metadata.graphiql.giql.OnlineIQLController;
import com.yonyou.einvoice.common.metadata.graphiql.giql.OnlineIQLProperties;
import com.yonyou.einvoice.common.metadata.graphiql.tgiql.TestIQLController;
import com.yonyou.einvoice.common.metadata.graphiql.tgiql.TestIQLProperties;
import com.yonyou.einvoice.common.metadata.graphql.GraphQLController;
import com.yonyou.einvoice.common.metadata.graphql.config.GraphQLSchemaConfig;
import com.yonyou.einvoice.common.metadata.graphql.config.GraphQLServletConfig;
import com.yonyou.einvoice.common.metadata.graphql.interceptor.EinvoiceGraphQLExceptionInterceptor;
import com.yonyou.einvoice.common.metadata.mp.injector.DynamicSqlInjector;
import com.yonyou.einvoice.common.metadata.service.GeneralPermissionService;
import com.yonyou.einvoice.common.metadata.service.GeneralService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(DispatcherServlet.class)
@EnableConfigurationProperties({MetadataProperties.class, OnlineIQLProperties.class,
    TestIQLProperties.class})
@Import({EinvoiceGraphQLExceptionInterceptor.class, DynamicSqlInjector.class, GeneralService.class,
    GeneralPermissionService.class, GraphQLServletConfig.class, EinvoiceConfig.class,
    GraphQLController.class,
    GraphQLSchemaConfig.class, OnlineIQLController.class, TestIQLController.class})
public class MetadataAutoConfiguration {
}
