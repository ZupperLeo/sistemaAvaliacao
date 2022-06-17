package com.sistemaAvaliacao.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemaAvaliacao.controller.dto.request.AvaliacaoRequest;
import com.sistemaAvaliacao.model.Aluno;
import com.sistemaAvaliacao.model.Avaliacao;
import com.sistemaAvaliacao.repository.AlunoRepository;
import com.sistemaAvaliacao.repository.AvaliacaoRepository;

@RestController
@RequestMapping("/alunos/{idAluno}/avaliacoes")
public class AvaliacaoController {

	private final AvaliacaoRepository repository;
	private final AlunoRepository alunoRepo;

	public AvaliacaoController(AvaliacaoRepository repository, AlunoRepository alunoRepo) {
		this.repository = repository;
		this.alunoRepo = alunoRepo;
	}

	@PostMapping
	public ResponseEntity<Void> cadastrado(@PathVariable Long idAluno, @Valid @RequestBody AvaliacaoRequest request) {
		Aluno aluno = alunoRepo.findById(idAluno).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("Aluno id %s não encontrado", idAluno)));

		Avaliacao avaliacao = request.toModel(aluno);
		
		repository.save(avaliacao);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/alunos/{idAluno}/avaliacoes/{id}")
				.buildAndExpand(aluno.getId(), avaliacao.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
