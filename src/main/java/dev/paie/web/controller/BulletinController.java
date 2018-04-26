/**
 * 
 */
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

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
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
	public ModelAndView creerBulletinSubmit(@ModelAttribute("bulletinForm") BulletinSalaire bulletinPreRempli) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("bulletinForm", bulletinPreRempli);
		mv.addObject("periodeList", periodeRepo.findAll());
		mv.addObject("remunerationEmployeList", remunerationEmployeRepo.findAll());
		bulletinRepo.save(bulletinPreRempli);
		return mv;
	}

}
