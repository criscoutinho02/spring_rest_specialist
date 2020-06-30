package com.coutinho.coutinhofood.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {
	
	
	/**
	 * Host do servidor de email
	 *
	 */
	private String hostServidor;
	
	/**
	 * Porta do servidor de email
	 * @author crisc
	 *
	 */
	private int portaServidor = 25;
	
	public String getHostServidor() {
		return hostServidor;
	}
	public void setHostServidor(String hostServidor) {
		this.hostServidor = hostServidor;
	}
	public int getPortaServidor() {
		return portaServidor;
	}
	public void setPortaServidor(int portaServidor) {
		this.portaServidor = portaServidor;
	}
	
	

}
