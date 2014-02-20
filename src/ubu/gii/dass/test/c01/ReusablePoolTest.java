package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ubu.gii.dass.c01.ReusablePool;

public class ReusablePoolTest {
	
	private static ReusablePool rp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rp = ReusablePool.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertEquals(ReusablePool.getInstance().hashCode(),  ReusablePool.getInstance().hashCode());
	}

	@Test
	public void testAcquireReusable() {
		fail("Not yet implemented");
	}

	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}
}
