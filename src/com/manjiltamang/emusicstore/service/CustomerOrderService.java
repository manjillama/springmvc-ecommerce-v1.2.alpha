package com.manjiltamang.emusicstore.service;

import com.manjiltamang.emusicstore.model.CustomerOrder;

public interface CustomerOrderService {
	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(int cartId);
	
}
