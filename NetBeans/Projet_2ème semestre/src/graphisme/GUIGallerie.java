package graphisme;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIGallerie {
	String dossier = "F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/photos";
	String extension = ".jpg";
	ArrayList<String> fichiers;
	int nb_items;
	int cpt = 0;
	list_directory photos = new list_directory(dossier, extension);

	GUIGallerie() {
		JFrame fen = new JFrame("Gallerie");
		JPanel pan = new JPanel();
		fichiers = list_directory.listFileNames(dossier, extension);
		nb_items = fichiers.size();

		for (int i = 0; i < nb_items; i++) {
			cpt++;

			JButton cpt = CreationBoutonImage((String) photos.getFichiers().get(i));
			pan.add(cpt);
		}

		fen.add(pan);
		fen.pack();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);

	}

	public static JButton CreationBoutonImage(String name) {

		ImageIcon ImageBouton = new ImageIcon(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/photos/"
						.concat(name));
		Image ImageBoutonRedim = ImageBouton.getImage().getScaledInstance(100,
				100, java.awt.Image.SCALE_SMOOTH);
		ImageBouton = new ImageIcon(ImageBoutonRedim);
		JButton Bouton = new JButton(ImageBouton);

		return Bouton;
	}
}
