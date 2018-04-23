package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.JeuxDeDonneesTest;

@ContextConfiguration(classes = { ServicesConfig.class, JeuxDeDonneesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CalculerRemunerationServiceSimpleTest {
	private ClassPathXmlApplicationContext context;
	@Autowired
	private CalculerRemunerationService remunerationService;
	@Autowired
	private BulletinSalaire bulletin1;

	@Before
	public void onSetup() {
		context = new ClassPathXmlApplicationContext("jdd-config.xml");
		bulletin1 = context.getBean("bulletin1", BulletinSalaire.class);
	}

	@Test
	public void test_calculer() {
		// TODO remplacer null par un objet bulletin
		ResultatCalculRemuneration resultat = remunerationService.calculer(bulletin1);
		assertThat(resultat.getSalaireBrut(), equalTo("2683.30"));
		assertThat(resultat.getTotalRetenueSalarial(), equalTo("517.08"));
		assertThat(resultat.getTotalCotisationsPatronales(), equalTo("1096.13"));
		assertThat(resultat.getNetImposable(), equalTo("2166.22"));
		assertThat(resultat.getNetAPayer(), equalTo("2088.41"));
	}

	@After
	public void onExit() {
		context.close();
	}

}
