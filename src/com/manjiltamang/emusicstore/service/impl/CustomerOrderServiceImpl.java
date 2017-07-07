package com.manjiltamang.emusicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjiltamang.emusicstore.dao.CustomerOrderDAO;
import com.manjiltamang.emusicstore.model.Cart;
import com.manjiltamang.emusicstore.model.CartItem;
import com.manjiltamang.emusicstore.model.CustomerOrder;
import com.manjiltamang.emusicstore.service.CartService;
import com.manjiltamang.emusicstore.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
	@Autowired
	private CustomerOrderDAO customerOrderDAO;
	
	@Autowired
	private CartService cartService;
	@Override
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDAO.addCustomerOrder(customerOrder);
		
	}

	@Override
	public double getCustomerOrderGrandTotal(int cartId) {
		double grandTotal = 0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem cartItem : cartItems){
			grandTotal += cartItem.getTotalPrice();
		}
		return grandTotal;
	}

}
