package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class RemunerationEmployeController.
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	/** The grades repo. */
	@Autowired
	private GradeRepository gradesRepo;

	/** The entreprises repo. */
	@Autowired
	private EntrepriseRepository entreprisesRepo;

	/** The profils repo. */
	@Autowired
	private ProfilRemunerationRepository profilsRepo;

	/** The employes repo. */
	@Autowired
	private RemunerationEmployeRepository employesRepo;

	/**
	 * Creer employe get.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("grades", gradesRepo.findAll());
		mv.addObject("entreprises", entreprisesRepo.findAll());
		mv.addObject("profils", profilsRepo.findAll());

		mv.addObject("RemunerationEmploye", new RemunerationEmploye());

		return mv;
	}

	/**
	 * Creer employe post.
	 *
	 * @param employe the employe
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployePost(@ModelAttribute("RemunerationEmploye") RemunerationEmploye employe) {
		ModelAndView mv = new ModelAndView();
		employesRepo.save(employe);
		mv.setViewName("redirect:/mvc/employes/lister");
		return mv;
	}

	/**
	 * Lister employe get.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployeGet() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("employes", employesRepo.findAll());
		mv.setViewName("employes/listerEmploye");
		return mv;
	}

	/**
	 * Lister employe post.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	public ModelAndView listerEmployePost() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("redirect:/mvc/employes/creer");
		return mv;
	}

}