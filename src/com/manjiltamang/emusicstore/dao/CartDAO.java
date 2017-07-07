package com.manjiltamang.emusicstore.dao;

import java.io.IOException;

import com.manjiltamang.emusicstore.model.Cart;

public interface CartDAO {
	Cart getCartById(int cartId);
	void updateCart(Cart cart);
	Cart validate(int cartId) throws IOException;
}
	
