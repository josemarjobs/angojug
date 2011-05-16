package com.angojug.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * 
 * @author josemarjobs
 * @since 13/05/2011:22:43
 */

@Entity
public class User {

	// @NotNull(message = "Não pode ficar vazio")
	// @Size(min = 3, max = 20, message =
	// "Deve ter mais 3 letras e menos que 20")

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@NotNull(message = "Não pode ficar vazio")
	@Size(min = 3, max = 50, message = "Deve ter mais 3 letras e menos que 50")
	private String nome;
	@Column(nullable = false)
	@NotNull(message = "Não pode ficar vazio")
	@Email(message = "Insira um email válido")
	private String email;
	@Column(nullable = false)
	@NotNull(message = "Não pode ficar vazio")
	@Size(min = 6, max = 15, message = "Deve ter mais 6 letras e menos que 15")
	private String password;

	private String site;
	private String localizacao;
	private String profissao;
	private String interesses;
	private String msnMessenger;
	private String yahooMessenger;

	@Lob
	private String biografia;
	private String avatar;

	public User(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public User() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	public String getMsnMessenger() {
		return msnMessenger;
	}

	public void setMsnMessenger(String msnMessenger) {
		this.msnMessenger = msnMessenger;
	}

	public String getYahooMessenger() {
		return yahooMessenger;
	}

	public void setYahooMessenger(String yahooMessenger) {
		this.yahooMessenger = yahooMessenger;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getAvatar() {
		return avatar;
	}

}
