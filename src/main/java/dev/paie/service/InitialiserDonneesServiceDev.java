package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("grades.xml",
				"cotisations-imposables.xml", "profils-remuneration.xml", "entreprises.xml",
				"cotisations-non-imposables.xml");

		Stream.of(Grade.class, Entreprise.class, Cotisation.class, ProfilRemuneration.class)
				.flatMap(uneClasse -> ctx.getBeansOfType(uneClasse).values().stream()).forEach(em::persist);

		initPeriod();
	}

	@Transactional
	public void initPeriod() {
		List<Periode> lPeriode = new ArrayList<>();

		IntStream.rangeClosed(1, 12).forEach(i -> {
			LocalDate debut = LocalDate.of(LocalDate.now().getYear(), i, 01);
			LocalDate fin = LocalDate.of(LocalDate.now().getYear(), i, debut.lengthOfMonth());
			lPeriode.add(new Periode(debut, fin));
		});
		lPeriode.stream().forEach(em::persist);
	}

}
