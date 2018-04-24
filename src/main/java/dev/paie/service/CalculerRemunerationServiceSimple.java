/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * @author ETY9
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		
		ResultatCalculRemuneration remu = new ResultatCalculRemuneration();
		Grade grade = bulletin.getRemunerationEmploye().getGrade();
		
		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		BigDecimal salaireBase = grade.getNbHeuresBase().multiply(grade.getTauxBase());

		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());

		BigDecimal totalRetenueSalarial = BigDecimal.ZERO;
		BigDecimal totalCotisationsPatronales = BigDecimal.ZERO;
		
		// TOTAL_RETENUE_SALARIALE = SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		List<Cotisation> cotisationNonImposable = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables();
		for (Cotisation cotiNonImpo : cotisationNonImposable) {
			if (cotiNonImpo.getTauxSalarial() != null) {
				totalRetenueSalarial.add(cotiNonImpo.getTauxSalarial().multiply(salaireBrut));
			}
		}

		// TOTAL_COTISATIONS_PATRONALES =
					//		SOMME(COTISATION_NON_IMPOSABLE.TAUX_PATRONAL*SALAIRE_BRUT)
		for (Cotisation cotiNonImpo : cotisationNonImposable) {
			if (cotiNonImpo.getTauxSalarial() != null) {
				totalCotisationsPatronales.add(cotiNonImpo.getTauxSalarial().multiply(salaireBrut));
			}
		}

		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalarial);

		BigDecimal totalRetenueSalarialeImposable = BigDecimal.ZERO;
		List<Cotisation> cotisationImposable = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables();
		for (Cotisation cotiImpo : cotisationImposable) {
			if (cotiImpo.getTauxSalarial() != null) {
				totalRetenueSalarialeImposable.add(cotiImpo.getTauxSalarial().multiply(salaireBrut));
			}
		}
		
		// NET_A_PAYER = NET_IMPOSABLE - SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal netAPayer = netImposable.subtract(totalRetenueSalarialeImposable);

		ResultatCalculRemuneration rsr = new ResultatCalculRemuneration();
		rsr.setSalaireDeBase(salaireBase.toString());
		rsr.setSalaireBrut(salaireBrut.toString());
		rsr.setTotalRetenueSalarial(totalRetenueSalarial.toString());
		rsr.setTotalCotisationsPatronales(totalCotisationsPatronales.toString());
		rsr.setNetImposable(netImposable.toString());
		rsr.setNetAPayer(netAPayer.toString());

		return rsr;
	}

}
