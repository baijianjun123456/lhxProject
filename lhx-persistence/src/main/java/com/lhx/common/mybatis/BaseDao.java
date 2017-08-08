package com.lhx.common.mybatis;

import java.util.List;

public interface BaseDao<T,Q> {
	
	public void save(T model);
	
	public int delete(String id_);
	
	public int update(T model);
	
	public T query(String id);
	
	public List<T> queryList(T model);
	
	public List<T> queryListPage(Q modelQuery);
}
