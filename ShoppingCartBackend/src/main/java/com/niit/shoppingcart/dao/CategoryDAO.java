package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(String id);

	public List<Category> list();

	public Category getCategoryByID(String id);

	public Category getCategoryByName(String name);
}
