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
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletins")
public class CreerBulletinController {
	@Autowired
	private BulletinSalaireRepository bulletinRepository;

	@Autowired
	private PeriodeRepository periodeRepository;

	@Autowired
	private RemunerationEmployeRepository employeRepository;

	@Autowired
	private CalculerRemunerationService remunerationService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletinGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", periodeRepository.findAll());
		mv.addObject("employes", employeRepository.findAll());
		mv.addObject("Bulletin", new BulletinSalaire());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerBulletinPost(@ModelAttribute("Bulletin") BulletinSalaire bulletin) {
		ModelAndView mv = new ModelAndView();

		bulletinRepository.save(bulletin);
		mv.setViewName("redirect:/mvc/bulletins/lister");

		return mv;
	}
}
