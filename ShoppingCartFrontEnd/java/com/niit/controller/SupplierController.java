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
		int noOfProducts = productDAO.getAllProductsBySupplierId(id).size();
		if (noOfProducts != 0) {
			log.debug("Few products are there by this seller, you cannot delete!");
			session.setAttribute("supplierMessage",
					"There are " + noOfProducts + " products under this " + id + " seller, you cannot delete!");
			return mv;
		}

		if (supplierDAO.delete(id) == true) {
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
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		mv.addObject("selectedSupplier", supplier);
		session.setAttribute("selectedSupplier", supplier);
		session.setAttribute("isAdminClickedManageSupplierEdit", "true");

		log.debug("Ending of method editSupplier");

		return mv;
	}

	@RequestMapping("/manage_supplier_update")
	public ModelAndView updateSupplier(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		log.debug("Starting of method updateSupplier");
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		session.setAttribute("isAdminClickedManageSupplierEdit", "false");

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

		session.setAttribute("isAdminClickedManageSupplierEdit", "false");

		log.debug("Ending of updateSupplier");
		return mv;
	}

}