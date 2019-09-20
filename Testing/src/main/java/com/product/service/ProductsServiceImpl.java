package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.ProductsDao;
import com.product.model.Products;

@Service("productsService")
@Transactional
public class ProductsServiceImpl implements ProductsService{

	@Autowired
	private ProductsDao productsDao;
	@Override
	public void addProducts(Products products) {
		productsDao.addProducts(products);
	}
	@Override
	public void updateProducts(Products products) {
		productsDao.updateProducts(products);
		
	}
	@Override
	public List<Products> getAllProduts() {
		return productsDao.getAllProduts();
		
	}
	@Override
	public void deleteProduct(Integer id) {
	productsDao.deleteProduct(id);
		
	}
	@Override
	public Products getProduct(Integer id) {
		return productsDao.getProduct(id);
	}

}
