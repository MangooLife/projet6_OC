package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.Exception.ResourceNotFoundException;
import com.thamarai.p6.entity.Topo;
import com.thamarai.p6.repository.TopoRepository;

@Service
public class TopoService {
	
	private static final Logger LOGGER = LogManager.getLogger(TopoService.class);
	
	@Autowired
	private TopoRepository topoRepository;	
	
	public List<Topo> getAllTopos() {
		List<Topo> topos = new ArrayList<>();
		try {
			topoRepository.findAll()
			.forEach(topos::add);
		}catch(Exception e) {
			LOGGER.warn("No topos found on database");
		}
		return topos;
	}
	
	public Optional<Topo> getTopo(Long id) throws ResourceNotFoundException {
		return topoRepository.findById(id);
	}
	
	public void addTopo(Topo topo) {
		topoRepository.save(topo);
	}
	
	public void updateTopo(Long id, Topo topo) {
		topoRepository.save(topo);
	}
	
	public void deleteTopo(Long id) {
		topoRepository.deleteById(id);
	}
}
