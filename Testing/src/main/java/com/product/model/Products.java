package com.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Integer productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productModel")
	private String productModel;
	@Column(name = "productPrize")
	private double productPrize;
	@Column(name = "productYear")
	private int productYear;
	@Column(name = "productWarrenty")
	private int productWarrenty;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

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

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productModel=" + productModel
				+ ", productPrize=" + productPrize + ", productYear=" + productYear + ", productWarrenty="
				+ productWarrenty + "]";
	}
	
}
