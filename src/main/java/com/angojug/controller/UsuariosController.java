package com.angojug.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import com.angojug.dao.UserDAO;
import com.angojug.model.User;

/**
 * 
 * @author josemarjobs
 * @since 13/05/2011:22:43
 * 
 *        Controlador de Recursos relacionados a Usuarios
 */
@Resource
public class UsuariosController {

	private final Result result;
	private final UserDAO dao;
	private final Validator validator;

	public UsuariosController(Result result, UserDAO dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}

	@Get
	@Path("/usuarios/novo")
	public void formulario() {

	}

	@Post
	@Path("/usuarios")
	public void adiciona(final User user) {
		validator.validate(user);
		validator.onErrorRedirectTo(this).formulario();
		// this.result.redirectTo(this).dados();
		this.dao.adiciona(user);
		//result.include("user", user);
		this.result.redirectTo(this).dados(user.getId());
	}

	@Get
	@Path("/usuarios/{id}")
	public User edita(Long id) {
		return this.dao.load(id);
	}

	@Put
	@Path("/usuarios/{user.id}")
	public void atualizar(User user) {
		this.validator.validate(user);
		this.validator.onErrorUsePageOf(this).edita(user.getId());
		this.dao.atualizar(user);
		// this.result.include("user", user);
		this.result.redirectTo(this).dados(user.getId());
	}

	@Get
	@Path("/usuarios/{id}/perfil")
	public User dados(Long id) {
		return this.dao.load(id);
	}
}
