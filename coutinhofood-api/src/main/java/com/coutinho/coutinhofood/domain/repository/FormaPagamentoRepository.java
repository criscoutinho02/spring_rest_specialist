package com.coutinho.coutinhofood.domain.repository;

import java.util.List;

import com.coutinho.coutinhofood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	List<FormaPagamento> todas();
	FormaPagamento porId(Long id);
	FormaPagamento salvar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);

	
}
