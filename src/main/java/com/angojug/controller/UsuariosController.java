package com.angojug.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

import com.angojug.IndexController;
import com.angojug.dao.UserDAO;
import com.angojug.model.Postagem;
import com.angojug.model.User;
import com.angojug.model.UsuarioWeb;

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
	private final UsuarioWeb usuarioWeb;

	public UsuariosController(Result result, UserDAO dao, Validator validator, UsuarioWeb usuarioWeb) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
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
		this.dao.adiciona(user);
		this.usuarioWeb.login(user);
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
		this.result.redirectTo(this).dados(user.getId());
	}

	@Get
	@Path("/usuarios/{id}/perfil")
	public User dados(Long id) {
		return this.dao.load(id);
	}

	@Delete
	@Path("/usuarios/{id}")
	public void remove(Long id) {
		User user = this.dao.load(id);
		this.dao.remove(user);
		this.result.redirectTo(IndexController.class).index();
	}

	@Get
	@Path("/usuarios")
	public List<User> list() {
		return this.dao.list();
	}
	
	@Get
	@Path("/login")
	public void login(){
		
	}
	
	@Post
	@Path("/usuarios/autentica")
	public void autentica(User user){
		User carregado = this.dao.carrega(user);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha incorretos",
					"user.email"));
		}
		validator.onErrorUsePageOf(this).login();
		this.usuarioWeb.login(carregado);
		this.result.redirectTo(IndexController.class).index();		
	}
	
	@Get
	@Path("/logout")
	public void logout() {
		this.usuarioWeb.logout();
		this.result.redirectTo(IndexController.class).index();
	}
	
	@Get
	@Path("/usuarios/{id}/postagens")
	public List<Postagem> postagens(Long id){
		User user = this.dao.load(id);
		return user.getPostagens();
	}
}
