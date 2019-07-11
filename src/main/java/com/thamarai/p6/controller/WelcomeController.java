package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.thamarai.p6.service.SiteService;


@Controller
//@RequestMapping("/accueil")
public class WelcomeController {

    private static final Logger LOGGER = LogManager.getLogger(WelcomeController.class);

    @Autowired
    SiteService siteService;

    @GetMapping("/")
    public String index(Model model) {
        LOGGER.debug("Welcome to LADE");
        model.addAttribute("msgs", siteService.getAllSites());
        LOGGER.error("KO");
        return "index";
    }

}
