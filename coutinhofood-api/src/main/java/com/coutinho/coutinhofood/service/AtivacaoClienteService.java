package com.coutinho.coutinhofood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.modelo.Cliente;
import com.coutinho.coutinhofood.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	 
	@Autowired(required=false)
	private List<Notificador> notificadores;

	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		for(Notificador notificador:notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema est� ativo");
		}
		
	}

}
