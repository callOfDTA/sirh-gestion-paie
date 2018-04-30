/**
 * 
 */
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

/**
 * @author ETY9
 *
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinController {
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepo;
	@Autowired
	PeriodeRepository periodeRepo;
	@Autowired
	BulletinSalaireRepository bulletinRepo;
	@Autowired
	CalculerRemunerationService crss;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletinAffichage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		BulletinSalaire bulletin = new BulletinSalaire();
		mv.addObject("bulletinForm", bulletin);
		mv.addObject("periodeList", periodeRepo.findAll());
		mv.addObject("remunerationEmployeList", remunerationEmployeRepo.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletinSubmit(@ModelAttribute("bulletinForm") BulletinSalaire bulletinPreRempli) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("bulletinForm", bulletinPreRempli);
		mv.addObject("periodeList", periodeRepo.findAll());
		mv.addObject("remunerationEmployeList", remunerationEmployeRepo.findAll());
		bulletinRepo.save(bulletinPreRempli);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletinAffichage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletinList", crss.calculerBulletin());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualise")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView visualiseBulletinAffichage(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiseBulletin");

		mv.addObject("bulletin", bulletinRepo.findById(Integer.parseInt(id)));
		mv.addObject("calc", crss.calculer(bulletinRepo.findById(Integer.parseInt(id))));
		return mv;
	}
}
