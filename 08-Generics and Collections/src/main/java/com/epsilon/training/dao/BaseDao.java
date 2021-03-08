package com.epsilon.training.dao;

public interface BaseDao<T> {
	public void add(T t);
	public T get(int id);
	public void update(T t);
	public void delete(int id);
}
