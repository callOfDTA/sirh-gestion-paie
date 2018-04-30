/*
 * package dev.paie.service;
 * 
 * import java.math.BigDecimal; import java.util.List;
 * 
 * import org.springframework.stereotype.Service;
 * 
 * import dev.paie.entite.BulletinSalaire; import dev.paie.entite.Cotisation;
 * import dev.paie.entite.ResultatCalculRemuneration;
 * 
 * @Service public class CalculerRemunerationServiceSimple implements
 * CalculerRemunerationService { public ResultatCalculRemuneration
 * calculer(BulletinSalaire bulletin) { BigDecimal salaireBase =
 * bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
 * .multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
 * BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
 * List<Cotisation> cotisationNonImposable =
 * bulletin.getRemunerationEmploye().getProfilRemuneration()
 * .getCotisationsNonImposables(); BigDecimal totalRetenueSalariale =
 * BigDecimal.ZERO; BigDecimal totalCotisationsPatronales = BigDecimal.ZERO; for
 * (Cotisation coti : cotisationNonImposable) { if (coti.getTauxSalarial() !=
 * null) { totalRetenueSalariale =
 * totalRetenueSalariale.add(coti.getTauxSalarial().multiply(salaireBrut)); } if
 * (coti.getTauxPatronal() != null) { totalCotisationsPatronales =
 * totalCotisationsPatronales
 * .add(coti.getTauxPatronal().multiply(salaireBrut)); } } BigDecimal
 * netImposable = salaireBrut.subtract(totalRetenueSalariale); BigDecimal
 * netAPayer = netImposable; List<Cotisation> cotisationImposable =
 * bulletin.getRemunerationEmploye().getProfilRemuneration()
 * .getCotisationsImposables(); for (Cotisation coti : cotisationImposable) {
 * netAPayer = netAPayer.add(coti.getTauxPatronal().multiply(salaireBrut)); }
 * ResultatCalculRemuneration res = new ResultatCalculRemuneration();
 * res.setNetAPayer(netAPayer.toString());
 * res.setNetImposable(netImposable.toString());
 * res.setSalaireBrut(salaireBrut.toString());
 * res.setSalaireDeBase(salaireBase.toString());
 * res.setTotalCotisationsPatronales(totalCotisationsPatronales.toString());
 * res.setTotalRetenueSalarial(totalRetenueSalariale.toString()); return null; }
 * }
 */