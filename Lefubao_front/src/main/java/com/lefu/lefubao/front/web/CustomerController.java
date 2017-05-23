package com.lefu.lefubao.front.web;

import com.lefu.lefubao.apiinner.dubbo.CustomerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by shuyan.qi on 2017/4/13.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerFacade customerCoreFacade;

    /**
     * 查询商户列表
     * @param loginKey
     * @return
     */
    @RequestMapping("/customerList")
    @ResponseBody
    public String customerList(String loginKey){
        logger.info("Method customerList start params:{}",loginKey);
       String result =  customerCoreFacade.customerList(loginKey);

       logger.info("Method customerList end result:{}",result);
        return result;
    }
}
