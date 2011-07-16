package com.angojug.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author josemarjobs
 * @since 15/05/2011 23:40
 */
@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@ManyToMany(mappedBy = "tags")
	private Set<Postagem> posts = new HashSet<Postagem>();

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

	public Set<Postagem> getPosts() {
		return posts;
	}

	public void setPosts(Set<Postagem> posts) {
		this.posts = posts;
	}

}
