package com.coutinho.coutinhofood.domain.repository;

import java.util.List;

import com.coutinho.coutinhofood.domain.model.Restaurante;

public interface RestauranteRepository {
	
	List<Restaurante> todos();
	Restaurante porId(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Restaurante restaurante);


}
