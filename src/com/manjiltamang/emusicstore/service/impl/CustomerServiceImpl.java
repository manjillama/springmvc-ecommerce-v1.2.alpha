package com.manjiltamang.emusicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjiltamang.emusicstore.dao.CustomerDAO;
import com.manjiltamang.emusicstore.model.Customer;
import com.manjiltamang.emusicstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDAO.insert(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDAO.getById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAll();
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		return customerDAO.getCustomerByUsername(username);
	}

}
