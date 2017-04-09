package com.manjiltamang.emusicstore.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	List<T> getAll() throws ClassNotFoundException, SQLException;
	int insert(T t) throws ClassNotFoundException, SQLException;
	T getById(String id) throws ClassNotFoundException, SQLException;
	T search(String name) throws ClassNotFoundException, SQLException;
	int update(T t)throws ClassNotFoundException,SQLException;
    int delete(String id)throws ClassNotFoundException,SQLException;
}
