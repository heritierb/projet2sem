package structure;



import java.io.Serializable;
import java.util.ArrayList;


public class AppGallerie implements Serializable{

	private String DOSSIER = "src/photos/";
	private String EXTENSION = ".jpg";
	
	public ArrayList<List_directory> fichiers= new ArrayList<List_directory>();
//	private List_directory photos = new List_directory(DOSSIER, EXTENSION);
	
	
	
	public String getDOSSIER() {
		return DOSSIER;
	}
//	public void setDOSSIER(String dOSSIER) {
//		DOSSIER = dOSSIER;
//	}
//	public String getEXTENSION() {
//		return EXTENSION;
//	}
////	public void setEXTENSION(String eXTENSION) {
////		EXTENSION = eXTENSION;
//	}
//	public List_directory getPhotos() {
//		return photos;
//	}
//	public void setPhotos(List_directory photos) {
//		this.photos = photos;
//	}
	public ArrayList<List_directory> getFichiers() {
		return fichiers;
	}
	public void setFichiers(ArrayList<List_directory> fichiers) {
		this.fichiers = fichiers;
	}
	
//	public AppGallerie(){
//		fichiers = list_directory.listFileNames(DOSSIER, EXTENSION);
//	}
    public void addI(List_directory ld) {
    	fichiers.add(ld);
    }

    public void deleteI(List_directory ld) {
    	fichiers.remove(ld);
    }

    public void afficheUnit() 
    {
    	
    }
    
}