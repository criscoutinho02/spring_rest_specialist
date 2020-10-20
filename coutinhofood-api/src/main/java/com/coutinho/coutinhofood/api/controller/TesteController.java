package com.coutinho.coutinhofood.api.controller;

import static com.coutinho.coutinhofood.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.coutinho.coutinhofood.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.model.Restaurante;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;
import com.coutinho.coutinhofood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam String nome){
		return cozinhaRepository.findByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(
			BigDecimal taxaInicial , 
			BigDecimal taxaFinal){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial , taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-nome-e-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(
			String nome,
			BigDecimal taxaInicial , 
			BigDecimal taxaFinal){
		return restauranteRepository.find(nome, taxaInicial , taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantesPorNomeECozinhaId(
			String nome , 
			Long cozinhaId){
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantesPrimeiroPorNome(
			String nome ){
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/top2-por-nome")
	public List<Restaurante> restaurantesDoisPrimeirosPorNome(
			String nome ){
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/exists")
	public boolean cozinhaExistePorNome(
			String nome ){
		return cozinhaRepository.existsByNome(nome);
	}
	
	@GetMapping("/restaurantes/count-por-cozinha")
	public int cozinhaExistePorNome(
			Long cozinhaId ){
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(
			String nome ){
		
		return restauranteRepository.findComFreteGratis(nome);
		
	}
	
	@GetMapping("/restaurantes/primeiro")
	public Optional<Restaurante> primeiroRestaurante(){
		
		return restauranteRepository.buscarPrimeiro();
		
	}
	
	@GetMapping("/cozinhas/primeiro")
	public Optional<Cozinha> primeiraCozinha(){
		
		return cozinhaRepository.buscarPrimeiro();
		
	}
	
	

	
}
