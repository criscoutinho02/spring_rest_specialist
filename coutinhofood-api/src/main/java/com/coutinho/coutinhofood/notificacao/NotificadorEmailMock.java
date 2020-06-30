package com.coutinho.coutinhofood.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEMURGENCIA)
@Component
public class NotificadorEmailMock implements Notificador{


	@Override
	public void notificar(Cliente cliente , String mensagem ) {
		System.out.printf("MOCK: Notificação seria enviada para %s atrav�s do email %s: %s\n" ,
				cliente.getNome() , cliente.getEmail() , mensagem);
	}


	
}


