package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.angojug.model.Comentario;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ComentarioDAO extends GenericDAO<Comentario> {

	private final Session session;

	public ComentarioDAO(Session session) {
		super(session);
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

}
