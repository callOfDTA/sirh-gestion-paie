package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
 * The Class BulletinDeSalaireController.
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinDeSalaireController {

	/** The employes repo. */
	@Autowired
	private RemunerationEmployeRepository employesRepo;

	/** The bulletin repo. */
	@Autowired
	private BulletinSalaireRepository bulletinRepo;

	/** The periode repo. */
	@Autowired
	private PeriodeRepository periodeRepo;

	/** The calc. */
	@Autowired
	private CalculerRemunerationService calc;

	/**
	 * Creer bulletin get.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletinGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", periodeRepo.findAll());
		mv.addObject("employes", employesRepo.findAll());

		mv.addObject("BulletinSalaire", new BulletinSalaire());

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
	public ModelAndView creerBulletinPost(@ModelAttribute("BulletinSalaire") BulletinSalaire bulletin) {
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
	public ModelAndView listerBulletinGet() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("bulletins", calc.calculerTousBulletins());
		mv.setViewName("bulletins/listerBulletin");
		return mv;
	}

	/**
	 * Lister bulletin post.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
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
	public ModelAndView visualiserBulletinGet(@RequestParam("id") Integer bulletinId) {
		ModelAndView mv = new ModelAndView();

		BulletinSalaire bulletinSalaire = bulletinRepo.findById(bulletinId);
		mv.addObject("bulletin", bulletinSalaire);
		mv.addObject("resultat", calc.calculer(bulletinSalaire));
		mv.setViewName("bulletins/visualiserBulletin");
		return mv;
	}

	/**
	 * Visualiser bulletin post.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/visualiser")
	public ModelAndView visualiserBulletinPost() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("redirect:/mvc/bulletins/lister");
		return mv;
	}

}