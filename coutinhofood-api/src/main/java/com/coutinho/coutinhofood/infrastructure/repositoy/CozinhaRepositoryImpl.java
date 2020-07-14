package com.coutinho.coutinhofood.infrastructure.repositoy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coutinho.coutinhofood.domain.model.Cozinha;
import com.coutinho.coutinhofood.domain.repository.CozinhaRepository;


@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> todas(){
		//retorna um tipado de cozinha.
		return manager.createQuery("from Cozinha", Cozinha.class)
			.getResultList();
	}
	
	@Override
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
		
	}
	
	
	@Override
	public Cozinha porId(Long id) {
		return manager.find(Cozinha.class, id);
	}

	@Override
	@Transactional
	public void remover(Cozinha cozinha) {
		
		cozinha = porId(cozinha.getId());
		manager.remove(cozinha);
	}


}
