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

    public ArrayList<Contact> arrayContacts = new ArrayList<Contact>();
    public void addC(Contact contact) {
        arrayContacts.add(contact);
//        for (Contact c : arrayContacts) {
//            System.out.println("nom : " + c.getPrenom());
//        }
    }

    public void deleteC(Contact contact) {
        arrayContacts.remove(contact);
    }

    public void affichePrenom() {

    }

    public void edit() {

    }

    public ArrayList<Contact> getArrayContacts() {
        return arrayContacts;
    }

    public void setArrayContacts(ArrayList<Contact> arrayContacts) {
        this.arrayContacts = arrayContacts;
    }

}
