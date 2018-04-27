package dev.paie.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletin")
public class ListBulletinController {
	@Autowired
	CalculerRemunerationService calc;

	@Autowired
	BulletinRepository bulletinRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/listerbulletin");
		Map<BulletinSalaire, ResultatCalculRemuneration> tousLesBulletin = calc.calculerTousLesBulletin();
		mv.addObject("result", tousLesBulletin);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/bulletin")
	public ModelAndView creerEmployeGetbulletin(@RequestParam("ID") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/bulletinindividuel");
		BulletinSalaire findOne = bulletinRepository.findById(id);
		mv.addObject("bulletin", findOne);
		mv.addObject("calcul", calc.calculer(findOne));
		return mv;
	}

}