package net.franckbenault.migration.dbunittodbsetup;

import java.io.File;
import java.util.List;

import net.franckbenault.migration.dbunittodbsetup.xml.XmlReader;

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
	    String operationHeader = "\tpublic static final Operation %s =\n \tOperations.sequenceOf(\n";
	    String operationDelete = "\tOperations.deleteAllFrom(%s)";
	    String operationInsertInto = "\tOperations.insertInto(\"%s\")\n";
	    String operationColumns = "\t.columns(%s)\n";
	    String operationValues = "\t.values(%s)\n";
	    String operationBuild = "\t.build()";
	    String operationFooter = ");\n\n";
	    List<File> files = FileUtils.listOfXMLFiles(inputFolder);
		
		for(File file : files) {
			FileUtils.writeToFile(outputFile,String.format(operationHeader,getOperationName(file.getName())), true);
			List<String> tables = XmlReader.getTablesNames(file.getAbsolutePath());
			String tablesString = ListUtils.listToString(tables);
			FileUtils.writeToFile(outputFile,String.format(operationDelete,tablesString) , true);
			
			for(String tableName: tables) {
				List<String> columns = XmlReader.getTableColumns(tableName, file.getAbsolutePath());
				if(!columns.isEmpty()) {
					FileUtils.writeToFile(outputFile,",\n", true);
					String columnsString = ListUtils.listToString(columns);					
					FileUtils.writeToFile(outputFile,String.format(operationInsertInto,tableName) , true);
					FileUtils.writeToFile(outputFile,String.format(operationColumns,columnsString) , true);
					List<List<String>> rows = XmlReader.getTableRowValues(tableName, file.getAbsolutePath());
	
					for(List<String> row : rows) {
						String rowString = ListUtils.listToStringWithNull(row,columns.size());
						FileUtils.writeToFile(outputFile,String.format(operationValues,rowString) , true);					
					}
					
					FileUtils.writeToFile(outputFile,operationBuild, true);
					
				}
			}
			
			FileUtils.writeToFile(outputFile,operationFooter, true);			
			
		}
		
		//FOOTER
		FileUtils.writeToFile(outputFile,"}", true);		
		

	
		return 0;
	}
	
	public String getOperationName(String xmlFileName) {
		
		return StringUtils.removePointAddProperCase(xmlFileName);
	}

}
