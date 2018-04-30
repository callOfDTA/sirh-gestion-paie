package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.entite.Grade;

public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouveau grade
		gradeService=new GradeServiceJdbcTemplate(new DataSourceMySQLConfig().dataSource());
		Grade nvGrade = new Grade();
		nvGrade.setId(1);
		nvGrade.setCode("M01");
		nvGrade.setNbHeuresBase(BigDecimal.valueOf(110.37));
		nvGrade.setTauxBase(BigDecimal.valueOf(110));
		gradeService.sauvegarder(nvGrade);
	// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> testGrades = gradeService.lister();
		testGrades.forEach(g -> System.out.println(g.getId() + " " + g.getCode() + " "  + g.getNbHeuresBase() + " " +g.getTauxBase()));
		nvGrade.setCode("M04");
		nvGrade.setTauxBase(BigDecimal.valueOf(115.42));
		gradeService.mettreAJour(nvGrade);
		testGrades = gradeService.lister();
		testGrades.forEach(g -> System.out.println(g.getId() + " " + g.getCode() + " "  + g.getNbHeuresBase() + " " +g.getTauxBase()));
 	// TODO modifier un grade
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	}

}
