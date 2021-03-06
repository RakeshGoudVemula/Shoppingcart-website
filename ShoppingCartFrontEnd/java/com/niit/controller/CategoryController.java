package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

import ch.qos.logback.classic.Logger;

@Controller
public class CategoryController {

	@Autowired
	HttpSession session;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;

	private static Logger log = (Logger) LoggerFactory.getLogger(CategoryController.class);

	@RequestMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {

		ModelAndView mv = new ModelAndView("Home");

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		// Before calling save method,check whether the category id already
		// exist in db or not

		// if it does not exist ,then only call save method.

		if (categoryDAO.getCategoryByID(id) != null) {
			mv.addObject("errorMessage", "Category already Exist with the same id" + id);
			return mv;
		} else {
			categoryDAO.save(category);
			mv.addObject("cMessage", "Category creation success with id : " + id);			
			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category",category);

		}
			
		
		return mv;

	}

	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) {

		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");

		// check whether

		/*
		 * productDAO.getAllProductsByCategoryID(id).size()!=0) { mv.addObject(
		 * "message","few products are there under this category.you can not delete"
		 * ); }
		 */
		if (categoryDAO.delete(id)) {
			mv.addObject("message", "successfully deleted the category");
		} else {
			mv.addObject("message", "Not able to delte the category");
		}

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		log.debug("Ending of the method deleteCategory");

		return mv;

	}

	// Edit category
	@RequestMapping("/manage-category-edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id) {
		log.debug("Starting of method editCategory");
		log.info("You are about to edit a category with id : " + id);

		category = categoryDAO.getCategoryByID(id);

		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		mv.addObject("selectedCategory", category);
		session.setAttribute("selectedCategory", category);
		session.setAttribute("isAdminClickedManageCategoryEdit", "true");

		log.debug("Ending of method editCategory");

		return mv;
	}

	@RequestMapping("/manage_category_update")
	public ModelAndView updateCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		log.debug("Starting of method updateCategory");
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		session.setAttribute("isAdminClickedManageCategoryEdit", "false");	


		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		if (categoryDAO.getCategoryByID(id) == null) {
			mv.addObject("cMessage", "Category does not exists with id : " + id);
			return mv;
		} else {
			categoryDAO.update(category);
			mv.addObject("cMessage", "Category updated success with id : " + id);

		}

		// get all categories
		List<Category> categoryList = categoryDAO.list();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", new Category());
		session.setAttribute("isAdminClickedManageCategoryEdit", "false");

		log.debug("Ending of updateCategory");
		return mv;
	}

}
