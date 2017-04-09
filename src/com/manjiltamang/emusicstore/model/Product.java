package com.manjiltamang.emusicstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="product_id")
	@NotEmpty(message = "The product name must not be null")
	private String productId;
	
	@NotEmpty(message = "The product name must not be null")
	@Column(name="product_name")
	private String productName;
	@Column(name="product_category")
	private String productCategory;
	@Column(name="product_description")
	private String productDescription;
	
	@Min(value=0, message = "The product price must not be less than zero")
	@Column(name="product_price")
	private Double productPrice;
	@Column(name="product_condition")
	private String productCondition;
	@Column(name="product_status")
	private boolean productStatus;
	
	@Column(name="product_stock")
	@Min(value=0, message = "The product price must not be less than zero")
	private int unitInStock;
	@Column(name="product_manufacturer")
	private String productManufacturer;
	@Transient
	@Column(name="product_image")
	private MultipartFile productImage;
	
	


	public Product(){}

	
	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	
	public MultipartFile getProductImage() {
		return productImage;
	}


	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
}
