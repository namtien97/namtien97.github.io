package com.hocjspservlet.dao;

import java.util.List;

import com.hocjspservlet.model.NewModel;

public interface INewDAO{
	List<NewModel> findByCategoryById(Long categoryId);
	Long save(NewModel newModel);
}
