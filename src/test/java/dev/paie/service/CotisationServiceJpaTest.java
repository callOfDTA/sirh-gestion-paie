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
import dev.paie.entite.Cotisation;

// TODO: Auto-generated Javadoc
/**
 * The Class CotisationServiceJpaTest.
 */
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { JpaConfig.class, DataSourceMySQLConfig.class, CotisationServiceJpa.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	/** The cotisation service. */
	@Autowired
	private CotisationService cotisationService;

	/** The cotisations. */
	private List<Cotisation> cotisations;

	/** The cot. */
	private Cotisation cot;

	/**
	 * Test sauvegarder lister mettre a jour.
	 */
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		cot = new Cotisation("TITI", "YOUHOU", BigDecimal.valueOf(0.89), BigDecimal.valueOf(0.12));

		cotisationService.sauvegarder(cot);
		cotisations = cotisationService.lister();
		cotisations.stream().forEach(g -> System.out.println(g.toString()));

		Stream.of(cot).forEach(g -> assertTrue("verification Sauvegarder ",
				cotisations.stream().filter(c -> cot.equals(cot)).findAny().isPresent()));

		cot = cotisations.stream().filter(c -> c.equals(cot)).findAny().get();

		cot.setCode("TOTO");
		cotisationService.mettreAJour(cot);
		cotisations = cotisationService.lister();

		cotisations.stream().forEach(g -> System.out.println(g.toString()));

		Stream.of(cot).forEach(g -> assertTrue("verification MAJ ",
				cotisations.stream().filter(c -> c.equals(cot)).findAny().isPresent()));

		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via laméthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}
