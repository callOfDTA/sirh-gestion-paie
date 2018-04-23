package dev.paie.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.ToLongFunction;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{

	private PaieUtils pu = new PaieUtils();
	
	public CalculerRemunerationServiceSimple() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		ResultatCalculRemuneration rcr = new ResultatCalculRemuneration();
		
		BigDecimal salaireBase = ((bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()).multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase()));
		
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		
		BigDecimal totalRetenuSalarial = BigDecimal.valueOf(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
										.mapToDouble(i -> ((i.getTauxSalarial().doubleValue()*salaireBrut.doubleValue()))).sum());
		
		BigDecimal totalCotisationsPatronales = BigDecimal.valueOf(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
										.mapToDouble(i -> ((i.getTauxPatronal().doubleValue()*salaireBrut.doubleValue()))).sum());
		
		BigDecimal netImposable = salaireBrut.subtract(totalRetenuSalarial);
		
		BigDecimal netAPayer = netImposable.subtract(BigDecimal.valueOf(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
								.mapToDouble(i -> ((i.getTauxSalarial().multiply(salaireBrut).doubleValue()))).sum()));
		
		
		rcr.setSalaireBrut(pu.formaterBigDecimal(salaireBrut));
		rcr.setSalaireDeBase(pu.formaterBigDecimal(salaireBase));
		
		rcr.setTotalCotisationsPatronales(pu.formaterBigDecimal(totalCotisationsPatronales));
		rcr.setTotalRetenueSalarial(pu.formaterBigDecimal(totalRetenuSalarial));
		
		rcr.setNetAPayer(pu.formaterBigDecimal(netAPayer));
		rcr.setNetImposable(pu.formaterBigDecimal(netImposable));
		
		return rcr;
	}


}
