package com.manjiltamang.emusicstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manjiltamang.emusicstore.model.Product;
import com.manjiltamang.emusicstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	 
	@Autowired
	ProductService productService;
	
	@RequestMapping
	public String getProducts(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productList";
	}
	
	@RequestMapping("/detail/{id}")
	public String viewProduct(@PathVariable int id, Model model) throws IOException{
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}
}
