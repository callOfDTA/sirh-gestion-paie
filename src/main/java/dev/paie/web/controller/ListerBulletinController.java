package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.repository.BulletinSalaireRepository;

@Controller
@RequestMapping("/bulletins")
public class ListerBulletinController {
	@Autowired
	BulletinSalaireRepository bulletinRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployeGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletins", bulletinRepository.findAll());

		return mv;
	}
}
