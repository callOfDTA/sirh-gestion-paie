/**
 * 
 */
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

/**
 * @author ETY9
 *
 */
@ContextConfiguration(classes = { DataSourceMySQLConfig.class, ServicesConfig.class, JpaConfig.class})
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Cotisation oldCotisation = new Cotisation();
		Cotisation newCotisation = new Cotisation();
		
		newCotisation.setCode("insert");
		newCotisation.setLibelle("INSERT");
		newCotisation.setTauxPatronal(BigDecimal.valueOf(10.5));
		newCotisation.setTauxSalarial(BigDecimal.valueOf(7.12));
		
		oldCotisation.setCode("update");
		oldCotisation.setLibelle("UPDATE");
		oldCotisation.setTauxPatronal(BigDecimal.valueOf(12.2));
		oldCotisation.setTauxSalarial(BigDecimal.valueOf(8.54));
		oldCotisation.setId(1);
	
		
		cotisationService.sauvegarder(newCotisation);
		cotisationService.mettreAJour(oldCotisation);
		
		List<Cotisation> test = cotisationService.lister();
		for (Cotisation c : test){
			System.out.println(c.getId());
			System.out.println(c.getCode());
			System.out.println(c.getLibelle());
		}
		
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}