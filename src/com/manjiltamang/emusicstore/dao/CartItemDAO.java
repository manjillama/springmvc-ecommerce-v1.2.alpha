package com.manjiltamang.emusicstore.dao;

import com.manjiltamang.emusicstore.model.Cart;
import com.manjiltamang.emusicstore.model.CartItem;

public interface CartItemDAO {
	void addCartItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllCartItems	(Cart cart);
	CartItem getCartItemByProductId(int productId);
}
