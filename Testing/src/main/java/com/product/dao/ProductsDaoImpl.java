package com.product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.model.Products;

@Repository("productsDao")
public class ProductsDaoImpl implements ProductsDao {
	private static final Logger logger = Logger.getLogger(ProductsDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProducts(Products products) {
		sessionFactory.getCurrentSession().saveOrUpdate(products);
		logger.info("Products details has been Saved successfully" + products.toString());
	}

	@Override
	public void updateProducts(Products products) {
		Session session = sessionFactory.getCurrentSession();
		session.update(products);
		logger.info("Products details has been updated successfully" + products.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getAllProduts() {
		return sessionFactory.getCurrentSession().createQuery("from Products").list();

	}

	@Override
	public void deleteProduct(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Products p = (Products) session.load(Products.class, id);
			if (null != p) {
				session.delete(p);
				System.out.println("Deleted success");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Products getProduct(Integer id) {
		return (Products) sessionFactory.getCurrentSession().get(Products.class, id);
	}

}
