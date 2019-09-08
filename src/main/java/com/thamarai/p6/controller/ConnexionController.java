package com.thamarai.p6.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thamarai.p6.entity.Person;
import com.thamarai.p6.service.PersonService;

@Controller
public class ConnexionController {
	private static final Logger LOGGER = LogManager.getLogger(ConnexionController.class);

	@Autowired
	PersonService personService;

	@RequestMapping("/connexion")
	public String connexion(Model model) {
		LOGGER.debug("Connexion page OK");
		return "connexion";
	}

	@RequestMapping("/deconnexion")
	public String deconnexion(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		LOGGER.debug("Deconnexion page OK");
		session.removeAttribute("firstname");
		session.removeAttribute("lastname");
		session.removeAttribute("username");
		session.removeAttribute("member");
		redirectAttributes.addFlashAttribute(
    			"message", "Vous êtes déconnecté");
		return "redirect:/connexion";
	}

	@RequestMapping(value = {"/authentificate"}, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView authentificate(
			HttpSession session, 
			Model model,
			RedirectAttributes redirectAttributes,
			@RequestParam("username") String username, 
			@RequestParam("password") String password
	) {
		if(personService.passwordOk(username, password)) {
			Person person = personService.authentificateUser(username).get();
			session.setAttribute("firstname", person.getFirstname());
			session.setAttribute("lastname", person.getLastname());
			session.setAttribute("username", person.getUsername());
			session.setAttribute("member", person.getStatus());
			return person(session, model, redirectAttributes);
		} else {
			redirectAttributes.addFlashAttribute(
	    			"message", "L'username ou le mot de passe est mauvais");
			return new ModelAndView("redirect:/connexion");
		}
	}

	@RequestMapping("/subscribe")
	public String subscribe(Model model) {
		LOGGER.debug("Subscription page OK");
		return "subscribe";
	}

	@RequestMapping("/newPerson")
	public ModelAndView createNewPerson(
		HttpSession session,
		Model model,
		RedirectAttributes redirectAttributes,
		@RequestParam("firstname") String firstname,
		@RequestParam("lastname") String lastname,
		@RequestParam("birthdate") String birthdate,
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		@RequestParam("email") String email
		
	) {
		if(password.length() < 8) {
			redirectAttributes.addFlashAttribute(
	    			"message", "Le mot de passe est trop petit");
			return new ModelAndView("redirect:/subscribe");
			
		} else {
			Person person = new Person();
			person.setFirstname(firstname);
			person.setLastname(lastname);
			person.setBirthdate(birthdate);
			person.setUsername(username);
			person.setPassword(password);
			person.setEmail(email);
			person.setStatus(0);
			personService.addPerson(person);
			session.setAttribute("firstname", person.getFirstname());
			session.setAttribute("lastname", person.getLastname());
			session.setAttribute("username", person.getUsername());
			session.setAttribute("member", person.getStatus());
			redirectAttributes.addFlashAttribute(
	    			"messageSuccess", "Inscription réussite, bravo =)");
			return person(session, model, redirectAttributes);
		}
	}
	
	@RequestMapping("/person")
	public ModelAndView person(
			HttpSession session, 
			Model model, 
			RedirectAttributes redirectAttributes
	) {
		if(!(session.getAttribute("username")==null)) {
			String username = (String) session.getAttribute("username");
			Person person = personService.authentificateUser(username).orElse(null);
			model.addAttribute("person", person);
			model.addAttribute("topos", person.getTopos());
			model.addAttribute("sites", person.getSites());
			model.addAttribute("comments", person.getComments());

			session.removeAttribute("classActiveTopos");
			session.removeAttribute("classActiveSitesPage");
			session.removeAttribute("classActiveReservation");
			session.setAttribute("classActiveProfil","active");
			return new ModelAndView("person");
			
		} else {
			redirectAttributes.addFlashAttribute(
	    			"message", "Une erreur a été rencontrée lors de l'authentification");
			return new ModelAndView("redirect:/connexion");
		}
		
	}
	
	@RequestMapping("/returnPerson")
	public ModelAndView returnPerson(
			HttpSession session, 
			Model model, 
			RedirectAttributes redirectAttributes
	) {
		if(!(session.getAttribute("username")==null)) {
			String username = (String) session.getAttribute("username");
			Person person = personService.authentificateUser(username).orElse(null);
			model.addAttribute("person", person);
			model.addAttribute("topos", person.getTopos());
			model.addAttribute("sites", person.getSites());
			model.addAttribute("comments", person.getComments());
			
			return new ModelAndView("person");
			
		} else {
			redirectAttributes.addFlashAttribute(
	    			"message", "Une erreur a été rencontrée lors de l'authentification");
			return new ModelAndView("redirect:/connexion");
		}
		
	}

}
