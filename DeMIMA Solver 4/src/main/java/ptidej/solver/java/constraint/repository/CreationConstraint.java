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
package ptidej.solver.java.constraint.repository;

import ptidej.solver.java.Variable;
import ptidej.solver.java.approximation.IApproximations;
import ptidej.solver.java.constraint.BinaryConstraint;

/**
 * Writen in CLAIRE by
 * @author Yann-Gaël Guéhéneuc
 * Translated and adapted from CLAIRE version to JAVA by
 * @author Iyadh Sidhom
 * @author Salim Bensemmane
 * @author Fayeal Skhiri
 */
public class CreationConstraint extends BinaryConstraint {
	public CreationConstraint(
		final String name,
		final String commande,
		final Variable v0,
		final Variable v1,
		final int weight,
		final IApproximations approximations) {

		super(name, commande, v0, v1, weight, approximations);
		this.setSymbol("-*-->");
		this.setStrict(true);
		this.setFieldName("createdEntities");
	}
}
