package com.hocjspservlet.dao;

import java.util.List;

import com.hocjspservlet.model.CategoryModel;

public interface ICategoryDAO  {
	List<CategoryModel> findAll();
}
