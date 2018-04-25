package dev.paie.repository;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.service.GradeServiceJdbcTemplate;

//TODO compléter la configuration
@ContextConfiguration(classes = { DataSourceMySQLConfig.class, ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Avantage nouveauAvantage = new Avantage("COD", "MONTANT", BigDecimal.valueOf(12.05));

		// TODO sauvegarder un nouvel avantage
		avantageRepository.save(nouveauAvantage);

		List<Avantage> listAvantage = avantageRepository.findAll();
		assertTrue("verification Sauvegarder ", avantageRepository.exists(nouveauAvantage.getId()));

		listAvantage.stream().forEach(a -> System.out.println(a.toString()));

		// TODO modifier un avantage
		nouveauAvantage.setNom("Cyril");
		avantageRepository.save(nouveauAvantage);
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		

		listAvantage.stream().forEach(a -> System.out.println(a.toString()));
		assertTrue("verification MAJ ", avantageRepository.exists(nouveauAvantage.getId()));

	}
}