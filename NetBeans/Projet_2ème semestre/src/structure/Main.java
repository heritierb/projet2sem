package structure;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args)throws FileNotFoundException, UnknownHostException{
        
        
    ArrayList arrayContacts = new ArrayList();
    
    Object[][] tableau = new Object[arrayContacts.size()][4];
    
    Contact c1 = new Contact("1", "2", "3", "4", "5", "6", "7");
    Contact c2 = new Contact("1", "2", "3", "4", "5", "6", "7");
       
    arrayContacts.add(c1);
    arrayContacts.toString();
        for (int i = 0; i < arrayContacts.size(); i++) {
            ArrayList ligne = (ArrayList)arrayContacts.get(i);
            for (int j = 0; j < ligne.size(); j++) {
                System.out.println(ligne.get(j)+"\n");
            }
        }
    }
    
}
