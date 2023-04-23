package com.igor.localizacao;

import com.igor.localizacao.domain.entity.Cidade;
import com.igor.localizacao.domain.repository.CidadeRepository;
import com.igor.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		//salvarCidade();
		var cidade = new Cidade(null,null,1L);
		cidadeService.listarCidadeSpecFiltroDinamico(cidade);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
