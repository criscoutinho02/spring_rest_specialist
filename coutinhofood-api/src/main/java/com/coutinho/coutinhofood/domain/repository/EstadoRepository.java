package com.coutinho.coutinhofood.domain.repository;

import java.util.List;

import com.coutinho.coutinhofood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> todos();
	Estado porUF(char uf);
	Estado salvar(Estado estado);
	void remover(Estado estado);

}
