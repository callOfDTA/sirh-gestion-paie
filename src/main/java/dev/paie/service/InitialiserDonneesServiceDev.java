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

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("grades.xml", "entreprises.xml",
				"profils-remuneration.xml", "cotisations-imposables.xml", "cotisations-non-imposables.xml");

		Stream.of(Grade.class, Entreprise.class, Cotisation.class, ProfilRemuneration.class)
				.flatMap(Classe -> ctx.getBeansOfType(Classe).values().stream()).forEach(em::persist);

		initPeriod();

		String iciUnMotDePasse1 = "Bonhomme";
		String iciMotDePasseHashe1 = this.passwordEncoder.encode(iciUnMotDePasse1);
		String iciUnMotDePasse2 = "Gougnafier";
		String iciMotDePasseHashe2 = this.passwordEncoder.encode(iciUnMotDePasse2);

		Utilisateur user1 = new Utilisateur("Alexis", iciMotDePasseHashe1, true, ROLES.ROLE_ADMINISTRATEUR);
		Utilisateur user2 = new Utilisateur("Maxime", iciMotDePasseHashe2, true, ROLES.ROLE_UTILISATEUR);
		em.persist(user1);
		em.persist(user2);

		ctx.close();
	}

	@Transactional
	public void initPeriod() {
		List<Periode> Period = new ArrayList<>();

		IntStream.rangeClosed(1, 12).forEach(i -> {
			LocalDate dateDebut = LocalDate.of(LocalDate.now().getYear(), i, 01);
			LocalDate dateFin = LocalDate.of(LocalDate.now().getYear(), i, dateDebut.lengthOfMonth());
			Period.add(new Periode(dateDebut, dateFin));
		});
		Period.stream().forEach(em::persist);
	}
}
