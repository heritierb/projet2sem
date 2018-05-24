package structure;

import graphisme.GUITelephone;

public class Main {
    
    public static void main(String[] args){
        AppContact contactA = new AppContact();
        AppGallerie gallerieA = new AppGallerie();
        GUITelephone tel = new GUITelephone(contactA, gallerieA);
        
        tel.setVisible(true);
    }
}
