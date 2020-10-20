package com.coutinho.coutinhofood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.coutinho.coutinhofood.domain.repository.CustomJpaRepository;
import com.coutinho.coutinhofood.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class CoutinhofoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoutinhofoodApiApplication.class, args);
	}

	
	
}
