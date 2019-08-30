package com.thamarai.p6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.Secteur;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Long>{
	
	@Query(value = "SELECT * FROM Secteur s WHERE s.name = ?", nativeQuery = true)
	List<Secteur>  getAllSecteursByKeywordRepo(String keyword);
}
