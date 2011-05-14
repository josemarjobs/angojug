package com.angojug;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateDataBase {
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();
		SchemaExport exp = new SchemaExport(cfg);
		exp.create(true, true);
		System.out.println("**************DATABASE CREATED**************");
	}
}
