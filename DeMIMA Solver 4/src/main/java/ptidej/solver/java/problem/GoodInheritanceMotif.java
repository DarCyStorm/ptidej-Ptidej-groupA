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
package ptidej.solver.java.problem;

import java.util.List;

import ptidej.solver.java.Problem;
import ptidej.solver.java.Variable;
import ptidej.solver.java.approximation.DefaultNoApproximations;
import ptidej.solver.java.approximation.TSE07ExtensibleStrictInheritanceApproximations;
import ptidej.solver.java.constraint.repository.IgnoranceConstraint;
import ptidej.solver.java.constraint.repository.NotEqualConstraint;
import ptidej.solver.java.constraint.repository.StrictInheritanceConstraint;

/**
 * @author Yann-Ga�l Gu�h�neuc
 * @since  2007/02/24 
 */
public final class GoodInheritanceMotif {
	public static Problem getProblem(final List allEntities) {
		final Problem pb =
			new Problem(90, "Good Inheritance Design Motif", allEntities);

		final Variable superclass = new Variable(pb, "superclass", true);
		final Variable subclass = new Variable(pb, "subclass", false);

		pb.addVar(superclass);
		pb.addVar(subclass);

		pb.post(new StrictInheritanceConstraint(
			"SubClass -|>- SuperClass",
			"",
			subclass,
			superclass,
			100,
			TSE07ExtensibleStrictInheritanceApproximations
				.getDefaultApproximations()));

		pb.post(new IgnoranceConstraint(
			"SuperClass -/--> SubClass",
			"",
			superclass,
			subclass,
			100,
			DefaultNoApproximations.getDefaultApproximations()));

		pb.post(new NotEqualConstraint(
			"SuperClass <> SubClass",
			"",
			superclass,
			subclass,
			100,
			DefaultNoApproximations.getDefaultApproximations()));

		return pb;
	}
}
