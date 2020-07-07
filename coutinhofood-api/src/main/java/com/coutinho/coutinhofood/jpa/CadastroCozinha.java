package com.coutinho.coutinhofood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.coutinho.coutinhofood.domain.model.Cozinha;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> listar(){
		//retorna um tipado de cozinha.
		return manager.createQuery("from Cozinha", Cozinha.class)
			.getResultList();
	}

}
