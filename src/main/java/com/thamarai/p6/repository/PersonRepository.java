package com.thamarai.p6.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	@Query(value = "SELECT * FROM Person p WHERE p.username = ?", nativeQuery = true)
	Optional<Person> authentificateUser(String username);
	
}
