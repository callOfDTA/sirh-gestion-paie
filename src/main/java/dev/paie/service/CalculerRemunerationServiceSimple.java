package dev.paie.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import dev.paie.config.JeuDeDonnerConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;
@ContextConfiguration(classes = { ServicesConfig.class, JeuDeDonnerConfig.class })

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{

	ResultatCalculRemuneration rcr = new ResultatCalculRemuneration();
	PaieUtils pu = new PaieUtils();
	
	@Autowired
	private Grade grade;
	
	
	@Autowired
	private ProfilRemuneration profil1 ;
	
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
	
		BigDecimal salairedebase = grade.getNbHeuresBase().multiply(grade.getTauxBase());	

			rcr.setSalaireDeBase(pu.formaterBigDecimal(salairedebase).toString());
		
			BigDecimal 	salaireBrut = salairedebase.add(bulletin.getPrimeExceptionnelle());
			rcr.setSalaireBrut(pu.formaterBigDecimal(salaireBrut).toString());

		
		
		BigDecimal totalretenuesalarial = new BigDecimal ("0");
				Source: http://godiche.ru/ordinateurs-et-logiciels/programmation/java/9962-comment-faire-de-l-arithmtique-bigdecimal-pour.html;
		for (int i = 0; i < profil1.getCotisationsNonImposables().size(); i++) {
			if(profil1.getCotisationsNonImposables().get(i).getTauxSalarial() != null){
				totalretenuesalarial = totalretenuesalarial.add(profil1.getCotisationsNonImposables().get(i).getTauxSalarial().multiply(salaireBrut));
			}
			
		}
		rcr.setTotalRetenueSalarial(pu.formaterBigDecimal(totalretenuesalarial).toString());
		
		BigDecimal totalretenuepatronal = new BigDecimal ("0");
		for (int i = 0; i < profil1.getCotisationsNonImposables().size(); i++) {
			if(profil1.getCotisationsNonImposables().get(i).getTauxPatronal() != null){
			totalretenuepatronal = totalretenuepatronal.add(profil1.getCotisationsNonImposables().get(i).getTauxPatronal().multiply(salaireBrut));
			}
			}
		rcr.setTotalCotisationsPatronales(pu.formaterBigDecimal(totalretenuepatronal).toString());
		
		BigDecimal netimpossable = salaireBrut.subtract(totalretenuesalarial);
		rcr.setNetImposable(pu.formaterBigDecimal(netimpossable).toString());
		
		BigDecimal netapayer = netimpossable;
		BigDecimal cotimpo = new BigDecimal ("0");
		for (int i = 0; i < profil1.getCotisationsImposables().size(); i++) {
			if(profil1.getCotisationsImposables().get(i).getTauxSalarial() != null){
				cotimpo = cotimpo.add(profil1.getCotisationsImposables().get(i).getTauxSalarial().multiply(salaireBrut));
				
			}
			
			}
		netapayer = netapayer.subtract(cotimpo);
		rcr.setNetAPayer(pu.formaterBigDecimal(netapayer).toString());
		return rcr;
	}

}
