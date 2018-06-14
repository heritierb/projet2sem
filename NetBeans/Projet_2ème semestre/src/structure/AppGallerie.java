package structure;
import java.io.Serializable;
import java.util.ArrayList;

public class AppGallerie implements AppAll, Serializable{

	private String DOSSIER = "src/photos/";
	private String EXTENSION = ".jpg";
	
	public ArrayList<Photo> fichiers= new ArrayList<Photo>();
	// **** getter and setters**** //
	public String getDOSSIER() {
		return DOSSIER;
	}
	
	public ArrayList<Photo> getFichiers() {
		return fichiers;
	}
	public void setFichiers(ArrayList<Photo> fichiers) {
		this.fichiers = fichiers;
	}
	// **** ajout d'une photo **** //
    public void addCI(Object o) {
        Photo ld = (Photo) o;
    	fichiers.add(ld);
    }
    // **** suppression d'une photo **** //
    public void deleteCI(Object o) {
        Photo ld = (Photo) o;
    	fichiers.remove(ld);
    }

    
}
