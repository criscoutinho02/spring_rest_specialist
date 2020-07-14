package com.coutinho.coutinhofood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.coutinho.coutinhofood.CoutinhofoodApiApplication;
import com.coutinho.coutinhofood.domain.model.Cidade;
import com.coutinho.coutinhofood.domain.model.Estado;
import com.coutinho.coutinhofood.domain.repository.CidadeRepository;
import com.coutinho.coutinhofood.domain.repository.EstadoRepository;
import com.coutinho.coutinhofood.infrastructure.repositoy.EstadoRepositoryImpl;

public class InclusaoCidadeMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(CoutinhofoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				  
		EstadoRepository estadoRepository =applicationContext.getBean(EstadoRepository.class);
		
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setUF("RJ");
		estadoRepository.salvar(estado);
		
		Estado estado2 = new Estado();
		estado2.setNome("Bahia");
		estado2.setUF("BA");
		estadoRepository.salvar(estado2);
		
		CidadeRepository cadastroCidade = applicationContext.getBean(CidadeRepository.class);		
		
		
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Rio de Janeiro");
		cidade1.setEstado(estado);
		cidade1 = cadastroCidade.salvar(cidade1);
		
		Cidade cidade2 = new Cidade();
		cidade2.setNome("Salvador");
		cidade2.setEstado(estado2);
		cidade2= cadastroCidade.salvar(cidade2);
		
		
		System.out.printf("%d - %s - UF: %s\n" , cidade1.getId() , cidade1.getNome(), cidade1.getEstado().getNome());
		System.out.printf("%d - %s - UF: %s\n" , cidade2.getId() , cidade2.getNome(), cidade2.getEstado().getNome());

				
		
	}

}
