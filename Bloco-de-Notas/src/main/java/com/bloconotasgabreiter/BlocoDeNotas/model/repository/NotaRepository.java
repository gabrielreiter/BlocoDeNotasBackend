package com.bloconotasgabreiter.BlocoDeNotas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloconotasgabreiter.BlocoDeNotas.model.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long>{

	boolean existsByTitulo(String titulo);
}
