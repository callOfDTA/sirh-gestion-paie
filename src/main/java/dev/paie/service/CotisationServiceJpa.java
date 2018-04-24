package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);	
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		Cotisation oldCot = em.find(Cotisation.class, cotisation.getId());
		
		if(oldCot != null) {
			oldCot.setCode(cotisation.getCode());
			oldCot.setLibelle(cotisation.getLibelle());
			oldCot.setTauxPatronal(cotisation.getTauxPatronal());
			oldCot.setTauxSalarial(cotisation.getTauxSalarial());
		}	
	}

	@Override
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("FROM cotisation", Cotisation.class);
		return query.getResultList();
	}

}
