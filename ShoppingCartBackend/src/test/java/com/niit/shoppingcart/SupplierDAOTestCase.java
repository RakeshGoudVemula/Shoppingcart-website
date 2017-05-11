package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;

import com.niit.shoppingcart.dao.SupplierDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO SupplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the SupplierDAO from context
		SupplierDAO = (SupplierDAO) context.getBean("SupplierDAO");

		// get the supplier from context
		supplier = (Supplier) context.getBean("supplier");
	}

	@Test
	public void createSupplierTestCase() {
		supplier.setId("1002");
		supplier.setName("Nokia");
		supplier.setDescription("standard company");
		boolean flag =SupplierDAO.save(supplier);
		assertEquals("CreateSupplierTestCase", true, flag);

	}
	
	@Test
	public void updateSupplierTestCase() {
		supplier.setId("1002");
		supplier.setName("Nokia &samsung");
		supplier.setDescription("standard companies");
		boolean flag =SupplierDAO.update(supplier);
		assertEquals("UpdateSupplierTestCase", true, flag);

	}
	
	@Test
	public void listCategoryTestCase() {

		int actualsize = SupplierDAO.list().size();
		// will compare actual and expected.
		assertEquals(4, actualsize);
	}

	
	
	

}
