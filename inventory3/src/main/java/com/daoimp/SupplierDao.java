package com.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.ISupplierDao;
import com.model.Supplier;

public class SupplierDao implements ISupplierDao {
	Transaction transaction;
	Session sos;

	@Override
	public boolean Save(Supplier entity) {

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
	public void Update(Supplier entity) {
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
	public Supplier Get(int Id) {
		Supplier entity = null;
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			entity = sos.get(Supplier.class, Id);
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
	public List<Supplier> Get() {
		List entity = null;
		try {
			sos = DBConnection.getconnection();
			transaction = sos.beginTransaction();
			entity = sos.createQuery("from Supplier").list();
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
			Supplier entity = sos.get(Supplier.class, Id);
			sos.delete(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
