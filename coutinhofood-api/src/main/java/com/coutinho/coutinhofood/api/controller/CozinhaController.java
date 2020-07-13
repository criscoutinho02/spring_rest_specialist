package com.coutinho.coutinhofood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coutinho.coutinhofood.api.model.CozinhaXMLWrapper;
import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;


@RestController
@RequestMapping(value = "/cozinhas" )
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.todas();
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaXMLWrapper listarXml(){
		return new CozinhaXMLWrapper(cozinhaRepository.todas());
		
	}
	
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		
		Cozinha cozinha =  cozinhaRepository.porId(cozinhaId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://api.coutinhofood.local:8080/cozinhas");
		
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.headers(headers)
				.build()
				;
	}

}
