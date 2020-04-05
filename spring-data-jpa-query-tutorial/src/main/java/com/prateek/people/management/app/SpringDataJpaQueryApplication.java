package com.prateek.people.management.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.service.PeopleMangementService;

@SpringBootApplication
public class SpringDataJpaQueryApplication implements CommandLineRunner {

	@Autowired
	private PeopleMangementService peopleMangementService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaQueryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		getPersonInfoByLastName();

		getPersonInfoByFirstNameAndEmail();

		getPersonInfoByLastNameOrFirstName();

		updatePersonEmailById();
	}

	private void updatePersonEmailById() {
		int id = 5;
		String newEmail = "poorva.tripathi@yahoo.com";
		peopleMangementService.updatePersonEmailById(id, newEmail);
		System.out.println("Update email id successfull for perosn id : " + id);

	}

	private void getPersonInfoByLastNameOrFirstName() {
		List<Person> personList = peopleMangementService.getPersonInfoByLastNameOrFirstName("Mehrotra", "Pulkit");
		System.out.println("\n\nRetrieving person list by lastName OR firstName");
		personList.forEach(System.out::println);
	}

	private void getPersonInfoByFirstNameAndEmail() {
		List<Person> personList = peopleMangementService.getPersonInfoByFirstNameAndEmail("Poorva",
				"poorva.tripathi@gmail.com");
		System.out.println("\n\nRetrieving person list by firstName AND email");
		personList.forEach(System.out::println);
	}

	private void getPersonInfoByLastName() {
		List<Person> personList = peopleMangementService.getPersonInfoByLastName("Verma");
		System.out.println("\n\nRetrieving person list by lastName");
		personList.forEach(System.out::println);
	}

}
