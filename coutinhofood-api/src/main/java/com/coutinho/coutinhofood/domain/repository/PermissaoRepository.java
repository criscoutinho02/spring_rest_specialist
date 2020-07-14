package com.coutinho.coutinhofood.domain.repository;

import java.util.List;

import com.coutinho.coutinhofood.domain.model.Permissao;

public interface PermissaoRepository {
	
	List<Permissao> todas();
	Permissao porId(Long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);


}
