package com.product.service;

import java.util.List;

import com.product.model.Products;

public interface ProductsService {
public void addProducts(Products products);
public void updateProducts(Products products);
public List<Products> getAllProduts();
public void deleteProduct(Integer id);
public Products getProduct(Integer id);
}
