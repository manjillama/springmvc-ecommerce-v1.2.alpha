package com.manjiltamang.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.manjiltamang.emusicstore.dao.ProductDAO;
import com.manjiltamang.emusicstore.model.Product;

@Controller
public class AdminController {
	// File|Image input
	private Path path;
		
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/admin")
	public String adminPage(){
		return "admin/admin";
	}
	
	@RequestMapping("/admin/productinventory")
	public String productInventory(Model model) throws ClassNotFoundException, SQLException{
		List<Product> products = productDAO.getAll();
		model.addAttribute("products",products);
		return "admin/productInventory";
	}
	
	@RequestMapping("/admin/productinventory/addproduct")
	public String addProduct(Model model){
		Product product = new Product();
		
		model.addAttribute("product", product);
		return "admin/addProduct";
	}
	
	@RequestMapping(value="/admin/productinventory/addproduct", method=RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product,BindingResult result, HttpServletRequest request) throws ClassNotFoundException, SQLException{
		if(result.hasErrors()){
			return "admin/addProduct";
		}
		
		productDAO.insert(product);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		path= Paths.get(rootDirectory+"/resources/images/products/"+product.getProductId()+".png");
		//System.out.println("file path: "+path.toString());
		if(productImage != null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException("Product image saving fail", ex);
			}
		}
		return "redirect:/admin/productinventory";
	}
	
	@RequestMapping("/admin/productinventory/deleteproduct/{id}")
	public String deleteProduct(@PathVariable String id, Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
		// For picture delete 
		String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		path= Paths.get(rootDirectory+"/resources/images/products/"+id+".png");
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		//database column delete
		productDAO.delete(id);
		
		
		return "redirect:/admin/productinventory";
	}
	
	@RequestMapping("/admin/productinventory/editproduct/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) throws ClassNotFoundException, SQLException{
		Product product = productDAO.getById(id);	
		model.addAttribute(product);
		return "admin/editProduct";
	}
	
	@RequestMapping(value="/admin/productinventory/editproduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product,BindingResult result, Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException{
		if(result.hasErrors()){
			return "admin/editProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path= Paths.get(rootDirectory+"/resources/images/products/"+product.getProductId()+".png");
		
		if(productImage != null && !productImage.isEmpty()){
			try{
				
				productImage.transferTo(new File(path.toString()));
				System.out.println("The image upload path is"+(path.toString()));
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException("Product Image Saving Failed", ex);
			}
		}
		productDAO.update(product);
		return "redirect:/admin/productinventory";
	}
}
