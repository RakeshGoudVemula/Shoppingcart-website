package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.domain.MyCart;

@Transactional
@Repository("myCartDAO")
public class MyCartDAOImpl implements MyCartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// write own or user defined constructor with one parameter i.e.,
	// sessionFactory

	public MyCartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(MyCart myCart) {

		try {
			sessionFactory.getCurrentSession().save(myCart);
		} catch (Exception e) {
			// If any exception comes during execute of try block,catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(MyCart myCart) {
		try {
			sessionFactory.getCurrentSession().update(myCart);
		} catch (Exception e) {
			// If any exception comes during execute of try block,catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public List<MyCart> list() {
		return sessionFactory.getCurrentSession().createQuery("from MyCart").list();
	}

	@Override
	public MyCart get(String id) {
		// TODO Auto-generated method stub
		return (MyCart) sessionFactory.getCurrentSession().get(MyCart.class, id);
	}

	@Override
	public List<MyCart> list(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(MyCart myCart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long getTotalAmount(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyCart getCart(String userID, String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getQuantity(String userID, String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
