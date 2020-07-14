package com.coutinho.coutinhofood.infrastructure.repositoy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coutinho.coutinhofood.domain.model.Restaurante;
import com.coutinho.coutinhofood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Restaurante> todos() {
		// TODO Auto-generated method stub
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante porId(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Restaurante.class, id);
	}

	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		// TODO Auto-generated method stub
		return manager.merge(restaurante);
	}

	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		// TODO Auto-generated method stub
		
		restaurante = porId(restaurante.getId());
		manager.remove(restaurante);
		
	}

}
