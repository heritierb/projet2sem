package Projet_2sem;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class App implements Serializable{

    private ArrayList<String> arrayContacts = new ArrayList<String>();
        
    
    public abstract void add();
    public abstract void delete();
    public abstract void afficheUnit();
    
}
