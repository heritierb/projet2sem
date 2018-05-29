package structure;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import graphisme.GUITelephone;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    
    public static void main(String[] args){
        // **** INSTANCE DES APPLICATIONS **** // + deserialisation
        AppContact contactA = new AppContact();
        contactA = deserializeObject();      
        AppGallerie gallerieA = new AppGallerie();
        
        // **** LANCE LE PROGRAMME **** //
        GUITelephone tel = new GUITelephone(contactA, gallerieA);
        tel.setVisible(true);
    }
        // **** RECUPERE L'INSTANCE contactB DU FICHIER DE SAUVEGARDE **** //
        public static AppContact deserializeObject() {
        try {
            AppContact contactB = new AppContact();
            FileInputStream fichier = new FileInputStream("src/svg.ser");
            ObjectInputStream obfichier = new ObjectInputStream(fichier);
            contactB = (AppContact)obfichier.readObject();
            if(contactB != null)
            System.out.println(contactB.arrayContacts.size());
            obfichier.close();
            return contactB;
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
        }
        return null;
    }
}
