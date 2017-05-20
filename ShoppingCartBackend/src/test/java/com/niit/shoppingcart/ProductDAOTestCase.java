package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

		product = (Product) context.getBean("product");
	}

	@Test
	public void createProductTestCase() {
		product.setId("LAP1");
		product.setName("DELL LAPTOP");
		product.setDescription("core i7,12gb RAM");
		product.setPrice(50000);
		product.setCategory_id("cat2");
		product.setSupplier_id("test4");
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("CreateProductTestCase", true, flag);

	}

	@Test
	public void updateProductTestCase() {
		product.setId("LAP1");
		product.setName("DELL LAPTOP");
		product.setDescription("core i7,16gb RAM");
		product.setPrice(50000);
		product.setCategory_id("cat2");
		product.setSupplier_id("test4");
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("CreateProductTestCase", true, flag);

	}

}
