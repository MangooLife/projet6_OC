package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.PersonBook;
import com.thamarai.p6.repository.PersonBookRepository;

@Service
public class PersonBookService {
	@Autowired
	private PersonBookRepository personBookRepository;	
	
	public List<PersonBook> getAllPersonBooks() {
		List<PersonBook> PersonBooks = new ArrayList<>();
		personBookRepository.findAll()
		.forEach(PersonBooks::add);
		return PersonBooks;
	}
	
	public Optional<PersonBook> getPersonBook(Long id) {
		return personBookRepository.findById(id);
	}
	
	public void addPersonBook(PersonBook personBook) {
		personBookRepository.save(personBook);
	}
	
	public void updatePersonBook(Long id, PersonBook personBook) {
		personBookRepository.save(personBook);
	}
	
	public void deletePersonBook(Long id) {
		personBookRepository.deleteById(id);
	}
}
