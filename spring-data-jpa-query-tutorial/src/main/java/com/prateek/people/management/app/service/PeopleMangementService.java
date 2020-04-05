package com.prateek.people.management.app.service;

import java.util.List;

import com.prateek.people.management.app.entities.Person;

public interface PeopleMangementService {

	List<Person> getPersonInfoByLastName(String lastName);

	List<Person> getPersonInfoByFirstNameAndEmail(String firstName, String email);

	List<Person> getPersonInfoByLastNameOrFirstName(String lastName, String firstName);

}
