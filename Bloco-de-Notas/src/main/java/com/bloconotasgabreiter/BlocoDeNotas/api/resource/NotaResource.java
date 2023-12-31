package com.bloconotasgabreiter.BlocoDeNotas.api.resource;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		this.service = service;
	}
	
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody NotaDTO dto) {
		
		Nota nota = new Nota(dto.getTitulo(), dto.getTexto(), LocalDateTime.now());
		
		try {
			Nota notaSalva = service.salvarNota(nota);
			return new ResponseEntity(notaSalva, HttpStatus.CREATED);
		}
		catch (RegraNegocioException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/editar")
	public ResponseEntity editar(@RequestBody NotaDTO dto) {
		
		Nota nota = new Nota(dto.getId(), dto.getTitulo(), dto.getTexto(), LocalDateTime.now());
		
		try {
			Nota notaEditada = service.editarNota(nota);
			return new ResponseEntity(notaEditada, HttpStatus.OK);
		}
		catch (RegraNegocioException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		
		try {
			service.excluirNota(id);
			return new ResponseEntity(HttpStatus.OK);
		}
		catch (RegraNegocioException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/visualizar")
	public ResponseEntity visualizarTodos() {
		
		try {
			List<Nota> notas = service.visualizarNotas();
			return new ResponseEntity(notas, HttpStatus.OK);
		}
		catch(RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
