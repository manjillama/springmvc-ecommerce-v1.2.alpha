package com.manjiltamang.emusicstore.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

import com.manjiltamang.emusicstore.model.Product;
import com.manjiltamang.emusicstore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProduct {
	private Path path;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/productinventory/addProduct")
	public String addProduct(Model model){
		Product product =  new Product();
		model.addAttribute("product", product);
		return "admin/addProduct";
	}
	
	@RequestMapping(value="/productinventory/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product,
							BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			return "admin/addProduct";
		}
		
		productService.addProduct(product);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/resources/images/products/"+product.getProductId()+".png");
		System.out.println(path.toString());
		if(productImage !=null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}
		return "redirect:/admin/productinventory";
	}
	
	@RequestMapping("/productinventory/editproduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model){
		Product product =  productService.getProductById(id);
		model.addAttribute("product", product);
		return "admin/editProduct";
	}
	
	@RequestMapping(value="/productinventory/editproduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product,
							BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			return "admin/editProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/resources/images/products/"+product.getProductId()+".png");
		System.out.println(path.toString());
		if(productImage !=null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}
		productService.editProduct(product);
		return "redirect:/admin/productinventory";
	}
	
	@RequestMapping("/productinventory/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request){
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/resources/images/products/"+id+".png");
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		Product product = productService.getProductById(id);
		productService.deleteProduct(product);
		return "redirect:/admin/productinventory";
	}
}
