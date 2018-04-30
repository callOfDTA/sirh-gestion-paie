package dev.paie.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

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
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.UtilisateurRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	@Autowired
	private CotisationRepository cotisRepo;
	@Autowired
	private EntrepriseRepository entreRepo;
	@Autowired
	private GradeRepository gradeRepo;
	@Autowired
	private PeriodeRepository periodeRepository;
	@Autowired
	private ProfilRemunerationRepository profRepo;
	@Autowired
	private UtilisateurRepository utiRepo;

	@Override
	public void initialiser() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"cotisations-non-imposables.xml", "grades.xml", "entreprises.xml", "profils-remuneration.xml")) {
			// possibilité de faire ça d'une manière plus élégante en passant
			// par un em.persist qui ne dépent pas de la classe
			Map<String, Cotisation> idCotis = ctx.getBeansOfType(Cotisation.class);
			Map<String, Grade> idGrade = ctx.getBeansOfType(Grade.class);
			Map<String, Entreprise> idEntre = ctx.getBeansOfType(Entreprise.class);
			Map<String, ProfilRemuneration> idProf = ctx.getBeansOfType(ProfilRemuneration.class);
			idCotis.forEach((k, cotis) -> {
				cotisRepo.save(cotis);
			});
			idGrade.forEach((k, grad) -> {
				gradeRepo.save(grad);
			});
			idEntre.forEach((k, entr) -> {
				entreRepo.save(entr);
			});
			idProf.forEach((k, prof) -> {
				profRepo.save(prof);
			});
			LocalDate today = LocalDate.now();
			IntStream.rangeClosed(1, 12).forEach(i -> {
				Periode p = new Periode();
				LocalDate debut = LocalDate.of(today.getYear(), i, 1);
				// à voir si il faut préciser l'id : p.setId(i);
				p.setDateDebut(debut);
				p.setDateFin(LocalDate.of(today.getYear(), i, debut.lengthOfMonth()));
				periodeRepository.save(p);
			});
			Utilisateur admin = new Utilisateur();
			Utilisateur user1 = new Utilisateur();
			admin.setNomUtilisateur("admin");
			admin.setMotDePasse("admin");
			admin.setEstActif(true);
			admin.setRole(ROLES.valueOf("ROLE_ADMINISTRATEUR"));
			user1.setNomUtilisateur("user1");
			user1.setMotDePasse("user1");
			user1.setEstActif(true);
			user1.setRole(ROLES.valueOf("ROLE_UTILISATEUR"));
			utiRepo.save(admin);
			utiRepo.save(user1);
		}
	}

}
