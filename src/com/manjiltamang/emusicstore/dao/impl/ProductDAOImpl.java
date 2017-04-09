package com.manjiltamang.emusicstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manjiltamang.emusicstore.dao.ProductDAO;
import com.manjiltamang.emusicstore.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getAll() throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();
		return products;
	}

	@Override
	public int insert(Product product) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
		return 0;
	}

	@Override
	public Product getById(String id) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		return product;
	}

	@Override
	public Product search(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Product product) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
		return 0;
	}

	@Override
	public int delete(String id) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getById(id));
		session.flush();
		return 0;
	}
	
	
}
