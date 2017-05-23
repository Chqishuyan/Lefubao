package com.lefubao.controller;

import com.lefu.lefubao.front.utils.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by shuyan.qi on 2017/4/14.
 */
public class CustomerControllerTest {

    @Test
    public void customerListTest() throws IOException {
        String url = "http://localhost:8082/Lefubao_front/customer/customerList?loginKey=2676609963";
        HttpEntity httpEntity = HttpClientUtil.send("get", url, null, "utf-8");
        String result = EntityUtils.toString(httpEntity);
        System.out.println(result);
    }
}
