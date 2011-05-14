package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.angojug.model.User;
import com.angojug.util.HibernateUtil;

public class UserDAO implements Dao<User> {

	private Session session;

	public UserDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public void adiciona(User user) {
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public void remove(User user) {
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}

	@Override
	public User get(Serializable id) {
		Transaction tx = session.beginTransaction();
		User user = (User) session.load(User.class, id);
		tx.commit();
		return user;
	}

	@Override
	public void atualizar(User user) {
		Transaction tx = session.beginTransaction();
		session.merge(user);
		tx.commit();

	}

	@Override
	public List<User> list() {
		Transaction tx = session.beginTransaction();
		List<User> users = session.createCriteria(User.class).list();
		tx.commit();
		return users;
	}

}
