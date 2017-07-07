package com.manjiltamang.emusicstore.service;

import com.manjiltamang.emusicstore.model.Cart;
import com.manjiltamang.emusicstore.model.CartItem;

public interface CartItemService {
	void addCartItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllCartItems	(Cart cart);
	CartItem getCartItemByProductId(int productId);
}
