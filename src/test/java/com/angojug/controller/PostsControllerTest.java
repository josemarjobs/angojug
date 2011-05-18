package com.angojug.controller;

import org.junit.Test;

import com.angojug.ControllerTestSetUp;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PostsControllerTest extends TestCase {

	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(PostsControllerTest.class);
		return new ControllerTestSetUp(suite);
	}

	@Test
	public void testCreate() {
		assertTrue(true);
	}
}
