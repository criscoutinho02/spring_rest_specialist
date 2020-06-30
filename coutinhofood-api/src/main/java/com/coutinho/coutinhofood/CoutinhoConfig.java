/*
 * package com.coutinho.coutinhofood;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import com.coutinho.coutinhofood.notificacao.NotificadorEmail; import
 * com.coutinho.coutinhofood.service.AtivacaoClienteService;
 * 
 * //@Configuration public class CoutinhoConfig {
 * 
 * @Bean public NotificadorEmail notificadorEmail() { NotificadorEmail
 * notificador = new NotificadorEmail("smtp.algamail.com.br");
 * notificador.setCaixaAlta(false); return notificador; }
 * 
 * @Bean public AtivacaoClienteService ativacaoClienteService() { return new
 * AtivacaoClienteService(notificadorEmail()); } }
 */