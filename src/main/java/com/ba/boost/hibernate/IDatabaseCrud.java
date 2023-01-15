package com.ba.boost.hibernate;

import java.util.List;

import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;

public interface IDatabaseCrud<T> {

	default void create(T entity) {

		Session session = databaseConnection();
		session.getTransaction().begin();

		session.persist(entity);

		session.getTransaction().commit();

	}

	List<T> retrive();

	default void update(T entity) {

		Session session = databaseConnection();
		session.getTransaction().begin();

		session.merge(entity);

		session.getTransaction().commit();

	}

	default void delete(T entity) {

		Session session = databaseConnection();
		session.getTransaction().begin();

		session.remove(entity);

		session.getTransaction().commit();

	}

	T find(long id);

	default Session databaseConnection() {
		return HibernateUtil.getSessionFactory().openSession();
	}

}
