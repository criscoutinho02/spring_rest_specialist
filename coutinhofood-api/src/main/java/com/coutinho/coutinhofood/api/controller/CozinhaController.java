package com.coutinho.coutinhofood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
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
import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;
import com.coutinho.coutinhofood.domain.service.CadastroCozinhaService;


@RestController
@RequestMapping(value = "/cozinhas" )
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.todas();
		
	}
	

	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		
		Cozinha cozinha =  cozinhaRepository.porId(cozinhaId);
		if(cozinha!=null) {
			return ResponseEntity.ok(cozinha);
		}
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}
	
	
	@PutMapping("{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
				@RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaRepository.porId(cozinhaId);
		//cozinhaAtual.setNome(cozinha.getNome());
		if(cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual , "id");
			cadastroCozinha.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}
		return ResponseEntity.notFound().build();
				
		
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		try {
			cadastroCozinha.excluir(cozinhaId);
			return ResponseEntity.noContent().build();

		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
