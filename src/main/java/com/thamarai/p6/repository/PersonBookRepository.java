package com.thamarai.p6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thamarai.p6.entity.PersonBook;

@Repository
public interface PersonBookRepository extends JpaRepository<PersonBook, Long>{

}
