package com.hocjspservlet.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hocjspservlet.dao.INewDAO;
import com.hocjspservlet.model.NewModel;
import com.hocjspservlet.service.INewService;

public class NewService implements INewService{

	@Inject
	private INewDAO newDao;

	@Override
	public List<NewModel> fillByCategoryId(Long categoryId) {
		return newDao.findByCategoryById(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		Long newId = newDao.save(newModel);
		System.out.println(newId);
		return null;
	}

}
