package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

// TODO: Auto-generated Javadoc
/**
 * The Class InitialiserDonneesServiceDev.
 */
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	/** The em. */
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Instantiates a new initialiser donnees service dev.
	 */
	public InitialiserDonneesServiceDev() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Permet d'initialiser la base de données gestion paie
	 */
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

		IntStream.rangeClosed(1, 12).forEach(i -> {
			LocalDate debut = LocalDate.of(year, i, 01);
			LocalDate fin = LocalDate.of(year, i, debut.lengthOfMonth());
			listPeriode.add(new Periode(debut, fin));
		});
		listPeriode.stream().forEach(em::persist);

		Utilisateur user = new Utilisateur("Cyril", passwordEncoder.encode("user"), Boolean.FALSE,
				ROLES.ROLE_UTILISATEUR);
		Utilisateur user1 = new Utilisateur("Mehdi", passwordEncoder.encode("user1"), Boolean.TRUE,
				ROLES.ROLE_UTILISATEUR);
		Utilisateur admin = new Utilisateur("QUERE", passwordEncoder.encode("admin"), Boolean.FALSE,
				ROLES.ROLE_ADMINISTRATEUR);
		Utilisateur admin1 = new Utilisateur("ZAHOUR", passwordEncoder.encode("admin1"), Boolean.TRUE,
				ROLES.ROLE_ADMINISTRATEUR);

		Stream.of(user, user1, admin, admin1).forEach(em::persist);
	}

}
