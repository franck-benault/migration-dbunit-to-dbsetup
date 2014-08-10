package net.franckbenault.migration.dbunittodbsetup.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XmlReader {

	static org.jdom2.Document document;
	static Element racine;

	public static void main(String[] args) {
		// On cr�e une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On cr�e un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est termin� ;)
			document = sxb.build(new File("Exercice2.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel �l�ment racine avec l'�l�ment racine du
		// document.
		racine = document.getRootElement();

		// M�thode d�finie dans la partie 3.2. de cet article
		afficheALL();
	}

	static void afficheALL() {
		// On cr�e une List contenant tous les noeuds "etudiant" de l'Element
		// racine
		List listEtudiants = racine.getChildren("etudiant");

		// On cr�e un Iterator sur notre liste
		Iterator i = listEtudiants.iterator();
		while (i.hasNext()) {
			// On recr�e l'Element courant � chaque tour de boucle afin de
			// pouvoir utiliser les m�thodes propres aux Element comme :
			// s�lectionner un n�ud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			// On affiche le nom de l��l�ment courant
			System.out.println(courant.getChild("nom").getText());
		}
	}
}
