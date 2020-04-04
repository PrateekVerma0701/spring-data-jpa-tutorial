package com.prateek.people.management.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prateek.people.management.app.entities.Person;

public interface PeopleManagementRepositry extends CrudRepository<Person, Integer> {

	List<Person> getPersonInfoByLastName(String lastName);

	List<Person> getPersonInfoByFirstNameAndEmail(String firstName, String email);

}
