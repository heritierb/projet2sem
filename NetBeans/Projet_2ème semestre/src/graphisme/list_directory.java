package graphisme;
import java.io.File;
import java.util.ArrayList;

class list_directory {
	String extension;
	ArrayList<String> fichiers;
	String dossier;
	int nb_items;

	// constructeur
	list_directory(String dossier, String extension) {
		this.dossier = dossier;
		this.extension = extension;
		fichiers = listFileNames(dossier, extension);
		nb_items = fichiers.size();
		System.out.println(fichiers.size() + "elements");
	}

	public ArrayList<String> getFichiers() {
		return fichiers;
	}

	private ArrayList<String> listFileNames(String dir, String extension) {
		File file = new File(dir);
		if (file.isDirectory()) {
			String names[] = file.list();

			// procedure d'elimination des fichiers non concernés
			ArrayList<String> names_ok = new ArrayList<>();
			for (int i = 0; i < names.length; i++) {
				String m1 = names[i].concat(extension);
				if (m1 != null) {
					names_ok.add(names[i]);
				}
			}
			return names_ok;
		} else {
			// If it's not a directory
			System.out.println("le nom fourni n'est pas celui d'un dossier");
			return null;
		}
	}
}