package com.product.dao;

import java.util.List;

import com.product.model.Products;

public interface ProductsDao {
public void addProducts(Products products);
public void updateProducts(Products products);
public List<Products> getAllProduts();
public void deleteProduct(Integer id);
public Products getProduct(Integer id);
}
