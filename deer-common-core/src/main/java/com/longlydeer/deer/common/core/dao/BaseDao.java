package com.longlydeer.deer.common.core.dao;

import java.io.Serializable;

/**
 *  Dao泛型基本接口
 * @author pez1420
 *
 * @param <T>  实体类
 * @param <ID> 主键类, 必须实现Serializable接口
 */
public interface BaseDao<T, ID extends Serializable>{
	
	/**
	 * 增加一个实体,数据库增加一条记录
	 * @param entity
	 */
	public  void save(T entity);
	
	/**
	 * 修改一个实体
	 * @param entity
	 */
	public  void update(T entity);
	
	/**
	 * 主键返回对应实体
	 * @param id
	 * @return entity
	 */
	public  T find(ID id);
	
	/**
	 * 按主键删除记录
	 * @param id
	 */
	public  void remove(ID id);
	
	/**
	 * 统计记录总数
	 * @return
	 */
	public  long count();
}
