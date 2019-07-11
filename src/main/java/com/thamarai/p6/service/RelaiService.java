package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Relai;
import com.thamarai.p6.repository.RelaiRepository;

@Service
public class RelaiService {
	@Autowired
	private RelaiRepository relaiRepository;	
	
	public List<Relai> getAllRelais() {
		List<Relai> Relais = new ArrayList<>();
		relaiRepository.findAll()
		.forEach(Relais::add);
		return Relais;
	}
	
	public Optional<Relai> getRelai(Long id) {
		return relaiRepository.findById(id);
	}
	
	public void addRelai(Relai relai) {
		relaiRepository.save(relai);
	}
	
	public void updateRelai(Long id, Relai relai) {
		relaiRepository.save(relai);
	}
	
	public void deleteRelai(Long id) {
		relaiRepository.deleteById(id);
	}
}
