package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller
public class HomeController {

	@Autowired
	HttpSession session;
	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;

	@RequestMapping({ "/", "/Home" })
	public ModelAndView goToHome() {
		ModelAndView mv = new ModelAndView("Home");

		mv.addObject("isUserAtRoot", "true");
		mv.addObject("message", "Thank you for visiting shopping cart");

		List<Category> categoryList = categoryDAO.list();

		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);

		List<Product> productList = productDAO.list();

		session.setAttribute("productList", productList);
		session.setAttribute("product", product);
		return mv;
	}

	@RequestMapping("/Login")
	public String loginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");

		Long currentTime = System.currentTimeMillis();
		Date currentDate = new Date(currentTime);

		return "Home";
	}

	@RequestMapping("/RegistrationPage")
	public String registrationPage(Model model) {
		model.addAttribute("isUserClickedRegister", "true");

		return "Home";
	}

	@RequestMapping("/ContactUs")
	public String contactUsPage(Model model) {
		model.addAttribute("isUserClickedContactUs", "true");
		return "Home";
	}

}
