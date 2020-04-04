package com.prateek.people.management.app.service;

import java.util.List;

import com.prateek.people.management.app.entities.Person;

public interface PeopleMangementService {

	Person createPerson(Person person);

	Iterable<Person> createPersons(List<Person> personList);

	Iterable<Person> getPersonByIds(List<Integer> ids);

}
