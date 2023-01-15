package com.ba.boost;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ba.boost.controller.PersonController;
import com.ba.boost.model.Person;

public class App {

	private static final String FILE = "C:\\Users\\selcu\\Desktop\\JWS\\MyBAWS\\Database-hwperson\\resources\\Person.csv";
	List<Person> persons = new ArrayList<>();

	public static void main(String[] args) {

		PersonController personController = new PersonController();

//		App main = new App();
//		main.createData();

//		personController.retrive();
//		
//		personController.find(15);

//		System.out.println();
//		System.out.println(personController.countGenderFluid());

//		System.out.println();
//		personController.findNameStartWithA();

//		System.out.println();
//		personController.biggerThan18();

//		System.out.println();
//		personController.add10000ToIdBiggerThan50();

		personController.retrive();

	}

	private void createData() {
		PersonController personController = new PersonController();
		String line = "";
		String splitBy = ",";

		DateTimeFormatter f = DateTimeFormatter.ofPattern("M/d/yyyy");

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
			while ((line = reader.readLine()) != null) {
				String[] persons = line.split(splitBy);

				System.out.println("Person [id=" + persons[0] + ", firstName=" + persons[1] + ", lastName=" + persons[2] + ", email=" + persons[3] + ", gender=" + persons[4] + ", birthday=" + persons[5] + "]");

				String birthday = persons[5];
				Date bday = Date.valueOf(LocalDate.parse(birthday, f));

				Person p1 = new Person(Long.parseLong(persons[0]), persons[1], persons[2], persons[3], persons[4],
						bday);
				personController.create(p1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
