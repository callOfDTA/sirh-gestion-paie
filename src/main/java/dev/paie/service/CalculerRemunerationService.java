package dev.paie.service;

import java.util.Map;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

// TODO: Auto-generated Javadoc
/**
 * The Interface CalculerRemunerationService.
 */
public interface CalculerRemunerationService {

	/**
	 * Calculer.
	 *
	 * @param bulletin
	 *            the bulletin
	 * @return the resultat calcul remuneration
	 */
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);

	/**
	 * Calculer tous bulletins.
	 *
	 * @return the map
	 */
	Map<BulletinSalaire, ResultatCalculRemuneration> calculerTousBulletins();

}
