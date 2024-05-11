/*
 * (c) Copyright 2002-2003 Yann-Gaël Guéhéneuc,
 * ecole des Mines de Nantes and Object Technology International, Inc.
 * 
 * Use and copying of this software and preparation of derivative works
 * based upon this software are permitted. Any copy of this software or
 * of any derivative work must include the above copyright notice of
 * the author, this paragraph and the one after it.
 * 
 * This software is made available AS IS, and THE AUTHOR DISCLAIMS
 * ALL WARRANTIES, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE, AND NOT WITHSTANDING ANY OTHER PROVISION CONTAINED HEREIN,
 * ANY LIABILITY FOR DAMAGES RESULTING FROM THE SOFTWARE OR ITS USE IS
 * EXPRESSLY DISCLAIMED, WHETHER ARISING IN CONTRACT, TORT (INCLUDING
 * NEGLIGENCE) OR STRICT LIABILITY, EVEN IF THE AUTHOR IS ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 * 
 * All Rights Reserved.
 */
package caffeine.test.composition5;

import caffeine.Constants;

/*
    traceExample13 :: Trace
    traceExample13 = [
        AssignField 1  ("A",1) ("B",2),
        Finalize    2  ("B",2),
        AssignField 3  ("A",3) ("B",4),
        Finalize    4  ("B",4),
        Finalize    5  ("A",1),
        Finalize    6  ("A",3)
	]
*/

public class Composition {
	public static void main(final String[] args) {
		final A a1 = new A();	// EX(A, B) = false
		final A a2 = new A();	// EX(A, B) = false

		a1.attach(new B());		// EX(B, A) = true

		// I force the garbage-collection of the
		// first instance of A, as if many object
		// allocations happened.
		a1.attach(null);
		for (int i = 0; i < Constants.VACUUM_CLEANER_LATENT_PERIOD; i++) {
			System.gc();
		}

		a2.attach(new B());		// EX(B, A) = true
		a2.operation();
	}
}