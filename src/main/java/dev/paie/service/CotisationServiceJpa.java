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
	@PersistenceContext private EntityManager em;
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
		
	}

	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		Cotisation c = em.find(Cotisation.class, cotisation.getId());
		if(c!=null){
			c.setCode(cotisation.getCode());
			c.setLibelle(cotisation.getLibelle());
			c.setTauxPatronal(cotisation.getTauxPatronal());
			c.setTauxSalarial(cotisation.getTauxSalarial());
		}
		
	}

	@Override
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("select c from Cotisation c", Cotisation.class);
		List<Cotisation>coti=query.getResultList();
		return coti;
	}

}
