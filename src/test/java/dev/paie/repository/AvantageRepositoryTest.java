package dev.paie.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	public List<Avantage> list() {
		return avantageRepository.findAll();
	}

	public void save(Avantage av) {
		avantageRepository.save(av);
	}

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Avantage av = new Avantage("test3", "Maxime3", new BigDecimal("0"));
		save(av);
		list();
		av.setNom("Roger2");
		save(av);
		list();
	}

	// TODO sauvegarder un nouvel avantage
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la
	// méthode findOne
	// TODO modifier un avantage
	// TODO vérifier que les modifications sont bien prises en compte via la
	// méthode findOne
}