package com.manjiltamang.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manjiltamang.emusicstore.dao.CustomerDAO;
import com.manjiltamang.emusicstore.model.Authorities;
import com.manjiltamang.emusicstore.model.Cart;
import com.manjiltamang.emusicstore.model.Customer;
import com.manjiltamang.emusicstore.model.Users;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Customer");
		List<Customer> customerList = query.list();
		return customerList;
	}

	@Override
	public void insert(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users newUser = new Users();
		newUser.setUsername(customer.getCustomerName());
		newUser.setPassword(customer.getPassword());		
		newUser.setEnabled(true); 
		newUser.setCustomerId(customer.getCustomerId());
		session.saveOrUpdate(newUser);
		
		Authorities newAuthority = new Authorities();
		newAuthority.setUsername(customer.getUsername());
		newAuthority.setAuthority("ROLE_USER");
		session.saveOrUpdate(newAuthority );
		
		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(newCart);
		
		session.flush();
	}

	@Override
	public Customer getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, id);
	}

	@Override
	public void update(Customer t) {
		
		
	}

	@Override
	public void delete(Customer t) {
		
		
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where username = ?");
		query.setString(0, username);
		return (Customer) query.uniqueResult();
	}

}
