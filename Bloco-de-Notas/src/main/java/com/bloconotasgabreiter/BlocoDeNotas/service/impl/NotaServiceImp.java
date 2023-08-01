package com.bloconotasgabreiter.BlocoDeNotas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloconotasgabreiter.BlocoDeNotas.exceptions.RegraNegocioException;
import com.bloconotasgabreiter.BlocoDeNotas.model.entity.Nota;
import com.bloconotasgabreiter.BlocoDeNotas.model.repository.NotaRepository;
import com.bloconotasgabreiter.BlocoDeNotas.service.NotaService;

import jakarta.transaction.Transactional;

@Service
public class NotaServiceImp implements NotaService{

	private NotaRepository repository;
	
	@Autowired
	public NotaServiceImp(NotaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public Nota salvarNota(Nota nota) {
		validarTitulo(nota.getTitulo());
		return repository.save(nota);
	}

	@Override
	public Nota editarNota(Nota nota) {
				
		Nota notaDB = repository.findById(nota.getId()).get();
		
		if (Objects.nonNull(nota.getTitulo()) && !"".equalsIgnoreCase(nota.getTitulo())) {
			notaDB.setTitulo(nota.getTitulo());
	    }
		
		if (Objects.nonNull(nota.getTexto()) && !"".equalsIgnoreCase(nota.getTexto())) {
			notaDB.setTexto(nota.getTexto());
	    }
		
		notaDB.setDataAtualizacao(LocalDateTime.now());
		
		return repository.save(notaDB);
	}

	@Override
	public void excluirNota(Nota nota) {
		Objects.requireNonNull(nota.getId());
		repository.delete(nota);
	}

	@Override
	public void validarTitulo(String titulo) {
		boolean existe = repository.existsByTitulo(titulo);
		
		if (existe) {
			throw new RegraNegocioException("Já existe uma nota cadastrada com este nome.");
		}
	}

	@Override
	public List<Nota> visualizarNotas() {
		return (List<Nota>)repository.findAll();
	}

}
