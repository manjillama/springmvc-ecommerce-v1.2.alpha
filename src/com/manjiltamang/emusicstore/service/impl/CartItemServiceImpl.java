package com.manjiltamang.emusicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjiltamang.emusicstore.dao.CartItemDAO;
import com.manjiltamang.emusicstore.model.Cart;
import com.manjiltamang.emusicstore.model.CartItem;
import com.manjiltamang.emusicstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDAO.addCartItem(cartItem);
		
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDAO.removeCartItem(cartItem);
		
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDAO.removeAllCartItems(cart);
		
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		return cartItemDAO.getCartItemByProductId(productId);
	}

}
