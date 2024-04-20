/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Ga�l Gu�h�neuc  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     Yann-Ga�l Gu�h�neuc  and others, see in file; API and its implementation
 ******************************************************************************/
package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestCreatorJavaFileUsingEclipseParser extends TestSuite {
	public TestCreatorJavaFileUsingEclipseParser() {
	}

	public TestCreatorJavaFileUsingEclipseParser(final Class<?> theClass) {
		super(theClass);
	}

	public TestCreatorJavaFileUsingEclipseParser(final String name) {
		super(name);
	}

	public static Test suite() {
		final TestCreatorJavaFileUsingEclipseParser suite = new TestCreatorJavaFileUsingEclipseParser();

		suite.addTestSuite(ConciseParseTest.class);
		suite.addTestSuite(FileListJavaProjectTest.class);
		suite.addTestSuite(JavaParserLineAndBlockCommentTest.class);
		suite.addTestSuite(SimpleJavaParserTest.class);
		suite.addTestSuite(VerboseParseTest.class);

		return suite;
	}
}
