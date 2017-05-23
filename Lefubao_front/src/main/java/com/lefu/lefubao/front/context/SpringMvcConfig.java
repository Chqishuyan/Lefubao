package com.lefu.lefubao.front.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by shuyan.qi on 2017/3/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lefu.lefubao.front.web", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class) )
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }

//    @Bean
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
//        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
//        List<MediaType>  mediaList = new ArrayList<MediaType>();
//        mediaList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
//        mediaList.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
//        mediaList.add(new MediaType("text", "html", Charset.forName("UTF-8")));
//        mediaList.add(new MediaType("text", "xml", Charset.forName("UTF-8")));
//
//        StringHttpMessageConverter stringHttpMessageConverter = new org.springframework.http.converter.StringHttpMessageConverter();
//        stringHttpMessageConverter.setSupportedMediaTypes(mediaList);
//
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new org.springframework.http.converter.json.MappingJackson2HttpMessageConverter();
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaList);
//
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        messageConverters.add(stringHttpMessageConverter);
//        messageConverters.add(mappingJackson2HttpMessageConverter);
//
//        adapter.setMessageConverters(messageConverters);
//        return adapter;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
//    }
//
//    @Bean
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
//        exceptionResolver.setDefaultErrorView("error/error");
//        return exceptionResolver;
//    }
//
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        exceptionResolvers.add(simpleMappingExceptionResolver());
//        super.configureHandlerExceptionResolvers(exceptionResolvers);
//    }
//
//    @Bean
//    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
//        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
//        Properties mappings = new Properties();
//        //mappings.put("/**", simpleForwardHttpRequestHandler());
//        simpleUrlHandlerMapping.setMappings(mappings);
//        return simpleUrlHandlerMapping;
//    }
//
//    @Bean
//    public SimpleForwardHttpRequestHandler simpleForwardHttpRequestHandler() {
//        return new SimpleForwardHttpRequestHandler();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//         //http前置请求拦截器
//        registry.addInterceptor(new CommonHttpRequestInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/notify/recommender/memberWeixinpayNotify");
//        // 微信付款结果通知
//        registry.addInterceptor(new WeixinNotifyHttpRequestInterceptor())
//                .addPathPatterns("/notify/recommender/memberWeixinpayNotify");
//        // 公共参数拦截器
//        registry.addInterceptor(new ValidateInterceptor()).addPathPatterns("/**").excludePathPatterns("/web/**");
//		//假数据拦截器
//		registry.addInterceptor(new FalseDataInterceptor()).addPathPatterns("/transaction/crcmList")
//				.addPathPatterns("/transaction/transationDetailList")
//				.addPathPatterns("/qualificationSupplement/queryCustomerList")
//				.addPathPatterns("/qualificationSupplement/queryOriginalQualification")
//				.addPathPatterns("/qualificationSupplement/queryQualificationDetail")
//				.addPathPatterns("/customer/queryCustomer").addPathPatterns("/customer/queryCustomerInfo")
//				.addPathPatterns("/sign/queryContractlList").addPathPatterns("/customer/queryCustomerDetails");
//        super.addInterceptors(registry);
//    }
//
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver commonsMultipartResolver() {
//
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setDefaultEncoding("UTF-8");
//        // commonsMultipartResolver.setMaxUploadSize(30*1024*1024);
//        return commonsMultipartResolver;
//    }
}
