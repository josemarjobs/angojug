package com.angojug.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author josemarjobs
 * @since 15/05/2011 23:40
 */

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

	@ManyToOne(optional = false)
	private User autor;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data = Calendar.getInstance();

	@Enumerated(EnumType.STRING)
	private ComentarioStatus comentarioStatus;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Tag> tags = new ArrayList<Tag>();

	@Transient
	private String marcadores;

	@Transient
	private String created_at;

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

	public int getTotalComentarios() {
		return this.comentarios.size();
	}

	public User getAutor() {
		return autor;
	}

	public void setAutor(User autor) {
		this.autor = autor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public ComentarioStatus getComentarioStatus() {
		return comentarioStatus;
	}

	public void setComentarioStatus(ComentarioStatus comentarioStatus) {
		this.comentarioStatus = comentarioStatus;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setMarcadores(String marcadores) {
		this.marcadores = marcadores;
	}

	public String getMarcadores() {
		return marcadores;
	}

	public void addComentario(Comentario c) {
		this.comentarios.add(c);
		c.setPostagem(this);
	}

	public String getDataDeCriacao() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return format.format(this.data.getTime());
	}

	public String getCreated_at() {
		this.created_at = getDataDeCriacao();
		return this.created_at;
	}
	
	public void addTag(Tag tag){
		this.getTags().add(tag);
		tag.getPosts().add(this);
	}

}
