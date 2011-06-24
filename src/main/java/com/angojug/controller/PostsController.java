package com.angojug.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Session;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import com.angojug.dao.PostDAO;
import com.angojug.dao.TagDAO;
import com.angojug.dao.UserDAO;
import com.angojug.model.Postagem;
import com.angojug.model.Tag;
import com.angojug.model.User;
import com.angojug.model.UsuarioWeb;
import com.angojug.util.HibernateUtil;

/**
 * 
 * @author josemarjobs
 * @since 15/05/2011 23:40
 */
@Resource
public class PostsController {
	private final Result result;
	private final PostDAO dao;
	private final Validator validator;
	private final UsuarioWeb usuarioWeb;
	private final TagDAO tagDao;

	public PostsController(Result result, PostDAO dao, Validator validator,
			UsuarioWeb usuarioWeb, TagDAO tagDao) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.tagDao = tagDao;
	}

	@Get
	@Path("/posts/novo")
	public void formulario() {

	}

	@Post
	@Path("/posts")
	public void adiciona(Postagem post) {
		this.validator.validate(post);
		this.validator.onErrorRedirectTo(this).formulario();
		dao.beginTransation();
		post.setAutor(usuarioWeb.getUser());
		this.dao.adiciona(post);
		getTags(post.getMarcadores(), post);
		dao.commit();
		this.result.redirectTo(this).show(post.getId());
	}

	@Get
	@Path("/posts/{id}")
	public Postagem show(Long id) {
		return this.dao.load(id);
	}

	private void getTags(String marcadores, Postagem post) {
		if (marcadores == null) {
			throw new ConstraintViolationException(
					"Nenhuma Tag foi epecificada", null);
		} else {
			for (String tagName : marcadores.split(",")) {
				Tag tag = new Tag(tagName.trim().replaceAll(" ", "_"));
				Tag t = tagDao.existeTag(tag);
				if (t == null) {
					tagDao.beginTransation();
					tagDao.adiciona(tag);
					tagDao.commit();
					post.addTag(tag);
				} else {
					post.addTag(t);
				}
			}
		}
	}

	private List<Tag> getTags(String marcadores) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TagDAO tagDao = new TagDAO(session);

		if (marcadores == null) {
			session.close();
			return null;
		} else {
			List<Tag> tags = new ArrayList<Tag>();
			for (String tag : marcadores.split(",")) {
				Tag t = tagDao.existeTag(new Tag(tag.trim()
						.replaceAll(" ", "_")));
				if (t == null) {
					tags.add(new Tag(tag.trim().replaceAll(" ", "_")));
				} else {
					tags.add(t);
				}
			}
			session.close();
			return tags;
		}
	}
}
