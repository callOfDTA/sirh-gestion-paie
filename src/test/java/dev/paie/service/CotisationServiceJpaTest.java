package dev.paie.service;

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
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

//TODO compléter la configuration
@ContextConfiguration(classes = { JpaConfig.class, DataSourceMySQLConfig.class, ServicesConfig.class})
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;
	
	private Cotisation nouvelleCotisation;
	private List<Cotisation> listCotisation;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		// TODO sauvegarder une nouvelle cotisation
		nouvelleCotisation = new Cotisation("CYRIL","REN",BigDecimal.valueOf(12.15),BigDecimal.valueOf(18.26));
		cotisationService.sauvegarder(nouvelleCotisation);
		

		// via la méthode lister
		listCotisation = cotisationService.lister();
		listCotisation.stream().forEach(c -> System.out.println(c.toString()));
		
		Stream.of(nouvelleCotisation).forEach(g -> assertTrue("verification Sauvegarder ",    listCotisation.stream().filter(c -> nouvelleCotisation.equals(nouvelleCotisation)).findAny().isPresent()));
		
		
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		nouvelleCotisation = listCotisation.stream().filter(c -> c.equals(nouvelleCotisation)).findFirst().get();

		// TODO modifier une cotisation
		nouvelleCotisation.setCode("Mehdi");
		cotisationService.mettreAJour(nouvelleCotisation);
		
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		listCotisation = cotisationService.lister();
		listCotisation.stream().forEach(c -> System.out.println(c.toString()));
		
		Stream.of(nouvelleCotisation).forEach(g -> assertTrue("verification Mise à Jour ",    listCotisation.stream().filter(c -> nouvelleCotisation.equals(nouvelleCotisation)).findAny().isPresent()));
	}
}