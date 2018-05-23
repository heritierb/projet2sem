package graphisme;

import javax.swing.JButton;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIGallerie extends JPanel {
	static int TAILLE_BOUTON = 100;
	static String DOSSIER = "src/photos/";
	static String EXTENSION = ".jpg";
	private GUITelephone guit = (GUITelephone) SwingUtilities
			.getAncestorOfClass(GUITelephone.class, GUIGallerie.this);
	private ImagePanel gallerie = new ImagePanel(new ImageIcon(
			"src/images/wallpaper2.png"));
	private ArrayList<String> fichiers;
	private list_directory photos = new list_directory(DOSSIER, EXTENSION);
	private static String imageAAfficher = "test";

	public GUIGallerie(GUITelephone guit) {
		this.guit = guit;
		// Pour chaque image du dossier, céer un bouton
		fichiers = list_directory.listFileNames(DOSSIER, EXTENSION);
		for (int i = 0; i < fichiers.size(); i++) {
			JButton cpt = CreationBoutonImage((String) photos.getFichiers()
					.get(i));

			cpt.setName((String) photos.getFichiers().get(i));
			gallerie.add(cpt);
			cpt.addActionListener(new ClickImage());
		}
		// Affichage de la gallerie
		gallerie.setLayout(new FlowLayout());
		gallerie.setOpaque(false);
		gallerie.setPreferredSize(new Dimension(480, 683));
		add(gallerie);

	}

	public static JButton CreationBoutonImage(String name) {
		ImageIcon imageBouton;
		Image imageBoutonRedim;
		JButton bouton;

		// un bouton a comme icon une image dans le dossier
		imageBoutonRedim = new ImageIcon(DOSSIER.concat(name)).getImage()
				.getScaledInstance(TAILLE_BOUTON, TAILLE_BOUTON,
						java.awt.Image.SCALE_SMOOTH);
		imageBouton = new ImageIcon(imageBoutonRedim);
		bouton = new JButton(imageBouton);

		return bouton;
	}

	private class ClickImage implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();

			guit.setCurrentPanel("image");
			guit.setBackPosition(4);

			imageAAfficher = DOSSIER.concat(button.getName());
			
		}
	}

	public static String getImageAAfficher() {

		return imageAAfficher;
	}

}
