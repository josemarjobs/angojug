package com.angojug.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.angojug.dao.ComentarioDAO;
import com.angojug.dao.PostDAO;
import com.angojug.model.Comentario;
import com.angojug.model.Postagem;

@Resource
public class ComentariosController {

	private final Result result;
	private final ComentarioDAO dao;
	private final PostDAO postDao;

	public ComentariosController(Result result, ComentarioDAO dao,
			PostDAO postDAO) {
		this.result = result;
		this.dao = dao;
		this.postDao = postDAO;
	}

	@Post
	@Path("/posts/{postagem.id}/comentarios")
	public void adiciona(Comentario comentario, Postagem postagem) {
		comentario.setPostagem(postagem);
		this.dao.adiciona(comentario);
		this.result.redirectTo(PostsController.class).show(postagem.getId());
	}
}
