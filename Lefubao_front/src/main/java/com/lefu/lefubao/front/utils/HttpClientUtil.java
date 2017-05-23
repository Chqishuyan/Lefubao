package com.lefu.lefubao.front.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by shuyan.qi on 2017/4/14.
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 发送http请求
     * @param method get post
     * @param url get请求带参数，post不带
     * @param params get请求为null，post请求JSON格式参数
     * @param charSet  字符集
     * @return
     */
    public static HttpEntity send(String method,String url,String params,String charSet ){
        HttpClientBuilder httpClientBuilder = null;
        RequestConfig config = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse  httpResponse = null;
        HttpEntity entity = null;
        try {
            httpClientBuilder = HttpClientBuilder.create();
            config = RequestConfig.custom().setConnectTimeout(15 * 1000).setSocketTimeout(30 * 1000).build();
            httpClientBuilder.setDefaultRequestConfig(config);

            client = httpClientBuilder.build();

            //发送get请求
            if ("get".equalsIgnoreCase(method)){
                HttpGet httpGet = new HttpGet(url);
                httpGet.setHeader("Content-Type",ContentType.TEXT_HTML.withCharset(charSet).toString());
                httpResponse = client.execute(httpGet);
            }

            //发送post请求
            if ("post".equalsIgnoreCase(method)) {
                HttpPost httpPost = new HttpPost(url);
                EntityBuilder entityBuilder = EntityBuilder.create();
                entityBuilder.setText(params);
                entityBuilder.setContentType(ContentType.APPLICATION_JSON);
                entityBuilder.setContentEncoding(charSet);
                httpPost.setEntity(entityBuilder.build());

                httpResponse = client.execute(httpPost);
            }

            //处理响应
            if (null != httpResponse){
                entity = httpResponse.getEntity();
            }
        } catch (IOException e) {
            logger.error("Method send 发送http请求异常："+e);
        }
        return entity;
    }
}
