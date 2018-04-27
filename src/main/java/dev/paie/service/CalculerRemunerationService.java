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
	 * @param bulletin the bulletin
	 * @return the resultat calcul remuneration
	 */
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);

	/**
	 * Calculer tous les bulletin.
	 *
	 * @return the map
	 */
	public Map<BulletinSalaire, ResultatCalculRemuneration> calculerTousLesBulletin();
}
