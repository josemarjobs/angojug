package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

import com.angojug.model.User;

/**
 * 
 * @author josemarjobs
 * @since 13/05/2011:22:43
 */
@Component
public class UserDAO implements Dao<User> {

	private final Session session;
	private Transaction tx;

	public void beginTransation() {
		this.tx = this.session.beginTransaction();
	}

	public void commit() {
		this.tx.commit();
	}

	public UserDAO(Session session) {
		this.session = session;
	}

	@Override
	public User load(Serializable id) {
		Transaction tx = session.beginTransaction();
		User user = (User) session.load(User.class, id);
		tx.commit();
		return user;
	}

	@Override
	public List<User> list() {
		Transaction tx = session.beginTransaction();
		List<User> users = session.createCriteria(User.class).list();
		tx.commit();
		return users;
	}

	public boolean existeUsuario(User usuario) {
		User encontrado = (User) this.session.createCriteria(User.class)
				.add(Restrictions.eq("Email", usuario.getEmail()))
				.uniqueResult();
		return encontrado != null;
	}

	public User carrega(User usuario) {
		User carregado = (User) this.session.createCriteria(User.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
		return carregado;
	}
	
	@Override
	public void adiciona(User tag) {
	//	Transaction tx = session.beginTransaction();
		session.save(tag);
	//	tx.commit();
	}

	@Override
	public void remove(User tag) {
		Transaction tx = session.beginTransaction();
		session.delete(tag);
		tx.commit();
	}

	@Override
	public void atualizar(User tag) {
		Transaction tx = session.beginTransaction();
		session.update(tag);
		tx.commit();
	}

	@Override
	public void refresh(User tag) {
		session.refresh(tag);
	}
}
