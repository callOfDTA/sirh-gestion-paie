package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("grades.xml", "entreprises.xml",
				"profils-remuneration.xml", "cotisations-imposables.xml", "cotisations-non-imposables.xml");

		Map<String, Cotisation> idCotisation = ctx.getBeansOfType(Cotisation.class);
		Map<String, Entreprise> idEntreprise = ctx.getBeansOfType(Entreprise.class);
		Map<String, Grade> idGrade = ctx.getBeansOfType(Grade.class);
		Map<String, ProfilRemuneration> idProfilRemuneration = ctx.getBeansOfType(ProfilRemuneration.class);

		idCotisation.forEach((id, cotisation) -> {
			em.persist(cotisation);
		});
		idEntreprise.forEach((id, entreprise) -> {
			em.persist(entreprise);
		});
		idGrade.forEach((id, grade) -> {
			em.persist(grade);
		});
		idProfilRemuneration.forEach((id, profilRemuneration) -> {
			em.persist(profilRemuneration);
		});

		initPeriod();

		ctx.close();
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