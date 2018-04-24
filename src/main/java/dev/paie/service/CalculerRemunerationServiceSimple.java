package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	PaieUtils pu = new PaieUtils();

	@Override
	
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		// TODO Auto-generated method stub
		BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		BigDecimal salaireBrut = bulletin.getPrimeExceptionnelle().add(salaireBase);
		BigDecimal total_retenue = BigDecimal.ZERO;
		BigDecimal cotis_patronales = BigDecimal.ZERO;
		List<Cotisation> cotisSal = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		List<Cotisation> cotisPat = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		cotisSal.removeIf(c -> c.getTauxSalarial()==null);
		cotisPat.removeIf(c -> c.getTauxPatronal()==null);
		cotisSal.forEach(c -> total_retenue.add(salaireBrut.multiply(c.getTauxSalarial())));
		cotisPat.forEach(c -> total_retenue.add(salaireBrut.multiply(c.getTauxPatronal())));
		BigDecimal net_imposable = salaireBrut.subtract(total_retenue);
		BigDecimal deductions = BigDecimal.ZERO;
		bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().forEach(c -> deductions.add(salaireBrut.multiply(c.getTauxSalarial())));
		BigDecimal net_a_payer = net_imposable.subtract(deductions);
		ResultatCalculRemuneration rc = new ResultatCalculRemuneration(pu.formaterBigDecimal(salaireBase), pu.formaterBigDecimal(salaireBrut), pu.formaterBigDecimal(total_retenue), pu.formaterBigDecimal(cotis_patronales), pu.formaterBigDecimal(net_imposable), pu.formaterBigDecimal(net_a_payer));
		return rc;
	}

}
