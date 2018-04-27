package dev.paie.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletin")
public class ListBulletinController {
	@Autowired
	CalculerRemunerationService calc;

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/listerbulletin");
		Map<BulletinSalaire, ResultatCalculRemuneration> tousLesBulletin = calc.calculerTousLesBulletin();
		mv.addObject("result", tousLesBulletin);
		return mv;
	}

}