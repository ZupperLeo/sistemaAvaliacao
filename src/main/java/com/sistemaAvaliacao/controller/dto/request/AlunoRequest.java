package com.sistemaAvaliacao.controller.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sistemaAvaliacao.model.Aluno;

public class AlunoRequest {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String curso;

	public AlunoRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String curso) {
		this.nome = nome;
		this.email = email;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCurso() {
		return curso;
	}
	
	public Aluno toModel() {
		return new Aluno(nome, email, curso);
	}
	
}
