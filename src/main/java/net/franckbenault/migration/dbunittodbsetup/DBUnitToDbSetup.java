package net.franckbenault.migration.dbunittodbsetup;

import java.io.File;
import java.util.List;

public class DBUnitToDbSetup {
	
	/**
	 * 
	 * @param inputFolder
	 * @param outputFile
	 * @return (int) return code O for ok process
	 */
	public int migration(String inputFolder, String outputFile) {
		
		//HEADER
		String header = "public class DBSetupCommonOperations {\n";
		FileUtils.writeToFile(outputFile, header, false);
		
		//read folder list of xml files
	    String headerOperation = "public static final Operation insertVendorsAndProducts =\n sequenceOf(\n";
		List<File> files = FileUtils.listOfFiles("./src/test/resources");
		
		for(File file : files) {
			FileUtils.writeToFile(outputFile, headerOperation, true);			
		}
		
		//for each xml file
		//write operation
			//delete part
			//data part
	
		return 0;
	}

}
