package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.entite.ResultatCalculRemuneration;

public class CalculerRemunerationServiceSimpleTest {

	@Autowired
	private CalculerRemunerationService remunerationService;

	@Test
	public void test_calculer() {
		// TODO remplacer null par un objet bulletin
		ResultatCalculRemuneration resultat = remunerationService.calculer(null);
		assertThat(resultat.getSalaireBrut(), equalTo("2683.30"));
		assertThat(resultat.getTotalRetenueSalarial(), equalTo("517.08"));
		assertThat(resultat.getTotalCotisationsPatronales(), equalTo("1096.13"));
		assertThat(resultat.getNetImposable(), equalTo("2166.22"));
		assertThat(resultat.getNetAPayer(), equalTo("2088.41"));
	}

}
