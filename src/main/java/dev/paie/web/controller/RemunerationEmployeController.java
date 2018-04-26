/**
 * 
 */
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
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;

/**
 * @author ETY9
 *
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	GradeRepository gradeRepo;
	@Autowired
	EntrepriseRepository entrepriseRepo;
	@Autowired
	ProfilRepository profilRepo;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmployeAffichage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		RemunerationEmploye employe = new RemunerationEmploye();
		mv.addObject("employeForm", employe);
		mv.addObject("gradeList", gradeRepo.findAll());
		mv.addObject("entrepriseList", entrepriseRepo.findAll());
		mv.addObject("profilList", profilRepo.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployeSubmit(@ModelAttribute("employeForm") RemunerationEmploye employePreRempli) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("employeForm", employePreRempli);
		mv.addObject("gradeList", gradeRepo.findAll());
		mv.addObject("entrepriseList", entrepriseRepo.findAll());
		mv.addObject("profilList", profilRepo.findAll());
		remunerationEmployeRepo.save(employePreRempli);
		return mv;
	}
}
