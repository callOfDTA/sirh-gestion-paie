package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
	EntrepriseRepository entreRepo;
	@Autowired
	ProfilRemunerationRepository profRepo;
	@Autowired
	RemunerationEmployeRepository remuRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmployeAffichage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		RemunerationEmploye employe = new RemunerationEmploye();
		mv.addObject("employeForm", employe);
		mv.addObject("entrepriseList", entreRepo.findAll());
		mv.addObject("profilList", profRepo.findAll());
		mv.addObject("gradeList", gradeRepo.findAll());
		mv.addObject("matricule.id");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmployeSubmit(@ModelAttribute("employeForm") RemunerationEmploye employePreRempli) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("employeForm", employePreRempli);
		mv.addObject("entrepriseList", entreRepo.findAll());
		mv.addObject("profilList", profRepo.findAll());
		mv.addObject("gradeList", gradeRepo.findAll());
		mv.addObject("matricule.id");
		remuRepo.save(employePreRempli);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerEmployeAffichage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employeList", remuRepo.findAll());
		return mv;

	}
}