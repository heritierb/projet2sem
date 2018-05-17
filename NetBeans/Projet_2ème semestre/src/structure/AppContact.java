package structure;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.UUID.randomUUID;

public abstract class AppContact implements Serializable{
    
    //0.ID 1.Nom 2.Prenom 3.Numero 4.Email 5.Adresse 6.Anni 7.Groupe
    //Contact contact = new Contact(randomUUID(), "2", "3", "4", "5", "6", "7", "8");

    private ArrayList<Contact> arrayContacts = new ArrayList<>();
    
    Object[][] tableau = new Object[arrayContacts.size()][4];
 
    public void addC(Contact contactC) {
        for (int i = 0; i < arrayContacts.size(); i++) {
            arrayContacts.add(contactC);
        }
 
    }
    public void deleteC(Contact contactC) {
        for (int i = 0; i < arrayContacts.size(); i++) {
            arrayContacts.remove(contactC);
        }
        
    }
    public void afficheUnit() {
           
    }
    public void edit(){
        
    }

    public ArrayList<Contact> getArrayContacts() {
        return arrayContacts;
    }

    public void setArrayContacts(ArrayList<Contact> arrayContacts) {
        this.arrayContacts = arrayContacts;
    }
 
}
