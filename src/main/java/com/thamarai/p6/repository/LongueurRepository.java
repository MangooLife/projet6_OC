package com.thamarai.p6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.Longueur;

@Repository
public interface LongueurRepository extends JpaRepository<Longueur, Long> {

	@Query(value = "SELECT * FROM Longueur l WHERE l.cotation = ?1 OR l.width = ?2 OR l.spit = ?3", nativeQuery = true)
	List<Longueur>  getAllLongueursByKeyRepo(String cotationLongueur, String widthLongueur, String spitLongueur);
}
