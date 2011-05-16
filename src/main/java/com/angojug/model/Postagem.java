package com.angojug.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Postagem {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String titulo;
	@Lob
	private String corpo;

	@OneToMany(mappedBy = "postagem", cascade = { CascadeType.ALL })
	private List<Comentario> comentarios = new ArrayList<Comentario>();

	public Postagem() {
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public int getTotalComentarios(){
		return this.comentarios.size();
	}

}
