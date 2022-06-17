package com.sistemaAvaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	private Aluno aluno;
	
	@Deprecated
	public Avaliacao() {}
	
	public Avaliacao(String titulo, String descricao, Aluno aluno) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.aluno = aluno;
	}



	public Long getId() {
		return id;
	}
	
}
