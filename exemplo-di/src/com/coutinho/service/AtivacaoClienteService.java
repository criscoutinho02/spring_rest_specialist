package com.coutinho.service;

import com.coutinho.modelo.Cliente;
import com.coutinho.notificacao.Notificador;


public class AtivacaoClienteService {
	
	private Notificador notificador;
	
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
		
	}

}
