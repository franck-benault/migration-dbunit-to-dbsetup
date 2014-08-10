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
		try {
			document = sxb.build(new File(pathFileName));
		} catch (Exception e) {
		}

		racine = document.getRootElement();
		List<Element> listTables = racine.getChildren("table");
		for (Element courant : listTables) {
			
			output.add(courant.getAttributeValue("name"));
		}
		return output;
		
	}
	
	public static List<String> getTableColumns(String tableName, String pathFileName) {
		
		List<String> output = new ArrayList<String>();
		
		SAXBuilder sxb = new SAXBuilder();
		try {
			document = sxb.build(new File(pathFileName));
		} catch (Exception e) {
		}

		racine = document.getRootElement();
		List<Element> listTables = racine.getChildren("table");

		for (Element courant : listTables) {
			if(courant.getAttributeValue("name").equals(tableName)) {
				List<Element> columns = courant.getChildren("column");
				System.out.println(columns.size());
				for(Element column : columns) {
					output.add(column.getValue());
				}
			}
		}
		return output;
		
	}
	
	
	
	static org.jdom2.Document document;
	static Element racine;

	public static void main(String[] args) {
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File("./src/test/resources/file1.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du
		// document.
		racine = document.getRootElement();

		// Méthode définie dans la partie 3.2. de cet article
		afficheALL();
	}

	static void afficheALL() {
		// On crée une List contenant tous les noeuds "etudiant" de l'Element
		// racine
		List listTables = racine.getChildren("table");

		// On crée un Iterator sur notre liste
		Iterator i = listTables.iterator();
		while (i.hasNext()) {
			// On recrée l'Element courant à chaque tour de boucle afin de
			// pouvoir utiliser les méthodes propres aux Element comme :
			// sélectionner un nœud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			System.out.println(courant.toString());
			// On affiche le nom de l’élément courant
			System.out.println(courant.getAttributeValue("name"));
		}
	}
}
