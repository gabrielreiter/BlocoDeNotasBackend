package com.bloconotasgabreiter.BlocoDeNotas.service;

import java.util.List;

import com.bloconotasgabreiter.BlocoDeNotas.model.entity.Nota;

public interface NotaService {

	Nota salvarNota(Nota nota);
	
	Nota editarNota(Nota nota);
	
	void excluirNota(Nota nota);
	
	void validarTitulo(String titulo);
	
	List<Nota> visualizarNotas();
}
