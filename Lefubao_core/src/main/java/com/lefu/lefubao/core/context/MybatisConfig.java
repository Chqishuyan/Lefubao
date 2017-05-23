package com.lefu.lefubao.core.context;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by shuyan.qi on 2017/3/16.
 */
@Configuration
@MapperScan(basePackages = "com.lefu.lefubao.core.dao")
@EnableTransactionManagement(order = 0)
public class MybatisConfig {
    @Resource
    private DataSource dataSource;

    /**
     *
     * @return
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        org.springframework.core.io.Resource configlation = new ClassPathResource("mybatis-config.xml");
        bean.setConfigLocation(configlation);
        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Spring的事务管理器
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
