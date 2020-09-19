package com.coutinho.coutinhofood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coutinho.coutinhofood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{

	
}
