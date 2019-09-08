package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thamarai.p6.entity.Person;
import com.thamarai.p6.service.CommentService;
import com.thamarai.p6.service.PersonService;
import com.thamarai.p6.service.SiteService;

@Controller
public class MemberController {
	private static final Logger LOGGER = LogManager.getLogger(MemberController.class);
	
	@Autowired
	SiteService siteService;
	
	@Autowired
	CommentService commmentService;
	
	@Autowired
	PersonService personService;
	
	@RequestMapping("/member")
	public ModelAndView memberPage(
			Model model
		) {
		LOGGER.debug("Admin page OK");
		model.addAttribute("sites", siteService.getAllSites());
		model.addAttribute("comments", commmentService.getAllComments());
		model.addAttribute("persons", personService.getAllPersons());
		
		if(!(model.containsAttribute("classActiveMember"))) {
			model.addAttribute("classActiveLabel","active");
		}
		
		return new ModelAndView("member");
	}
	
	@GetMapping("/getMember/{id}/{isLabel}")
    public ModelAndView getMember(
    		Model model,
    		RedirectAttributes redirectAttributes,
    		@PathVariable("id") Long personId,
    		@PathVariable("isLabel") Integer isAdmin
    ) {
    	Person person = personService.getPerson(personId).get();
		if(isAdmin == 1) {
			person.setStatus(1);
		} else {
			person.setStatus(0);
		}
		personService.updatePerson(personId, person);
		
		redirectAttributes.addFlashAttribute(
    			"message", "Status du membre changé avec succès");
    	return new ModelAndView("redirect:/member", "classActiveMember", "active");
    }
}
