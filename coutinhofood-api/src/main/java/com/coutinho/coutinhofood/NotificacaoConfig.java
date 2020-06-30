package com.coutinho.coutinhofood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coutinho.coutinhofood.notificacao.NotificadorEmail;

//@Configuration
public class NotificacaoConfig {
	
	//@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail();
		notificador.setCaixaAlta(false);
		return notificador;
	}

}
