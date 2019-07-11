package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Longueur;
import com.thamarai.p6.repository.LongueurRepository;

@Service
public class LongueurService {
	@Autowired
	private LongueurRepository longueurRepository;	
	
	public List<Longueur> getAllLongueurs() {
		List<Longueur> longueurs = new ArrayList<>();
		longueurRepository.findAll()
		.forEach(longueurs::add);
		return longueurs;
	}
	
	public Optional<Longueur> getLongueur(Long id) {
		return longueurRepository.findById(id);
	}
	
	public void addLongueur(Longueur longueur) {
		longueurRepository.save(longueur);
	}
	
	public void updateLongueur(Long id, Longueur longueur) {
		longueurRepository.save(longueur);
	}
	
	public void deleteLongueur(Long id) {
		longueurRepository.deleteById(id);
	}
}
