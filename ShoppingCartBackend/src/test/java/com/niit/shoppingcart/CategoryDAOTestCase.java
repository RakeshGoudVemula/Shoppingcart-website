package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

public class CategoryDAOTestCase {

	// because we used Annotations @Repository,@Component,@Configuration

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CategoryDAO CategoryDAO;
	@Autowired
	static Category category;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the userDAO from context
		CategoryDAO = (CategoryDAO) context.getBean("CategoryDAO");

		// get the user from context
		category = (Category) context.getBean("category");

	}

/*	@Test
	public void createCategoryTestCase() {

		category.setId("2028");
		category.setName("Electronics");
		category.setDescription("all types of electronics");
		boolean flag = CategoryDAO.save(category);
		assertEquals("CreatecategoryTestCase", true, flag);

	}

	@Test
	public void updateCategoryTestCase() {
		category.setId("2025");
		category.setName("Electronics & shoes");
		category.setDescription("all types of electronics&shoes");
		boolean flag = CategoryDAO.update(category);
		assertEquals("CreatecategoryTestCase", true, flag);
	}

	@Test
	public void listCategoryTestCase() {

		int actualsize = CategoryDAO.list().size();
		// will compare actual and expected.
		assertEquals(4, actualsize);
	}

	@Test
	public void getAllCategoriesTestCase() {
		List<Category> categories = CategoryDAO.list();
	}*/
	

}