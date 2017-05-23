package com.lefu.lefubao.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.lefu.lefubao.core.dao.CustomerMapper;
import com.lefu.lefubao.core.service.CustomerService;
import com.lefu.lefubao.model.beans.ReturnBean;
import com.lefu.lefubao.model.beans.ReturnCode;
import com.lefu.lefubao.model.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shuyan.qi on 2017/3/19.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Resource
    private CustomerMapper customerMapper;

    /**
     * 查询商户列表
     * @param loginKey
     * @return
     */
    @Override
    public String customerList(String loginKey) {
        ReturnBean<List<Customer>> returnBean = new ReturnBean<List<Customer>>();
        //TODO 模拟从通过loginKey从缓存中取出合伙人编号
        String recommenderNo = loginKey;
        logger.info("Method customerList recomNo:{}",recommenderNo);
        try {
            List<Customer> list = customerMapper.queryList(recommenderNo);
            returnBean.setCode(ReturnCode.SUCCESS);
            returnBean.setMsg(ReturnCode.SUCCESS_DESC);
            returnBean.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Method customerList error :{}",e);
            returnBean.setCode(ReturnCode.ERROR);
            returnBean.setMsg(ReturnCode.ERROR_DESC);
        }
        logger.info("Method customerList end return:{}", JSON.toJSONString(returnBean));
        return JSON.toJSONString(returnBean);
    }
}
