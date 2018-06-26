package com.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.IProductDao;
import com.model.Product;

public class ProductDao implements IProductDao {
	Transaction transaction;
	Session sos;

	@Override
	public boolean Save(Product entity) {

		try {
			
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			sos.save(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return false;
		}
		
	}

	@Override
	public void Update(Product  entity) {
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			sos.update(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public Product Get(int Id) {
		Product  entity = null;
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			entity = sos.get(Product.class, Id);
			System.out.println("hey i am there size of list");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return entity;
	}

	@Override
	public List<Product> Get() {
		List entity = null;
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			entity = sos.createQuery("from Product").list();
			System.out.println("hey i am there size of list"+entity.size());
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return entity;
	}

	@Override
	public void Delete(int Id) {
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			Product entity = sos.get(Product.class, Id);
			sos.delete(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}


}

