package com.prateek.people.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.repository.PeopleManagementRepositry;

@Service
public class PeopleMangementServiceImpl implements PeopleMangementService {

	@Autowired
	PeopleManagementRepositry peopleManagementRepositry;

	@Override
	public List<Person> findByLastName(String lastName, PageRequest pageRequest) {
		return peopleManagementRepositry.findByLastName(lastName, pageRequest);
	}

}
