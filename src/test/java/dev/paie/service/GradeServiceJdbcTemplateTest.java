package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

//TODO compléter la configuration
@ContextConfiguration(classes = { DataSourceMySQLConfig.class, GradeServiceJdbcTemplate.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;
	
	private Grade nouveauGrade;
	private List<Grade> listGrade;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//sauvegarder un nouveau grade
		nouveauGrade = new Grade( "segseg", BigDecimal.valueOf(141.67), BigDecimal.valueOf(15.10));
		gradeService.sauvegarder(nouveauGrade);


		//Methode Lister
		listGrade = gradeService.lister();
		listGrade.stream().forEach(g -> System.out.println(g.toString()));
		
		Stream.of(nouveauGrade).forEach(g -> assertTrue("verification Sauvegarder ",    listGrade.stream().filter(c -> c.equals(nouveauGrade)).findAny().isPresent()));

		//modifier un grade
		
		nouveauGrade = listGrade.stream().filter(g -> g.equals(nouveauGrade)).findFirst().get();
		nouveauGrade.setCode("Cyril");
		gradeService.mettreAJour(nouveauGrade);

		// vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		listGrade = gradeService.lister();
		listGrade.stream().forEach(g -> System.out.println(g.toString()));
		
		Stream.of(nouveauGrade).forEach(g -> assertTrue("verification Mise à Jour ",    listGrade.stream().filter(c -> c.equals(nouveauGrade)).findAny().isPresent()));
	}
}