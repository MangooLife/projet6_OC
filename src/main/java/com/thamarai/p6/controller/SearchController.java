package com.thamarai.p6.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thamarai.p6.entity.Longueur;
import com.thamarai.p6.entity.Secteur;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.entity.Voie;
import com.thamarai.p6.service.LongueurService;
import com.thamarai.p6.service.SecteurService;
import com.thamarai.p6.service.SiteService;
import com.thamarai.p6.service.VoieService;

@Controller
public class SearchController {
	
    private static final Logger LOGGER = LogManager.getLogger(SearchController.class);
    
    @Autowired 
    VoieService voieService;
    
    @Autowired
    LongueurService longueurService;
    
    @Autowired 
    SecteurService secteurService;
    
    @Autowired
    SiteService siteService;

	@RequestMapping(value = {"/searchASite"})
    @ResponseBody
    public ModelAndView sites(
    		Model model
    ) {
    	LOGGER.debug("Search page OK");
    	
    	List<Voie> voies = voieService.getAllVoies();
    	List<Longueur> longueurs = longueurService.getAllLongueurs();
    	
    	model.addAttribute("voies", voies);
    	model.addAttribute("longueurs", longueurs);
    	
        return new ModelAndView("searchASite");
    }
	
	@RequestMapping(value = {"/searchSitePerkeyword"}, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addTopo(
    		Model model,
    		@RequestParam("keyword") String keyword
    ) {
    	List<Site> sites = siteService.getAllSitesByKeyword(keyword);
    	List<Secteur> secteur = secteurService.getAllSecteursByKeyword(keyword);
    	model.addAttribute("sites", sites);
    	model.addAttribute("secteurs", secteur);
    	return new ModelAndView("results");    
    }
	
	@RequestMapping(value = {"/searchSiteByVoie"}, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addTopo(
    		Model model,
    		@RequestParam("cotationVoie") String cotationVoie,
    		@RequestParam("widthVoie") String widthVoie
    ) {
    	List<Voie> voies = voieService.getAllVoiesByKey(cotationVoie, widthVoie);
    	return new ModelAndView("results", "results", voies);    
    }
	
	@RequestMapping(value = {"/searchSitePerLongueur"}, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addTopo(
    		Model model,
    		@RequestParam("cotationLongueur") String cotationLongueur,
    		@RequestParam("widthLongueur") String widthLongueur,
    		@RequestParam("spitLongueur") String spitLongueur
    ) {
    	List<Longueur> longueurs = longueurService.getAllLongueursByKey(cotationLongueur, widthLongueur, spitLongueur);
    	return new ModelAndView("results", "resultsLongueur", longueurs);    
    }
}
