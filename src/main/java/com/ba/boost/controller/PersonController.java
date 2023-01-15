package com.ba.boost.controller;

import java.util.ArrayList;
import java.util.List;

import com.ba.boost.hibernate.IDatabaseCrud;
import com.ba.boost.hibernate.IDatabaseOperatation;
import com.ba.boost.model.Person;
import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;

public class PersonController implements IDatabaseCrud<Person>, IDatabaseOperatation<Person> {

	@Override
	public List<Person> retrive() {
		ArrayList<Person> retrivePerson = null;
		try (Session session = databaseConnection();) {

			String hql = "SELECT p FROM Person AS p";

			TypedQuery<Person> typedQuery = session.createQuery(hql, Person.class);
			retrivePerson = (ArrayList<Person>) typedQuery.getResultList();

			for (Person p : retrivePerson) {
				System.out.println(p);
			}

		} catch (Exception e) {
			System.out.println("Some problem occured while RETRIVING all of USER from DB.");
		}
		return retrivePerson;
	}

	@Override
	public Person find(long id) {
		Person findPerson = null;
		try (Session session = databaseConnection();) {
			findPerson = session.find(Person.class, id);
			if (findPerson != null) {
				System.out.println(findPerson);
			} else {
				System.out.println("PERSON cannot FOUND.");
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while FINDING PERSON.");
		}

		return findPerson;
	}

	@Override
	public String countGenderFluid() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT COUNT(xxx) FROM Person AS xxx WHERE xxx.gender = 'Genderfluid'"; // SQL'in aksine tablo adı
																								// değil okumak
																								// istedigimiz sınıf
																								// ismini
		// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
		// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<Person> typedQuery = session.createQuery(hql, Person.class);
		ArrayList<Person> persons = (ArrayList<Person>) typedQuery.getResultList();
		return "Total Genderfluids are: " + persons.get(0);
	}

	@Override
	public void add10000ToIdBiggerThan50() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "UPDATE Person p SET p.id = p.id + 10000 WHERE 18262.5 <= (CURRENT_DATE - p.birthday)"; // SQL'in
																												// aksine
																												// tablo
		// adı değil okumak
		// istedigimiz sınıf
		// ismini
		// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
		// Bunların hepsini hibernate reflection kullanarak yapıyor.
		session.getTransaction().begin();
		Query query = session.createQuery(hql);
		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Updated.");
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void biggerThan18() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Person AS xxx WHERE 6574.5 <= (CURRENT_DATE - xxx.birthday)"; // SQL'in aksine
																									// tablo
																									// adı değil okumak
																									// istedigimiz sınıf
																									// ismini
		// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
		// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<Person> typedQuery = session.createQuery(hql, Person.class);
		ArrayList<Person> persons = (ArrayList<Person>) typedQuery.getResultList();
		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
			if (persons.size() - 1 == i) {
				System.out.println("There are " + ++i + " rows.");
			}
		}
	}

	@Override
	public void findNameStartWithA() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Person AS xxx WHERE xxx.firstName ILIKE 'A%'"; // SQL'in aksine tablo adı değil
																						// okumak istedigimiz sınıf
																						// ismini
		// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
		// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<Person> typedQuery = session.createQuery(hql, Person.class);

		ArrayList<Person> persons = (ArrayList<Person>) typedQuery.getResultList();

		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
			if (persons.size() - 1 == i) {
				System.out.println("There are " + ++i + " rows.");
			}
		}
	}

}
