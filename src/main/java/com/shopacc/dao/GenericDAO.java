package com.shopacc.dao;

import java.util.List;

import com.shopacc.mapper.RowMapper;

public interface GenericDAO <T>{
	<T> List<T> query(String sql,RowMapper<T> rowMapper,Object... parameters);
	int insert(String sql, Object...parameters);
	int count(String sql, Object...parameters);
	void update(String sql, Object...parameters);
}
