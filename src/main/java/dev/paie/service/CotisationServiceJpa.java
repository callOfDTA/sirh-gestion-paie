package dev.paie.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		// TODO Auto-generated method stub
		em.persist(nouvelleCotisation);

	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		// TODO Auto-generated method stub
		Query q = em.createQuery(
				"UPDATE Cotisation c SET c.code=:code, c.libelle=:libelle, c.tauxSalarial=:tauxSalarial, c.tauxPatronal=:tauxPatronal WHERE c.id=:id ");
		q.setParameter("code", cotisation.getCode());
		q.setParameter("libelle", cotisation.getLibelle());
		q.setParameter("tauxSalarial", cotisation.getTauxSalarial());
		q.setParameter("tauxPatronal", cotisation.getTauxPatronal());
		q.setParameter("id", cotisation.getId());
		q.executeUpdate();

	}

	@Override
	public List<Cotisation> lister() {
		List<Cotisation> listCotisation = new ArrayList<>();
		Query query = em.createQuery("select c from Cotisation c");
		if (query != null) {
			listCotisation = (List<Cotisation>) query.getResultList();
			return listCotisation;
		}
		return listCotisation;

	}

}
