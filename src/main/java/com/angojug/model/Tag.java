package com.angojug.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;

	@ManyToMany(mappedBy = "tags")
	private List<Postagem> posts = new ArrayList<Postagem>();

	public Tag(String tag) {
		setNome(tag);
	}
	
	public Tag() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Postagem> getPosts() {
		return posts;
	}

	public void setPosts(List<Postagem> posts) {
		this.posts = posts;
	}

}
