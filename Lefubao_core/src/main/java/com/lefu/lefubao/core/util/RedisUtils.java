package com.lefu.lefubao.core.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * Created by shuyan.qi on 2017/4/13.
 */
public class RedisUtils {
    public static void main(String[] args) {
        String result = "{\"RESULT\":\"TRUE\",\"RESTRICTS_DETAIL\":{\"IDENTITY_NO\":\"12345678900\",\"BANK_ACCOUNT_NO\":\"6222222222222222222222\"}}";
        HashMap<String,String> checkMap = JSON.parseObject(result, HashMap.class);
        System.out.println(checkMap.get("RESULT"));
    }
}
