package com.hocjspservlet.dao;

import java.util.List;

import com.hocjspservlet.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void update (String sql, Object... paremeters);
	Long insert (String sql, Object... paremeters);
	int count (String sql, Object... paremeters);
}
