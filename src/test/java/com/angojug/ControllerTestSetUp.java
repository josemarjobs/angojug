package com.angojug;

import junit.extensions.TestSetup;
import junit.framework.Test;

public class ControllerTestSetUp extends TestSetup {

	public ControllerTestSetUp(Test test) {
		super(test);
	}

	@Override
	protected void setUp() throws Exception {
		CreateTestDataBase.create();
	}

	@Override
	protected void tearDown() throws Exception {
		CreateTestDataBase.getSessionFactory().close();
	}
}
