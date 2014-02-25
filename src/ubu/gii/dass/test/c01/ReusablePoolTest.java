package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;

import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

public class ReusablePoolTest {

	private static ReusablePool rp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rp = ReusablePool.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertEquals(
				"Test getInstance(). Objeto obtenido no es de tipo ReusablePool",
				ReusablePool.class, ReusablePool.getInstance().getClass());
		assertEquals(
				"Test Singleton getInstance(). Instancias obtenidas no son del mismo objeto",
				ReusablePool.getInstance().hashCode(), ReusablePool
						.getInstance().hashCode());
	}

	@Test(expected = NotFreeInstanceException.class)
	public void testAcquireReusable() throws NotFreeInstanceException {
		int counter = 0;
		do {
			counter++;
			assertEquals("Test acquireReusable(): " + counter + "ª llamada.",
					rp.acquireReusable().getClass(), Reusable.class);
		} while (counter < 3);
	}

	@Test
	public void testReleaseReusable() {
		try {
			Reusable reusable = rp.acquireReusable();
			rp.releaseReusable(reusable);
			rp.releaseReusable(reusable);
		} catch (NotFreeInstanceException e) {
			e.printStackTrace();
		}
	}
}
