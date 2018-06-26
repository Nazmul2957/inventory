package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.dao.IProductDao;

import com.model.Product;
import com.servicecontact.IProductService;

public class ProductService  implements IProductService{

	@Autowired
	IProductDao productDao;

	@Override
	public boolean Save(Product entity) {
		return productDao.Save(entity);
		
	}

	@Override
	public void Update(Product entity) {
		productDao.Update(entity);
	}

	@Override
	public Product Get(int Id) {
		System.out.print("who i am");
		return productDao.Get(Id);
	}

	@Override
	public List<Product> Get() {
		System.out.print("who i am 22uii");
		return productDao.Get();
		 
	}

	@Override
	public void Delete(int Id) {
		productDao.Delete(Id);

	}


}
