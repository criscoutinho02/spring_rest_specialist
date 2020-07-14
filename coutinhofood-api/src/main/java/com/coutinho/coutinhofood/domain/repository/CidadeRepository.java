package com.coutinho.coutinhofood.domain.repository;

import java.util.List;

import com.coutinho.coutinhofood.domain.model.Cidade;


public interface CidadeRepository {

	List<Cidade> todas();
	Cidade porId(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);

	
}
