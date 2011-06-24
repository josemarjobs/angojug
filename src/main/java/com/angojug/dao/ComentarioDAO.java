package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.angojug.model.Comentario;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ComentarioDAO implements Dao<Comentario> {

	private final Session session;

	private Transaction tx;

	public void beginTransation() {
		this.tx = this.session.beginTransaction();
	}

	public void commit() {
		this.tx.commit();
	}

	public ComentarioDAO(Session session) {
		this.session = session;
	}

	@Override
	public Comentario load(Serializable id) {
		Transaction tx = this.session.beginTransaction();
		Comentario comentario = (Comentario) this.session.load(
				Comentario.class, id);
		tx.commit();
		return comentario;
	}

	@Override
	public List<Comentario> list() {
		Transaction tx = this.session.beginTransaction();
		List<Comentario> comentarios = this.session.createCriteria(
				Comentario.class).list();
		tx.commit();
		return comentarios;
	}

	@Override
	public void adiciona(Comentario comentario) {
		Transaction tx = session.beginTransaction();
		session.save(comentario);
		tx.commit();
	}

	@Override
	public void remove(Comentario comentario) {
		Transaction tx = session.beginTransaction();
		session.delete(comentario);
		tx.commit();
	}

	@Override
	public void atualizar(Comentario comentario) {
		Transaction tx = session.beginTransaction();
		session.update(comentario);
		tx.commit();
	}

	@Override
	public void refresh(Comentario comentario) {
		session.refresh(comentario);
	}
}
