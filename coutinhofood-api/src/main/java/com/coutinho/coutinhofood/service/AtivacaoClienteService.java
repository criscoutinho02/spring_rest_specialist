package com.coutinho.coutinhofood.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.modelo.Cliente;
import com.coutinho.coutinhofood.notificacao.NivelUrgencia;
import com.coutinho.coutinhofood.notificacao.Notificador;
import com.coutinho.coutinhofood.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
	 
	@Autowired
	@TipoDoNotificador(NivelUrgencia.SEMURGENCIA)
	private Notificador notificador;

	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		this.notificador.notificar(cliente, "Seu cadastro no sistema est� ativo");
		
	}

}
