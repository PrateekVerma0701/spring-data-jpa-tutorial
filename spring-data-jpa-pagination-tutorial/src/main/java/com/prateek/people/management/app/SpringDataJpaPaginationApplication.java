package com.prateek.people.management.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.prateek.people.management.app.entities.Person;
import com.prateek.people.management.app.service.PeopleMangementService;

@SpringBootApplication
public class SpringDataJpaPaginationApplication implements CommandLineRunner {

	@Autowired
	private PeopleMangementService peopleMangementService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaPaginationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PageRequest pageRequest = PageRequest.of(0, 2, Direction.ASC, "firstName");

		List<Person> personList = peopleMangementService.findByLastName("Verma", pageRequest);

		for (Person person : personList) {
			System.out.println(person);
		}

	}

}
