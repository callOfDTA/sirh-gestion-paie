package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Controller
@RequestMapping("/employes")
public class CreerEmployeController {
	@Autowired
	private GradeRepository gradeRepo;
	@Autowired
	private EntrepriseRepository entrRepo;
	@Autowired
	private ProfilRemunerationRepository profilRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("grades", gradeRepo.findAll());
		mv.addObject("entreprises", entrRepo.findAll());
		mv.addObject("profils", profilRepo.findAll());
		return mv;
	}

}
