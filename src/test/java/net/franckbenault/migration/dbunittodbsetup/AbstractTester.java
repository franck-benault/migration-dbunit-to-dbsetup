package net.franckbenault.migration.dbunittodbsetup;

import static org.junit.Assert.*;

import java.io.File;


public class AbstractTester {

	protected void deleteFile(String filePathString) {
		File file = new File(filePathString); 
		file.delete();
	}
	
	protected void checkFileExist(String filePathString) {
		File f = new File(filePathString);
		if(!f.exists() || f.isDirectory()) { 
			fail("file not found");
		}
	}
}