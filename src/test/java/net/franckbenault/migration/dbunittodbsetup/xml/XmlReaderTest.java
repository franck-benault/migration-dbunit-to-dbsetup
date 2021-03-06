package net.franckbenault.migration.dbunittodbsetup.xml;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class XmlReaderTest {

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
	public void testGetTablesNames_file1() {
		List<String> res =XmlReader.getTablesNames("./src/test/resources/file1.xml");
		assertNotNull(res);
		assertEquals(res.size(),1);
	}
	
	@Test
	public void testGetTablesNames_file2() {
		List<String> res =XmlReader.getTablesNames("./src/test/resources/file2.xml");
		assertNotNull(res);
		assertEquals(res.size(),2);
		assertTrue(res.contains("USERS"));
	}
	
	
	@Test
	public void testGetTablesColumns_file1_SettleAcquirers() {
		List<String> res =XmlReader.getTableColumns("SETTLE_ACQUIRERS", "./src/test/resources/file1.xml");
		assertNotNull(res);
		assertEquals(res.size(),3);
		assertTrue(res.contains("ACQ_COMMENT"));
	}

	@Test
	public void testGetTablesColumns_file2_Users() {
		List<String> res =XmlReader.getTableColumns("USERS", "./src/test/resources/file2.xml");
		assertNotNull(res);
		assertEquals(res.size(),2);
		assertTrue(res.contains("NAME"));
	}
	
	@Test
	public void testGetTablesRowValues_file1_SettleAcquirers() {
		List<List<String>> res =XmlReader.getTableRowValues("SETTLE_ACQUIRERS", "./src/test/resources/file1.xml");
		assertNotNull(res);
		assertEquals(res.size(),1);
		assertEquals(res.get(0).size(),3);
		
		assertTrue(res.get(0).contains("CTC0"));
	}
	
	@Test
	public void testGetTablesRowValues_file2_Users() {
		List<List<String>> res =XmlReader.getTableRowValues("USERS", "./src/test/resources/file2.xml");
		assertNotNull(res);
		assertEquals(res.size(),2);
		assertEquals(res.get(0).size(),2);
		
		assertTrue(res.get(0).contains("01"));
	}
}
