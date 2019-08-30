package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.repository.SiteRepository;

@Service
public class SiteService {
	
	private static final Logger LOGGER = LogManager.getLogger(SiteService.class);
	
	@Autowired
	private SiteRepository siteRepository;	
	
	public List<Site> getAllSites() {
		List<Site> sites = new ArrayList<>();
		try {
			siteRepository.findAll()
			.forEach(sites::add);
		}catch(Exception e) {
			LOGGER.warn("No sites found on database");
		}
		return sites;
	}
	
	public Optional<Site> getSite(Long id) throws ResourceNotFoundException {
		return siteRepository.findById(id);
	}
	
	public List<Site> getAllSitesByKeyword(String keyword) {
		return siteRepository.getAllSitesByKeywordRepo(keyword);
	}
	
	public void addSite(Site site) {
		siteRepository.save(site);
	}
	
	public void updateSite(Long id, Site site) throws ResourceNotFoundException {
		siteRepository.save(site);
	}
	
	public void deleteSite(Long id)  throws ResourceNotFoundException {
		siteRepository.deleteById(id);
	}

}
