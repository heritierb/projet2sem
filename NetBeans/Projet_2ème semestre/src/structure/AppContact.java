package structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.UUID.randomUUID;

public class AppContact implements Serializable {
    
    // **** DECLARATION LISTE DYNAMIQUE DE CONTACTS **** //
    public ArrayList<Contact> arrayContacts = new ArrayList<Contact>();
    
    // **** AJOUTE UN CONTACT **** //
    public void addC(Contact contact) {
        arrayContacts.add(contact);
        // **** affichage de la liste **** //
        //        for (Contact c : arrayContacts) {
        //            System.out.println("Prenom : " + c.getPrenom()+ " || Nom : " + c.getNom());
        //        }
    }
    // **** SUPPRIME UN CONTACT **** //
    public void deleteC(Contact contact) {
        arrayContacts.remove(contact);
    }
    // **** EDITER LES INFORMATIONS D'UN CONTACT **** //
    public void edit() {

    }
    // **** GETTERS&SETTERS **** //
    public ArrayList<Contact> getArrayContacts() {
        return arrayContacts;
    }
    public void setArrayContacts(ArrayList<Contact> arrayContacts) {
        this.arrayContacts = arrayContacts;
    }

}
