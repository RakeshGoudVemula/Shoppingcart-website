package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class AdminController {
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@Autowired
	HttpSession session;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	Supplier supplier;

	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories() {

		ModelAndView mv = new ModelAndView("Home");

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		return mv;
	}

	@RequestMapping("/manageSuppliers")
	public ModelAndView manageSuppliers() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");

		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("supplier", supplier);

		return mv;
	}

	@RequestMapping("/manageProducts1")
	public ModelAndView manageProducts() {
		ModelAndView mv = new ModelAndView("Home");
		
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");
		return mv;
	}

}
