package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private final Logger LOGGER = LogManager.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String index(Model model) {
        LOGGER.debug("Welcome to mkyong.com...");
        model.addAttribute("msg", getMessage());
        return "index";

    }

    private String getMessage() {
        return "Hello World";
    }

}
