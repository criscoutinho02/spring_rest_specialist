package com.coutinho.coutinhofood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column( nullable = false)
	private String nome;
	
	@Column( nullable = false)
	private BigDecimal taxaFrete;
	
	@JoinColumn( nullable = false)
	@ManyToOne
	private Cozinha cozinha;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private FormaPagamento formaPagamento;

	
	
}
