package com.beClean.soba1.soba1.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beClean.soba1.soba1.Entities.Person;
import com.beClean.soba1.soba1.Repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	
	public Iterable<Person> getAllPersons() {
	    return personRepository.findAll();
	  }

	  public Person getPersonById(int id) {
	     Optional<Person> optionalPerson = personRepository.findById(id);
	    if (!optionalPerson.isPresent()) {
	      throw new IllegalArgumentException();
	    }
	    return optionalPerson.get();
	  }

	  public void saveOrUpdate(Person person) {
	    personRepository.save(person);
	  }

	  public void delete(int id) {
	    personRepository.deleteById(id);
	  }
}
