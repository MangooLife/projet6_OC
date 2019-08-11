package com.thamarai.p6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamarai.p6.entity.Person;
import com.thamarai.p6.repository.PersonRepository;

@Service
public class PersonService {
	private static final Logger LOGGER = LogManager.getLogger(PersonService.class);
	
	@Autowired
	private PersonRepository personRepository;	
	
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		try {
			personRepository.findAll()
			.forEach(persons::add);
		}catch(Exception e) {
			LOGGER.warn("No persons found on database"+ e);
		}
		return persons;
	}
	
	public Optional<Person> getPerson(Long id) {
		return personRepository.findById(id);
	}
	
	public Optional<Person> authentificateUser(String username) {
		Optional<Person> personByUsername = personRepository.authentificateUser(username);
		return personByUsername;
	}
	
	public boolean passwordOk(String username, String password) {
		Optional<Person> personByUsername = this.authentificateUser(username);
		boolean rawPassword = false;
		if(!personByUsername.isEmpty()) {
			rawPassword = BCrypt.checkpw(password, personByUsername.get().getPassword());
		} 
		
		return rawPassword;
	}
	
	public void addPerson(Person person) {
		String rawPassword = person.getPassword();
		person.setPassword(BCrypt.hashpw(rawPassword, BCrypt.gensalt(12)));

		personRepository.save(person);
	}
	
	public void updatePerson(Long id, Person person) {
		personRepository.save(person);
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
}
