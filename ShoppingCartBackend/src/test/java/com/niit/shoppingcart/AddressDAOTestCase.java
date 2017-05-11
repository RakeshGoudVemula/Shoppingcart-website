package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.AddressDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Address;
import com.niit.shoppingcart.domain.Supplier;

public class AddressDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static AddressDAO addressDAO;
	@Autowired
	static Address address;
	
	

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the SupplierDAO from context
		addressDAO = (AddressDAO) context.getBean("addressDAO");

		// get the supplier from context
		address = (Address) context.getBean("address");
	}
	@Test
	public void createAddressTestCase()
	{
		address.setId("497");
		address.setUser_id("rakesh");
		address.setH_no("1148");
		address.setStreet("LB nagar");
		address.setCity("Hyderabad");
		address.setCountry("India");
		address.setPin("500074");
		boolean flag =addressDAO.save(address);
		assertEquals("CreateSupplierTestCase", true, flag);
	}
	@Test
	public void updateAddressTestCase()
	{
		address.setId("497");
		address.setUser_id("rakesh");
		address.setH_no("1148");
		address.setStreet("dilsukhnagar");
		address.setCity("Hyderabad");
		address.setCountry("India");
		address.setPin("500074");
		boolean flag =addressDAO.update(address);
		assertEquals("CreateSupplierTestCase", true, flag);
	}
	
	
	
	
	

}
