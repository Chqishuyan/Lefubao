package com.lefu.lefubao.core.context;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;

/**
 * Created by shuyan.qi on 2017/3/16.
 */
@Configuration
@EnableAspectJAutoProxy
@Import({DBConfig.class,MybatisConfig.class,
        DubboConfig.class,DubboServiceConfig.class,DubboClientConfig.class,TimerConfig.class})
@ComponentScan(basePackages = "com.lefu.lefubao.core",excludeFilters = {@ComponentScan.Filter(Configuration.class)})
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
