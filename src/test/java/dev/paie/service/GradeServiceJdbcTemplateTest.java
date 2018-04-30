/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

/**
 * @author ETY9
 *
 */
@ContextConfiguration(classes = { DataSourceMySQLConfig.class, ServicesConfig.class})
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Grade grade = new Grade();
		grade.setCode("test2");
		grade.setNbHeuresBase(BigDecimal.valueOf(12.2));
		grade.setTauxBase(BigDecimal.valueOf(0.01));

		gradeService.sauvegarder(grade);
		gradeService.lister();
		
		// TODO sauvegarder un nouveau grade
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}
