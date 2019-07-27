package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thamarai.p6.service.TopoService;

@Controller
public class BookingController {

	private static final Logger LOGGER = LogManager.getLogger(BookingController.class);
  
	@Autowired
	TopoService topoService;

	@RequestMapping("/booking")
	public ModelAndView index() {
		LOGGER.debug("Booking page OK");
		return new ModelAndView("booking", "topos", topoService.getAllTopos());
	}

}