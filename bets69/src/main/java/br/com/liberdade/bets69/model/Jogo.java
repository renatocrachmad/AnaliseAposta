package br.com.liberdade.bets69.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jogo {
	
	@Id
	private Long id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private User autor;

	public Jogo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jogo(Long id, String nome, User autor) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
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

	public User getAutor() {
		return autor;
	}

	public void setAutor(User autor) {
		this.autor = autor;
	}
	

}
