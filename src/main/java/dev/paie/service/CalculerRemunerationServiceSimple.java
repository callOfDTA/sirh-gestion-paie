package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Override
	
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		// TODO Auto-generated method stub
		BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		BigDecimal salaireBrut = bulletin.getPrimeExceptionnelle().add(salaireBase);
		BigDecimal total_retenue = BigDecimal.ZERO;
		BigDecimal cotis_patronales = BigDecimal.ZERO;
		List<Cotisation> cotisSal = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		cotisSal.removeIf(c -> c.getTauxSalarial()!=null);		
		cotisSal.forEach(c -> total_retenue.add(salaireBrut.multiply(c.getTauxSalarial())));
		bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().forEach(c -> total_retenue.add(salaireBrut.multiply(c.getTauxPatronal())));
		BigDecimal net_imposable = salaireBrut.subtract(total_retenue);
		
		BigDecimal deductions = BigDecimal.ZERO;
		bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().forEach(c -> deductions.add(salaireBrut.multiply(c.getTauxSalarial())));
		BigDecimal net_a_payer = net_imposable.subtract(deductions);
		ResultatCalculRemuneration rc = new ResultatCalculRemuneration(salaireBase.toString(), salaireBrut.toString(), total_retenue.toString(), cotis_patronales.toString(), net_imposable.toString(), net_a_payer.toString());
		return rc;
	}

}
