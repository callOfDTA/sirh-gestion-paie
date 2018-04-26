package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	PeriodeRepository periodeRepo;

	@Autowired
	BulletinSalaireRepository bulletinRepo;

	@Autowired
	RemunerationEmployeRepository employeRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletinGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", periodeRepo.findAll());
		mv.addObject("employes", employeRepo.findAll());

		mv.addObject("bulletin", new BulletinSalaire());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerBulletinPost(@ModelAttribute("bulletin") BulletinSalaire bulletin) {
		ModelAndView mv = new ModelAndView();
		bulletinRepo.save(bulletin);
		mv.setViewName("redirect:/mvc/bulletins/lister");

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletinGet() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("bulletins", bulletinRepo.findAll());
		mv.setViewName("bulletins/listerBulletin");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	public ModelAndView listerBulletinPost() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/mvc/employes/creer");
		return mv;
	}

}
