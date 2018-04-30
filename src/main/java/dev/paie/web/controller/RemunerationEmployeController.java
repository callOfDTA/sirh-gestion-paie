package dev.paie.web.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

	/** The grade repo. */
	@Autowired
	GradeRepository gradeRepo;

	/** The entreprise repo. */
	@Autowired
	EntrepriseRepository entrepriseRepo;

	/** The profil repo. */
	@Autowired
	ProfilRemunerationRepository profilRepo;

	/** The employe repo. */
	@Autowired
	RemunerationEmployeRepository employeRepo;

	/**
	 * Creer employe get.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("grades", gradeRepo.findAll());
		mv.addObject("entreprises", entrepriseRepo.findAll());
		mv.addObject("profils", profilRepo.findAll());

		mv.addObject("RemunerationEmploye", new RemunerationEmploye());
		return mv;
	}

	/**
	 * Creer employe post.
	 *
	 * @param employe
	 *            the employe
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmployePost(@ModelAttribute("RemunerationEmploye") RemunerationEmploye employe) {
		ModelAndView mv = new ModelAndView();
		employeRepo.save(employe);
		mv.setViewName("redirect:/mvc/employes/lister");

		return mv;
	}

	/**
	 * Lister employe get.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("localDateTimeFormat", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));

		mv.addObject("employes", employeRepo.findAll());
		mv.setViewName("employes/listerEmploye");
		return mv;
	}

	/**
	 * Lister employe post.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerEmployePost() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/mvc/employes/creer");
		return mv;
	}

}
