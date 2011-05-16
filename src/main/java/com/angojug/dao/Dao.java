package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

	public void adiciona(T bean);

	public void remove(T bean);

	public T load(Serializable id);

	public void atualizar(T bean);

	public List<T> list();

	public void refresh(T bean);

}
