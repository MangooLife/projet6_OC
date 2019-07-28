package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Person;
import com.thamarai.p6.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository PersonRepository;	
	
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		PersonRepository.findAll()
		.forEach(persons::add);
		return persons;
	}
	
	public Optional<Person> getPerson(Long id) {
		return PersonRepository.findById(id);
	}
	
	public Optional<Person> authentificateUser(String username) {
		return PersonRepository.authentificateUser(username);
	}
	
	public void addPerson(Person person) {
		PersonRepository.save(person);
	}
	
	public void updatePerson(Long id, Person person) {
		PersonRepository.save(person);
	}
	
	public void deletePerson(Long id) {
		PersonRepository.deleteById(id);
	}
}
