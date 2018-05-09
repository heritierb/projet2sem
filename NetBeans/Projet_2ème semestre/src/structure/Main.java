package structure;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args){
        Phone gastonTel = new Phone();
        
        System.out.println("Chemin de sauvegarde : "+"C:\\Users\\ben\\OneDrive\\HES\\2eme semestre\\Fondements de la programmation\\NetBeans\\Projet_2ème semestre\\svg.ser");
        try {
		serializeObject(gastonTel);
		deserializeObject(gastonTel);
        } catch (IOException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    	private static void serializeObject(Phone gastonTel) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fichier = new FileOutputStream("C:\\Users\\ben\\OneDrive\\HES\\2eme semestre\\Fondements de la programmation\\NetBeans\\Projet_2ème semestre\\svg.ser");
		
		BufferedOutputStream bfichier = new BufferedOutputStream(fichier);
		
		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
		obfichier.writeObject(gastonTel);
		obfichier.close();
	}
    
	private static void deserializeObject(Phone gastonTel) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fichier = new FileInputStream("C:\\Users\\ben\\OneDrive\\HES\\2eme semestre\\Fondements de la programmation\\NetBeans\\Projet_2ème semestre\\svg.ser");
		BufferedInputStream bfichier = new BufferedInputStream(fichier);
		
		ObjectInputStream obfichier = new ObjectInputStream(bfichier);
		Phone gaston = (Phone)obfichier.readObject();
		System.out.println("deserializeObject : "+gaston);
		obfichier.close();
		
		
	}
}
