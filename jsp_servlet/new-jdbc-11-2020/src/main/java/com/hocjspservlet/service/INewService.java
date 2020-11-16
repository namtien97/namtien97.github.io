package com.hocjspservlet.service;

import java.util.List;

import com.hocjspservlet.model.NewModel;

public interface INewService {
	List<NewModel> fillByCategoryId(Long categoryId);
	NewModel save(NewModel newMdel);
}
