package com.angojug;

import com.angojug.controller.ComentariosControllerTest;
import com.angojug.controller.PostsControllerTest;
import com.angojug.controller.UsuariosControllerTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(UsuariosControllerTest.class);
		suite.addTestSuite(PostsControllerTest.class);
		suite.addTestSuite(ComentariosControllerTest.class);
		return new ControllerTestSetUp(suite);
	}
}
