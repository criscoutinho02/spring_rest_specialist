package com.coutinho.notificacao;

import com.coutinho.modelo.Cliente;

public class NotificadorSMS implements Notificador{
	
	@Override
	public void notificar(Cliente cliente , String mensagem) {
		System.out.printf("Notificando %s por SMS atrav�s do telefone %s: %s\n", 
				cliente.getNome() , cliente.getTelefone() , mensagem);
	}

}
