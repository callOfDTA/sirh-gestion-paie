package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CotisationRepository cR;

	@Autowired
	private EntrepriseRepository entR;

	@Autowired
	private GradeRepository gR;

	@Autowired
	private ProfilRemunerationRepository pRR;

	public InitialiserDonneesServiceDev() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public void initialiser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("grades.xml",
				"cotisations-imposables.xml", "profils-remuneration.xml", "entreprises.xml",
				"cotisations-non-imposables.xml");

		Stream.of(Grade.class, Cotisation.class, Entreprise.class, ProfilRemuneration.class)
				.flatMap(uneClasse -> context.getBeansOfType(uneClasse).values().stream()).forEach(em::persist);

		List<Periode> listPeriode = new ArrayList<>();
		int year = LocalDate.now().getYear();

		LocalDate debut, fin;

		for (int i = 1; i <= 12; i++) {
			debut = LocalDate.of(year, i, 01);
			fin = LocalDate.of(year, i, debut.lengthOfMonth());
			listPeriode.add(new Periode(debut, fin));
		}
		listPeriode.stream().forEach(em::persist);

	}

}
