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
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;

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

	@Override
	public void initialiser() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"cotisations-non-imposables.xml", "grades.xml", "entreprises.xml", "profils-remuneration.xml")) {
			// possibilité de faire ça d'une manière plus élégante en passant
			// par un em.persist qui ne dépent pas de la classe
			Map<String, Cotisation> idCotis = ctx.getBeansOfType(Cotisation.class);
			Map<String, Grade> idGrade = ctx.getBeansOfType(Grade.class);
			Map<String, Entreprise> idEntre = ctx.getBeansOfType(Entreprise.class);
			idCotis.forEach((k, cotis) -> {
				cotisRepo.save(cotis);
			});
			idGrade.forEach((k, grad) -> {
				gradeRepo.save(grad);
			});
			idEntre.forEach((k, entr) -> {
				entreRepo.save(entr);
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
		}
	}

}
