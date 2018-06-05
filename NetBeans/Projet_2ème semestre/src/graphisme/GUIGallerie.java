package graphisme;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import structure.AppGallerie;
import structure.Gallerie;

public class GUIGallerie extends JPanel {
	AppGallerie gallerieA;
	static int TAILLE_BOUTON = 100;
	private GUITelephone guit = (GUITelephone) SwingUtilities
			.getAncestorOfClass(GUITelephone.class, GUIGallerie.this);
	private ImagePanel gallerie = new ImagePanel(new ImageIcon(
			"src/images/wallpaper.png"));
	private ArrayList<String> fichiers2;
	private ArrayList<JButton> tableauBouton = new ArrayList<JButton>();
	private static String imageAAfficher = "chemin image pas trouvé";
	private JPanel panelImage = new JPanel();
	private JPanel panelImageEtScroll = new JPanel();
	private JScrollPane panelScroll = new JScrollPane(panelImage,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private int tailleScroll;
	String numeroImage;

	public GUIGallerie(GUITelephone guit, AppGallerie gallerieA) {
		this.gallerieA = gallerieA;
		this.tableauBouton=tableauBouton;
		fichiers2 = gallerieA.getFichiers();
		this.guit = guit;

		tailleScroll = (fichiers2.size() / 3 + 1) * 116;

		panelImage.setLayout(new FlowLayout());
		panelImage.setOpaque(false);
		panelImage.setBackground(null);
		panelImage.setBorder(null);
		panelImage.setPreferredSize(new Dimension(480, tailleScroll));

		panelImageEtScroll.setLayout(new BorderLayout());
		panelImageEtScroll.setOpaque(false);
		panelImageEtScroll.setBackground(null);
		panelImageEtScroll.setBorder(null);
		panelImageEtScroll.setPreferredSize(new Dimension(480, 650));

		panelScroll.getViewport().setOpaque(false);
		panelScroll.setOpaque(false);
		panelScroll.setPreferredSize(new Dimension(15, 600));

		// Pour chaque image du dossier, céer un bouton avec un nom
		for (int i = 0; i < fichiers2.size(); i++) {
			JButton boutonImage = CreationBoutonImage((String) gallerieA
					.getFichiers().get(i));
			boutonImage.setName((String) gallerieA.getFichiers().get(i));
			panelImage.add(boutonImage);
			boutonImage.addActionListener(new ClickImage());
			panelImageEtScroll.add(panelScroll);
			tableauBouton.add(boutonImage);
		}

		gallerie.add(panelImageEtScroll, BorderLayout.CENTER);

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
		imageBoutonRedim = new ImageIcon(gallerieA.getDOSSIER().concat(name))
				.getImage().getScaledInstance(TAILLE_BOUTON, TAILLE_BOUTON,
						java.awt.Image.SCALE_SMOOTH);
		imageBouton = new ImageIcon(imageBoutonRedim);
		bouton = new JButton(imageBouton);
		bouton.setContentAreaFilled(false);
		bouton.setBorderPainted(false);
		return bouton;
	}

	private class ClickImage implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();
			imageAAfficher = gallerieA.getDOSSIER().concat(button.getName());
			numeroImage = gallerieA.fichiers.get(tableauBouton.indexOf(button));
			guit.guiimage.update();
			guit.setCurrentPanel("image");
			guit.setBackPosition(4);

			imageAAfficher = gallerieA.getDOSSIER().concat(button.getName());

		}
	}

	public static String getImageAAfficher() {

		return imageAAfficher;
	}
	public String getNumeroImage(){
		return numeroImage;
	}

}
