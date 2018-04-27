package dev.paie.web.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletin")
public class BulletinController {

	@Autowired
	private PeriodeRepository periodeRepository;

	@Autowired
	private RemunerationEmployeRepository remRepository;

	@Autowired
	private BulletinRepository bulletinRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/creerbulletinsalaire");
		mv.addObject("periode", periodeRepository.findAll());
		mv.addObject("employes", remRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployePost(@RequestParam("periodeParam") Integer periodeId,
			@RequestParam("matriculeParam") Integer matriculeId, @RequestParam("Primeexeptionnel") BigDecimal prime) {
		ModelAndView mv = new ModelAndView();

		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setPrimeExceptionnelle(prime);
		Periode periode = new Periode();
		periode.setId(periodeId);
		RemunerationEmploye remuneration = new RemunerationEmploye();
		remuneration.setId(matriculeId);
		bulletin.setPeriode(periode);
		bulletin.setRemunerationEmploye(remuneration);

		bulletinRepository.save(bulletin);

		mv.setViewName("bulletin/creerbulletinsalaire");
		mv.addObject("periode", periodeRepository.findAll());
		mv.addObject("employes", remRepository.findAll());
		return mv;
	}
}
