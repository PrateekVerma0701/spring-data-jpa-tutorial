package com.prateek.people.management.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.service.PeopleMangementService;

@SpringBootApplication
public class SpringDataJpaNamedQueryApplication implements CommandLineRunner {

	@Autowired
	private PeopleMangementService peopleMangementService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaNamedQueryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		getPersonInfoByLastName();

		getPersonInfoByFirstNameAndEmail();
	}

	private void getPersonInfoByFirstNameAndEmail() {
		List<Person> personList = peopleMangementService.getPersonInfoByFirstNameAndEmail("Poorva",
				"poorva.tripathi@gmail.com");
		System.out.println("\n\nRetrieving person list by firstName and email");
		personList.forEach(System.out::println);
	}

	private void getPersonInfoByLastName() {
		List<Person> personList = peopleMangementService.getPersonInfoByLastName("Verma");
		System.out.println("\n\nRetrieving person list by lastName");
		personList.forEach(System.out::println);
	}

}
