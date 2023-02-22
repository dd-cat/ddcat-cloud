package com.ddcat.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * validation配置
 *
 * @author dd-cat
 */
@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator() {
        /*
         * 普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
         * 快速失败返回模式(只要有一个验证失败，则返回)
         * failFast：true 快速失败返回模式 false 普通模式
         */
        return Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
    }
}
