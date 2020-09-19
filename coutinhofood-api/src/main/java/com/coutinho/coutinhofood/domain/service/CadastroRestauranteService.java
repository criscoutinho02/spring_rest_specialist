package com.coutinho.coutinhofood.domain.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coutinho.coutinhofood.domain.exception.EntidadeEmUsoException;
import com.coutinho.coutinhofood.domain.exception.EntidadeNaoEncontradaException;
import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.model.Restaurante;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;
import com.coutinho.coutinhofood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
		
	public Restaurante salvar(Restaurante restaurante) {
		
		Long cozinhaID = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cozinhaRepository.findById(cozinhaID)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", cozinhaID)));
				
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
		
		
		
	}
	
	public void deletar(Long id) {
		
		try {
			restauranteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de restaurante com o código ¨d" , id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de restaurante %d não pode ser removido, pois está em uso.", id));
		} 
		
	}
	
	
}
