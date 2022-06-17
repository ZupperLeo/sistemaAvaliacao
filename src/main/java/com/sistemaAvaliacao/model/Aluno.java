package com.sistemaAvaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String curso;
	
	@Deprecated
	public Aluno() {}

	public Aluno(String nome, String email, String curso) {
		this.nome = nome;
		this.email = email;
		this.curso = curso;
	}
	
	public Long getId() {
		return id;
	}
	
}
