package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private ProfilRepository profilRepository;

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private RemunerationEmployeRepository remRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprise", entrepriseRepository.findAll());
		mv.addObject("profil", profilRepository.findAll());
		mv.addObject("grade", gradeRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployePost(@RequestParam("Matricule") String matricule,
			@RequestParam("gradeParam") Integer gradeId, @RequestParam("entrepriseParam") Integer entrepriseId,
			@RequestParam("profilParam") Integer profilId) {
		ModelAndView mv = new ModelAndView();

		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setMatricule(matricule);
		Grade grade = new Grade();
		grade.setId(gradeId);
		Entreprise entreprise = new Entreprise();
		entreprise.setId(entrepriseId);
		ProfilRemuneration profil = new ProfilRemuneration();
		profil.setId(profilId);
		employe.setGrade(grade);
		employe.setEntreprise(entreprise);
		employe.setProfilRemuneration(profil);

		remRepository.save(employe);

		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprise", entrepriseRepository.findAll());
		mv.addObject("profil", profilRepository.findAll());
		mv.addObject("grade", gradeRepository.findAll());
		return mv;
	}
}
