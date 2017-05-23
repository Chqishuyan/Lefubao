package com.lefu.lefubao.core.dubbo;

import com.lefu.lefubao.apiinner.handler.CustomerHandler;
import com.lefu.lefubao.core.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shuyan.qi on 2017/3/19.
 */
@Service("customerCoreFacade")
public class CustomerFacadeImpl extends CustomerHandler {

    @Resource
    private CustomerService customerService;

    /**
     * 查询商户列表
     * @param loginKey
     * @return
     */
    @Override
    public String customerList(String loginKey) {
        return customerService.customerList(loginKey);
    }

}
