package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class listEmployeController {

	@Autowired
	private RemunerationEmployeRepository remRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employes", remRepository.findAll());
		return mv;
	}
}
