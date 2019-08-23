package com.thamarai.p6.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
public class CommonsMultipartFileController {
	private static final Logger LOGGER = LogManager.getLogger(CommonsMultipartFileController.class);
	
	public void upload(CommonsMultipartFile file, HttpSession session){  
		LOGGER.info("beggining upload file");
		String path = session.getServletContext().getRealPath("/resources/image/download");  
		String filename = file.getOriginalFilename();  
		try{  
			byte barr[]=file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream (  
			new FileOutputStream(path+"/"+filename));  
			bout.write(barr);  
			bout.flush();  
			bout.close();  
			LOGGER.info("image chargement in loading");
		} catch(Exception e){
			LOGGER.info("error in image chargement", e);
		}  
	} 
}
