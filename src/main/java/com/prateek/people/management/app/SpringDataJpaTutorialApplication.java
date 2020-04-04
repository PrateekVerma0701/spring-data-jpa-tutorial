package com.prateek.people.management.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.service.PeopleMangementService;

@SpringBootApplication
public class SpringDataJpaTutorialApplication implements CommandLineRunner {

	@Autowired
	private PeopleMangementService peopleMangementService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createPerson();
		createPersons();
	}

	public void createPerson() {
		Person person1 = new Person("Prateek", "Verma", "prateek.verma@gmail.com", new Date());
		Person personDb = peopleMangementService.createPerson(person1);
		System.out.println(personDb);
	}

	public void createPersons() {

		List<Person> personList = new ArrayList<>();
		Person person1 = new Person("Ankit", "Verma", "ankit.verma@gmail.com", new Date());
		Person person2 = new Person("Poorva", "Verma", "poorva.verma@gmail.com", new Date());
		personList.add(person1);
		personList.add(person2);

		Iterable<Person> createPersons = peopleMangementService.createPersons(personList);

		for (Person person : createPersons) {
			System.out.println(person);
		}

	}

}
