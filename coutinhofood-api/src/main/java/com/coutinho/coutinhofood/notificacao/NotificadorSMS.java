package com.coutinho.coutinhofood.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.modelo.Cliente;

@Component
@TipoDoNotificador(NivelUrgencia.URGENTE)
public class NotificadorSMS implements Notificador {
	
	private boolean caixaAlta;
	private String hostServidorSMTP;
	
		
	@Override
	public void notificar(Cliente cliente , String mensagem ) {
		
		if(this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
	
		System.out.printf("Notificando %s por SMS através do telefone %s: %s \n" ,
				cliente.getNome() , cliente.getTelefone() , mensagem);
	}

	
	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

	
	
}
