package com.beClean.soba1.soba1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beClean.soba1.soba1.Entities.Person;
import com.beClean.soba1.soba1.Service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;

	 @GetMapping("/person")
	  public Iterable<Person> getAllPersons() {
	    return personService.getAllPersons();
	  }

	  @GetMapping("/{id}")
	  public Person getPerson(@PathVariable int id) {
	    return personService.getPersonById(id);
	  }
}
