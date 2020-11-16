package com.hocjspservlet.dao.impl;

import java.util.List;

import com.hocjspservlet.dao.INewDAO;
import com.hocjspservlet.mapper.NewMapper;
import com.hocjspservlet.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryById(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "INSERT INTO news(title, content, categoryid) VALUES(?, ?, ?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(),newModel.getCategoryId());
	}
}
