package net.franckbenault.migration.dbunittodbsetup;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

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
	
	private void deleteFile(String filePathString) {
		File file = new File(filePathString); 
		file.delete();
	}
	
	private void checkFileExist(String filePathString) {
		File f = new File(filePathString);
		if(!f.exists() || f.isDirectory()) { 
			fail("file not found");
		}
	}

	@Test
	public void testWriteToFile() {
		//how to check the content of a file ?
		String filePathString = "target/myFile.txt";
		deleteFile(filePathString);
		
		FileUtils.writeToFile(filePathString, "texte",false);
		
		checkFileExist(filePathString);
	}
	
	@Test
	public void testListOfFiles() {
		List<File> res =FileUtils.listOfFiles("./src/test/resources");
		assertNotNull(res);
		assertEquals(res.size(),3);
		
	}

}
