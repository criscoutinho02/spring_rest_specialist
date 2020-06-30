package com.coutinho.coutinhofood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.notificacao.NivelUrgencia;
import com.coutinho.coutinhofood.notificacao.Notificador;
import com.coutinho.coutinhofood.notificacao.TipoDoNotificador;
import com.coutinho.coutinhofood.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {
	
	@TipoDoNotificador(NivelUrgencia.SEMURGENCIA)
	@Autowired
	private Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListester(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo");
	}

}
