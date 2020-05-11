package com.coutinho.di;

import com.coutinho.modelo.Cliente;
import com.coutinho.notificacao.Notificador;
import com.coutinho.notificacao.NotificadorEmail;
import com.coutinho.notificacao.NotificadorSMS;
import com.coutinho.service.AtivacaoClienteService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente joao = new Cliente("João" , "joão@xyz" , "234567");
		Cliente maria = new Cliente("Maria" , "maria@xyz" , "98767654");

		Notificador notificador = new NotificadorSMS();
		
		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(notificador);
		ativacaoCliente.ativar(joao);
		ativacaoCliente.ativar(maria);
	}

}
