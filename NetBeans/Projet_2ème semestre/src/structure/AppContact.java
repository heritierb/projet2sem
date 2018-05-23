package structure;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.UUID.randomUUID;

public abstract class AppContact implements Serializable{
    

    public ArrayList<Contact> arrayContacts = new ArrayList<Contact>();
 
    public void addC(Contact contact) {
            arrayContacts.add(contact);
            System.out.println(contact.getPrenom()+" "+contact.getNom()+" : contact enregistré");
    }
    public void deleteC(Contact contact) {
            arrayContacts.remove(contact);
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