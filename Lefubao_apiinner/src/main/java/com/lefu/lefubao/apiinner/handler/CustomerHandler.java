package com.lefu.lefubao.apiinner.handler;

import com.lefu.lefubao.apiinner.dubbo.CustomerFacade;

/**
 * Created by shuyan.qi on 2017/3/19.
 */
public  abstract class CustomerHandler implements CustomerFacade {


    @Override
    public String customerList(String loginKey) {
        return null;
    }
}
