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
	public Person createPerson(Person person) {
		return peopleManagementRepositry.save(person);
	}

	@Override
	public Iterable<Person> createPersons(List<Person> personList) {
		return peopleManagementRepositry.saveAll(personList);
	}

	@Override
	public Iterable<Person> getPersonByIds(List<Integer> ids) {
		return peopleManagementRepositry.findAllById(ids);
	}

	@Override
	public void deletePersonEntity(Person person) {
		peopleManagementRepositry.delete(person);
	}

	@Override
	public Person updatePersonEmailbyId(Integer id, String email) {
		Optional<Person> personToBeUpdated = peopleManagementRepositry.findById(id);
		if (personToBeUpdated.isPresent()) {
			personToBeUpdated.get().setEmail(email);
		}
		return peopleManagementRepositry.save(personToBeUpdated.get());
	}

}
