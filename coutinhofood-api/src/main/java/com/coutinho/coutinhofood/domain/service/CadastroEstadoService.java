package com.coutinho.coutinhofood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coutinho.coutinhofood.domain.exception.EntidadeEmUsoException;
import com.coutinho.coutinhofood.domain.exception.EntidadeNaoEncontradaException;
import com.coutinho.coutinhofood.domain.model.Estado;
import com.coutinho.coutinhofood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
		
	}
	
	public void excluir(String uf) {
		try {
			estadoRepository.deleteById(uf);
			
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não há um estado com a UF informada %s", uf));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado com a uf %s não pode ser removido pois está em uso", uf));
			
		}
		
	}
	
}
