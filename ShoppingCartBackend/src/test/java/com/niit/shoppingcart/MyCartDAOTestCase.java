package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.domain.MyCart;

public class MyCartDAOTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static MyCartDAO myCartDAO;
	@Autowired
	static MyCart myCart;
	
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the SupplierDAO from context
		myCartDAO = (MyCartDAO) context.getBean("myCartDAO");

		// get the supplier from context
		myCart = (MyCart) context.getBean("myCart");
	}
	@Test
	public void createMyCartTestCase()
	{
		myCart.setId("8956");
		myCart.setUser_id("rakesh");
		myCart.setProduct_name("DELL LAPTOP");
		myCart.setPrice("50000");
		myCart.setQuantity("2");
		boolean flag=myCartDAO.save(myCart);
		assertEquals("CreateMyCartTestCase", true, flag);

	}
	
	
	

}
