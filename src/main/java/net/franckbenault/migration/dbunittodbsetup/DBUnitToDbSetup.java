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
		
		//IMPORT
		String importString = "import static com.ninja_squad.dbsetup.Operations.*;\n";
		String importString2 = "import com.ninja_squad.dbsetup.operation.Operation;\n\n";
		FileUtils.writeToFile(outputFile, importString, false);
		FileUtils.writeToFile(outputFile, importString2, true);
		
		//HEADER
		String header = "public class DBSetupCommonOperations {\n";
		FileUtils.writeToFile(outputFile, header, true);
		
		//read folder list of xml files
	    String operation = "\tpublic static final Operation insertVendorsAndProducts%s =\n \tsequenceOf();\n\n";
		List<File> files = FileUtils.listOfFiles(inputFolder);
		
		int counter =0;
		for(File file : files) {
			counter++;
			FileUtils.writeToFile(outputFile,String.format(operation,counter), true);			
		}
		
		//FOOTER
		FileUtils.writeToFile(outputFile,"}", true);		
		

	
		return 0;
	}

}
