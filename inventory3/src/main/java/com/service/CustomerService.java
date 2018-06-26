package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ICustomerDao;
import com.model.Customer;
import com.servicecontact.ICustomerService;

public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;

	@Override
	public boolean Save(Customer entity) {
		return customerDao.Save(entity);
		
	}

	@Override
	public void Update(Customer entity) {
		customerDao.Update(entity);
	}

	@Override
	public Customer Get(int Id) {
		System.out.print("who i am");
		return customerDao.Get(Id);
	}

	@Override
	public List<Customer> Get() {
		System.out.print("who i am 22uii");
		return customerDao.Get();
		 
	}

	@Override
	public void Delete(int Id) {
		customerDao.Delete(Id);

	}

}
