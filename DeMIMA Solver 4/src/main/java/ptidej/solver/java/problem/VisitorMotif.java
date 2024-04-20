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
import ptidej.solver.java.approximation.TSE07AggregationApproximations;
import ptidej.solver.java.constraint.repository.AggregationConstraint;
import ptidej.solver.java.constraint.repository.AssociationConstraint;
import ptidej.solver.java.constraint.repository.NoGhostEntityConstraint;
import ptidej.solver.java.constraint.repository.NotEqualConstraint;
import ptidej.solver.java.constraint.repository.StrictInheritanceConstraint;
import ptidej.solver.java.constraint.repository.UseConstraint;

/**
 * @author Yann-Ga�l Gu�h�neuc
 * @since  2007/02/24 
 */
public final class VisitorMotif {
	public static Problem getProblem(final List allEntities) {
		final Problem pb =
			new Problem(90, "Visitor Design Motif", allEntities);

		final Variable client = new Variable(pb, "client", false);
		final Variable objectstructure =
			new Variable(pb, "objectstructure", false);
		final Variable visitor = new Variable(pb, "visitor", true);
		final Variable concretevisitor =
			new Variable(pb, "concretevisitor", false);
		final Variable element = new Variable(pb, "element", true);
		final Variable concreteelement =
			new Variable(pb, "concreteelement", false);

		pb.addVar(client);
		pb.addVar(objectstructure);
		pb.addVar(visitor);
		pb.addVar(concretevisitor);
		pb.addVar(element);
		pb.addVar(concreteelement);

		pb.post(
			new StrictInheritanceConstraint(
				"ConcreteElement -|>- Element",
				"",
				concreteelement,
				element,
				100,
				DefaultNoApproximations
					.getDefaultApproximations()));
		pb.post(
			new StrictInheritanceConstraint(
				"ConcreteVisitor -|>- Visitor",
				"",
				concretevisitor,
				visitor,
				100,
				DefaultNoApproximations
					.getDefaultApproximations()));
		pb.post(
			new AggregationConstraint(
				"ObjectStructure <>--> Element",
				"",
				objectstructure,
				element,
				50,
				TSE07AggregationApproximations
					.getDefaultApproximations()));
		pb.post(
			new AssociationConstraint(
				"Element ----> Visitor",
				"",
				element,
				visitor,
				100,
				DefaultNoApproximations.getDefaultApproximations()));
		pb.post(
			new AssociationConstraint(
				"ConcreteElement ----> Visitor",
				"",
				concreteelement,
				visitor,
				100,
				DefaultNoApproximations.getDefaultApproximations()));
		pb.post(
			new UseConstraint(
				"Visitor ----> ConcreteElement",
				"",
				visitor,
				concreteelement,
				100,
				DefaultNoApproximations.getDefaultApproximations()));
		pb.post(
			new UseConstraint(
				"ConcreteVisitor ----> ConcreteElement",
				"",
				concretevisitor,
				concreteelement,
				100,
				DefaultNoApproximations.getDefaultApproximations()));
		pb.post(
			new AssociationConstraint(
				"Client ----> Visitor",
				"",
				client,
				visitor,
				100,
				DefaultNoApproximations.getDefaultApproximations()));
		pb.post(
			new AssociationConstraint(
				"Client ----> ObjectStructure",
				"",
				client,
				objectstructure,
				100,
				DefaultNoApproximations.getDefaultApproximations()));
		pb.post(
			new NotEqualConstraint(
				"Element <> Visitor",
				"",
				element,
				visitor,
				100,
				DefaultNoApproximations.getDefaultApproximations()));
		pb.post(
			new NoGhostEntityConstraint(
				"Visitor <> ?",
				"",
				visitor,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		return pb;
	}
}
