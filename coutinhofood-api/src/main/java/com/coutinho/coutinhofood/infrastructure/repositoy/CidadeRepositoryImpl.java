package com.coutinho.coutinhofood.infrastructure.repositoy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coutinho.coutinhofood.domain.model.Cidade;
import com.coutinho.coutinhofood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Cidade> todas() {
		return entityManager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade porId(Long id) {
		return entityManager.find(Cidade.class, id);
	}

	@Transactional
	@Override
	public Cidade adicionar(Cidade cidade) {
		return entityManager.merge(cidade);
	}

	@Transactional
	@Override
	public void remover(Cidade cidade) {
		cidade = entityManager.find(Cidade.class, cidade.getId());
		entityManager.remove(cidade);
	}

}
