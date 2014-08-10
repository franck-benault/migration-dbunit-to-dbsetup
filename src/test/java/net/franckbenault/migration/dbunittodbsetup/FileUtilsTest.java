package net.franckbenault.migration.dbunittodbsetup;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileUtilsTest {

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
	public void testWriteToFile() {
		FileUtils.writeToFile("target/myFile.txt", "texte");
	}
	
	@Test
	public void testListOfFiles() {
		FileUtils.listOfFiles("./src/test/resources");
	}

}
