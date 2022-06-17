package com.sistemaAvaliacao.utils.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		Set<String> mensagens = new HashSet<>();
		
		for (FieldError field : fieldErrors) {
			String msg =  mensagemDeErro(field.getField());
			mensagens.add(msg);
		}
		
		return ResponseEntity.badRequest().body(mensagens);
	}

	private String mensagemDeErro(String field) {
		return String.format("Erro no campo %s", field);
	}

}
