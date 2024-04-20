package padl.creator.cppfile.eclipse.test.big;

import junit.framework.TestCase;
import padl.kernel.ICodeLevelModel;
import padl.kernel.exception.CreationException;

public class JNIModel extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testModel() throws CreationException {
		PadlModelJNI JNI = new PadlModelJNI();
		ICodeLevelModel model = JNI.CreateModelTestCase();
		assertEquals(8, model.getNumberOfConstituents());
	}

}
