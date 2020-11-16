package com.hocjspservlet.dao.impl;

import java.util.List;

import com.hocjspservlet.dao.ICategoryDAO;
import com.hocjspservlet.mapper.CategoryMapper;
import com.hocjspservlet.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql,new CategoryMapper());
	}
	
}
