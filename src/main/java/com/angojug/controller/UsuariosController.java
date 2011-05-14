package com.angojug.controller;

import com.angojug.model.User;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class UsuariosController {

	private Result result;

	public UsuariosController(Result result) {
		this.result = result;
	}

	@Get
	@Path("/usuarios/novo")
	public void formulario() {

	}

	@Post
	@Path("/usuarios")
	public void adiciona(final User user) {
		result.include("user", user);
	}
}
