/**
 * 
 */
package dev.paie.service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * @author ETY9
 *
 */
public interface CalculerRemunerationService {
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
}
