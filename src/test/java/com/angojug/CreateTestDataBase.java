package com.angojug;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateTestDataBase {
	private static AnnotationConfiguration cfg;
	private static SessionFactory factory;
	static {
		cfg = new AnnotationConfiguration();
		cfg.configure("test_hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}

	public static void create() {
		SchemaExport exp = new SchemaExport(cfg);
		exp.create(true, true);
		System.out.println("******TEST DATABASE CREATED*******");
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
