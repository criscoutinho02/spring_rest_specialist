package com.coutinho.coutinhofood.notificacao;

import com.coutinho.coutinhofood.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}