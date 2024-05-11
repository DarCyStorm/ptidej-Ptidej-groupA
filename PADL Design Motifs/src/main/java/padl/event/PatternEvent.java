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
package padl.event;

import padl.kernel.IAbstractModel;
import padl.motif.IDesignMotifModel;

public final class PatternEvent implements IEvent {
	private final IAbstractModel abstractModel;
	private final IDesignMotifModel patternModel;

	public PatternEvent(
		final IAbstractModel abstractModel,
		final IDesignMotifModel patternModel) {

		this.abstractModel = abstractModel;
		this.patternModel = patternModel;
	}
	public IDesignMotifModel getPatternModel() {
		return this.patternModel;
	}
	public IAbstractModel getAbstractModel() {
		return this.abstractModel;
	}
}
