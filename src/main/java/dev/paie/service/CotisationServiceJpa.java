package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

// TODO: Auto-generated Javadoc
/**
 * The Class CotisationServiceJpa.
 */
@Service
public class CotisationServiceJpa implements CotisationService {
	
	
	/** The em. */
	@PersistenceContext
	private EntityManager em;
	// TODO

	/* (non-Javadoc)
	 * @see dev.paie.service.CotisationService#sauvegarder(dev.paie.entite.Cotisation)
	 */
	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	/**
	 * Instantiates a new cotisation service jpa.
	 */
	public CotisationServiceJpa() {
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.CotisationService#mettreAJour(dev.paie.entite.Cotisation)
	 */
	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {

		Query q = em.createQuery("UPDATE Cotisation c SET c.code=:CODE, c.libelle=:LIBELLE, c.tauxSalarial=:TX_SALARIAL, c.tauxPatronal=:TX_PATRONAL  WHERE c.id = :ID");
		q.setParameter("CODE", cotisation.getCode());
		q.setParameter("LIBELLE", cotisation.getLibelle());
		q.setParameter("TX_SALARIAL", cotisation.getTauxSalarial());
		q.setParameter("TX_PATRONAL", cotisation.getTauxPatronal());
		q.setParameter("ID", cotisation.getId());

		q.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.CotisationService#lister()
	 */
	@Override
	public List<Cotisation> lister() {
		List<Cotisation> listCotisation = null;
		
		Query q = em.createQuery("SELECT c FROM Cotisation c");
		if (q != null) {
			listCotisation = (List<Cotisation>) q.getResultList();
		}
		
		return listCotisation;
	}
}