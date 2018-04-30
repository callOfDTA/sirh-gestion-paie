/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

/**
 * @author ETY9
 *
 */
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
		Cotisation oldCotisation = em.find(Cotisation.class, cotisation.getId());

		if (oldCotisation != null) {
			oldCotisation.setCode(cotisation.getCode());
			oldCotisation.setLibelle(cotisation.getLibelle());
			oldCotisation.setTauxPatronal(cotisation.getTauxPatronal());
			oldCotisation.setTauxSalarial(cotisation.getTauxSalarial());
		}
	}

	@Override
	public List<Cotisation> lister() {
		
		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		List<Cotisation> cotisations = query.getResultList();
		
		return cotisations;
	}

}
