package com.angojug.controller;

import java.util.ArrayList;
import java.util.List;

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

	public PostsController(Result result, PostDAO dao, Validator validator,
			UsuarioWeb usuarioWeb) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Get
	@Path("/posts/novo")
	public void formulario() {

	}

	@Post
	@Path("/posts")
	public void adiciona(Postagem post) {
		post.setTags(getTags(post.getMarcadores()));
		this.validator.validate(post);
		this.validator.onErrorRedirectTo(this).formulario();
		post.setAutor(usuarioWeb.getUser());
		this.dao.adiciona(post);
		this.result.redirectTo(this).show(post.getId());
	}

	@Get
	@Path("/posts/{id}")
	public Postagem show(Long id) {
		return this.dao.load(id);
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
