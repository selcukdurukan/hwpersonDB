package com.ba.boost.util;

import com.ba.boost.model.Person;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (HibernateUtil.sessionFactory == null) {
			HibernateUtil.sessionFactory = createSessionFactory();
		}
		return HibernateUtil.sessionFactory;
	}

	private static SessionFactory createSessionFactory() {
		Configuration config = new Configuration();

		config.addAnnotatedClass(Person.class);

		SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();

		return factory;
	}

}
