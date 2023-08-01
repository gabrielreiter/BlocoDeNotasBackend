package com.bloconotasgabreiter.BlocoDeNotas.model.repository;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bloconotasgabreiter.BlocoDeNotas.model.entity.Nota;
import com.bloconotasgabreiter.BlocoDeNotas.model.repository.NotaRepository;

@SpringBootTest
@ExtendWith( SpringExtension.class )
@DataJpaTest
public class NotaRepositoryTest {
	
	@Autowired
	NotaRepository repository;
	
	@Test
	public void deveVerificarExistenciaDeTitulo() {
		//cenário
		Nota nota = new Nota("título", "texto", LocalDateTime.now());
		repository.save(nota);
		
		//ação/execução
		boolean result = repository.existsByTitulo("título");
		
		//verificação
		Assertions.assertThat(result).isTrue();
	}	
}
