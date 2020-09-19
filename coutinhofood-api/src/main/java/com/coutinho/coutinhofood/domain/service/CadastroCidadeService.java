package com.coutinho.coutinhofood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coutinho.coutinhofood.domain.exception.EntidadeEmUsoException;
import com.coutinho.coutinhofood.domain.exception.EntidadeNaoEncontradaException;
import com.coutinho.coutinhofood.domain.model.Cidade;
import com.coutinho.coutinhofood.domain.model.Estado;
import com.coutinho.coutinhofood.domain.repository.CidadeRepository;
import com.coutinho.coutinhofood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		
		String uf = cidade.getEstado().getUF();
		
		Optional<Estado> estado = estadoRepository.findById(uf);
		
		if(estado.isEmpty()) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não há UF cadastrada com a sigla %s" , uf));
		}
		cidade.setEstado(estado.get());		
		
		return cidadeRepository.save(cidade);
		
	}
	
	
	public void excluir(Long cidadeId) {
		
		try {
			
			cidadeRepository.deleteById(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de cidade com código %d", cidadeId));
        
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
		
		
	}
}
