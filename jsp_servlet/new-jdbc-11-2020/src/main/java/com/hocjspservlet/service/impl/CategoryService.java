package com.hocjspservlet.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hocjspservlet.dao.ICategoryDAO;
import com.hocjspservlet.dao.impl.CategoryDAO;
import com.hocjspservlet.model.CategoryModel;
import com.hocjspservlet.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDAO categoryDao;
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}
