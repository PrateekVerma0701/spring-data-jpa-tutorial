package com.prateek.people.management.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.prateek.people.management.app.entities.Person;

public interface PeopleManagementRepositry extends CrudRepository<Person, Integer> {

}
