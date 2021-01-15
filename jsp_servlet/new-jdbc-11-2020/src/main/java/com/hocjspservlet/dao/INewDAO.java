package com.hocjspservlet.dao;

import java.util.List;

import com.hocjspservlet.model.NewModel;
import com.hocjspservlet.paging.Pageble;

public interface INewDAO {
	NewModel findOne(Long id);

	List<NewModel> findByCategoryById(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel newModel);

	void delete(long id);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
