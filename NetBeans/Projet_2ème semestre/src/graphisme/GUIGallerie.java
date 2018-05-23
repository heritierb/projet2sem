package graphisme;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GUIGallerie extends JPanel {
	static int TAILLE_BOUTON = 100;
	static String DOSSIER = "src/photos/";
	static String EXTENSION = ".jpg";
	private ImagePanel gallerie = new ImagePanel(new ImageIcon(
			"src/images/wallpaper2.png"));
	private int nb_items;
	private ArrayList<String> fichiers;
	private list_directory photos = new list_directory(DOSSIER, EXTENSION);

	public GUIGallerie(GUITelephone guit) {

		//Pour chaque image du dossier, céer un bouton
		fichiers = list_directory.listFileNames(DOSSIER, EXTENSION);
		nb_items = fichiers.size();
		for (int i = 0; i < nb_items; i++) {
			JButton cpt = CreationBoutonImage((String) photos.getFichiers()
					.get(i));
			gallerie.add(cpt);
		}
		
		//Affichage de la gallerie
		gallerie.setLayout(new FlowLayout());
		gallerie.setOpaque(false);
		gallerie.setPreferredSize(new Dimension(480, 683));
		add(gallerie);

	}

	public static JButton CreationBoutonImage(String name) {
		ImageIcon imageBouton;
		Image imageBoutonRedim;
		JButton bouton;

		//un bouton a comme icon une image dans le dossier
		imageBoutonRedim = new ImageIcon(DOSSIER.concat(name)).getImage().getScaledInstance(
				TAILLE_BOUTON, TAILLE_BOUTON, java.awt.Image.SCALE_SMOOTH);
		imageBouton = new ImageIcon(imageBoutonRedim);
		bouton = new JButton(imageBouton);

		return bouton;
	}

}
