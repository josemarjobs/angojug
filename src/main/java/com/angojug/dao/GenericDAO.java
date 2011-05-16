package com.angojug.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDAO<T> implements Dao<T> {

	private final Session session;

	public GenericDAO(Session session) {
		this.session = session;
	}

	@Override
	public void adiciona(T bean) {
		Transaction tx = session.beginTransaction();
		session.save(bean);
		tx.commit();
	}

	@Override
	public void remove(T bean) {
		Transaction tx = session.beginTransaction();
		session.delete(bean);
		tx.commit();
	}

	@Override
	public void atualizar(T bean) {
		Transaction tx = session.beginTransaction();
		session.update(bean);
		tx.commit();
	}

	@Override
	public void refresh(T bean) {
		session.refresh(bean);
	}

}
