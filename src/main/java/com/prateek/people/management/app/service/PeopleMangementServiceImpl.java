package com.prateek.people.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.repository.PeopleManagementRepositry;

@Service
public class PeopleMangementServiceImpl implements PeopleMangementService {

	@Autowired
	PeopleManagementRepositry peopleManagementRepositry;

	// Create entry in a database - Create Operation

	@Override
	public Person createPerson(Person person) {
		return peopleManagementRepositry.save(person);
	}

	@Override
	public List<Person> createPersons(List<Person> personList) {
		return (List<Person>) peopleManagementRepositry.saveAll(personList);
	}

}
