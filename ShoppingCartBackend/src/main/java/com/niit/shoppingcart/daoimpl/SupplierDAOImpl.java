package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Repository("SupplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// write own or user defined constructor with one parameter i.e.,
	// sessionFactory

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Supplier supplier) {

		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			// If any exception comes during execute of try block,catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			// If any exception comes during execute of try block,catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public Supplier getSupplierByID(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	public Supplier getSupplierByName(String name) {
		// TODO Auto-generated method stub
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where name = ?")
				.setString(0, name).uniqueResult();
	}

	@Override
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierByID(id));
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
