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
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletins")
public class ListerBulletinController {
	@Autowired
	BulletinSalaireRepository bulletinRepository;

	@Autowired
	CalculerRemunerationService calcul;

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletinGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");

		Map<BulletinSalaire, ResultatCalculRemuneration> listBulletins = calcul.calculerTousLesBulletins();
		mv.addObject("result", listBulletins);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	public ModelAndView visualiserBulletinGet(@RequestParam("ID") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/bulletin");

		BulletinSalaire findOne = bulletinRepository.findById(id);
		mv.addObject("bulletin", findOne);
		mv.addObject("calcul", calcul.calculer(findOne));
		return mv;
	}

}
