package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService{
	@PersistenceContext private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);		
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
	Cotisation oldcotisation =	em.find(Cotisation.class, cotisation.getId());
	oldcotisation.setCode(cotisation.getCode());
	oldcotisation.setLibelle(cotisation.getLibelle());
	oldcotisation.setTauxPatronal(cotisation.getTauxPatronal());
	oldcotisation.setTauxSalarial(cotisation.getTauxSalarial());
		
	}

	@Override
	public List<Cotisation> lister() {
		// TODO Auto-generated method stub
		TypedQuery<Cotisation> query = em.createQuery("From Cotisation",Cotisation.class);
		return query.getResultList();
	}
}
