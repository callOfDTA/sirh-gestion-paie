package dev.paie.service;

import java.util.List;

import dev.paie.entite.Cotisation;

// TODO: Auto-generated Javadoc
/**
 * The Interface CotisationService.
 */
public interface CotisationService {

	/**
	 * Sauvegarder.
	 *
	 * @param nouvelleCotisation
	 *            the nouvelle cotisation
	 */
	void sauvegarder(Cotisation nouvelleCotisation);

	/**
	 * Mettre A jour.
	 *
	 * @param cotisation
	 *            the cotisation
	 */
	void mettreAJour(Cotisation cotisation);

	/**
	 * Lister.
	 *
	 * @return the list
	 */
	List<Cotisation> lister();
}