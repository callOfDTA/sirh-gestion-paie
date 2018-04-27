package dev.paie.repository;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

// TODO: Auto-generated Javadoc
/**
 * The Class AvantageRepositoryTest.
 */
@ContextConfiguration(classes = { ServicesConfig.class })
// TODO compléter la configuration
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	
	/** The avantage repository. */
	@Autowired
	private AvantageRepository avantageRepository;

	/** The av. */
	private Avantage av;

	/**
	 * Test sauvegarder lister mettre a jour.
	 */
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		av = new Avantage("TITI", "MEHDI", BigDecimal.valueOf(150.36));

		avantageRepository.save(av);

		assertTrue(avantageRepository.exists(av.getId()));

		av.setCode("TOTO");

		avantageRepository.save(av);

		assertTrue(avantageRepository.exists(av.getId()));

		avantageRepository.delete(av);
		// avantageRepository.

		// TODO sauvegarder un nouvel avantage
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
		// TODO modifier un avantage
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
	}
}