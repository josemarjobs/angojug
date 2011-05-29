package com.angojug.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

import com.angojug.model.Tag;
import com.angojug.model.User;

@Component
public class TagDAO extends GenericDAO<Tag> {

	private Session session;

	public TagDAO(Session session) {
		super(session);
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
				.add(Restrictions.eq("nome", tag.getNome()))
				.uniqueResult();
		return encontrado;
	}

}
