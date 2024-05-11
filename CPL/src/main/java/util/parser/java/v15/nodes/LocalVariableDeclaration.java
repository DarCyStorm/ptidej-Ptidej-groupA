/*******************************************************************************
 * Copyright (c) 2014 Yann-Gaël Guéhéneuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Gaël Guéhéneuc and others, see in file; API and its implementation
 ******************************************************************************/
//
// Generated by JTB 1.2.2
//

package util.parser.java.v15.nodes;

/**
 * Grammar production:
 * f0 -> Modifiers()
 * f1 -> Type()
 * f2 -> VariableDeclarator()
 * f3 -> ( "," VariableDeclarator() )*
 */
public class LocalVariableDeclaration implements Node {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Modifiers f0;
   public Type f1;
   public VariableDeclarator f2;
   public NodeListOptional f3;

   public LocalVariableDeclaration(Modifiers n0, Type n1, VariableDeclarator n2, NodeListOptional n3) {
      this.f0 = n0;
      this.f1 = n1;
      this.f2 = n2;
      this.f3 = n3;
   }

   public void accept(util.parser.java.v15.visitors.Visitor v) {
      v.visit(this);
   }
   public Object accept(util.parser.java.v15.visitors.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

