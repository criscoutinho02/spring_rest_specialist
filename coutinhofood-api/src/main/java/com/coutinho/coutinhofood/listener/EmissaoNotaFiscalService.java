package com.coutinho.coutinhofood.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalService {

	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Emitindo Nota Fiscal para cliente " + event.getCliente().getNome());
	}
	
	
}
