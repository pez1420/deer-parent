package com.longlydeer.deer.common.core.service;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {

	public abstract void save(T entity);
	
	public abstract void update(T entity);
	
	public abstract T find(ID id);
	
	public abstract void remove(ID id);
	
	public abstract void remove(ID... ids);
	
	public abstract long count();	
	
}
