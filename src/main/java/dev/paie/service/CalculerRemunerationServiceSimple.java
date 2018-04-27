package dev.paie.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	@Autowired
	private BulletinSalaireRepository bulletinRepository;

	@PersistenceContext
	private EntityManager em;

	PaieUtils pu = new PaieUtils();

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration result = new ResultatCalculRemuneration();

		Grade grade = bulletin.getRemunerationEmploye().getGrade();

		BigDecimal sal = grade.getTauxBase().multiply(grade.getNbHeuresBase());
		result.setSalaireDeBase(pu.formaterBigDecimal(sal).toString());

		BigDecimal prime = bulletin.getPrimeExceptionnelle();
		BigDecimal salBrut = sal.add(prime);
		result.setSalaireBrut(pu.formaterBigDecimal(salBrut).toString());

		BigDecimal retenueSal = new BigDecimal("0");
		ProfilRemuneration profil = bulletin.getRemunerationEmploye().getProfilRemuneration();
		for (int i = 0; i < profil.getCotisationsNonImposables().size(); i++) {
			if (profil.getCotisationsNonImposables().get(i).getTauxSalarial() != null) {
				retenueSal = retenueSal
						.add(profil.getCotisationsNonImposables().get(i).getTauxSalarial().multiply(salBrut));
			}
		}
		result.setTotalRetenueSalarial(pu.formaterBigDecimal(retenueSal).toString());

		BigDecimal cosPal = new BigDecimal("0");
		for (int i = 0; i < profil.getCotisationsNonImposables().size(); i++) {
			if (profil.getCotisationsNonImposables().get(i).getTauxPatronal() != null) {
				cosPal = cosPal.add(profil.getCotisationsNonImposables().get(i).getTauxPatronal().multiply(salBrut));
			}
		}
		result.setTotalCotisationsPatronales(pu.formaterBigDecimal(cosPal).toString());

		BigDecimal netImp = new BigDecimal("0");
		netImp = salBrut.subtract(retenueSal);
		result.setNetImposable(netImp.toString());

		BigDecimal netPayer = netImp;
		BigDecimal sommeSansImpot = new BigDecimal("0");
		for (int i = 0; i < profil.getCotisationsImposables().size(); i++) {
			if (profil.getCotisationsImposables().get(i).getTauxSalarial() != null) {
				sommeSansImpot = sommeSansImpot
						.add(profil.getCotisationsImposables().get(i).getTauxSalarial().multiply(salBrut));
			}
		}
		netPayer = netPayer.subtract(sommeSansImpot);
		result.setNetAPayer(pu.formaterBigDecimal(netPayer).toString());

		return result;
	}

	@Override
	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> calculerTousLesBulletins() {

		List<BulletinSalaire> listBulletins = bulletinRepository.findAll();

		Map<BulletinSalaire, ResultatCalculRemuneration> resultat = new HashMap<>();

		for (BulletinSalaire bulletin : listBulletins) {

			resultat.put(bulletin, calculer(bulletin));
		}

		/*
		 * Map<BulletinSalaire, ResultatCalculRemuneration> resultat =
		 * listBulletins.stream() .collect(Collectors.toMap(Function.identity(),
		 * b -> calculer(b)));
		 */

		return resultat;
	}
}
