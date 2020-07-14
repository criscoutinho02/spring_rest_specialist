package com.coutinho.coutinhofood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.coutinho.coutinhofood.CoutinhofoodApiApplication;
import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;

public class InclusaoCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(CoutinhofoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				  
		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		cozinha1 = cadastroCozinha.salvar(cozinha1);
		cozinha2 = cadastroCozinha.salvar(cozinha2);
		
		System.out.printf("%d - %s\n" , cozinha1.getId() , cozinha1.getNome());
		System.out.printf("%d - %s\n" , cozinha2.getId() , cozinha2.getNome());
		
				
		
	}

}
