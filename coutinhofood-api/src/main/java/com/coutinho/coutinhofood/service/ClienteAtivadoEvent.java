package com.coutinho.coutinhofood.service;

import com.coutinho.coutinhofood.modelo.Cliente;

public class ClienteAtivadoEvent {
	
	private Cliente cliente;
	
	public ClienteAtivadoEvent(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
