package com.coutinho.coutinhofood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.coutinho.coutinhofood.CoutinhofoodApiApplication;
import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;

public class AlteracaoCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(CoutinhofoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				  
		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(3L); 
		cozinha.setNome("Brasileira");
	
		
		cozinha = cadastroCozinha.adicionar(cozinha);
				
		
	}

}
