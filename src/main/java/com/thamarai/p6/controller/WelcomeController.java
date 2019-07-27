package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thamarai.p6.service.SiteService;


@Controller
public class WelcomeController {

    private static final Logger LOGGER = LogManager.getLogger(WelcomeController.class);

    @Autowired
    SiteService siteService;

    @RequestMapping("/")
    public ModelAndView index() {
        LOGGER.debug("Welcome to LADE");
        return new ModelAndView("index", "sites", siteService.getAllSites());
    }

}
