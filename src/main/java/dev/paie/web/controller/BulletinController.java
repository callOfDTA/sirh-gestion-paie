package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	RemunerationEmployeRepository remuEmpRepo;
	@Autowired
	PeriodeRepository perioRepo;
	@Autowired
	BulletinSalaireRepository bullRepo;
	@Autowired
	CalculerRemunerationService crsc;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletinAffichage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		BulletinSalaire bulletin = new BulletinSalaire();
		mv.addObject("bulletinForm", bulletin);
		mv.addObject("periodeList", perioRepo.findAll());
		mv.addObject("remunerationEmployeList", remuEmpRepo.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletinSubmit(@ModelAttribute("bulletinForm") BulletinSalaire bulletinPreRempli) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("bulletinForm", bulletinPreRempli);
		mv.addObject("periodeList", perioRepo.findAll());
		mv.addObject("remunerationEmployeList", remuEmpRepo.findAll());
		bullRepo.save(bulletinPreRempli);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerBulletinAffichage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletinList", crsc.calculerTousLesBulletins());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView visualiserBulletinAffichage(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletin");
		mv.addObject("bulletin", bullRepo.findById(Integer.parseInt(id)));
		mv.addObject("calc", crsc.calculer(bullRepo.findById(Integer.parseInt(id))));
		return mv;
	}
}
