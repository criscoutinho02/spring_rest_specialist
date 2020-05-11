package com.coutinho.notificacao;

import com.coutinho.modelo.Cliente;

public interface Notificador {
	
	void notificar(Cliente cliente , String mensagem);
}
