package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Secteur;
import com.thamarai.p6.repository.SecteurRepository;

@Service
public class SecteurService {
	@Autowired
	private SecteurRepository secteurRepository;	
	
	public List<Secteur> getAllSecteurs() {
		List<Secteur> secteurs = new ArrayList<>();
		secteurRepository.findAll()
		.forEach(secteurs::add);
		return secteurs;
	}
	
	public Optional<Secteur> getSecteur(Long id) {
		return secteurRepository.findById(id);
	}
	
	public void addSecteur(Secteur secteur) {
		secteurRepository.save(secteur);
	}
	
	public void updateSecteur(Long id, Secteur secteur) {
		secteurRepository.save(secteur);
	}
	
	public void deleteSecteur(Long id) {
		secteurRepository.deleteById(id);
	}
}
