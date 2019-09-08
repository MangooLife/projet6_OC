package com.thamarai.p6.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Longueur;
import com.thamarai.p6.entity.Person;
import com.thamarai.p6.entity.Secteur;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.entity.Voie;
import com.thamarai.p6.service.LongueurService;
import com.thamarai.p6.service.PersonService;
import com.thamarai.p6.service.SecteurService;
import com.thamarai.p6.service.SiteService;
import com.thamarai.p6.service.VoieService;


@Controller
public class SiteController {

    private static final Logger LOGGER = LogManager.getLogger(SiteController.class);

    @Autowired
    SiteService siteService;
    
    @Autowired
    PersonService personService;
    
    @Autowired
    SecteurService secteurService;
    
    @Autowired
    LongueurService longueurService;
    
    @Autowired 
    VoieService voieService;
    
    @Autowired
    MemberController memberController;
    
    @Autowired
    CommonsMultipartFileController commonsMultipartFileController;
    
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
    
    @RequestMapping(value = {"/addSite/{id}/"}, headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addSite(
    		HttpSession session,
    		Model model,
    		RedirectAttributes redirectAttributes,
    		@PathVariable("id") Long personId,
    		@RequestParam("siteName") String siteName,
    		@RequestParam("siteDescription") String siteDescription,
    		@RequestParam("siteImage") CommonsMultipartFile siteImage
    ) {
    	commonsMultipartFileController.upload(siteImage, session);
    	LOGGER.info("Image chargée");
    	String filename = siteImage.getOriginalFilename(); 
		Person person = personService.getPerson(personId).get();
    	Site site = new Site();
    	site.setName(siteName);
    	site.setLabel(0);
    	site.setDescription(siteDescription);
    	site.setPerson(person); 
    	if (!filename.isEmpty()) {
    		site.setImage("/resources/image/download/"+filename);
    	} else {
    		site.setImage("/resources/image/LADE.png");
    	}
    	siteService.addSite(site);

		session.removeAttribute("classActiveProfil");
		session.removeAttribute("classActiveReservation");
		session.removeAttribute("classActiveTopos");
    	session.setAttribute("classActiveSitesPage","active");
    	redirectAttributes.addFlashAttribute(
    			"message", "Site créé avec succès");
    	return new ModelAndView("redirect:/person");    
    }
    
    @RequestMapping(value = {"/addSecteur"}, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addSecteur(
    		HttpSession session,
    		Model model,
    		RedirectAttributes redirectAttributes,
    		@RequestParam("secteurSite") Long secteurSite,
    		@RequestParam("secteurName") String secteurName
    ) throws ResourceNotFoundException {
    	Site site = siteService.getSite(secteurSite).get();
    	Secteur secteur = new Secteur();
    	secteur.setSite(site);
    	secteur.setName(secteurName);
    	secteurService.addSecteur(secteur);

		session.removeAttribute("classActiveProfil");
		session.removeAttribute("classActiveReservation");
		session.removeAttribute("classActiveTopos");
		session.setAttribute("classActiveSitesPage","active");
    	redirectAttributes.addFlashAttribute(
    			"message", "Secteur créé avec succès");
    	return new ModelAndView("redirect:/person");    
    }
    
    @RequestMapping(value = {"/addVoie"}, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addVoie(
    		HttpSession session,
    		Model model,
    		RedirectAttributes redirectAttributes,
    		@RequestParam("voieSecteur") Long voieSecteur,
    		@RequestParam("voieName") String voieName,
    		@RequestParam("voieCotation") String voieCotation,
    		@RequestParam("voieWith") Long voieWith
    ) throws ResourceNotFoundException {
    	Secteur secteur = secteurService.getSecteur(voieSecteur).get();
    	Voie voie = new Voie();
    	voie.setSecteur(secteur);
    	voie.setName(voieName);
    	voie.setCotation(voieCotation);
    	voie.setWidth(voieWith);
    	voieService.addVoie(voie);

		session.removeAttribute("classActiveProfil");
		session.removeAttribute("classActiveReservation");
		session.removeAttribute("classActiveTopos");
		session.setAttribute("classActiveSitesPage","active");
    	redirectAttributes.addFlashAttribute(
    			"message", "Voie créée avec succès");
    	return new ModelAndView("redirect:/person");    
    }
    
    @RequestMapping(value = {"/addLongueur"}, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addLongueur(
    		HttpSession session,
    		Model model,
    		RedirectAttributes redirectAttributes,
    		@RequestParam("longueurVoie") Long longueurVoie,
    		@RequestParam("longueurName") String longueurName,
    		@RequestParam("longueurSpit") String longueurSpit,
    		@RequestParam("longueurCotation") String longueurCotation,
    		@RequestParam("longueurWidth") String longueurWidth
    ) throws ResourceNotFoundException {
    	Voie voie = voieService.getVoie(longueurVoie).get();
    	Longueur longueur = new Longueur();
    	longueur.setVoie(voie);
    	longueur.setName(longueurName);
    	longueur.setSpit(longueurSpit);
    	longueur.setCotation(longueurCotation);
    	longueur.setWidth(longueurWidth);
    	longueurService.addLongueur(longueur);

		session.removeAttribute("classActiveProfil");
		session.removeAttribute("classActiveReservation");
		session.removeAttribute("classActiveTopos");
		session.setAttribute("classActiveSitesPage","active");
    	redirectAttributes.addFlashAttribute(
    			"message", "Longueur créée avec succès");
    	return new ModelAndView("redirect:/person");    
    }
    
    @GetMapping("/getLabel/{id}/{isLabel}")
    public ModelAndView getLabel(
    		Model model,
			HttpSession session,
    		RedirectAttributes redirectAttributes,
    		@PathVariable("id") Long siteId,
    		@PathVariable("isLabel") Integer isLabel
    ) {
    	try {
			Site site = siteService.getSite(siteId).get();
			if(isLabel == 1) {
				site.setLabel(1);
				redirectAttributes.addFlashAttribute(
		    			"message", "Label ajouté avec succès");
			} else {
				site.setLabel(0);
				redirectAttributes.addFlashAttribute(
		    			"message", "Label enlevé avec succès");
			}
			siteService.updateSite(siteId, site);
		} catch (ResourceNotFoundException e) {
			LOGGER.warn("resource not found"+siteId+e);
		}

		session.removeAttribute("classActiveMember");
		session.removeAttribute("classActiveComment");
		session.setAttribute("classActiveLabel","active");
    	
    	return new ModelAndView("redirect:/member");
    }
    
}
