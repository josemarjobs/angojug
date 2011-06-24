package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.caelum.vraptor.ioc.Component;

import com.angojug.model.Postagem;

/**
 * 
 * @author josemarjobs
 * @since 15/05/2011 23:40
 */

@Component
public class PostDAO implements Dao<Postagem> {

	private final Session session;
	private Transaction tx;

	public PostDAO(Session session) {
		this.session = session;
	}

	public void beginTransation() {
		this.tx = this.session.beginTransaction();
	}

	public void commit() {
		this.tx.commit();
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
		List<Postagem> posts = (List<Postagem>) this.session
				.createCriteria(Postagem.class).addOrder(Order.desc("data"))
				.list();
		return posts;
	}

	@Override
	public void adiciona(Postagem post) {
		// Transaction tx = session.beginTransaction();
		session.save(post);
		// tx.commit();
	}

	public void adiciona(Postagem post, boolean commit) {
		Transaction tx = session.beginTransaction();
		session.save(post);
		tx.commit();
	}

	@Override
	public void remove(Postagem post) {
		Transaction tx = session.beginTransaction();
		session.delete(post);
		tx.commit();
	}

	@Override
	public void atualizar(Postagem post) {
		Transaction tx = session.beginTransaction();
		session.update(post);
		tx.commit();
	}

	@Override
	public void refresh(Postagem post) {
		session.refresh(post);
	}

}
