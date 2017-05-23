package com.lefu.lefubao.apiinner.dubbo;

/**
 * Created by shuyan.qi on 2017/3/19.
 */
public interface CustomerFacade {
    /**
     * 查询商户列表
     * @param loginKey
     * @return
     */
    String customerList(String loginKey);
}
