package com.manjiltamang.emusicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjiltamang.emusicstore.dao.CartDAO;
import com.manjiltamang.emusicstore.model.Cart;
import com.manjiltamang.emusicstore.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public Cart getCartById(int cartId) {
		
		return cartDAO.getCartById(cartId);
	}

	@Override
	public void updateCart(Cart cart) {
		cartDAO.updateCart(cart);
		
	}

}
