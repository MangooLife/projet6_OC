package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thamarai.p6.repository.SiteRepository;

@Controller
public class WelcomeController {

    private static final Logger LOGGER = LogManager.getLogger(WelcomeController.class);

    @Autowired
    SiteRepository siteRepository;

    @GetMapping("/")
    public String index(Model model) {
        LOGGER.debug("Welcome to LADE");
        //model.addAttribute("msgs", "OK");
        LOGGER.error("KO");
        return "index";

    }

}
