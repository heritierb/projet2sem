package structure;

import graphisme.GUITelephone;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args){
        GUITelephone tel = new GUITelephone();
        tel.setVisible(true);
        try {
                deserializeObject(tel);
                
//            if(tel.getSerialisation() == true){
//                serializeObject(tel);
//                System.out.println("test seri");
//            }

//                System.out.println("Chemin de sauvegarde : "+"src/svg.ser");
		
        } catch (IOException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    	public static void serializeObject(GUITelephone tel) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		FileOutputStream fichier = new FileOutputStream("src/svg.ser");
		BufferedOutputStream bfichier = new BufferedOutputStream(fichier);
		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
		obfichier.writeObject(tel);
		obfichier.close();
	}
    
	private static void deserializeObject(GUITelephone tel) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fichier = new FileInputStream("src/svg.ser");
		BufferedInputStream bfichier = new BufferedInputStream(fichier);
		ObjectInputStream obfichier = new ObjectInputStream(bfichier);
		GUITelephone telsvg = (GUITelephone)obfichier.readObject();
		obfichier.close();
		
		
	}
}
