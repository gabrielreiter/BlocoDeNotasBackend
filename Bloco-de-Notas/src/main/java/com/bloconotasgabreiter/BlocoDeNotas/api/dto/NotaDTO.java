package com.bloconotasgabreiter.BlocoDeNotas.api.dto;

import java.time.LocalDateTime;

public class NotaDTO {

	private String titulo;

	private String texto;

	private LocalDateTime dataAtualizacao;

	public NotaDTO(String titulo, String texto, LocalDateTime dataAtualizacao) {
		this.titulo = titulo;
		this.texto = texto;
		this.dataAtualizacao = dataAtualizacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
