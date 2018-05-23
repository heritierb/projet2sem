package graphisme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIGallerie extends JPanel {
	private ImagePanel gallerie = new ImagePanel(new ImageIcon(
			"src/images/wallpaper2.png"));
	private GUITelephone guit;

	int TAILLE_BOUTON = 100;
	int nb_items;

	static String DOSSIER = "src/photos/";
	String EXTENSION = ".jpg";
	ArrayList<String> fichiers;
	list_directory photos = new list_directory(DOSSIER, EXTENSION);
	JFrame fen = new JFrame("Gallerie");
	JPanel panelSouth = new JPanel();
	JButton home = new JButton("Home");

	public GUIGallerie(GUITelephone guit) {
		this.guit = guit;
		setLayout(new GridLayout(10, 3));

		fichiers = list_directory.listFileNames(DOSSIER, EXTENSION);
		nb_items = fichiers.size();

		for (int i = 0; i < nb_items; i++) {
			JButton cpt = CreationBoutonImage((String) photos.getFichiers()
					.get(i));
			gallerie.add(cpt);
		}

		add(gallerie);

	}

	public static JButton CreationBoutonImage(String name) {
		ImageIcon imageBouton;
		Image imageBoutonRedim;
		JButton bouton;

		imageBouton = new ImageIcon(DOSSIER.concat(name));
		imageBoutonRedim = imageBouton.getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		imageBouton = new ImageIcon(imageBoutonRedim);
		bouton = new JButton(imageBouton);

		return bouton;
	}
}

