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
public class ListerEmployeController {
	@Autowired
	RemunerationEmployeRepository employeRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employes", employeRepository.findAll());

		return mv;
	}
}
