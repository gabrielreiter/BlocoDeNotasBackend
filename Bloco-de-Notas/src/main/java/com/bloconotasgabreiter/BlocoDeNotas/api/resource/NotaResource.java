package com.bloconotasgabreiter.BlocoDeNotas.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloconotasgabreiter.BlocoDeNotas.api.dto.NotaDTO;
import com.bloconotasgabreiter.BlocoDeNotas.exceptions.RegraNegocioException;
import com.bloconotasgabreiter.BlocoDeNotas.model.entity.Nota;
import com.bloconotasgabreiter.BlocoDeNotas.service.NotaService;

@RestController
@RequestMapping("/api/notas")
public class NotaResource {

	private NotaService service;
	
	public NotaResource(NotaService service) {
		
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody NotaDTO dto) {
		
		Nota nota = new Nota(dto.getTitulo(), dto.getTexto(), dto.getDataAtualizacao());
		
		try {
			Nota notaSalva = service.salvarNota(nota);
			return new ResponseEntity(notaSalva, HttpStatus.CREATED);
		}
		catch (RegraNegocioException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity editar(@RequestBody NotaDTO dto) {
		
		Nota nota = new Nota(dto.getTitulo(), dto.getTexto(), dto.getDataAtualizacao());
		
		try {
			Nota notaEditada = service.editarNota(nota);
			return new ResponseEntity(notaEditada, HttpStatus.CREATED);
		}
		catch (RegraNegocioException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
