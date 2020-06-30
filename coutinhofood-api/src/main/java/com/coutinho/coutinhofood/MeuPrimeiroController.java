package com.coutinho.coutinhofood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coutinho.coutinhofood.modelo.Cliente;
import com.coutinho.coutinhofood.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroController {
	
	@Autowired
	private AtivacaoClienteService ativacaoClienteService;
	

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente joao = new Cliente("João", "joao@coutinho", "119976544");
		ativacaoClienteService.ativar(joao);
		return "Hello";
		
		
	}
	
}
