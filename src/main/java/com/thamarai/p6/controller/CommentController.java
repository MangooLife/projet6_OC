package com.thamarai.p6.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Comment;
import com.thamarai.p6.entity.Person;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.entity.Topo;
import com.thamarai.p6.service.CommentService;

@Controller
public class CommentController {
	
	private static final Logger LOGGER = LogManager.getLogger(CommentController.class);
	  
	@Autowired
	CommentService commentService;
	
	@Autowired
	SiteController siteController;
	
	@Autowired
	TopoController topoController;
	
	@RequestMapping(value = {"/addCommentSite/{person}/{site}"}, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCommentSite(
		HttpSession session,
		Model model,
		@RequestParam("description") String description,
		@PathVariable("person") final Person person,
		@PathVariable("site") final Site site
	)  throws ResourceNotFoundException {
		Comment comment = addComment(description, person);
		comment.setSite(site);
		commentService.addComment(comment);
		LOGGER.info("Add comment for a site");
		return siteController.site(site.getId(), model);
	}
	
	@RequestMapping(value = {"/addCommentTopo/{person}/{topo}"}, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCommentTopo(
		HttpSession session,
		Model model,
		@RequestParam("description") String description,
		@PathVariable("person") final Person person,
		@PathVariable("topo") final Topo topo
	)  throws ResourceNotFoundException {
		Comment comment = addComment(description, person);
		comment.setTopo(topo);
		commentService.addComment(comment);
		LOGGER.info("Add comment for a site");
		return topoController.topo(topo.getId(), model);
	}
	
	public Comment addComment(String description, Person person) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		Comment comment = new Comment();
		comment.setDescription(description);
		comment.setPerson(person);
		comment.setPublicationDate(formatter.format(date));
		return comment;
	}

}
