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

		CategoryDAO = (CategoryDAO) context.getBean("CategoryDAO");

		category = (Category) context.getBean("category");

	}

	@Test
	public void createCategoryTestCase() {

		category.setId("2028");
		category.setName("Electronics");
		category.setDescription("all types of electronics");
		boolean flag = CategoryDAO.save(category);
		assertEquals("CreatecategoryTestCase", true, flag);

	}

}
