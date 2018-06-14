package junit;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import static junit.framework.Assert.assertEquals;
import structure.AppContact;
import structure.Contact;

public class AppContactTest {

    AppContact appcontactTest = new AppContact();
    ImageIcon imageTest = new ImageIcon();
    JTextField txt = new JTextField("Test");
    Contact contactTest1 = new Contact(txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), imageTest);
    Contact contactTest2 = new Contact(txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), imageTest);
    Contact contactTest3 = new Contact(txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), imageTest);
    Contact contactTest4 = new Contact(txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), txt.getText(), imageTest);

    
    
    public void init() {
        // appcontactTest.arrayContacts.add("Test Prénom 1","Test Nom 1", "Test Numéro 1", "Test Email 1", "Test Adresse 1", "Test Anniversaire 1", "Test Groupe 1", imageTest);

        appcontactTest.arrayContacts.add(contactTest1);
        appcontactTest.arrayContacts.add(contactTest2);
        appcontactTest.arrayContacts.add(contactTest3);

    }

    public void testSize() {
        assertEquals("Taille du tableau", 3, appcontactTest.arrayContacts.size());
    }

    public void testAdd() {

        appcontactTest.arrayContacts.add(contactTest4);

        assertEquals("1 contact rajouté", 4, appcontactTest.arrayContacts.size());

    }

    public void testRemove() {

        appcontactTest.arrayContacts.remove(contactTest4);

        assertEquals("1 contact enlevé", 3, appcontactTest.arrayContacts.size());

    }
        public void testEdit() {

        appcontactTest.arrayContacts.get(1).setPrenom("prénom modifié");

        assertEquals("1 contact modifié", "prénom modifié", appcontactTest.arrayContacts.get(1).getPrenom());

    }
}
