package com.coutinho.coutinhofood.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.modelo.Cliente;

@Qualifier("normal")
@Component
public class NotificadorEmail implements Notificador {
	
	private boolean caixaAlta;
	private String hostServidorSMTP;
	
		
	@Override
	public void notificar(Cliente cliente , String mensagem ) {
		
		if(this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
	
		System.out.printf("Notificando %s atrav�s do email %s usando SMTP %s: %s\n" ,
				cliente.getNome() , cliente.getEmail() , hostServidorSMTP , mensagem);
	}

	
	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

	
	
}
