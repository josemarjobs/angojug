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
public class UserDAO extends GenericDAO<User> {

	private final Session session;

	public UserDAO(Session session) {
		super(session);
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
		User carregado = (User) this.session
				.createCriteria(User.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
		return carregado;
	}
}
