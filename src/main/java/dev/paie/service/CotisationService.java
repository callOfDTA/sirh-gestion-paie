package dev.paie.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Transactional
public interface CotisationService {
	void sauvegarder(Cotisation nouvelleCotisation);

	void mettreAJour(Cotisation cotisation);

	List<Cotisation> lister();
}
