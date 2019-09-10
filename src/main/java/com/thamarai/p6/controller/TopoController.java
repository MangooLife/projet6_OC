package com.thamarai.p6.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.thamarai.p6.entity.Booking;
import com.thamarai.p6.entity.Person;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.entity.Topo;
import com.thamarai.p6.service.BookingService;
import com.thamarai.p6.service.PersonService;
import com.thamarai.p6.service.SiteService;
import com.thamarai.p6.service.TopoService;

@Controller
public class TopoController {

    private static final Logger LOGGER = LogManager.getLogger(TopoController.class);
    
    @Autowired
    TopoService topoService;
    
    @Autowired
    SiteService siteService;

    @Autowired 
    PersonService personService;
    
    @Autowired
    BookingService bookingService;
    
    @Autowired 
    CommonsMultipartFileController commonsMultipartFileController;

    @RequestMapping("/topos")
    public ModelAndView topos(Model model) {
        LOGGER.debug("Topos page OK");
        List<Topo> topos = topoService.getAllTopos();
        return new ModelAndView("topos", "topos", topos);
    }

    @GetMapping("/topo/{id}")
    public ModelAndView topo(@PathVariable("id") final Long id, Model model) throws ResourceNotFoundException {
    	Topo topo = topoService.getTopo(id).orElseThrow(() -> new ResourceNotFoundException(id, "Topo"));
     	model.addAttribute("comments", topo.getComments());
     	model.addAttribute("sites", topo.getTopoSites());
     	return new ModelAndView("topo", "topo", topo);
    }
    
    @RequestMapping(value = {"/addTopo/{id}/"}, headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addTopo(
    		HttpSession session,
    		Model model,
    		RedirectAttributes redirectAttributes,
    		@PathVariable("id") Long personId,
    		@RequestParam("topoName") String topoName,
    		@RequestParam("topoPlace") String topoPlace,
    		@RequestParam("description") String description,
    		@RequestParam("topoImage") CommonsMultipartFile topoImage,
    		@RequestParam("sites") List<Long> sites
    ) {
    	commonsMultipartFileController.upload(topoImage, session);
    	LOGGER.info("Image chargée");
    	String filename = topoImage.getOriginalFilename(); 
    	Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Person person = personService.getPerson(personId).get();
    	Topo topo = new Topo();
    	topo.setName(topoName);
    	topo.setPlace(topoPlace);
    	topo.setDescription(description);
    	topo.setParutionDate(formatter.format(date));
    	topo.setStatus(0);
    	topo.setPerson(person); 
    	if (!filename.isEmpty()) {
    		topo.setImage("/resources/image/download/"+filename);
    	} else {
    		topo.setImage("/resources/image/LADE.png");
    	}
    	Set<Site> sitesList = new HashSet<Site>();
    	for(int i = 0; i < sites.size(); i++) {
    		Site site;
			try {
				site = siteService.getSite(sites.get(i)).get();
				sitesList.add(site);
			} catch (ResourceNotFoundException e) {
				e.printStackTrace();
			}
    	}
    	topo.setTopoSites(sitesList);
    	topoService.addTopo(topo);

		session.removeAttribute("classActiveProfil");
		session.removeAttribute("classActiveSitesPage");
		session.removeAttribute("classActiveReservation");
		session.setAttribute("classActiveTopos","active");
    	redirectAttributes.addFlashAttribute(
    			"message", "Topo créée avec succès");
    	return new ModelAndView("redirect:/returnPerson");    
    }
    
    @GetMapping("/topoStatus/{id}")
    public ModelAndView topoStatus(
    		@PathVariable("id") final Long id, 
    		Model model,
    		HttpSession session,
    		RedirectAttributes redirectAttributes
    ) throws ResourceNotFoundException {
    	Topo topo = topoService.getTopo(id).get();
    	topo.setStatus(0);
    	
    	Booking booking  = bookingService.getBooking(topo.getBooking().getId()).get();
    	booking.setBookingPerson(null);
    	bookingService.updateBooking(booking.getId(), booking);
    	
    	topo.setBooking(null);
    	topoService.updateTopo(id, topo);

		session.removeAttribute("classActiveProfil");
		session.removeAttribute("classActiveSitesPage");
		session.removeAttribute("classActiveReservation");
		session.setAttribute("classActiveTopos","active");
    	redirectAttributes.addFlashAttribute(
    			"message", "Status de la topo changé avec succès");
     	return new ModelAndView("redirect:/returnPerson");
    }

}
