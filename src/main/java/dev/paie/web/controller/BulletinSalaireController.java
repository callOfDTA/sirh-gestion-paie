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

// TODO: Auto-generated Javadoc
/**
 * The Class BulletinSalaireController.
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	/** The periode repo. */
	@Autowired
	PeriodeRepository periodeRepo;

	/** The bulletin repo. */
	@Autowired
	BulletinSalaireRepository bulletinRepo;

	/** The employe repo. */
	@Autowired
	RemunerationEmployeRepository employeRepo;

	/** The calc. */
	@Autowired
	CalculerRemunerationService calc;

	/**
	 * Creer bulletin get.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletinGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", periodeRepo.findAll());
		mv.addObject("employes", employeRepo.findAll());

		mv.addObject("bulletin", new BulletinSalaire());
		return mv;
	}

	/**
	 * Creer bulletin post.
	 *
	 * @param bulletin
	 *            the bulletin
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletinPost(@ModelAttribute("bulletin") BulletinSalaire bulletin) {
		ModelAndView mv = new ModelAndView();
		bulletinRepo.save(bulletin);
		mv.setViewName("redirect:/mvc/bulletins/lister");

		return mv;
	}

	/**
	 * Lister bulletin get.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerBulletinGet() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("bulletins", calc.calculerTousLesBulletin());
		mv.setViewName("bulletins/listerBulletin");
		return mv;
	}

	/**
	 * Lister bulletin post.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerBulletinPost() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/mvc/bulletins/creer");
		return mv;
	}

	/**
	 * Visualiser bulletin get.
	 *
	 * @param bulletinId
	 *            the bulletin id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView visualiserBulletinGet(@RequestParam("id") Integer bulletinId) {
		ModelAndView mv = new ModelAndView();

		BulletinSalaire bulletin = bulletinRepo.findById(bulletinId);

		mv.addObject("bulletin", bulletin);

		mv.addObject("resultat", calc.calculer(bulletin));

		mv.setViewName("bulletins/visualiserBulletin");
		return mv;
	}

	/**
	 * Visualiser bulletin post.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/visualiser")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView visualiserBulletinPost() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
