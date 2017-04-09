package com.manjiltamang.emusicstore.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manjiltamang.emusicstore.dao.ProductDAO;
import com.manjiltamang.emusicstore.model.Product;;

@Controller
public class HomeController {
	
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request){
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		return "home";
	}
	
	@RequestMapping("/products")
	public String getProducts(Model model) throws ClassNotFoundException, SQLException{
		List<Product> products = productDAO.getAll();
		
//		for (Product list: products ){
//			System.out.println(list.getProductName());
//		}
		model.addAttribute("products",products);
		return "productlist";
	} 
	
	@RequestMapping("/products/detail/{productId}")
	public String viewProduct(HttpServletRequest request,@PathVariable String productId, Model model) throws ClassNotFoundException, SQLException{
		Product product = productDAO.getById(productId);
		model.addAttribute(product);
		return "viewProduct";
	}
	
	
	
}
