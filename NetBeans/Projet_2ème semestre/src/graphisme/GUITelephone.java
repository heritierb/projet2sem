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

public class GUITelephone extends JFrame {

	public GUITelephone() {
		JFrame fen = new JFrame("Téléphone");
		ImagePanel fondecran = new ImagePanel();

		ImageIcon ImageContact = new ImageIcon(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/contact.jpg");
		Image ImageContactRedim = ImageContact.getImage().getScaledInstance(
				100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageContact = new ImageIcon(ImageContactRedim);
		JButton BoutonContact = new JButton(ImageContact);

		ImageIcon ImageGallerie = new ImageIcon(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/gallerie.jpg");
		Image ImageGallerieRedim = ImageGallerie.getImage().getScaledInstance(
				100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageGallerie = new ImageIcon(ImageGallerieRedim);
		JButton BoutonGallerie = new JButton(ImageGallerie);

		fen.setPreferredSize(new Dimension(480, 800));
		BoutonGallerie.setPreferredSize(new Dimension(100, 100));
		BoutonContact.setPreferredSize(new Dimension(100, 100));

		fondecran.add(BoutonGallerie);
		fondecran.add(BoutonContact);

		fen.add(fondecran);
		fen.setResizable(false);
		fen.pack();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
	}

}
