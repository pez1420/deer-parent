package com.longlydeer.deer.common.core.service.impl;

import com.longlydeer.deer.common.core.dao.BaseDao;
import com.longlydeer.deer.common.core.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements
		BaseService<T, ID> {

	private BaseDao<T, ID> baseDao;

	public void setBaseDao(BaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Transactional
	public void save(T entity) {
		 this.baseDao.save(entity);
	}

	@Transactional
	public void update(T entity) {
		this.baseDao.update(entity);
	}

	@Transactional(readOnly = true)
	public T find(ID id) {
		return this.baseDao.find(id);
	}

	
	public void remove(ID id) {
		this.baseDao.remove(id);
	}

	@Transactional
	public void remove(ID... ids) {
		if (ids != null) {
			for (ID id : ids) {
				remove(id);
			}
		}
	}

	public long count() {
		return baseDao.count();
	}

}
