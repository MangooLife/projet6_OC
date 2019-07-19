package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thamarai.p6.service.SiteService;


@Controller
public class SiteController {

    private static final Logger LOGGER = LogManager.getLogger(SiteController.class);

    @Autowired
    SiteService siteService;
    
    @RequestMapping("/sites")
    public ModelAndView sites() {
    	LOGGER.debug("Sites page OK");
        return new ModelAndView("sites","sites", "OK");
    }

    @RequestMapping(value="/site/{id}", method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView site(@RequestParam("id") final Long id) {
        return new ModelAndView("site","sites", siteService.getSite(id));
    }

}
