package com.thamarai.p6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.Voie;

@Repository
public interface VoieRepository extends JpaRepository<Voie, Long>{
	
	@Query(value = "SELECT DISTINCT * FROM Voie v WHERE v.cotation = ?1 OR v.width = ?2", nativeQuery = true)
	List<Voie>  getAllVoiesBySomeKey(String cotationVoie, String widthVoie);
}
