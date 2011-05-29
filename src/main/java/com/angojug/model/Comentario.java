package com.angojug.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Comentario {

	@Id
	@GeneratedValue
	private Long id;
	@Lob
	private String corpo;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "nome", column = @Column(name = "nome_comentador")),
			@AttributeOverride(name = "email", column = @Column(name = "email_comentador")),
			@AttributeOverride(name = "site", column = @Column(name = "site_comentador")) })
	private Comentador comentador;

	@ManyToOne
	private Postagem postagem;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data = Calendar.getInstance();

	@Transient
	private String created_at;

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public Comentador getComentador() {
		return comentador;
	}

	public void setComentador(Comentador comentador) {
		this.comentador = comentador;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getData() {
		return data;
	}

	public String getDataDeCriacao() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return format.format(this.data.getTime());
	}

	public String getCreated_at() {
		this.created_at = getDataDeCriacao();
		return this.created_at;
	}

	public String getSite() {
		if (this.comentador.getSite().startsWith("http://")) {
			return this.comentador.getSite();
		} else {
			return "http://" + this.comentador.getSite();
		}
	}

}
