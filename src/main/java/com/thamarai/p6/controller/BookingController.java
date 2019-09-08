package com.thamarai.p6.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Booking;
import com.thamarai.p6.entity.Person;
import com.thamarai.p6.entity.Topo;
import com.thamarai.p6.service.BookingService;
import com.thamarai.p6.service.PersonService;
import com.thamarai.p6.service.TopoService;

import javax.servlet.http.HttpSession;

@Controller
public class BookingController {

	private static final Logger LOGGER = LogManager.getLogger(BookingController.class);
  
	@Autowired
	BookingService bookingService;
	
	@Autowired
	TopoService topoService;
	
	@Autowired
	PersonService personService;

	@RequestMapping("/booking")
	public ModelAndView index() {
		LOGGER.debug("Booking page OK");
		return new ModelAndView("booking", "topos", topoService.getAllTopos());
	}
	
	@RequestMapping(value = {"/bookingTopo/{username}"}, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView bookingTopo(
    		Model model,
    		@PathVariable("username") String username,
    		@RequestParam("topoList") Long topoList,
    		final RedirectAttributes redirectAttributes
    ) throws ResourceNotFoundException {
    	Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Set<Person> persons = new HashSet<Person>();
		persons.add(personService.authentificateUser(username).get());
		
		Topo topo = topoService.getTopo(topoList).get();
		Set<Topo> topos = new HashSet<Topo>();
		topos.add(topo);
		
    	Booking booking = new Booking();
    	booking.setBookingPerson(persons);
    	booking.setDate(formatter.format(date));
    	booking.setTopos(topos);
    	bookingService.addBooking(booking);
    	
    	topo.setBooking(booking);
    	topoService.updateTopo(topoList, topo);
    	redirectAttributes.addFlashAttribute(
    			"message", "La réservation a bien été prise en compte. L'auteur de la topo vous contactera.");
    	return new ModelAndView("redirect:/booking");    
    }
	
	@GetMapping("/acceptBooking/{bookingId}")
    public ModelAndView acceptBooking(
    		Model model,
			HttpSession session,
			RedirectAttributes redirectAttributes,
    		@PathVariable("bookingId") Long bookingId
    ) {
    	Booking booking = bookingService.getBooking(bookingId).get();
    	Set<Topo> topos = new HashSet<Topo>();
    	topos.addAll(booking.getTopos());
    	topos.forEach( (topo) -> { 
    		topo.setStatus(1);
    		topoService.updateTopo(topo.getId(), topo);
    	});

		session.removeAttribute("classActiveProfil");
		session.removeAttribute("classActiveSitesPage");
		session.removeAttribute("classActiveTopos");
		session.setAttribute("classActiveReservation","active");
		redirectAttributes.addFlashAttribute(
				"message", "Vous avez bien pris en compte la réservation. Veuillez contacter l'ami(e) par mail :)");
    	return new ModelAndView("redirect:/returnPerson");
    }

}