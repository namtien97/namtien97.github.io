package com.hocjspservlet.service;

import java.util.List;

import com.hocjspservlet.model.NewModel;
import com.hocjspservlet.paging.Pageble;

public interface INewService {
	List<NewModel> fillByCategoryId(Long categoryId);

	NewModel save(NewModel newModel);

	NewModel update(NewModel updateNew);

	void delete(long[] ids);
	
	List<NewModel> findAll(Pageble pageble);
	
	int getTotalItem();
	
	NewModel findOne(long id);
}
