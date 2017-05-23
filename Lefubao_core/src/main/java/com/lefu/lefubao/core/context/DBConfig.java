package com.lefu.lefubao.core.context;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by shuyan.qi on 2017/3/16.
 */
@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setUser("root");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/lefu");
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setPassword("123456");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return null;
        }

        return dataSource;

    }
}
