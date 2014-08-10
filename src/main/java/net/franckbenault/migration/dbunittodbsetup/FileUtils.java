package net.franckbenault.migration.dbunittodbsetup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	/**
	 * 
	 * @param folderName
	 * @return
	 */
	public static List<File> listOfFiles(String folderName) {

		List<File> files = new ArrayList<File>();
		File folder = new File(folderName);

		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				System.out.println(fileEntry.getName());
				files.add(fileEntry);
			}
		}

		return files;
	}

	public static List<File> listOfXMLFiles(String folderName) {

		List<File> files = new ArrayList<File>();

		List<File> filesAll = listOfFiles(folderName);
		for (final File fileEntry : filesAll) {
			if (fileEntry.getName().endsWith(".xml")) {
				files.add(fileEntry);
			}
		}

		return files;
	}

	public static void writeToFile(String nomFic, String texte,
			boolean appendMode) {
		// on va chercher le chemin et le nom du fichier et on me tout ca dans
		// un String
		String adressedufichier = System.getProperty("user.dir") + "/" + nomFic;

		// on met try si jamais il y a une exception
		try {
			/**
			 * BufferedWriter a besoin d un FileWriter, les 2 vont ensemble, on
			 * donne comme argument le nom du fichier true signifie qu on ajoute
			 * dans le fichier (append), on ne marque pas par dessus
			 */
			FileWriter fw = new FileWriter(adressedufichier, appendMode);

			// le BufferedWriter output auquel on donne comme argument le
			// FileWriter fw cree juste au dessus
			BufferedWriter output = new BufferedWriter(fw);

			// on marque dans le fichier ou plutot dans le BufferedWriter qui
			// sert comme un tampon(stream)
			output.write(texte);
			// on peut utiliser plusieurs fois methode write

			output.flush();
			// ensuite flush envoie dans le fichier, ne pas oublier cette
			// methode pour le BufferedWriter

			output.close();

		} catch (IOException ioe) {
			System.out.print("Error: ");
			ioe.printStackTrace();
		}
	}
}
