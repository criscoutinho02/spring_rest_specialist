package com.coutinho.service;

import com.coutinho.modelo.Cliente;
import com.coutinho.modelo.Produto;
import com.coutinho.notificacao.Notificador;


public class EmissaoNotaFiscalService {
	
private Notificador notificador;
	
	public EmissaoNotaFiscalService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void emitir(Cliente cliente , Produto produto) {
		//TODO  emite a nota fiscal aqui..
		
		notificador.notificar(cliente, "Nota Fiscal do produto "+
				produto.getNome() + " foi emitida!");
		
	
	}
	
}
