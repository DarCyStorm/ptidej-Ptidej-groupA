/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Gaël Guéhéneuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Gaël Guéhéneuc and others, see in file; API and its implementation
 ******************************************************************************/
package padl.creator.classfile.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import padl.creator.classfile.test.compare.TestCompare;
import padl.creator.classfile.test.fieldaccess.TestFieldAccess;
import padl.creator.classfile.test.inheritance.TestInheritance;
import padl.creator.classfile.test.methodInvocation.MethodInvocationMissingtest;
import padl.creator.classfile.test.path.TestPathArgoUML;
import padl.creator.classfile.test.topLevelEntity.TopLevelEntityTest;

/**
 * @author Yann-Gaël Guéhéneuc
 * @since  2004/01/25
 */
public final class TestCreatorClassFile extends TestSuite {
	public TestCreatorClassFile() {
	}

	public TestCreatorClassFile(final Class theClass) {
		super(theClass);
	}

	public TestCreatorClassFile(final String name) {
		super(name);
	}

	public static Test suite() {
		final TestCreatorClassFile suite = new TestCreatorClassFile();

		suite.addTest(TestCompare.suite());
		suite.addTest(TestFieldAccess.suite());
		suite.addTest(TestInheritance.suite());
		suite.addTestSuite(MethodInvocationMissingtest.class);
		suite.addTestSuite(TestPathArgoUML.class);
		suite.addTestSuite(TopLevelEntityTest.class);
		return suite;
	}
}
