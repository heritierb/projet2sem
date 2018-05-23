package graphisme;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import structure.AppGallerie;

public class GUIGallerie extends JPanel {
	AppGallerie gallerieA;
	
	static int TAILLE_BOUTON = 100;
	
	private GUITelephone guit = (GUITelephone) SwingUtilities
			.getAncestorOfClass(GUITelephone.class, GUIGallerie.this);
	private ImagePanel gallerie = new ImagePanel(new ImageIcon(
			"src/images/wallpaper2.png"));
	private ArrayList<String> fichiers; 
	private static String imageAAfficher = "test";

	public GUIGallerie(GUITelephone guit, AppGallerie gallerieA) {
		this.gallerieA=gallerieA;
		fichiers= gallerieA.getFichiers();
		this.guit = guit;
		// Pour chaque image du dossier, céer un bouton
		
		
		for (int i = 0; i < fichiers.size(); i++) {
			JButton cpt = CreationBoutonImage((String) gallerieA.getFichiers()
					.get(i));

			cpt.setName((String) gallerieA.getFichiers().get(i));
			gallerie.add(cpt);
			cpt.addActionListener(new ClickImage());
		}
		// Affichage de la gallerie
		gallerie.setLayout(new FlowLayout());
		gallerie.setOpaque(false);
		gallerie.setPreferredSize(new Dimension(480, 683));
		add(gallerie);

	}

	public JButton CreationBoutonImage(String name) {
		ImageIcon imageBouton;
		Image imageBoutonRedim;
		JButton bouton;

		// un bouton a comme icon une image dans le dossier
		imageBoutonRedim = new ImageIcon(gallerieA.getDOSSIER().concat(name)).getImage()
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

			imageAAfficher = gallerieA.getDOSSIER().concat(button.getName());
			
		}
	}

	public static String getImageAAfficher() {

		return imageAAfficher;
	}

}
