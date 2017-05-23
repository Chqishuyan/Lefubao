package com.lefu.lefubao.front.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.EnumSet;

/**
 * 用于替代web.xml的web容器配置类
 * 在这里配置过滤器、监听器、Servlet
 * Created by shuyan.qi on 2017/3/15.
 */
public class WebInitializer implements WebApplicationInitializer {

    private Logger logger = LoggerFactory.getLogger(WebInitializer.class);

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        //基于注解配置的Spring容器上下文
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        ConfigurableEnvironment environment = rootContext.getEnvironment();
        try {
            environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:/environment.properties"));
        } catch (IOException e) {
            logger.error("", e);
        }
        //注册Spring容器配置类
        rootContext.register(SpringRootConfig.class);
        container.addListener(new ContextLoaderListener(rootContext));

        //配置Spring提供的字符编码过滤器
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        javax.servlet.FilterRegistration.Dynamic filter = container.addFilter("characterEncodingFilter", encodingFilter);
        //配置过滤器的过滤路径
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");

        //基于注解配置的Web容器上下文
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //注册Web容器配置类
        context.register(SpringMvcConfig.class);
        javax.servlet.ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(context));
        //启动顺序
        servlet.setLoadOnStartup(1);
        //配置映射路径
        servlet.addMapping("/");

    }
}
