package com.thamarai.p6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long>{
	
	@Query(value = "SELECT * FROM Site s WHERE s.name = ?", nativeQuery = true)
	List<Site>  getAllSitesByKeywordRepo(String keyword);
}
