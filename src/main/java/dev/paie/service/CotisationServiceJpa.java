package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
@Transactional
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext 
	private EntityManager em;
	
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {

		em.persist(nouvelleCotisation);

	}

	@Override
	public void mettreAJour(Cotisation cotisation) {
		// TODO Auto-generated method stub
		
		Cotisation cotisationBDD = em.find(Cotisation.class, cotisation.getId());
		cotisationBDD.setCode(cotisation.getCode());
		
	}

	@Override
	public List<Cotisation> lister() {
		
		TypedQuery<Cotisation> query = em.createQuery("FROM Cotisation", Cotisation.class);
		return query.getResultList();
		
	}

}
