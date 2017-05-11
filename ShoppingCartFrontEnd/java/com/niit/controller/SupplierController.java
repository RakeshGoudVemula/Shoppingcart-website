package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	HttpSession session;

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;

	private static Logger log = (Logger) LoggerFactory.getLogger(SupplierController.class);

	@RequestMapping("/manage_supplier_add")
	public ModelAndView createSupplier(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {

		ModelAndView mv = new ModelAndView("Home");

		supplier.setId(id);
		supplier.setName(name);
		supplier.setDescription(description);

		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");
		
		
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("supplier", supplier);


		// Before calling save method,check whether the supplier id already
		// exist in db or not

		// if it does not exist ,then only call save method.

		if (supplierDAO.getSupplierByID(id) != null) {
			mv.addObject("errorMessage", "Supplier already Exist with the same id" + id);
			return mv;
		} else {
			supplierDAO.save(supplier);
			mv.addObject("cMessage", "Supplier creation success with id : " + id);

		}
		return mv;

	}

	@RequestMapping("/manage_supplier_delete/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") String id) {

		log.debug("Starting of the method deleteSupplier");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");

		// check whether

		/*
		 * productDAO.getAllProductsBySupplierID(id).size()!=0) { mv.addObject(
		 * "message","few products are there under this supplier.you can not delete"
		 * ); }
		 */
		if (supplierDAO.delete(id)) {
			mv.addObject("message", "successfully deleted the supplier");
		} else {
			mv.addObject("message", "Not able to delte the supplier");
		}

		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("supplier", supplier);

		log.debug("Ending of the method deleteSupplier");

		return mv;

	}

	// Edit supplier
	@RequestMapping("/manage-supplier-edit/{id}")
	public ModelAndView editSupplier(@PathVariable("id") String id) {
		log.debug("Starting of method editSupplier");
		log.info("You are about to edit a supplier with id : " + id);

		supplier = supplierDAO.getSupplierByID(id);

		// Selected supplier details we have to store in another instance
		// i.e., ModelAndView instance
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		mv.addObject("selectedSupplier", supplier);
		session.setAttribute("selectedSupplier", supplier);

		log.debug("Ending of method editSupplier");

		return mv;
	}

	@RequestMapping("/manage_supplier_update")
	public ModelAndView updateSupplier(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		log.debug("Starting of method updateSupplier");
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");

		supplier.setId(id);
		supplier.setName(name);
		supplier.setDescription(description);

		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");

		if (supplierDAO.getSupplierByID(id) == null) {
			mv.addObject("cMessage", "Supplier does not exists with id : " + id);
			return mv;
		} else {
			supplierDAO.update(supplier);
			mv.addObject("cMessage", "Supplier updated success with id : " + id);

		}

		// get all suppliers
		List<Supplier> supplierList = supplierDAO.list();
		// attach to session
		session.setAttribute("supplierList", supplierList);
		session.setAttribute("supplier", supplier);

		// Before calling save method, check whether supplier_id already exists
		// in db
		// if it does not exist, then only call save method.
		log.debug("Ending of updateSupplier");
		return mv;
	}

}