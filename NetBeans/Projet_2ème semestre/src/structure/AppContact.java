package structure;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class AppContact extends App implements Serializable{
    
    //0.ID 1.Nom 2.Prenom 3.Numero 4.Email 5.Adresse 6.Anni 7.Groupe
    private String dossierContacts;        


    private ArrayList<Contact> arrayContacts = new ArrayList<>();
    
    Object[][] tableau = new Object[arrayContacts.size()][4];
 
    public void add() {
        for (int i = 0; i < arrayContacts.size(); i++) {
            arrayContacts.add();
        }
 
    }
    public void delete() {
        for (int i = 0; i < arrayContacts.size(); i++) {
            arrayContacts.remove(1);
        }
        
    }
    public void afficheUnit() {
           
    }
    public void edit(){
        
    }
    
    public String getDossierContacts() {
        return dossierContacts;
    }

    public void setDossierContacts(String dossierContacts) {
        this.dossierContacts = dossierContacts;
    }

    public ArrayList<Contact> getArrayContacts() {
        return arrayContacts;
    }

    public void setArrayContacts(ArrayList<Contact> arrayContacts) {
        this.arrayContacts = arrayContacts;
    }
 
}
