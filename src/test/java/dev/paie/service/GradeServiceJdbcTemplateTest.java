package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { ServicesConfig.class, DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// ResultatCalculRemuneration resultat =
		// remunerationService.calculer(bulletin);
		Grade grade = new Grade();
		grade.setId(9);
		grade.setCode("test");
		grade.setNbHeuresBase(new BigDecimal("10"));
		grade.setTauxBase(new BigDecimal("0.0022"));
		Grade grade2 = new Grade();
		grade2.setId(10);
		grade2.setCode("test2");
		grade2.setNbHeuresBase(new BigDecimal("20"));
		grade2.setTauxBase(new BigDecimal("0.002"));

		gradeService.sauvegarder(grade);
		gradeService.sauvegarder(grade2);
		// TODO sauvegarder un nouveau grade
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		List<Grade> lgrade = gradeService.lister();
		for (int j = 0; j < lgrade.size(); j++) {
			System.out.println(lgrade.get(j).getCode() + lgrade.get(j).getId());
		}
		
		// méthode lister
		// TODO modifier un grade
		grade2.setId(10);
		grade2.setCode("test3");
		grade2.setNbHeuresBase(new BigDecimal("20"));
		grade2.setTauxBase(new BigDecimal("0.002"));
		gradeService.mettreAJour(grade2);
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		List<Grade> lgrade2 = gradeService.lister();
		for (int j = 0; j < lgrade2.size(); j++) {
			System.out.println("Code: "+lgrade2.get(j).getCode() +"id: " + lgrade2.get(j).getId());
		}
	}
}
