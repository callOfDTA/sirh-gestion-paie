package dev.paie.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletins")
public class VisualiserBulletinController {
	@Autowired
	BulletinSalaireRepository bulletinRepository;

	@Autowired
	CalculerRemunerationService calcul;

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	public ModelAndView listerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/bulletin");

		Map<BulletinSalaire, ResultatCalculRemuneration> listBulletins = calcul.calculerTousLesBulletins();
		mv.addObject("result", listBulletins);
		return mv;
	}
}
