package com.prateek.people.management.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.service.PeopleMangementService;

@SpringBootApplication
public class SpringDataJpaCrudApplication implements CommandLineRunner {

	@Autowired
	private PeopleMangementService peopleMangementService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// create one person record - peopleManagementRepositry.save(person)
		createPerson();

		// create list of person record - peopleManagementRepositry.saveAll(personList)
		createPersons();

		/*
		 * retrieve person record with list of id -
		 * peopleManagementRepositry.findAllById(Id's)
		 */
		getPersonByIds();

		// delete a person record with id - peopleManagementRepositry.delete(person)
		deletePersonEntity();

		/*
		 * update person email by id i - peopleManagementRepositry.findById(id) ii
		 * -update the person object with email id iii - save person object
		 */
		updatePersonEmailbyId();
	}

	private void updatePersonEmailbyId() {
		Person updatedPerson = peopleMangementService.updatePersonEmailbyId(1, "prateek.verma@yahoo.com");
		System.out.println("Updating Person Email with Id : " + updatedPerson.getId());
		System.out.println(updatedPerson);

	}

	private void deletePersonEntity() {
		Person person = new Person();
		person.setId(3);
		peopleMangementService.deletePersonEntity(person);
	}

	private void getPersonByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(3);
		Iterable<Person> personList = peopleMangementService.getPersonByIds(ids);

		System.out.println("Retrieving person list with list of ids");

		for (Person person : personList) {
			System.out.println(person);
		}
	}

	private void createPerson() {
		Person person1 = new Person("Prateek", "Verma", "prateek.verma@gmail.com", new Date());
		Person personDb = peopleMangementService.createPerson(person1);
		System.out.println(personDb);
	}

	private void createPersons() {
		List<Person> personList = new ArrayList<>();
		Person person1 = new Person("Ankit", "Verma", "ankit.verma@gmail.com", new Date());
		Person person2 = new Person("Sanya", "Verma", "sanya.verma@yahoo.com", new Date());
		Person person3 = new Person("Pulkit", "Mehrotra", "pulkit.mehrotra@outlook.com", new Date());
		Person person4 = new Person("Poorva", "Tripathi", "poorva.tripathi@gmail.com", new Date());
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);

		Iterable<Person> createPersons = peopleMangementService.createPersons(personList);

		for (Person person : createPersons) {
			System.out.println(person);
		}
	}

}
