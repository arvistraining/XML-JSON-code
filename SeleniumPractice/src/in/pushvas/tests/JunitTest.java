package in.pushvas.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {

	
	
	/*@Before
	@BeforeClass
	@After
	@AfterClass
	@Test
	@Ignore
	@Test(timeout=500)
	@Test(expected=IllegalArgumentException.class)*/  //Ignore the Expected Error in that method
	
	@Before
	public void beforeAnnoatation() {
		
	}
	@BeforeClass
	public void beforeClassAnnotation() {
		
	}
	
	@After
	public void afterAnnoatation() {
		
	}
	@AfterClass
	public void afterClassAnnoatation() {
		
	}
	@
	
	
	@Test(timeout=5000) // Milliseconds
	public void timeOut() {
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void expectedError() {
		
	}
}
