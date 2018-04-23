/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * @author ETY9
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		BigDecimal nbHeuresBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase();
		BigDecimal tauxBase = bulletin.getRemunerationEmploye().getGrade().getTauxBase();
		BigDecimal salaireBase = nbHeuresBase.multiply(tauxBase);

		BigDecimal primeExceptionnelle = bulletin.getPrimeExceptionnelle();
		BigDecimal salaireBrut = nbHeuresBase.add(primeExceptionnelle);

		BigDecimal totalRetenueSalarial = BigDecimal.ZERO;
		List<Cotisation> cotisationNonImposable = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables();
		for (Cotisation cotiNonImpo : cotisationNonImposable) {
			if (cotiNonImpo.getTauxSalarial() != null) {
				totalRetenueSalarial.add(cotiNonImpo.getTauxSalarial().multiply(salaireBrut));
			}
		}

		BigDecimal totalCotisationsPatronales = BigDecimal.ZERO;
		for (Cotisation cotiNonImpo : cotisationNonImposable) {
			if (cotiNonImpo.getTauxSalarial() != null) {
				totalCotisationsPatronales.add(cotiNonImpo.getTauxPatronal().multiply(salaireBrut));
			}
		}

		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalarial);

		BigDecimal totalRetenueSalarialeImposable = BigDecimal.ZERO;
		List<Cotisation> cotisationImposable = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables();
		for (Cotisation cotiImpo : cotisationImposable) {
			if (cotiImpo.getTauxSalarial() != null) {
				totalRetenueSalarialeImposable.add(cotiImpo.getTauxSalarial().multiply(salaireBrut));
			}
		}
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
