package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.dao.ISupplierDao;
import com.model.Supplier;
import com.servicecontact.ISupplierService;

public class SupplierService implements ISupplierService {

	@Autowired
	ISupplierDao supplierDao;

	@Override
	public boolean Save(Supplier entity) {
		return supplierDao.Save(entity);
		
	}

	@Override
	public void Update(Supplier entity) {
		supplierDao.Update(entity);
	}

	@Override
	public Supplier Get(int Id) {
		System.out.print("who i am");
		return supplierDao.Get(Id);
	}

	@Override
	public List<Supplier> Get() {
		System.out.print("who i am 22uii");
		return supplierDao.Get();
		 
	}

	@Override
	public void Delete(int Id) {
		supplierDao.Delete(Id);

	}

}
