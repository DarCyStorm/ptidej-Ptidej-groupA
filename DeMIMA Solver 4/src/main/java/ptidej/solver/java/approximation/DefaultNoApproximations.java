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
package ptidej.solver.java.approximation;

/**
 * @author	Yann-Gaël Guéhéneuc
 * @since	2007/02/24
 */
public class DefaultNoApproximations implements IApproximations {
	private static DefaultNoApproximations UniqueInstance;
	public static DefaultNoApproximations getDefaultApproximations() {
		if (DefaultNoApproximations.UniqueInstance == null) {
			DefaultNoApproximations.UniqueInstance =
				new DefaultNoApproximations();
		}
		return DefaultNoApproximations.UniqueInstance;
	}

	private DefaultNoApproximations() {
	}
	public String[] getApproximations() {
		return new String[0];
	}
}
