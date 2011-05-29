package com.angojug.model;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb {

	private User logado;

	public void login(User usuario) {
		this.logado = usuario;
	}

	public String getNome() {
		return this.logado.getNome();
	}

	public boolean isLogado() {
		return this.logado != null;
	}

	public void logout() {
		this.logado = null;
	}
	
	public User getUser() {
		return logado;
	}
}
