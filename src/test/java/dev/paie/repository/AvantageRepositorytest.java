package dev.paie.repository;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServiceConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServiceConfig.class, DataSourceMySQLConfig.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositorytest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Avantage a=new Avantage();
		a.setCode("desSous");
		a.setNom("patrick");
		a.setMontant(BigDecimal.valueOf(125.50));
		avantageRepository.save(a);
		Avantage b= avantageRepository.findOne(1);
		System.out.println(b.getCode() + b.getNom() + b.getMontant());
		b.setCode("plusDeSous");
		b.setNom("patrice");
		b.setMontant(BigDecimal.valueOf(500.25));
		b.setId(1);
		avantageRepository.save(b);
		Avantage c= avantageRepository.findOne(1);
		System.out.println(c.getCode() + c.getNom() + c.getMontant());
	// TODO sauvegarder un nouvel avantage
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
	// TODO modifier un avantage
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
	}
}
