package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
public class ListerEmployesController {

	@Autowired
	private RemunerationEmployeRepository empRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listeEmployes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeEmployes");
		// mv.addObject("dateCreation", "01/01/2018");
		// mv.addObject("matricule", "M001");
		mv.addObject("employes", empRepo.findAll());
		return mv;
	}

}
