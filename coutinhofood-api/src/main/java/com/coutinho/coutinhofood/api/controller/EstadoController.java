package com.coutinho.coutinhofood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutinho.coutinhofood.domain.model.Estado;
import com.coutinho.coutinhofood.domain.repository.EstadoRepository;


@RequestMapping("/estados")
@RestController
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.todos();
	}
	
}
