package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinRepository;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	PaieUtils pu = new PaieUtils();

	@Autowired
	private BulletinRepository bulletinRepository;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration rcr = new ResultatCalculRemuneration();

		BigDecimal salairedebase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());

		rcr.setSalaireDeBase(pu.formaterBigDecimal(salairedebase).toString());

		BigDecimal salaireBrut = salairedebase.add(bulletin.getPrimeExceptionnelle());
		rcr.setSalaireBrut(pu.formaterBigDecimal(salaireBrut).toString());

		BigDecimal totalretenuesalarial = new BigDecimal("0");
		Source: http: // godiche.ru/ordinateurs-et-logiciels/programmation/java/9962-comment-faire-de-l-arithmtique-bigdecimal-pour.html;
		for (int i = 0; i < bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.size(); i++) {
			if (bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().get(i)
					.getTauxSalarial() != null) {
				totalretenuesalarial = totalretenuesalarial
						.add(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
								.get(i).getTauxSalarial().multiply(salaireBrut));
			}

		}
		rcr.setTotalRetenueSalarial(pu.formaterBigDecimal(totalretenuesalarial).toString());

		BigDecimal totalretenuepatronal = new BigDecimal("0");
		for (int i = 0; i < bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.size(); i++) {
			if (bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().get(i)
					.getTauxPatronal() != null) {
				totalretenuepatronal = totalretenuepatronal
						.add(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
								.get(i).getTauxPatronal().multiply(salaireBrut));
			}
		}
		rcr.setTotalCotisationsPatronales(pu.formaterBigDecimal(totalretenuepatronal).toString());

		BigDecimal netimpossable = salaireBrut.subtract(totalretenuesalarial);
		rcr.setNetImposable(pu.formaterBigDecimal(netimpossable).toString());

		BigDecimal netapayer = netimpossable;
		BigDecimal cotimpo = new BigDecimal("0");
		for (int i = 0; i < bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()
				.size(); i++) {
			if (bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().get(i)
					.getTauxSalarial() != null) {
				cotimpo = cotimpo.add(bulletin.getRemunerationEmploye().getProfilRemuneration()
						.getCotisationsImposables().get(i).getTauxSalarial().multiply(salaireBrut));
			}
		}
		netapayer = netapayer.subtract(cotimpo);
		rcr.setNetAPayer(pu.formaterBigDecimal(netapayer).toString());
		return rcr;
	}

	@Override
	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> calculerTousLesBulletin() {
		List<BulletinSalaire> listBulletins = bulletinRepository.findAll();
		Map<BulletinSalaire, ResultatCalculRemuneration> resultat = listBulletins.stream()
				.collect(Collectors.toMap(k -> k, b -> calculer(b)));
		return resultat;
	}
}
