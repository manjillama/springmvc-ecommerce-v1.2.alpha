package com.manjiltamang.emusicstore.dao;

import com.manjiltamang.emusicstore.model.Customer;

public interface CustomerDAO extends GenericDAO<Customer>{
	Customer getCustomerByUsername(String username);
}
