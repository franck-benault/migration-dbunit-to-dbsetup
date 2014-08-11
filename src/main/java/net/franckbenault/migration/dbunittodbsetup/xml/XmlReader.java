package net.franckbenault.migration.dbunittodbsetup.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XmlReader {

	
	public static List<String> getTablesNames(String pathFileName) {
		
		List<String> output = new ArrayList<String>();
		
		SAXBuilder sxb = new SAXBuilder();
		org.jdom2.Document document = null;
		try {
			document = sxb.build(new File(pathFileName));
		} catch (Exception e) {
		}

		Element racine = document.getRootElement();
		List<Element> listTables = racine.getChildren("table");
		for (Element courant : listTables) {
			
			output.add(courant.getAttributeValue("name"));
		}
		return output;
		
	}
	
	public static List<String> getTableColumns(String tableName, String pathFileName) {
		
		List<String> output = new ArrayList<String>();
		
		SAXBuilder sxb = new SAXBuilder();
		org.jdom2.Document document = null;
		try {
			document = sxb.build(new File(pathFileName));
		} catch (Exception e) {
		}

		Element racine = document.getRootElement();
		List<Element> listTables = racine.getChildren("table");

		for (Element courant : listTables) {
			if(courant.getAttributeValue("name").equals(tableName)) {
				List<Element> columns = courant.getChildren("column");
				//System.out.println(columns.size());
				for(Element column : columns) {
					output.add(column.getValue());
				}
			}
		}
		return output;
		
	}
	

	public static List<List<String>> getTableRowValues(String tableName, String pathFileName) {
		
		List<List<String>> output = new ArrayList<List<String>>();
		
		SAXBuilder sxb = new SAXBuilder();
		org.jdom2.Document document = null;
		try {
			document = sxb.build(new File(pathFileName));
		} catch (Exception e) {
		}

		Element racine = document.getRootElement();
		List<Element> listTables = racine.getChildren("table");

		for (Element courant : listTables) {
			if(courant.getAttributeValue("name").equals(tableName)) {
				List<Element> rows = courant.getChildren("row");
				//System.out.println(columns.size());
				for(Element row : rows) {
					List<Element> values = row.getChildren();
					List<String> listValues = new ArrayList<String>();
					for(Element value: values) {
						if (value.getName().equals("value"))
							listValues.add(value.getValue());
						else if(value.getName().equals("null")) {
							listValues.add("NULL");							
						}
					}
					output.add(listValues);
				}
			}
		}
		return output;
		
	}
	
	//static org.jdom2.Document document;
	//static Element racine;
}
