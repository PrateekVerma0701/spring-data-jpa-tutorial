package com.prateek.people.management.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.repository.PeopleManagementRepositry;

@Service
public class PeopleMangementServiceImpl implements PeopleMangementService {

	@Autowired
	PeopleManagementRepositry peopleManagementRepositry;

	@Override
	public List<Person> getPersonInfoByLastName(String lastName) {
		return peopleManagementRepositry.findByLastName(lastName);
	}

	@Override
	public List<Person> getPersonInfoByFirstNameAndEmail(String firstName, String email) {
		return peopleManagementRepositry.findByFirstNameAndEmail(firstName, email);
	}

}
