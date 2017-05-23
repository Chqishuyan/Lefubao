package com.lefu.lefubao.core.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * Created by shuyan.qi on 2017/3/16.
 */
@Configuration
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        //基于注解配置的Spring容器上下文
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        //注册Spring容器配置类
        rootContext.register(SpringRootConfig.class);
        container.addListener(new ContextLoaderListener(rootContext));

        //配置Spring提供的字符编码过滤器
        javax.servlet.FilterRegistration.Dynamic filter = container.addFilter("encoding", new CharacterEncodingFilter());
        //配置过滤器的过滤路径
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/");

        //基于注解配置的Web容器上下文
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //注册Web容器配置类
        context.register(SpringMvcConfig.class);
        javax.servlet.ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(context));
        //配置映射路径
        servlet.addMapping("/");
        //启动顺序
        servlet.setLoadOnStartup(1);

    }
}
