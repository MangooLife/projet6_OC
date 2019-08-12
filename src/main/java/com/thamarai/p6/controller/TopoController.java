package com.thamarai.p6.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Topo;
import com.thamarai.p6.service.TopoService;

@Controller
public class TopoController {

    private static final Logger LOGGER = LogManager.getLogger(TopoController.class);
    
    @Autowired
    TopoService topoService;


    @RequestMapping("/topos")
    public ModelAndView topos() {
        LOGGER.debug("Topos page OK");
        return new ModelAndView("topos", "topos", topoService.getAllTopos());
    }

    @GetMapping("/topo/{id}")
    public ModelAndView topo(@PathVariable("id") final Long id, Model model) throws ResourceNotFoundException {
    	Topo topo = topoService.getTopo(id).orElseThrow(() -> new ResourceNotFoundException(id, "Topo"));
     	model.addAttribute("comments", topo.getComments());
     	model.addAttribute("sites", topo.getTopoSites());
     	return new ModelAndView("topo", "topo", topo);
    }
       
}
