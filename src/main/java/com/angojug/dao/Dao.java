package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import com.angojug.model.User;

public interface Dao<T> {

	public void adiciona(T bean);

	public void remove(T bean);

	public User get(Serializable id);

	public void atualizar(T bean);

	public List<T> list();

}
