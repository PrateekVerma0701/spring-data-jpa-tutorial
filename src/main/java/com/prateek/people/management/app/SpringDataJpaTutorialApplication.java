package com.prateek.people.management.app;

import java.util.Date;

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
	}

	public void createPerson() {

		Person person1 = new Person("Prateek", "Verma", "prateek.verma@gmail.com", new Date());
		peopleMangementService.createPerson(person1);

	}

}
