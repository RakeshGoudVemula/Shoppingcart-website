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

	public MyCartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean save(MyCart myCart) {

		try {
			sessionFactory.getCurrentSession().save(myCart);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(MyCart myCart) {

		try {
			sessionFactory.getCurrentSession().update(myCart);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {

		try {
			sessionFactory.getCurrentSession().delete(getCartById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Override
	public List<MyCart> list(String userID) {
		return sessionFactory.getCurrentSession().createQuery("from MyCart where user_id=?").setString(0, userID)
				.list();
	}

	@Override
	public double getTotalAmount(String userID) {

		return (Double) sessionFactory.getCurrentSession().createQuery("select sum(price) from MyCart where user_id=?")
				.setString(0, userID).uniqueResult();

	}

	@Override
	public MyCart getCartById(int id) {

		return (MyCart) sessionFactory.getCurrentSession().createQuery("from MyCart where id = ?").setInteger(0, id)
				.uniqueResult();

	}

}
