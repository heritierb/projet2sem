package structure;

import java.io.Serializable;
import java.util.ArrayList;

public class AppContact extends App implements Serializable{

            
    ArrayList<Contact> arrayContacts = new ArrayList<Contact>();
    
    Object[][] tableau = new Object[arrayContacts.size()][4];
    
    Contact c1 = new Contact("1", "2", "3", "4", "5", "6", "7");
    Contact c2 = new Contact("1", "2", "3", "4", "5", "6", "7");
    
    
    
    public void add() {
        
    }
    public void delete() {
    }
    public void afficheUnit() {
        for (int i = 0; i < arrayContacts.size(); i++) {
            System.out.println(arrayContacts.get(i));
        }
        
    }
    public void edit(){
        
    }
 
}
