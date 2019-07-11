package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Topo;
import com.thamarai.p6.repository.TopoRepository;

@Service
public class TopoService {
	@Autowired
	private TopoRepository topoRepository;	
	
	public List<Topo> getAllTopos() {
		List<Topo> topos = new ArrayList<>();
		topoRepository.findAll()
		.forEach(topos::add);
		return topos;
	}
	
	public Optional<Topo> getTopo(Long id) {
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
