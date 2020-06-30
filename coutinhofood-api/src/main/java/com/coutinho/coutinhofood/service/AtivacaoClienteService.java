package com.coutinho.coutinhofood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.modelo.Cliente;
import com.coutinho.coutinhofood.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	 
	@Autowired(required=false)
	private Notificador notificador;

	/*
	 * @Autowired public void setNotificador(Notificador notificador) {
	 * this.notificador = notificador; }
	 */
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		if(notificador != null) {
			this.notificador.notificar(cliente, "Seu cadastro no sistema est� ativo");
		} else {
			System.out.println("Não existe notificador, mas cliente foi ativado");
		}
	}

}
