/**
 * 
 */
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

	@Override
	public void initialiser() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"grades.xml", "entreprises.xml")) {

			Map<String, Cotisation> idCotis = ctx.getBeansOfType(Cotisation.class);
			Map<String, Entreprise> idEntreprise = ctx.getBeansOfType(Entreprise.class);
			Map<String, Grade> idGrade = ctx.getBeansOfType(Grade.class);

			idCotis.forEach((k, cotisation) -> {
				cotisationRepository.save(cotisation);
			});
			idEntreprise.forEach((k, entreprise) -> {
				entrepriseRepository.save(entreprise);
			});
			idGrade.forEach((k, grade) -> {
				gradeRepository.save(grade);
			});

			LocalDate today = LocalDate.now();
			IntStream.range(1, 13).forEach(i -> {
				Periode periode = new Periode();
				LocalDate debut = LocalDate.of(today.getYear(), i, 1);
				periode.setDateDebut(debut);
				periode.setDateFin(LocalDate.of(today.getYear(), i, debut.lengthOfMonth()));
				periodeRepository.save(periode);
			});
		}

	}
}
