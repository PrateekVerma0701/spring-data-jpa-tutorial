package com.prateek.people.management.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prateek.people.management.app.entities.Person;

public interface PeopleManagementRepositry extends CrudRepository<Person, Integer> {

	List<Person> findByLastName(String lastName);

	List<Person> findByFirstNameAndEmail(String firstName, String email);

}
