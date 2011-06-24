package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

import com.angojug.model.Tag;

@Component
public class TagDAO implements Dao<Tag> {

	private Session session;
	private Transaction tx;

	public void beginTransation() {
		this.tx = this.session.beginTransaction();
	}

	public void commit() {
		this.tx.commit();
	}

	public TagDAO(Session session) {
		this.session = session;
	}

	@Override
	public Tag load(Serializable id) {
		return (Tag) this.session.load(Tag.class, id);
	}

	@Override
	public List<Tag> list() {
		return this.session.createCriteria(Tag.class).list();
	}

	public Tag existeTag(Tag tag) {
		Tag encontrado = (Tag) this.session.createCriteria(Tag.class)
				.add(Restrictions.eq("nome", tag.getNome())).uniqueResult();
		return encontrado;
	}
	
	@Override
	public void adiciona(Tag tag) {
		// Transaction tx = session.beginTransaction();
		session.save(tag);
		// tx.commit();
	}

	@Override
	public void remove(Tag tag) {
		Transaction tx = session.beginTransaction();
		session.delete(tag);
		tx.commit();
	}

	@Override
	public void atualizar(Tag tag) {
		Transaction tx = session.beginTransaction();
		session.update(tag);
		tx.commit();
	}

	@Override
	public void refresh(Tag tag) {
		session.refresh(tag);
	}

}
