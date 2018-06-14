package structure;
import java.io.Serializable;
import java.util.ArrayList;

public class AppGallerie implements Serializable{

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
    public void addI(Photo ld) {
    	fichiers.add(ld);
    }
    // **** suppression d'une photo **** //
    public void deleteI(Photo ld) {
    	fichiers.remove(ld);
    }

    
}
