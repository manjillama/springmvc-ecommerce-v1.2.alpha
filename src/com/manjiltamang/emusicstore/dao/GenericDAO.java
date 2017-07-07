package com.manjiltamang.emusicstore.dao;

import java.util.List;

public interface GenericDAO<T> {
	List<T> getAll() ;
	void insert(T t) ;
	T getById(int id) ;
	void update(T t);
    void delete(T t);
	//void deleteProduct(Product product) ;
}
