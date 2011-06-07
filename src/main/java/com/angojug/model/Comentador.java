package com.angojug.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.angojug.util.MD5Util;

@Embeddable
public class Comentador {

	@NotNull
	private String nome;
	@NotNull
	@Email
	private String email;
	private String site;

	public Comentador() {
	}

	public Comentador(String nome, String email, String site) {
		this.nome = nome;
		this.email = email;
		this.site = site;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getImage() {
		String hash = MD5Util.md5Hex(this.email);
		// http://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=200
		return "http://www.gravatar.com/avatar/" + hash +"?s=200";
	}

}
