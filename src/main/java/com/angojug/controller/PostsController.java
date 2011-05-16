package com.angojug.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.angojug.dao.PostDAO;
import com.angojug.model.Postagem;

@Resource
public class PostsController {
	private final Result result;
	private final PostDAO dao;

	public PostsController(Result result, PostDAO dao) {
		this.result = result;
		this.dao = dao;
	}

	@Get
	@Path("/posts/novo")
	public void formulario() {

	}

	@Post
	@Path("/posts")
	public void adiciona(Postagem post) {
		this.dao.adiciona(post);
		this.result.redirectTo(this).show(post.getId());
	}

	@Get
	@Path("/posts/{id}")
	public Postagem show(Long id) {
		return this.dao.load(id);
	}
}
