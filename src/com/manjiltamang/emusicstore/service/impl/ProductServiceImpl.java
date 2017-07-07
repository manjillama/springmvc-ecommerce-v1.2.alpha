package com.manjiltamang.emusicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjiltamang.emusicstore.dao.ProductDAO;
import com.manjiltamang.emusicstore.model.Product;
import com.manjiltamang.emusicstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Product> getProductList()  {
		return productDAO.getAll();
	}

	@Override
	public Product getProductById(int id)  {
		return productDAO.getById(id);
	}

	@Override
	public void addProduct(Product product)  {
		productDAO.insert(product);
	}

	@Override
	public void editProduct(Product product)  {
		productDAO.update(product);		
	}

	@Override
	public void deleteProduct(Product product) {
		productDAO.delete(product);
		
	}

}
