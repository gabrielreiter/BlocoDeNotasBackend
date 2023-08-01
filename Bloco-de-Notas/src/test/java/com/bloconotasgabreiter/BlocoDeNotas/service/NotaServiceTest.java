package com.bloconotasgabreiter.BlocoDeNotas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bloconotasgabreiter.BlocoDeNotas.exceptions.RegraNegocioException;
import com.bloconotasgabreiter.BlocoDeNotas.model.entity.Nota;
import com.bloconotasgabreiter.BlocoDeNotas.model.repository.NotaRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NotaServiceTest {

	@Autowired
	NotaService service;

	@Autowired
	NotaRepository repository;

	@Test
	public void deveValidarTitulo() {
		Assertions.assertThrows(null, () -> {
			// cenario
			repository.deleteAll();

			// ação
			service.validarTitulo("título");
		});
	}

	@Test
	public void deveLancarExcecaoAoValidarTituloCasoCadastrado() {
		Assertions.assertThrows(RegraNegocioException.class, () -> {
			// cenario
			Nota nota = new Nota("titulo", "texto", LocalDateTime.now());
			repository.save(nota);

			// ação
			service.validarTitulo("título");
		});
	}
	
	@Test 
	public void devePersistirUmaNotaNaBaseDeDados() {
		//cenário
		Nota nota = new Nota("título", "texto", LocalDateTime.now());
		
		//ação
		Nota notaSalva = repository.save(nota);
		
		Assertions.assertNotNull(notaSalva.getId());
	}
	
	@Test
	public void devePersistirBuscaDasNotas() {
		//cenário
		List<Nota> notas;
		
		//ação
		notas = repository.findAll();
		
		Assertions.assertNotNull(notas);
	}
	
	@Test
	public void devePersistirExclusao() {
		//cenário
		Nota nota = new Nota("título", "texto", LocalDateTime.now());
		
		//ação
		repository.save(nota);
		
		repository.delete(nota);
		
		boolean existe = repository.existsById(nota.getId());
		
		Assertions.assertFalse(existe);
	}
}