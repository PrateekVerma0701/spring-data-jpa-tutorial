package com.prateek.people.management.app.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.prateek.people.management.app.entities.Person;

public interface PeopleMangementService {

	List<Person> findByLastName(String lastName, PageRequest pageRequest);
}
