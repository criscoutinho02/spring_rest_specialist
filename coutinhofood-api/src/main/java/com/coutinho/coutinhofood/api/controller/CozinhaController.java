package com.coutinho.coutinhofood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;


@RestController
@RequestMapping(value = "/cozinhas" , produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.todas();
		
	}
	
	@GetMapping("/{cozinhaId}")
	public Cozinha buscar(@PathVariable Long cozinhaId) {
		return cozinhaRepository.porId(cozinhaId);
	}

}
