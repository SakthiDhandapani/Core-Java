package com.product.controller;

import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.product.bean.Product;
import com.product.export.ProductListExcelView;
import com.product.model.Products;
import com.product.service.ProductsService;

@RestController
public class ProductsController {

	private static final Logger log = Logger.getLogger(ProductsController.class);
	@Autowired
	private ProductsService productsService;

	/**
	 * This method used to view the entire product details.
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */

	@RequestMapping(value = "/viewproducts")
	public ModelAndView getListOfProducts(ModelAndView model) throws IOException {
		List<Products> listProducts = productsService.getAllProduts();
		return new ModelAndView("viewproduct", "listProducts", listProducts);

	}

	/**
	 * This method used to add new product details in the html form
	 * 
	 * @param model
	 * @return model
	 */

	@RequestMapping(value = "/addproduct")
	public ModelAndView newContact(ModelAndView model) {
		Product product = new Product();
		model.addObject("product", product);
		model.setViewName("product");
		return model;
	}

	/**
	 * This method used to save form data into database
	 * 
	 * @param product
	 * @return viewproducts
	 */
	@RequestMapping(value = "/saveproducts", method = RequestMethod.POST)
	public ModelAndView addProducts(@ModelAttribute("command") Product product) {
		log.info("adding new products");
		System.out.println("addproducts method called");
		Products products = prepareModel(product);
		productsService.addProducts(products);
		return new ModelAndView("redirect:/viewproducts");
	}

	/**
	 * This method used to edit the product and back to save into DB
	 * 
	 * @param products
	 * @return
	 */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView updateProducts(@ModelAttribute("listProducts") Products products) {
		log.info("update existing products");
		productsService.updateProducts(products);
		return new ModelAndView("redirect:/viewproducts");
	}

	/**
	 * This method used to edit the particular method based on the id
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/editsave/{id}")
	public ModelAndView editProduct(@PathVariable("id") Integer id) {
		Products product = productsService.getProduct(id);
		return new ModelAndView("editproduct", "command", product);

	}
	/**
	 * Export the excel report
	 */
	
	@RequestMapping(value="/export", method =RequestMethod.GET)
	public ModelAndView exportIntoExcel(){
		List<Products> listOfProducts = productsService.getAllProduts();
		return new ModelAndView(new ProductListExcelView(),"listOfProducts",listOfProducts);
	}

	/**
	 * This method save the edited date into data base
	 * 
	 * @param product
	 * @return editproduct form
	 */
	@RequestMapping(value = "/editsave/", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute("product") Products product) {
		productsService.updateProducts(product);
		return new ModelAndView("editproduct", "command", product);

	}

	/**
	 * This method used to delete the particular product based on the id
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("id") Integer id) {
		log.info("Delete Prduct method has been called ->");

		productsService.deleteProduct(id);
		System.out.println("Method has been executed successfully");
		 
		return new ModelAndView("redirect:/viewproducts");
	}

	/**
	 * This method used to convert the Product bean to Products model
	 * 
	 * @param products
	 * @return Products
	 */
	private Products prepareModel(Product products) {
		Products product = new Products();
		product.setProductName(products.getProductName());
		product.setProductModel(products.getProductModel());
		product.setProductPrize(products.getProductPrize());
		product.setProductWarrenty(products.getProductWarrenty());
		product.setProductYear(products.getProductYear());
		return product;
	}

}
