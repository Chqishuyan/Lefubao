package com.lefu.lefubao.core.dao;

import com.lefu.lefubao.model.entity.CustomerQualificationInfo;

public interface CustomerQualificationInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_qualification_info
     *
     * @mbggenerated Thu Apr 13 14:49:09 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_qualification_info
     *
     * @mbggenerated Thu Apr 13 14:49:09 CST 2017
     */
    int insert(CustomerQualificationInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_qualification_info
     *
     * @mbggenerated Thu Apr 13 14:49:09 CST 2017
     */
    int insertSelective(CustomerQualificationInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_qualification_info
     *
     * @mbggenerated Thu Apr 13 14:49:09 CST 2017
     */
    CustomerQualificationInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_qualification_info
     *
     * @mbggenerated Thu Apr 13 14:49:09 CST 2017
     */
    int updateByPrimaryKeySelective(CustomerQualificationInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_qualification_info
     *
     * @mbggenerated Thu Apr 13 14:49:09 CST 2017
     */
    int updateByPrimaryKey(CustomerQualificationInfo record);
}