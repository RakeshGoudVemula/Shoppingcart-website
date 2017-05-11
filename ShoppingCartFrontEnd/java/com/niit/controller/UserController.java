package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	
	@Autowired
	HttpSession session;

	@PostMapping("validate")
	public ModelAndView login(@RequestParam("userName") String id, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView("/Home");
		if (userDAO.validate(id, password) == true)

		{
			user = userDAO.get(id);
			mv.addObject("message", "Welcome" + user.getName());

			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", categoryDAO);
			
			
			//store id in session
			session.setAttribute("LoggedInUserID",id);

			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplierDAO);

			if (user.getRole().equals("Admin")) 
			{
				
				mv.addObject("isAdmin", true);
				session.setAttribute("role","Admin");
			} 
			else {
				mv.addObject("isAdmin", false);
				session.setAttribute("role","User");

			}

		} 
		else {
			mv.addObject("message", "Invalid credentials..please try again");
		}
		
		return mv;
	}

}
