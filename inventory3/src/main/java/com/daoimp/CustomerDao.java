package com.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.ICustomerDao;
import com.model.Customer;

public class CustomerDao implements ICustomerDao {
	Transaction transaction;
	Session sos;

	@Override
	public boolean Save(Customer entity) {

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
	public void Update(Customer entity) {
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
	public Customer Get(int Id) {
		Customer entity = null;
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			entity = sos.get(Customer.class, Id);
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
	public List<Customer> Get() {
		List entity = null;
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			entity = sos.createQuery("from Customer").list();
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
			Customer entity = sos.get(Customer.class, Id);
			sos.delete(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
