package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Grade;
import dev.paie.config.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GradeServiceJdbcTemplateTest.
 */
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { GradeServiceJdbcTemplate.class, DataSourceMySQLConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	/** The grade service. */
	@Autowired
	private GradeService gradeService;

	/** The grades. */
	private List<Grade> grades;
	
	/** The g 1. */
	private Grade g1 = new Grade();
	
	/**
	 * Test sauvegarder lister mettre a jour.
	 */
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		
		g1.setCode("TOTO");
		g1.setNbHeuresBase(BigDecimal.valueOf(536.25));
		g1.setTauxBase(BigDecimal.valueOf(0.20));

		gradeService.sauvegarder(g1);
		grades = gradeService.lister();
		grades.stream().forEach(g -> System.out.println(g.toString()));

		Stream.of(g1).forEach(g -> assertTrue("verification Sauvegarder ",	grades.stream().filter(c -> c.equals(g1)).findAny().isPresent()));
		
		g1 = grades.stream().filter(c -> c.equals(g1)).findAny().get();
		
		g1.setCode("TITI");
		gradeService.mettreAJour(g1);
		grades = gradeService.lister();

		grades.stream().forEach(g -> System.out.println(g.toString()));

		Stream.of(g1).forEach(g -> assertTrue("verification MAJ ",	grades.stream().filter(c -> c.equals(g1)).findAny().isPresent()));

		
		
		
		
		
		
		// TODO sauvegarder un nouveau grade
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}
