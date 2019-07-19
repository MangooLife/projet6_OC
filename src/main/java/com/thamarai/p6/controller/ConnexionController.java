package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConnexionController {
	 private static final Logger LOGGER = LogManager.getLogger(ConnexionController.class);

	  @RequestMapping("/connexion")
	  public ModelAndView index() {
	      LOGGER.debug("Connexion page OK");
	      return new ModelAndView("connexion", "sites", "OK");
	  }
}
