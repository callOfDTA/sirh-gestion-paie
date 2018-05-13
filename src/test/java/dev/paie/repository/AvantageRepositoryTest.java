package dev.paie.repository;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class, DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Avantage ava1 = new Avantage("ALEX", "Alexis", new BigDecimal("124.00"));

		avantageRepository.save(ava1);

	}
}
