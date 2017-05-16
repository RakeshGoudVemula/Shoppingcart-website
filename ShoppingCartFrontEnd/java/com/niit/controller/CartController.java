package com.niit.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.MyCart;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CartController {
	
	
	@Autowired
	MyCart myCart;
	
	

	@Autowired
	MyCartDAO myCartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	HttpSession session;
	
	
	private static Logger log = (Logger) LoggerFactory.getLogger(CartController.class);


	@RequestMapping("/myCart")
	public String myCart(Model model){
		log.debug("Starting of myCart in CartController");
		
		model.addAttribute("myCart", myCart);
		
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		
		if(loggedInUser != null){
			int cartSize = myCartDAO.list(loggedInUser).size();
			
			if(cartSize == 0){
				model.addAttribute("errorMessage", "You do not have any products in your cart!");
			} else {
				model.addAttribute("cart", myCart);
				model.addAttribute("cartList", myCartDAO.list(loggedInUser));
				model.addAttribute("isUserClickedCart", "true");
				model.addAttribute("totalAmount", myCartDAO.getTotalAmount(loggedInUser));
				long totalAmount = (long) myCartDAO.getTotalAmount(loggedInUser);
				session.setAttribute("totalAmount", totalAmount);
				session.setAttribute("isAdmin", "false");
				//System.out.println(totalAmount);
			}
			
		}
		
		log.debug("Ending of myCart in CartController");
		return "Home";
	}
	
	
	@GetMapping("mycart/add/{id}")
	public ModelAndView addToCart(@PathVariable("id") String id){
		log.debug("Starting of addToCart in CartController");
		
		Product product = productDAO.getProductById(id);
		
		myCart.setProduct_name(product.getName());
		myCart.setPrice(product.getPrice());
		
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		
		myCart.setUser_id(loggedInUser);
		myCart.setStatus("N");
		myCart.setQuantity(1);
		myCart.setDate_added(new Date(System.currentTimeMillis()));
		session.setAttribute("isAdmin", "false");
		myCartDAO.save(myCart);
		
		//This way it will redirect to Home.jsp
		ModelAndView mv = new ModelAndView("redirect:/Home");
		mv.addObject("successMessage", "Successfully added message to your cart");
		
		log.debug("Ending of addToCart in CartController");
		return mv;
		
	}
	@GetMapping("myCart/delete/{id}")
	public ModelAndView removeFromCart(@PathVariable("id") int id){
		log.debug("Starting of removeFromCart in CartController");
		
		ModelAndView mv = new ModelAndView("redirect:/myCart");
		//Check whether products are there for this category or not
		
		if (myCartDAO.delete(id) == true) {
			mv.addObject("cartMessage", "Successfullly deleted from cart");
		} else {
			mv.addObject("cartMessage", "Failed to delete from cart");
		}
		
		log.debug("Ending of removeFromCart in CartController");
		return mv;
		
	}
	
	@GetMapping("/Thankyou")
	public ModelAndView thankyou(){
		ModelAndView mv = new ModelAndView("redirect:/Thankyou");
		session.setAttribute("isUserClickedCheckout", "true");

		return mv;

	}

}
