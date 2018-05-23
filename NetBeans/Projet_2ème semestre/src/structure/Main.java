package structure;

import graphisme.GUITelephone;

public class Main {
    
    public static void main(String[] args){
        AppContact contactA = new AppContact();
        GUITelephone tel = new GUITelephone(contactA);
        
        tel.setVisible(true);
    }
}
