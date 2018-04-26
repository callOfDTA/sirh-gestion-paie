package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Entreprise;

@Service
@Transactional
public class EntrepriseServiceJpa implements EntrepriseService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void sauvegarder(Entreprise nouvelleEntreprise) {

		em.persist(nouvelleEntreprise);

	}

	@Override
	public void mettreAJour(Entreprise entreprise) {
		// TODO Auto-generated method stub

		Entreprise entrepriseBDD = em.find(Entreprise.class, entreprise.getId());
		entrepriseBDD.setSiret(entreprise.getSiret());

	}

	@Override
	public List<Entreprise> lister() {

		TypedQuery<Entreprise> query = em.createQuery("FROM Entreprise", Entreprise.class);
		return query.getResultList();

	}

}
