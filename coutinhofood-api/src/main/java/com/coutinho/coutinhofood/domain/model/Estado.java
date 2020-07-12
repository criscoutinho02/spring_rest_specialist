package com.coutinho.coutinhofood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estado {

	@Id
	@EqualsAndHashCode.Include
	@Column(columnDefinition = "char(2)" , nullable = false)
	private String UF;
	
	@Column(nullable = false)
	private String nome;
}
