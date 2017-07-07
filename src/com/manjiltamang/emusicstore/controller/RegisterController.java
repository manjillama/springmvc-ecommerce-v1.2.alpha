package com.manjiltamang.emusicstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manjiltamang.emusicstore.model.BillingAddress;
import com.manjiltamang.emusicstore.model.Customer;
import com.manjiltamang.emusicstore.model.ShippingAddress;
import com.manjiltamang.emusicstore.service.CustomerService;

@Controller
public class RegisterController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model){
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		
		return "registerCustomer";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){
		if(result.hasErrors()){
			return "registerCustomer";
		}
		
		List<Customer> customerList=customerService.getAllCustomers();
		for(int i=0;i<customerList.size();i++){
			if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())){
				model.addAttribute("emailMsg", "Email already exist");
				
				return "registerCustomer";
			}
		}
		
		for(int i=0;i<customerList.size();i++){
			if(customer.getUsername().equals(customerList.get(i).getUsername())){
				model.addAttribute("usernameMsg", "Username already exist");
				
				return "registerCustomer";
			}
		}
		
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		return "registerCustomerSuccess";
	}
}
