/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Ga�l Gu�h�neuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Ga�l Gu�h�neuc and others, see in file; API and its implementation
 ******************************************************************************/
package ptidej.solver.java.test.problem;

import java.util.List;

import ptidej.solver.java.Problem;
import ptidej.solver.java.Variable;
import ptidej.solver.java.approximation.DefaultNoApproximations;
import ptidej.solver.java.constraint.repository.InheritancePathConstraint;
import ptidej.solver.java.constraint.repository.NotEqualConstraint;

/**
 * @author Yann-Ga�l Gu�h�neuc
 * @since  2004/09/19
 */
public final class InheritancePathProblem {
	public static final char[] SUB_ENTITY = "SubEntity".toCharArray();
	public static final char[] SUPER_ENTITY = "SuperEntity".toCharArray();

	public static Problem getProblem(final List allEntities) {
		final Problem pb = new Problem(90, "Composition Test", allEntities);

		final Variable subEntity =
			new Variable(pb, InheritancePathProblem.SUB_ENTITY, true);
		final Variable superEntity =
			new Variable(pb, InheritancePathProblem.SUPER_ENTITY, true);

		pb.addVar(subEntity);
		pb.addVar(superEntity);

		final InheritancePathConstraint c1 =
			new InheritancePathConstraint(
				"Sub-entity -|>- ... -|>- Super-entity",
				"SubEntity, SuperEntity |\n\t\t\tjavaXL.XClass c1, javaXL.XClass c2 |\n\t\t\tc1.setSuperclass(c2.getName());",
				subEntity,
				superEntity,
				100,
				DefaultNoApproximations.getDefaultApproximations());
		final NotEqualConstraint c2 =
			new NotEqualConstraint(
				"SuperEntity <> SubEntity",
				"throw new RuntimeException(\"SuperEntity <> SubEntity\");",
				superEntity,
				subEntity,
				100,
				DefaultNoApproximations.getDefaultApproximations());

		pb.post(c1);
		pb.post(c2);

		return pb;
	}
}
