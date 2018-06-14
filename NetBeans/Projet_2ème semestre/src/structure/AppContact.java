package structure;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

import java.io.Serializable;
import java.util.ArrayList;

/**
 * POLYMORPHISME : AJOUT/SUPPR/EDIT DANS UNE LISTE DE CONTACTS
 *
 * @author ben
 */
public class AppContact implements AppAll, Serializable {

    /**
     * DECLARATION LISTE DYNAMIQUE DE CONTACTS
     */
    public ArrayList<Contact> arrayContacts = new ArrayList<Contact>();

    /**
     * AJOUTE UN CONTACT
     *
     * @param o
     */
    public void addCI(Object o) {
        Contact contact = (Contact) o;
        arrayContacts.add(contact);
        // **** affichage de la liste **** //
        //        for (Contact c : arrayContacts) {
        //            System.out.println("Prenom : " + c.getPrenom()+ " || Nom : " + c.getNom());
        //        }
    }

    /**
     * SUPPRIME UN CONTACT
     *
     * @param o
     */
    public void deleteCI(Object o) {
        Contact contact = (Contact) o;
        arrayContacts.remove(contact);
    }

    /**
     * EDITER LES INFORMATIONS D'UN CONTACT
     *
     * @param contact
     */
    public void editCI(Contact contact) {
        arrayContacts.set(arrayContacts.indexOf(contact), contact);
    }

    public ArrayList<Contact> getArrayContacts() {
        return arrayContacts;
    }

    public void setArrayContacts(ArrayList<Contact> arrayContacts) {
        this.arrayContacts = arrayContacts;
    }

}
