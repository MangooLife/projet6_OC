package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TopoController {

    private static final Logger LOGGER = LogManager.getLogger(TopoController.class);

    @RequestMapping("/topos")
    public ModelAndView topos() {
        LOGGER.debug("Topos page OK");
        return new ModelAndView("topos", "sites", "OK");
    }

}
