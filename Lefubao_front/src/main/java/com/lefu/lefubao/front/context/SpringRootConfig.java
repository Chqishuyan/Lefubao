package com.lefu.lefubao.front.context;

import java.io.IOException;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;


/**
 * @Description: Spring上下文配置
 * @see: SpringRootConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:27:10
 * @author qinji.xu
 */
@Configuration
@EnableAspectJAutoProxy
@Import({DubboConfig.class,DubboServiceConfig.class,DubboClientConfig.class })
@ComponentScan(basePackages = "com.lefu.lefubao.front", excludeFilters = { @Filter(Controller.class), @Filter(Configuration.class) })
public class SpringRootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Validator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    @Bean
    public ResourcePropertySource peripheralUrisProperties() throws IOException {
        return new ResourcePropertySource("classpath:/system.properties");
    }

}
