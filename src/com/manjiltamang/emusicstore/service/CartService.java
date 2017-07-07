package com.manjiltamang.emusicstore.service;

import com.manjiltamang.emusicstore.model.Cart;

public interface CartService {
	Cart getCartById(int cartId);
	void updateCart(Cart cart);
}
