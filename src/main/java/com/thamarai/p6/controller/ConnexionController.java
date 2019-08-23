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
	public String deconnexion(Model model, HttpSession session) {
		LOGGER.debug("Deconnexion page OK");
		session.removeAttribute("firstname");
		session.removeAttribute("lastname");
		session.removeAttribute("username");
		session.removeAttribute("admin");
		return "connexion";
	}

	@RequestMapping(value = {"/authentificate"}, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView authentificate(
			HttpSession session, 
			Model model,
			@RequestParam("username") String username, 
			@RequestParam("password") String password
	) {
		if(personService.passwordOk(username, password)) {
			Person person = personService.authentificateUser(username).orElse(null);
			session.setAttribute("firstname", person.getFirstname());
			session.setAttribute("lastname", person.getLastname());
			session.setAttribute("username", person.getUsername());
			session.setAttribute("admin", person.getStatus());
			return member(session, model);
		} else {
			return new ModelAndView("connexion");
		}
	}

	@RequestMapping("/subscribe")
	public String subscribe(Model model) {
		LOGGER.debug("Subscription page OK");
		return "subscribe";
	}

	@RequestMapping("/newMember")
	public ModelAndView createNewPerson(
		HttpSession session,
		Model model,
		@RequestParam("firstname") String firstname,
		@RequestParam("lastname") String lastname,
		@RequestParam("birthdate") String birthdate,
		@RequestParam("username") String username,
		@RequestParam("password") String password
	) {
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setBirthdate(birthdate);
		person.setUsername(username);
		person.setPassword(password);
		person.setStatus(0);
		personService.addPerson(person);
		session.setAttribute("firstname", person.getFirstname());
		session.setAttribute("lastname", person.getLastname());
		session.setAttribute("username", person.getUsername());
		session.setAttribute("admin", person.getStatus());
		return member(session, model);
	}
	
	@RequestMapping("/member")
	public ModelAndView member(HttpSession session, Model model) {
		if(!(session.getAttribute("username")==null)) {
			String username = (String) session.getAttribute("username");
			Person person = personService.authentificateUser(username).orElse(null);
			model.addAttribute("person", person);
			model.addAttribute("topos", person.getTopos());
			model.addAttribute("sites", person.getSites());
			model.addAttribute("comments", person.getComments());
			return new ModelAndView("person");
			
		} else {
			return new ModelAndView("connexion");
		}
		
	}

}
