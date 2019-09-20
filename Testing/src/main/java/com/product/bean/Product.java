package com.product.bean;

public class Product {
	private Integer productId;
	private String productName;
	private String productModel;
	private double productPrize;
	private int productYear;
	private int productWarrenty;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public double getProductPrize() {
		return productPrize;
	}

	public void setProductPrize(double productPrize) {
		this.productPrize = productPrize;
	}

	public int getProductYear() {
		return productYear;
	}

	public void setProductYear(int productYear) {
		this.productYear = productYear;
	}

	public int getProductWarrenty() {
		return productWarrenty;
	}

	public void setProductWarrenty(int productWarrenty) {
		this.productWarrenty = productWarrenty;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
