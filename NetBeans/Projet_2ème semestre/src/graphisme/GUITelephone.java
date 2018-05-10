package graphisme;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUITelephone extends JFrame{

	public GUITelephone() {
		JFrame fen = new JFrame("Téléphone");
		ImagePanel fondecran = new ImagePanel();
		ImageIcon gallerie = new ImageIcon(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/gallerie.jpg");
		JButton Gallerie = new JButton(gallerie);
	
		ImageIcon contact = new ImageIcon(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/contact.jpg");
		
		JButton Contact = new JButton(contact);
		Image hu = contact.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		contact = new ImageIcon(hu);
	
		
		
		fen.setPreferredSize(new Dimension(480, 800));
		Gallerie.setPreferredSize(new Dimension(100, 100));
		Contact.setPreferredSize(new Dimension(100, 100));
		
		fondecran.add(Gallerie);
		fondecran.add(Contact);
		
		fen.add(fondecran);
		fen.setResizable(false);
		fen.pack();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
	}
	             


}
