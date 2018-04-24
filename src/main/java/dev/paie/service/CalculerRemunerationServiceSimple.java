package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService
{
	ResultatCalculRemuneration result = new ResultatCalculRemuneration();
	
	PaieUtils pu = new PaieUtils();
	
	@Autowired
	private Grade grade;
	
	@Autowired
	private ProfilRemuneration profil;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		BigDecimal sal = grade.getTauxBase().multiply(grade.getNbHeuresBase());
		result.setSalaireDeBase(pu.formaterBigDecimal(sal).toString());
		
		BigDecimal prime = bulletin.getPrimeExceptionnelle();
		BigDecimal salBrut = sal.add(prime); 
		result.setSalaireBrut(pu.formaterBigDecimal(salBrut).toString());
		
		
		BigDecimal retenueSal = new BigDecimal("0");
		for(int i = 0; i < profil.getCotisationsNonImposables().size(); i++){
			if(profil.getCotisationsNonImposables().get(i).getTauxSalarial() != null) {
				retenueSal = retenueSal.add(profil.getCotisationsNonImposables().get(i).getTauxSalarial().multiply(salBrut));
			}
		}
		result.setTotalRetenueSalarial(pu.formaterBigDecimal(retenueSal).toString());
		
		BigDecimal cosPal = new BigDecimal("0");
		for(int i = 0; i < profil.getCotisationsNonImposables().size(); i++){
			if(profil.getCotisationsNonImposables().get(i).getTauxPatronal() != null) {
				cosPal = cosPal.add(profil.getCotisationsNonImposables().get(i).getTauxPatronal().multiply(salBrut));
			}
		}
		result.setTotalCotisationsPatronales(pu.formaterBigDecimal(cosPal).toString());
		
		BigDecimal netImp = new BigDecimal("0");
		netImp = salBrut.subtract(retenueSal);
		result.setNetImposable(netImp.toString());
		
		BigDecimal netPayer = netImp;
		BigDecimal sommeSansImpot = new BigDecimal("0");
		for(int i = 0; i < profil.getCotisationsImposables().size(); i++){
			if(profil.getCotisationsImposables().get(i).getTauxSalarial() != null) {
				sommeSansImpot = sommeSansImpot.add(profil.getCotisationsImposables().get(i).getTauxSalarial().multiply(salBrut));
			}
		}
		netPayer = netPayer.subtract(sommeSansImpot);
		result.setNetAPayer(pu.formaterBigDecimal(netPayer).toString());
		
		return result;
	}

}
