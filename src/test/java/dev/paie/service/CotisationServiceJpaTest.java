package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class, DataSourceMySQLConfig.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;
	
	public void onSetup() {
		//cotisationService=new CotisationServiceJpa();
	}

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
	// TODO sauvegarder une nouvelle cotisation
		Cotisation cot = new Cotisation();
		cot.setId(1);
		cot.setCode("cot1");
		cot.setLibelle("Cotisation1");
		cot.setTauxSalarial(BigDecimal.valueOf(1.15));
		cotisationService.sauvegarder(cot);
	// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
	// TODO modifier une cotisation
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	}
}
