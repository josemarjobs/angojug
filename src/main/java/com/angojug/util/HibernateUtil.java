package com.angojug.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private final static SessionFactory FACTORY;

	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		FACTORY = cfg.configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
}
