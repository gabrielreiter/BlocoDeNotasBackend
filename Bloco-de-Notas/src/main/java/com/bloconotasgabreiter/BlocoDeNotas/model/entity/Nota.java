package com.bloconotasgabreiter.BlocoDeNotas.model.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "nota", schema = "BlocoDeNotasDB")
public class Nota {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	public Nota() {
		super();
	}

	public Nota(String titulo, String texto, LocalDateTime dataAtualizacao) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataAtualizacao, id, texto, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(dataAtualizacao, other.dataAtualizacao) && Objects.equals(id, other.id)
				&& Objects.equals(texto, other.texto) && Objects.equals(titulo, other.titulo);
	}
}
