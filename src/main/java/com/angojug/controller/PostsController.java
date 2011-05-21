package com.angojug.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

import com.angojug.dao.PostDAO;
import com.angojug.model.Postagem;
import com.angojug.model.Tag;

@Resource
public class PostsController {
	private final Result result;
	private final PostDAO dao;
	private final Validator validator;

	public PostsController(Result result, PostDAO dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
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
		this.dao.adiciona(post);
		this.result.redirectTo(this).show(post.getId());
	}

	@Get
	@Path("/posts/{id}")
	public Postagem show(Long id) {
		return this.dao.load(id);
	}

	private List<Tag> getTags(String marcadores) {
		if (marcadores == null) {
			return null;
		} else {
			List<Tag> tags = new ArrayList<Tag>();
			for (String tag : marcadores.split(",")) {
				tags.add(new Tag(tag.trim().replaceAll(" ", "_")));
			}
			return tags;
		}
	}
}
