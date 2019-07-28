package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Site;
import com.thamarai.p6.repository.SiteRepository;

@Service
public class SiteService {
	
	@Autowired
	private SiteRepository siteRepository;	
	
	public List<Site> getAllSites() {
		List<Site> sites = new ArrayList<>();
		siteRepository.findAll()
		.forEach(sites::add);
		return sites;
	}
	
	public Optional<Site> getSite(Long id) throws ResourceNotFoundException {
		return siteRepository.findById(id);
	}
	
	public void addSite(Site site) {
		siteRepository.save(site);
	}
	
	public void updateSite(String id, Site site) throws ResourceNotFoundException {
		siteRepository.save(site);
	}
	
	public void deleteSite(Long id)  throws ResourceNotFoundException {
		siteRepository.deleteById(id);
	}

}
