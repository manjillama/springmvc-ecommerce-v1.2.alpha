package com.manjiltamang.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manjiltamang.emusicstore.dao.CartItemDAO;
import com.manjiltamang.emusicstore.model.Cart;
import com.manjiltamang.emusicstore.model.CartItem;

@Repository
@Transactional
public class CartItemDAOImpl implements CartItemDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item: cartItems){
			removeCartItem(item);
		}
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From CartItem where productId = ?");
		query.setInteger(0, productId);
		session.flush();
		return (CartItem) query.uniqueResult();
	}
	

}
