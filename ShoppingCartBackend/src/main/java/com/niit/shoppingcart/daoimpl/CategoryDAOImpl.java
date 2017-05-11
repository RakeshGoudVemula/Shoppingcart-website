package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

@Repository("CategoryDAO") // To create singleton instance
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// write own or user defined constructor with one parameter i.e.,
	// sessionFactory

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Category category) {

		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			// If any exception comes during execute of try block,catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			// If any exception comes during execute of try block,catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@SuppressWarnings("unchecked")
	public List<Category> list() {

		return sessionFactory.getCurrentSession().createQuery("from Category").list();

	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;

	}

	public Category getCategoryByID(String id) {
		// select * from category where id=?

		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

	}

	public Category getCategoryByName(String name) {

		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name=?")
				.setString(0, name).uniqueResult();

	}

}
