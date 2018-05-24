package structure;
import java.io.File;
import java.util.ArrayList;

class list_directory {
	
	private ArrayList<String> fichiers;

	int nb_items;

	list_directory(String dossier, String extension) {
		fichiers = listFileNames(dossier, extension);
		nb_items = fichiers.size();
	}


	public static ArrayList<String> listFileNames(String dir, String extension) {
		File file = new File(dir);
		if (file.isDirectory()) {
			String names[] = file.list();

			ArrayList<String> names_ok = new ArrayList<>();
			for (int i = 0; i < names.length; i++) {
				String m1 = names[i].concat(extension);
				if (m1 != null) {
					names_ok.add(names[i]);
				}
			}
			
			return names_ok;
			
		} else {
			
			System.out.println("le nom fourni n'est pas celui d'un dossier");
			return null;
		}
	}


	public ArrayList<String> getFichiers() {
		return fichiers;
	}


	
}