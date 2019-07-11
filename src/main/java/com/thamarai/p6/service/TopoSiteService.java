package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.TopoSite;
import com.thamarai.p6.repository.TopoSiteRepository;

@Service
public class TopoSiteService {
	@Autowired
	private TopoSiteRepository topoSiteRepository;	
	
	public List<TopoSite> getAllTopoSites() {
		List<TopoSite> topoSites = new ArrayList<>();
		topoSiteRepository.findAll()
		.forEach(topoSites::add);
		return topoSites;
	}
	
	public Optional<TopoSite> getTopoSite(Long id) {
		return topoSiteRepository.findById(id);
	}
	
	public void addTopoSite(TopoSite topoSite) {
		topoSiteRepository.save(topoSite);
	}
	
	public void updateTopoSite(Long id, TopoSite topoSite) {
		topoSiteRepository.save(topoSite);
	}
	
	public void deleteTopoSite(Long id) {
		topoSiteRepository.deleteById(id);
	}
}
