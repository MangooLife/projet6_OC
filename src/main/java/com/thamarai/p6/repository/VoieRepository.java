package com.thamarai.p6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.Voie;

@Repository
public interface VoieRepository extends JpaRepository<Voie, Long>{

}
