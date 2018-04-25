/**
 * 
 */
package dev.paie.repository;

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
import dev.paie.entite.Avantage;

/**
 * @author ETY9
 *
 */
@ContextConfiguration(classes = { DataSourceMySQLConfig.class, ServicesConfig.class, JpaConfig.class})
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;
	

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Avantage avantage =  new Avantage();
		avantage.setCode("test1");
		avantage.setMontant(BigDecimal.valueOf(0.01));
		avantage.setNom("TEST1");
		
		// ajoute un avantage a la base
		avantageRepository.save(avantage);
		
		// recupere la liste et affiche
		List<Avantage> list = avantageRepository.findAll();
		for (Avantage a : list){
			System.out.println(a.getNom());
			System.out.println(a.getCode());
			System.out.println(a.getMontant());
		}
		
		Avantage test = avantageRepository.findOne(1);
		test.setCode("modif");
		// modifie l'avantage
		avantageRepository.save(test);
		
		list = avantageRepository.findAll();
		for (Avantage a : list){
			System.out.println(a.getNom());
			System.out.println(a.getCode());
			System.out.println(a.getMontant());
		}
		
		// recupere l'avantage par son code
		Avantage avByCode = avantageRepository.findByCode("modif");
		System.out.println(avByCode.getCode());
	}
}