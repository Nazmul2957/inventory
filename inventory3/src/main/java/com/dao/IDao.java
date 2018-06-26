package com.dao;

import java.util.List;

public interface IDao<T> {
	boolean Save( T entity);
	void Update( T entity);
	T Get(int Id);
	List<T> Get();
	void Delete(int Id);
	
}
