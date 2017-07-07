package com.manjiltamang.emusicstore.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manjiltamang.emusicstore.model.Customer;
import com.manjiltamang.emusicstore.model.Product;
import com.manjiltamang.emusicstore.service.CustomerService;
import com.manjiltamang.emusicstore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
	public String adminPage(){
		return "admin/admin";
	}
	
	@RequestMapping("/productinventory")
	public String productInventory(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "admin/productInventory";
	}
	
	@RequestMapping("/customer")
	public String customerManagement(Model model){
		//to add some customer service later
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList", customerList);
		
		return "admin/customerManagement";
	}
}
