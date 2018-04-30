package dev.paie.service;

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
import dev.paie.entite.Cotisation;

//TODO compléter la configuration
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, DataSourceMySQLConfig.class})
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Cotisation cot1 =new Cotisation("test","C'est un putain de test",new BigDecimal("10"),new BigDecimal("20"));
		cotisationService.sauvegarder(cot1);
		
		List<Cotisation> lcoti =cotisationService.lister();
		for (int i = 0; i < lcoti.size(); i++) {
			System.out.println(lcoti.get(i).getLibelle());
		}
		
		cot1.setLibelle("C'est une putain de modification du test");
		cotisationService.mettreAJour(cot1);
		List<Cotisation> lcoti2 =cotisationService.lister();
		
		for (int i = 0; i < lcoti2.size(); i++) {
			System.out.println(lcoti2.get(i).getLibelle());
		}
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}