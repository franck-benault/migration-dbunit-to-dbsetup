package net.franckbenault.migration.dbunittodbsetup;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBUnitToDbSetupTest {

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
	public void testMigration() {
		DBUnitToDbSetup migration = new DBUnitToDbSetup();
		int res = migration.migration(null, "target/myFile.txt");
		assertTrue(res==0);
	}

}
