package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

import com.angojug.model.Postagem;

@Component
public class PostDAO extends GenericDAO<Postagem> {

	private final Session session;

	public PostDAO(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Postagem load(Serializable id) {
		Transaction tx = this.session.beginTransaction();
		Postagem post = (Postagem) this.session.load(Postagem.class, id);
		tx.commit();
		return post;
	}

	@Override
	public List<Postagem> list() {
		Transaction tx = this.session.beginTransaction();
		List<Postagem> posts = (List<Postagem>) this.session.createCriteria(Postagem.class)
				.list();
		return posts;
	}

}
