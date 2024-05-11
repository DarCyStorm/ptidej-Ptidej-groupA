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
package padl.kernel.impl;

import padl.kernel.IElementMarker;
import padl.kernel.IFirstClassEntity;
import padl.kernel.IGeneralisation;

/**
 * @author Yann-Gaël Guéhéneuc
 * @since  2004/08/15
 */
class Generalisation extends Relationship implements IElementMarker,
		IGeneralisation {

	private static final long serialVersionUID = 4207114920644600626L;

	public Generalisation(
		final char[] anID,
		final IFirstClassEntity aTargetEntity) {

		super(anID);
		this.setTargetEntity(aTargetEntity);
	}
}
