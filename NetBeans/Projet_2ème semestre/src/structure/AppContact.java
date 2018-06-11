package structure;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

import java.io.Serializable;
import java.util.ArrayList;

// **** POLYMORPHISME : AJOUT/SUPPR/EDIT DANS UNE LISTE DE CONTACTS **** //
public class AppContact implements AppAll, Serializable {

    // **** DECLARATION LISTE DYNAMIQUE DE CONTACTS **** //
    public ArrayList<Contact> arrayContacts = new ArrayList<Contact>();

    // **** AJOUTE UN CONTACT **** //
    public void addCI(Object o) {
        Contact contact = (Contact) o;
        arrayContacts.add(contact);
        // **** affichage de la liste **** //
        //        for (Contact c : arrayContacts) {
        //            System.out.println("Prenom : " + c.getPrenom()+ " || Nom : " + c.getNom());
        //        }
    }

    // **** SUPPRIME UN CONTACT **** //
    public void deleteCI(Object o) {
        Contact contact = (Contact) o;
        arrayContacts.remove(contact);
    }

    // **** EDITER LES INFORMATIONS D'UN CONTACT **** //
    public void editCI(Contact contact) {
        arrayContacts.set(arrayContacts.indexOf(contact), contact);
    }

    // **** GETTERS&SETTERS **** //
    public ArrayList<Contact> getArrayContacts() {
        return arrayContacts;
    }

    public void setArrayContacts(ArrayList<Contact> arrayContacts) {
        this.arrayContacts = arrayContacts;
    }


}
