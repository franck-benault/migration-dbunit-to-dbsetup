package net.franckbenault.migration.dbunittodbsetup;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRemovePointAddProperCase() {
		assertEquals(StringUtils.removePointAddProperCase("test.xml"), "test");
		assertEquals(StringUtils.removePointAddProperCase("test.test.xml"), "testTest");
		assertEquals(StringUtils.removePointAddProperCase("titi.tata.toto.xml"), "titiTataToto");
	}
	
	@Test
	public void testToProperCase() {
		assertEquals(StringUtils.toProperCase("test"), "Test");
		assertEquals(StringUtils.removePointAddProperCase("Test"), "Test");
		assertEquals(StringUtils.removePointAddProperCase("TEST"), "TEST");
	}

}
