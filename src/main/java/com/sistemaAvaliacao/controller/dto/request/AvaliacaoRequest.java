package com.sistemaAvaliacao.controller.dto.request;

import javax.validation.constraints.NotBlank;

import com.sistemaAvaliacao.model.Aluno;
import com.sistemaAvaliacao.model.Avaliacao;

public class AvaliacaoRequest {

	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descricao;

	public AvaliacaoRequest(@NotBlank String titulo, @NotBlank String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Avaliacao toModel(Aluno aluno) {
		return new Avaliacao(titulo, descricao, aluno);
	}
	
}
