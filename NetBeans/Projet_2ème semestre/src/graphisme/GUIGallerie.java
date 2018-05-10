package graphisme;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIGallerie extends JFrame {
	private static int TAILLE_BOUTON = 100;
	private static String DOSSIER = "F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/photos";
	private String EXTENSION = ".jpg";
	private ArrayList<String> fichiers;
	private int nb_items;
	private list_directory photos = new list_directory(DOSSIER, EXTENSION);
	private JFrame fen = new JFrame("Gallerie");
	private JPanel pan = new JPanel();

	public GUIGallerie() {
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fichiers = list_directory.listFileNames(DOSSIER, EXTENSION);
		nb_items = fichiers.size();

		for (int i = 0; i < nb_items; i++) {
			JButton cpt = CreationBoutonImage((String) photos.getFichiers()
					.get(i));
			pan.add(cpt);
		}

		fen.add(pan);
		fen.pack();
		fen.setVisible(true);

	}

	public static JButton CreationBoutonImage(String name) {
		ImageIcon imageBouton;
		Image imageBoutonRedim;
		JButton bouton;
		imageBouton = new ImageIcon(DOSSIER.concat(name));
		imageBoutonRedim = imageBouton.getImage().getScaledInstance(
				TAILLE_BOUTON, TAILLE_BOUTON, java.awt.Image.SCALE_SMOOTH);
		imageBouton = new ImageIcon(imageBoutonRedim);
		bouton = new JButton(imageBouton);

		return bouton;
	}
}
