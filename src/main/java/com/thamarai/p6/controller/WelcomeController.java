package com.thamarai.p6.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.service.SiteService;


@Controller
public class WelcomeController {

    private static final Logger LOGGER = LogManager.getLogger(WelcomeController.class);

    @Autowired
    SiteService siteService;

    @RequestMapping("/")
    public String index(Model model) throws ResourceNotFoundException {
        LOGGER.debug("Welcome to LADE");
        List<Site> sites = siteService.getAllSites();
        if(sites.isEmpty()) {
        	LOGGER.info("No sites was charged");
        	return "index";
        } else {
        	LOGGER.info("There is some sites was charged");
        	model.addAttribute("sites", sites);
        	return "index";
        }
    }

}
