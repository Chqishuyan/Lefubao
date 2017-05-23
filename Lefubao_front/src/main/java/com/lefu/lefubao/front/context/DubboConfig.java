package com.lefu.lefubao.front.context;

import com.alibaba.dubbo.config.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by shuyan.qi on 2017/3/16.
 */
@Configuration
@PropertySource("classpath:/dubbo.properties")
public class DubboConfig {

    @Value("${dubbo.appName}")
    private  String appName;

    @Value("${dubbo.resUsername}")
    private  String resUsername;

    @Value("${dubbo.resPassword}")
    private String resPassword;

    @Value("${dubbo.resAddress}")
    private String resAddress;

    @Value("${dubbo.protocol}")
    private String protocol;

    @Value("${dubbo.port}")
    private int port;

    @Value("${dubbo.monAddress}")
    private  String monAddress;

    @Value("${dubbo.connections}")
    private int connections;

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig(appName);
        applicationConfig.setMonitor(monitorConfig());
        applicationConfig.setRegistry(registry());
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registry(){
        RegistryConfig registryConfig = new RegistryConfig(resAddress);
        registryConfig.setProtocol(protocol);
        registryConfig.setPort(port);
        registryConfig.setDefault(true);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocol() {
        ProtocolConfig protocolConfig = new ProtocolConfig(protocol, port);
        return protocolConfig;
    }

    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setConnections(connections);
        return providerConfig;
    }

}
