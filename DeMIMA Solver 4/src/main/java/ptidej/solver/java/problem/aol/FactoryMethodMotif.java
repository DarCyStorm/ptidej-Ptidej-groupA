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
package ptidej.solver.java.problem.aol;

import java.util.List;

import ptidej.solver.java.Problem;
import ptidej.solver.java.Variable;
import ptidej.solver.java.approximation.DefaultNoApproximations;
import ptidej.solver.java.approximation.TSE07ExtendedAssociationApproximations;
import ptidej.solver.java.approximation.TSE07ExtensibleStrictInheritanceApproximations;
import ptidej.solver.java.constraint.repository.AbstractEntityConstraint;
import ptidej.solver.java.constraint.repository.AssociationConstraint;
import ptidej.solver.java.constraint.repository.NotEqualConstraint;
import ptidej.solver.java.constraint.repository.StrictInheritanceConstraint;

/**
 * @author Jean-Yves Guyomarc'h
 * @author Yann-Ga�l Gu�h�neuc
 */
public final class FactoryMethodMotif {
	public static Problem getProblem(final List allEntities) {
		final Problem pb =
			new Problem(90, "Factory Method Design Motif", allEntities);

		final Variable creator = new Variable(pb, "creator", true);
		final Variable concreteCreator =
			new Variable(pb, "concreteCreator", false);
		final Variable product = new Variable(pb, "product", true);
		final Variable concreteProduct =
			new Variable(pb, "concreteProduct", false);

		pb.addVar(creator);
		pb.addVar(concreteCreator);
		pb.addVar(product);
		pb.addVar(concreteProduct);

		// Constraints
		pb.post(
			new StrictInheritanceConstraint(
				"ConcreteCreator -|>- Creator",
				"",
				concreteCreator,
				creator,
				50,
				TSE07ExtensibleStrictInheritanceApproximations
					.getDefaultApproximations()));

		pb.post(
			new StrictInheritanceConstraint(
				"ConcreteProdcut -|>- Product",
				"",
				concreteProduct,
				product,
				50,
				TSE07ExtensibleStrictInheritanceApproximations
					.getDefaultApproximations()));

		pb.post(
			new AssociationConstraint(
				"Creator ----> Product",
				"",
				creator,
				product,
				80,
				TSE07ExtendedAssociationApproximations
					.getDefaultApproximations()));

		pb.post(
			new AssociationConstraint(
				"ConcreteCreator ----> ConcreteProduct",
				"",
				concreteCreator,
				concreteProduct,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new NotEqualConstraint(
				"Creator <> Product",
				"",
				creator,
				product,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new NotEqualConstraint(
				"Creator <> ConcreteCreator",
				"",
				creator,
				concreteCreator,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new NotEqualConstraint(
				"Creator <> ConcreteProduct",
				"",
				creator,
				concreteProduct,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new NotEqualConstraint(
				"Product <> ConcreteProduct",
				"",
				product,
				concreteProduct,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new NotEqualConstraint(
				"ConcreteCreator <> ConcreteProduct",
				"",
				concreteCreator,
				concreteProduct,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new NotEqualConstraint(
				"ConcreteCreator <> Product",
				"",
				concreteCreator,
				product,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new AbstractEntityConstraint(
				"Product is abstract",
				"",
				product,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		pb.post(
			new AbstractEntityConstraint(
				"Creator is abstract",
				"",
				creator,
				100,
				DefaultNoApproximations.getDefaultApproximations()));

		return pb;
	}
}
