package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServiceConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServiceConfig.class, DataSourceMySQLConfig.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired 
	private CotisationService cotisationService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Cotisation newCot =new Cotisation();
		newCot.setCode("cot2");
		newCot.setLibelle("cot");
		newCot.setTauxPatronal(BigDecimal.valueOf(0.1));
		newCot.setTauxSalarial(BigDecimal.valueOf(0.50));
		newCot.setId(1);
		//cotisationService.sauvegarder(newCot);
		cotisationService.mettreAJour(newCot);
		for(Cotisation cot : cotisationService.lister()){
			System.out.println(cot.getCode());
		}
	// TODO sauvegarder une nouvelle cotisation
	// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
	// TODO modifier une cotisation
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	}
}
