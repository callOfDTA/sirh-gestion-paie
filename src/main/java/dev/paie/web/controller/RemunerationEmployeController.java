package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	GradeRepository gradeRepo;

	@Autowired
	EntrepriseRepository entrepriseRepo;

	@Autowired
	ProfilRemunerationRepository profilRepo;

	@Autowired
	RemunerationEmployeRepository employeRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("grades", gradeRepo.findAll());
		mv.addObject("entreprises", entrepriseRepo.findAll());
		mv.addObject("profils", profilRepo.findAll());

		mv.addObject("RemunerationEmploye", new RemunerationEmploye());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployePost(@ModelAttribute("RemunerationEmploye") RemunerationEmploye employe) {
		ModelAndView mv = new ModelAndView();
		employeRepo.save(employe);
		mv.setViewName("redirect:/mvc/employes/lister");

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		return mv;
	}

}
