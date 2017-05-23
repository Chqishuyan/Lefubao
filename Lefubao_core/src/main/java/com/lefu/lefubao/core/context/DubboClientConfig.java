package com.lefu.lefubao.core.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by shuyan.qi on 2017/3/16.
 */
@Configuration
@ImportResource("classpath:/dubbo-client.xml")
public class DubboClientConfig {
}
