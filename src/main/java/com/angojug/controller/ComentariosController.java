package com.angojug.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.angojug.dao.ComentarioDAO;
import com.angojug.model.Comentario;
import com.angojug.model.Postagem;

@Resource
public class ComentariosController {

	private final Result result;
	private final ComentarioDAO dao;

	public ComentariosController(Result result, ComentarioDAO dao) {
		this.result = result;
		this.dao = dao;
	}

	@Post
	@Path("/posts/{postagem.id}/comentarios")
	public void adiciona(Comentario comentario, Postagem postagem) {
		postagem.addComentario(comentario);
		this.dao.adiciona(comentario);
		this.result.redirectTo(PostsController.class).show(postagem.getId());
	}

	@Post
	@Path("/posts/{postagem.id}/comentarios/ajax")
	public void adicionaAjax(Comentario comentario, Postagem postagem) {
		postagem.addComentario(comentario);
		this.dao.adiciona(comentario);
		//this.result.redirectTo(PostsController.class).show(postagem.getId());
		this.result.use(Results.json()).from(comentario).serialize();
	}
	
	@Delete
	@Path("/posts/{postagem.id}/comentarios")
	public void remove(Postagem p, Comentario c) {
		p.getComentarios().remove(c);
		this.dao.remove(c);
		this.result.redirectTo(PostsController.class).show(p.getId());
	}
}
