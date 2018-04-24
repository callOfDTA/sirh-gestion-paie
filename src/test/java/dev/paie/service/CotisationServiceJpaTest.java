package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Cotisation cot1 = new Cotisation("BRA", "Bramard", new BigDecimal("124.00"), new BigDecimal("20.15"));
		
		// TODO sauvegarder une nouvelle cotisation
		cotisationService.sauvegarder(cot1);
		
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via laméthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// mhode lister
	}
}
