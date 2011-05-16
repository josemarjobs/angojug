package com.angojug.model;

import javax.persistence.Embeddable;

@Embeddable
public class Comentador {

	private String nome;
	private String email;
	private String site;

	public Comentador() {
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
