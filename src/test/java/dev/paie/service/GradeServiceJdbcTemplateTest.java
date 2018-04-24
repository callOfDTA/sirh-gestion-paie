package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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

@ContextConfiguration(classes = { DataSourceMySQLConfig.class, ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//TODO sauvegarder un nouveau grade
		Grade grade1 = new Grade(1, "BLU", new BigDecimal("687.50"), new BigDecimal("12.17"));
		Grade grade2 = new Grade(2, "BLA", new BigDecimal("123.11"), new BigDecimal("13.68"));
		Grade grade3 = new Grade(3, "BLI", new BigDecimal("424.43"), new BigDecimal("45.34"));
		Grade grade4 = new Grade(4, "BLO", new BigDecimal("147.43"), new BigDecimal("55.34"));
		gradeService.sauvegarder(grade4);
		//assertThat();
		//TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> lgrade = gradeService.lister();
		for(int i = 0; i < lgrade.size(); i++){
			System.out.println(lgrade.get(i).getCode());
		}
		
		//TODO modifier un grade
		grade1.setCode("BLY");
		grade1.setNbHeuresBase(new BigDecimal("123.00"));
		grade1.setTauxBase(new BigDecimal("45.00"));
		gradeService.mettreAJour(grade1);
		//TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	}
}
