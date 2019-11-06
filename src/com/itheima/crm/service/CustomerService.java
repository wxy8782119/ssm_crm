package com.itheima.crm.service;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {
	//通过四个条件，查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	//通过id查询客户
	public Customer selectCustomerById(Integer id);
	//通过id更新客户数据
	public void updateCustomerById(Customer customer);
	//通过id删除客户
	public void deleteCustomerById(Integer id);
}
