package com.angojug.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

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

}
