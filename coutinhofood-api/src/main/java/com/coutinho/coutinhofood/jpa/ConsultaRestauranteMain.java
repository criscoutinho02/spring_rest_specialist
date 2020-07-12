package com.coutinho.coutinhofood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.coutinho.coutinhofood.CoutinhofoodApiApplication;
import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.model.Restaurante;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;
import com.coutinho.coutinhofood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(CoutinhofoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				  
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		List<Restaurante> todosRestaurantes = restauranteRepository.todos();
		
		
		
		for (Restaurante restaurante : todosRestaurantes) {
	 		System.out.printf("Restaurante: (%d) %s - Cozinha: %s\n" , restaurante.getId() , restaurante.getNome() , restaurante.getCozinha().getNome());
		}
		
	}

}
