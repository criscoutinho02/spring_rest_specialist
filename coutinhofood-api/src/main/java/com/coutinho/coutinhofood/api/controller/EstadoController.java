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
import com.coutinho.coutinhofood.domain.model.Estado;
import com.coutinho.coutinhofood.domain.repository.EstadoRepository;
import com.coutinho.coutinhofood.domain.service.CadastroEstadoService;


@RequestMapping("/estados")
@RestController
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CadastroEstadoService cadastroEstado;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.findAll();
	}
	
	@GetMapping("/{estadoUF}")
	public ResponseEntity<Estado> buscar(@PathVariable String estadoUF) {
		Optional<Estado> estado = estadoRepository.findById(estadoUF);
		
		if(estado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estado.get());
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar(@RequestBody Estado estado){
			
		return cadastroEstado.salvar(estado);
	
	}
	
	@PutMapping("/{estadoUF}")
	public ResponseEntity<?> atualizar(@PathVariable String estadoUF,
			@RequestBody Estado estado){
		
		Optional<Estado> estadoAtual = estadoRepository.findById(estadoUF);
		
		if(estadoAtual.isPresent()) {
			BeanUtils.copyProperties(estado, estadoAtual.get() , "uf");
			
			Estado estadoAtualizado = cadastroEstado.salvar(estadoAtual.get());
			
			return ResponseEntity.ok(estadoAtualizado);
		}
			
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{estadoUF}")
	public ResponseEntity<String> deletar(@PathVariable String estadoUF) {
		
		try {
			cadastroEstado.excluir(estadoUF);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}

		
	}
	
	
}
