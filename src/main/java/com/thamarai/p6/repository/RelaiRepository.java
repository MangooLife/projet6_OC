package com.thamarai.p6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.Relai;

@Repository
public interface RelaiRepository extends JpaRepository<Relai, Long>{

}
