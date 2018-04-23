package dev.paie.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		PaieUtils pu = new PaieUtils();
		
		
		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		Grade grade = bulletin.getRemunerationEmploye().getGrade();
		ProfilRemuneration profil = bulletin.getRemunerationEmploye().getProfilRemuneration();
		
		BigDecimal salaireDeBase = (grade.getNbHeuresBase().multiply(grade.getTauxBase()));
		BigDecimal salaireBrut = (salaireDeBase.add(bulletin.getPrimeExceptionnelle()));
		
		ToDoubleFunction<Cotisation> func1 = c -> (c.getTauxSalarial().multiply(salaireBrut).doubleValue());
		ToDoubleFunction<Cotisation> func2 = c -> (c.getTauxPatronal().multiply(salaireBrut).doubleValue());
		
		
		
		BigDecimal totalRetenue = BigDecimal.valueOf(profil.getCotisationsNonImposables().stream().mapToDouble(func1).sum());
		BigDecimal totalCotisation = BigDecimal.valueOf(profil.getCotisationsNonImposables().stream().mapToDouble(func2).sum());
		
		
		
		res.setSalaireBrut(pu.formaterBigDecimal(salaireBrut));
		res.setSalaireDeBase(pu.formaterBigDecimal(salaireDeBase));
		res.setTotalCotisationsPatronales(pu.formaterBigDecimal(totalCotisation));
		res.setTotalRetenueSalarial(pu.formaterBigDecimal(totalRetenue));

		ToDoubleFunction<Cotisation> func3 = c -> (c.getTauxSalarial().multiply(new BigDecimal(res.getSalaireBrut())).doubleValue());

		BigDecimal netImposable = new BigDecimal(res.getSalaireBrut()).subtract(new BigDecimal(res.getTotalRetenueSalarial()));
		
		res.setNetImposable(pu.formaterBigDecimal(netImposable));

		BigDecimal netAPayer = new BigDecimal(res.getNetImposable()).subtract(BigDecimal.valueOf(profil.getCotisationsImposables().stream().mapToDouble(func3).sum()));
		
		res.setNetAPayer(pu.formaterBigDecimal(netAPayer));
		
		
		return res;
	}
}
