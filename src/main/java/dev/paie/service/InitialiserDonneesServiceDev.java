package dev.paie.service;

import java.time.LocalDateTime;
import java.util.Map;

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
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("grades.xml", "entreprises.xml",
				"profils-remuneration.xml");

		Map<String, Grade> idGrade = ctx.getBeansOfType(Grade.class);
		idGrade.forEach((id, grade) -> {
			System.out.println("GRADE " + grade + id);
			em.persist(grade);

		});
		Map<String, Entreprise> idEntreprise = ctx.getBeansOfType(Entreprise.class);
		idEntreprise.forEach((id, entreprise) -> {
			em.persist(entreprise);
		});

		Map<String, Cotisation> cotisations = ctx.getBeansOfType(Cotisation.class);
		cotisations.forEach((id, cotisation) -> {
			em.persist(cotisation);
		});
		Map<String, ProfilRemuneration> profilsRemunerations = ctx.getBeansOfType(ProfilRemuneration.class);
		profilsRemunerations.forEach((id, profil) -> {
			em.persist(profil);
		});

		RemunerationEmploye employe1 = new RemunerationEmploye();
		employe1.setMatricule("A01");
		Grade grade1 = idGrade.get("grade1");
		employe1.setGrade(grade1);
		employe1.setDateCreation(LocalDateTime.now());
		em.persist(employe1);
		RemunerationEmploye employe2 = new RemunerationEmploye();
		employe2.setMatricule("A02");
		employe2.setGrade(idGrade.get("grade2"));
		employe2.setDateCreation(LocalDateTime.now());
		em.persist(employe2);
		em.persist(
				new Utilisateur("admin", passwordEncoder.encode("admin"), true, Utilisateur.ROLES.ROLE_ADMINISTRATEUR));
		em.persist(new Utilisateur("user", passwordEncoder.encode("pass"), true, Utilisateur.ROLES.ROLE_UTILISATEUR));
		ctx.close();
	}

}
