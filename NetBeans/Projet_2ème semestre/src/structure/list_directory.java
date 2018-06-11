package structure;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class List_directory {
	
	private ArrayList<String> fichiers;

	int nb_items;
	String dossier;
	String extension;
	ImageIcon imageI;

	public List_directory(String dossier, String extension, ImageIcon imageI) {
		this.dossier=dossier;
		this.extension=extension;
		this.imageI=imageI;
		
	}


	public ImageIcon getImageI() {
		return imageI;
	}


	public void setImageI(ImageIcon imageI) {
		this.imageI = imageI;
	}


	public String getDossier() {
		return dossier;
	}


	public void setDossier(String dossier) {
		this.dossier = dossier;
	}


	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
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
