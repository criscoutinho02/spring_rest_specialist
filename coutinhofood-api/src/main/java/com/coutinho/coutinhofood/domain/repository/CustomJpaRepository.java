package com.coutinho.coutinhofood.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.coutinho.coutinhofood.domain.model.Restaurante;

@NoRepositoryBean
public interface CustomJpaRepository<T,ID> extends JpaRepository<T, ID>{
	
	Optional<T> buscarPrimeiro();

}
