package com.prateek.people.management.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prateek.people.management.app.entities.Person;

public interface PeopleManagementRepositry extends CrudRepository<Person, Integer> {

	// @Query(value = "SELECT p FROM Person p WHERE p.lastName = ?1")

	// now writing through native query

	@Query(value = "select * from person_table where last_name = ?1", nativeQuery = true)
	List<Person> getPersonInfoByLastName(String lastName);

	@Query(value = "SELECT p FROM Person p WHERE p.firstName = ?1 AND p.email = ?2")
	List<Person> getPersonInfoByFirstNameAndEmail(String firstName, String email);

}
