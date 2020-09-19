package com.coutinho.coutinhofood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coutinho.coutinhofood.domain.exception.EntidadeEmUsoException;
import com.coutinho.coutinhofood.domain.exception.EntidadeNaoEncontradaException;
import com.coutinho.coutinhofood.domain.model.Cidade;
import com.coutinho.coutinhofood.domain.repository.CidadeRepository;
import com.coutinho.coutinhofood.domain.service.CadastroCidadeService;

import jdk.jfr.BooleanFlag;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	CadastroCidadeService cadastroCidade;

	@Autowired
	CidadeRepository cidadeRepository;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cidade> listar(){

		return cidadeRepository.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long id){

		Optional<Cidade> cidadeAtual = cidadeRepository.findById(id);

		if(cidadeAtual.isEmpty()) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(cidadeAtual.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade){

		try {
			cidade = cadastroCidade.salvar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}


	}


	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId , 
			@RequestBody Cidade cidade){

		try {
			Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);

			if(cidadeAtual.isPresent()) {
				BeanUtils.copyProperties(cidade, cidadeAtual.get() , "id");
				Cidade cidadeSalva = cadastroCidade.salvar(cidadeAtual.get());
				return ResponseEntity.ok(cidadeSalva);

			}

			return ResponseEntity.notFound().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		try {
			cadastroCidade.excluir(id);
			return ResponseEntity.noContent().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}




}



