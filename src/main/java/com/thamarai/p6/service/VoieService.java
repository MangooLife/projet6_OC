package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Voie;
import com.thamarai.p6.repository.VoieRepository;

@Service
public class VoieService {
	@Autowired
	private VoieRepository voieRepository;	
	
	public List<Voie> getAllVoies() {
		List<Voie> voies = new ArrayList<>();
		voieRepository.findAll()
		.forEach(voies::add);
		return voies;
	}
	
	public Optional<Voie> getVoie(Long id) {
		return voieRepository.findById(id);
	}
	
	public void addVoie(Voie voie) {
		voieRepository.save(voie);
	}
	
	public void updateVoie(Long id, Voie voie) {
		voieRepository.save(voie);
	}
	
	public void deleteVoie(Long id) {
		voieRepository.deleteById(id);
	}
}
