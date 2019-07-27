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
		session.removeAttribute("username");
		session.removeAttribute("admin");
		return "connexion";
	}

	@RequestMapping(value = {"/authentificate"}, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {

		Person person = personService.authentificateUser(username, password).orElse(null);

		if(person!=null) {
			session.setAttribute("username", person.getUsername());
			session.setAttribute("admin", person.getStatus());
			return new ModelAndView("person", "person", person);
		} else {
			return new ModelAndView("connexion", "OK", "OK");
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
		person.setStatus("Membre");
		personService.addPerson(person);
		session.setAttribute("username", person.getUsername());
		session.setAttribute("admin", person.getStatus());
		return new ModelAndView("person", "person", person);
	}

}
