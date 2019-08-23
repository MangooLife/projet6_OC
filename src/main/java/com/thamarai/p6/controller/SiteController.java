package com.thamarai.p6.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Person;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.service.PersonService;
import com.thamarai.p6.service.SiteService;


@Controller
public class SiteController {

    private static final Logger LOGGER = LogManager.getLogger(SiteController.class);

    @Autowired
    SiteService siteService;
    
    @Autowired
    PersonService personService;
    
    @Autowired
    AdminController adminController;
    
    @RequestMapping("/sites")
    public ModelAndView sites() throws ResourceNotFoundException {
    	LOGGER.debug("Sites page OK");
    	List<Site> sites = siteService.getAllSites();
        return new ModelAndView("sites","sites", sites);
    }

    @GetMapping("/site/{id}")
    public ModelAndView site(@PathVariable("id") final Long id, Model model) throws ResourceNotFoundException {
    	Site site = siteService.getSite(id).orElseThrow(() -> new ResourceNotFoundException(id, "Site"));
    	model.addAttribute("comments", site.getComments());
    	model.addAttribute("secteurs", site.getSecteurs());  
    	return new ModelAndView("site", "site", site);
    }
    
    @GetMapping("/addSite/{id}/")
    public String addSite(
    		Model model,
    		@PathVariable("id") Long personId,
    		@RequestParam("name") String name,
    		@RequestParam("description") String description,
    		@RequestParam("image") String image
    ) {
		Person person = personService.getPerson(personId).get();
    	Site site = new Site();
    	site.setName(name);
    	site.setDescription(description);
    	site.setLabel(0);
    	site.setPerson(person);
    	site.setImage(image);
    	siteService.addSite(site);
    	return "member";
    }
    
    @GetMapping("/getLabel/{id}/{isLabel}")
    public String getLabel(
    		Model model,
    		@PathVariable("id") Long siteId,
    		@PathVariable("isLabel") Integer isLabel
    ) {
    	try {
			Site site = siteService.getSite(siteId).get();
			if(isLabel == 1) {
				site.setLabel(1);
			} else {
				site.setLabel(0);
			}
			siteService.updateSite(siteId, site);
		} catch (ResourceNotFoundException e) {
			LOGGER.warn("resource not found"+siteId+e);
		}
    	return adminController.adminPage(model);
    }
    
}
