package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/**
 * 客户管理
 * @author 古炫天
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	//通过四个条件，查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		//每页数
		page.setSize(5);
		vo.setSize(5);
		if(null != vo) {
			//判断当前页
			if(null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {//trim()的作用是去掉字符串两端的多余的空格
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//总条数
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			//结果集
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;
	}
	
	//通过id查询客户
	public Customer selectCustomerById(Integer id) {
		return customerDao.selectCustomerById(id);
	}

	//通过id更新客户数据
	public void updateCustomerById(Customer customer) {
		customerDao.updateCustomerById(customer);
	}
	
	//通过id删除客户
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
	}
}
