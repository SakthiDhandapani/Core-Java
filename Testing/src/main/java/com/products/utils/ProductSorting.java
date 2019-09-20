package com.products.utils;

import java.util.Comparator;

import com.product.model.Products;

public class ProductSorting {
	/**
	 * Sort the warranty years
	 */

	public static Comparator<Products> SortWarrentyYear = new Comparator<Products>(){

		@Override
		public int compare(Products obj1, Products obj2) {
			 
			return obj1.getProductWarrenty() -obj2.getProductWarrenty();
		}
		
	};
	/**
	 * Sort the Product Prize
	 */
	public static Comparator<Products> sortProductPrize = new Comparator<Products>(){

		@Override
		public int compare(Products obj1, Products obj2) {
			 
			return (int) (obj1.getProductPrize() - obj2.getProductPrize());
		}
		
	};
	/**
	 * Sort the Product Name
	 */
	public static Comparator<Products> sortProductName = new Comparator<Products>(){

		@Override
		public int compare(Products obj1, Products obj2) {
			 
			return obj1.getProductName().compareTo(obj2.getProductName());
		}
		
	};
}
