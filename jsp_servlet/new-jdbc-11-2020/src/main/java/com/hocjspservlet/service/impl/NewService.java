package com.hocjspservlet.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.hocjspservlet.dao.ICategoryDAO;
import com.hocjspservlet.dao.INewDAO;
import com.hocjspservlet.model.CategoryModel;
import com.hocjspservlet.model.NewModel;
import com.hocjspservlet.paging.Pageble;
import com.hocjspservlet.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<NewModel> fillByCategoryId(Long categoryId) {
		return newDao.findByCategoryById(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDao.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}
}
