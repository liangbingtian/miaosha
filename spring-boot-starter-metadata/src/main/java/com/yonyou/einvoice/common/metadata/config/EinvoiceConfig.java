package com.yonyou.einvoice.common.metadata.config;

import com.yonyou.einvoice.common.metadata.graphql.strategy.BatchedAsyncExecutionStrategy;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用于配置实际执行query的查询策略。 采用batch+异步结合的执行策略
 *
 * @author liuqiangm
 */
@Configuration
public class EinvoiceConfig {

  @Bean
  public BatchedAsyncExecutionStrategy getStrategy() {
    BatchedAsyncExecutionStrategy batchedAsyncExecutionStrategy = new BatchedAsyncExecutionStrategy();
    batchedAsyncExecutionStrategy.setAsyncTransmitContext(null);
    return batchedAsyncExecutionStrategy;
  }

  @Bean
  public Validator graphqlValidator() {
    ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
        .configure()
        .addProperty(HibernateValidatorConfiguration.FAIL_FAST, "true")
        .buildValidatorFactory();
    Validator validator = validatorFactory.getValidator();
    return validator;
  }
}
