/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.util.PaieUtils;

/**
 * @author ETY9
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	@Autowired
	BulletinSalaireRepository bulletinRepo;

	@Override
	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> calculerBulletin() {
		HashMap<BulletinSalaire, ResultatCalculRemuneration> calcBulletin = new HashMap<BulletinSalaire, ResultatCalculRemuneration>();
		List<BulletinSalaire> bulletins = bulletinRepo.findAll();

		for (BulletinSalaire bulletin : bulletins) {
			calcBulletin.put(bulletin, calculer(bulletin));
		}

		return calcBulletin;
	}

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration remu = new ResultatCalculRemuneration();
		PaieUtils paieUtils = new PaieUtils();
		Grade grade = bulletin.getRemunerationEmploye().getGrade();

		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		BigDecimal salaireBase = grade.getNbHeuresBase().multiply(grade.getTauxBase());

		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());

		BigDecimal totalRetenueSalariale = BigDecimal.ZERO;
		BigDecimal totalCotisationsPatronales = BigDecimal.ZERO;

		try (Stream<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream()) {

			BinaryOperator<BigDecimal> binaryOperator = BigDecimal::add;

			// TOTAL_RETENUE_SALARIALE =
			// SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
			totalRetenueSalariale = cotisationsNonImposables.filter(c -> c.getTauxSalarial() != null)
					.map(c -> c.getTauxSalarial().multiply(salaireBrut)).reduce(binaryOperator).orElse(BigDecimal.ZERO);
		}

		try (Stream<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream()) {

			BinaryOperator<BigDecimal> binaryOperator = BigDecimal::add;

			// TOTAL_COTISATIONS_PATRONALES =
			// SOMME(COTISATION_NON_IMPOSABLE.TAUX_PATRONAL*SALAIRE_BRUT)
			totalCotisationsPatronales = cotisationsNonImposables.filter(c -> c.getTauxPatronal() != null)
					.map(c -> c.getTauxPatronal().multiply(salaireBrut)).reduce(BigDecimal.ZERO, binaryOperator);
		}

		BigDecimal totalCotisationsImposables = BigDecimal.ZERO;

		try (Stream<Cotisation> cotisationsImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables().stream()) {

			totalCotisationsImposables = cotisationsImposables.filter(c -> c.getTauxSalarial() != null)
					.map(c -> c.getTauxSalarial().multiply(salaireBrut)).reduce(BigDecimal::add)
					.orElse(BigDecimal.ZERO);
		}

		remu.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireBase));
		remu.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		remu.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalariale));
		remu.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatronales));

		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		BigDecimal netImposable = new BigDecimal(remu.getSalaireBrut())
				.subtract(new BigDecimal(remu.getTotalRetenueSalarial()));
		remu.setNetImposable(paieUtils.formaterBigDecimal(netImposable));

		// NET_A_PAYER = NET_IMPOSABLE -
		// SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal netAPayer = new BigDecimal(remu.getNetImposable()).subtract(totalCotisationsImposables);

		remu.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));
		return remu;
	}

}
