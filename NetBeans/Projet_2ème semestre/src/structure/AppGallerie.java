package structure;



import java.io.Serializable;
import java.util.ArrayList;


public class AppGallerie implements Serializable{

	private String DOSSIER = "src/photos/";
	private String EXTENSION = ".jpg";
	
	private ArrayList<String> fichiers= new ArrayList<String>();
	private list_directory photos = new list_directory(DOSSIER, EXTENSION);
	
	
	
	public String getDOSSIER() {
		return DOSSIER;
	}
	public void setDOSSIER(String dOSSIER) {
		DOSSIER = dOSSIER;
	}
	public String getEXTENSION() {
		return EXTENSION;
	}
	public void setEXTENSION(String eXTENSION) {
		EXTENSION = eXTENSION;
	}
	public list_directory getPhotos() {
		return photos;
	}
	public void setPhotos(list_directory photos) {
		this.photos = photos;
	}
	public ArrayList<String> getFichiers() {
		return fichiers;
	}
	public void setFichiers(ArrayList<String> fichiers) {
		this.fichiers = fichiers;
	}
	public AppGallerie(){
		fichiers = list_directory.listFileNames(DOSSIER, EXTENSION);
	}
    public void addC() {
    }

    public void deleteC() {
    }

    public void afficheUnit() 
    {
    	
    }
    
}