package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;
	@Autowired
	static User user;

	// the above objects need to initialize
	/**
	 * This method is going to execute before calling any one of the test case
	 * and will execute only once
	 */

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the userDAO from context
		userDAO = (UserDAO) context.getBean("userDAO");

		// get the user from context
		user = (User) context.getBean("user");

	}

	@Test
	public void createUserTestCase() {
		user.setId("1009");
		user.setName("rakesh");
		user.setPassword("password");
		user.setRole("Admin");
		user.setContact("8965456");
		boolean flag = userDAO.save(user);
		assertEquals("CreateUserTestCase", true, flag);

	}

	/*@Test
	public void updateUserTestCase() {
		user.setId("rakesh");
		user.setName("Chintu");
		user.setPassword("password");
		user.setRole("Admin");
		user.setContact("8965456");
		boolean flag = userDAO.update(user);

		// this assertEquals method
		// error-if there is any runtime error- Red mark
		// success-if expected and actual is same- green mark
		// fail-if expected and actual is different- blue mark
		assertEquals("UpdateUserTestCase", true, flag);

	}

	@Test
	public void validateUserTestCase() {
		boolean flag = userDAO.validate("Chintu", "password");

		assertEquals(true, flag);
	}

	@Test
	public void listAllUserTestCase() {

		int actualsize = userDAO.list().size();
		// will compare actual and expected.
		assertEquals(4, actualsize);

	}*/

}
