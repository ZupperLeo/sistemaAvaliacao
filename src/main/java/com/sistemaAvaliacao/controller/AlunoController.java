package com.sistemaAvaliacao.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemaAvaliacao.controller.dto.request.AlunoRequest;
import com.sistemaAvaliacao.model.Aluno;
import com.sistemaAvaliacao.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	private final AlunoRepository repository;
	
	public AlunoController(AlunoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadatrar(@Valid @RequestBody AlunoRequest request) {
		Aluno aluno = request.toModel();
		
		repository.save(aluno);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("alunos/{id}")
					.buildAndExpand(aluno.getId())
					.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
