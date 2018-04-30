/**
 * 
 */
package dev.paie.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.IntStream;

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
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.UtilisateurRepository;

/**
 * @author ETY9
 *
 */
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private CotisationRepository cotisationRepository;
	@Autowired
	private PeriodeRepository periodeRepository;
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Transactional
	@Override
	public void initialiser() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"cotisations-non-imposables.xml", "grades.xml", "entreprises.xml", "profils-remuneration.xml")) {

			Map<String, Cotisation> idCotis = ctx.getBeansOfType(Cotisation.class);
			Map<String, Entreprise> idEntreprise = ctx.getBeansOfType(Entreprise.class);
			Map<String, Grade> idGrade = ctx.getBeansOfType(Grade.class);
			Map<String, ProfilRemuneration> idProfil = ctx.getBeansOfType(ProfilRemuneration.class);

			idCotis.forEach((k, cotisation) -> {
				cotisationRepository.save(cotisation);
			});
			idEntreprise.forEach((k, entreprise) -> {
				entrepriseRepository.save(entreprise);
			});
			idGrade.forEach((k, grade) -> {
				gradeRepository.save(grade);
			});
			idProfil.forEach((k, profil) -> {
				profilRepository.save(profil);
			});

			LocalDate today = LocalDate.now();
			IntStream.range(1, 13).forEach(i -> {
				Periode periode = new Periode();
				LocalDate debut = LocalDate.of(today.getYear(), i, 1);
				periode.setDateDebut(debut);
				periode.setDateFin(LocalDate.of(today.getYear(), i, debut.lengthOfMonth()));
				periodeRepository.save(periode);
			});

			Utilisateur user1 = new Utilisateur();
			user1.setNomUtilisateur("user1");
			user1.setMotDePasse(this.passwordEncoder.encode("mdp1"));
			user1.setRole(ROLES.valueOf("ROLE_ADMINISTRATEUR"));
			user1.setEstActif(true);

			Utilisateur user2 = new Utilisateur();
			user2.setNomUtilisateur("user2");
			user2.setMotDePasse(this.passwordEncoder.encode("mdp2"));
			user2.setRole(ROLES.valueOf("ROLE_UTILISATEUR"));
			user2.setEstActif(true);

			utilisateurRepository.save(user1);
			utilisateurRepository.save(user2);
		}

	}
}
