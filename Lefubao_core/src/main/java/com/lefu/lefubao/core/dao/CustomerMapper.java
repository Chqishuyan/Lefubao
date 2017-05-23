package com.lefu.lefubao.core.dao;

import com.lefu.lefubao.model.entity.Customer;

import java.util.List;

public interface CustomerMapper {

    List<Customer> queryList(String recommenderNo);
}