package graphisme;

import graphisme.GUIImage.Suppression;

import javax.imageio.stream.FileCacheImageInputStream;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import structure.AppGallerie;
import structure.List_directory;
import structure.Photo;

public class GUIGallerie extends JPanel {
	List_directory ld;
	AppGallerie gallerieA;
	static int TAILLE_BOUTON = 100;
	private GUITelephone guit = (GUITelephone) SwingUtilities
			.getAncestorOfClass(GUITelephone.class, GUIGallerie.this);
	private ImagePanel gallerie = new ImagePanel(new ImageIcon(
			"src/images/wallpaper.png"));
	private ArrayList<String> fichiers2;
	private static ArrayList<JButton> tableauBouton = new ArrayList<JButton>();
	private static String imageAAfficher = "chemin image pas trouvé";
	private JPanel panelAjoutImage = new JPanel();
	private static JPanel panelImage = new JPanel();
	private JPanel panelImageEtScroll = new JPanel();
	private JScrollPane panelScroll = new JScrollPane(panelImage,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private int tailleScroll;

	private static int numeroImage;
	ImageIcon icone;

	String dir = "src/photos/";

	public GUIGallerie(GUITelephone guit, AppGallerie gallerieA) {
		this.gallerieA = gallerieA;
		// this.tableauBouton = tableauBouton;
		this.guit = guit;

		File file = new File(dir);
		if (file.isDirectory()) {

			String names[] = file.list();
			ArrayList<String> names_ok = new ArrayList<>();
			for (int i = 0; i < names.length; i++) {
				String m1 = names[i].concat(".jpg");
				if (m1 != null) {
					names_ok.add(names[i]);
				}
				icone = new ImageIcon(dir.concat(names[i]));

				List_directory ldd = new List_directory(dir, ".jpg", icone);
				gallerieA.fichiers.add(ldd);
			}
		}
		affichageBouton();
	}

	public void affichageBouton() {

		tailleScroll = (gallerieA.getFichiers().size() / 3 + 1) * 116;

		panelImage.setLayout(new FlowLayout());
		panelImage.setOpaque(false);
		panelImage.setBackground(null);
		panelImage.setBorder(null);
		panelImage.setPreferredSize(new Dimension(480, tailleScroll));

		panelImageEtScroll.setLayout(new BorderLayout());
		panelImageEtScroll.setOpaque(false);
		panelImageEtScroll.setBackground(null);
		panelImageEtScroll.setBorder(null);
		panelImageEtScroll.setPreferredSize(new Dimension(480, 550));

		panelScroll.getViewport().setOpaque(false);
		panelScroll.setOpaque(false);
		panelScroll.setPreferredSize(new Dimension(15, 600));

		// Pour chaque image du dossier, céer un bouton avec un nom
		for (int i = 0; i < gallerieA.getFichiers().size(); i++) {
			JButton buttonI = new JButton();
			JButton boutonImage = CreationBoutonImage(buttonI);
			icone = new ImageIcon(new ImageIcon(gallerieA.getFichiers().get(i)
					.getImageI().getImage()).getImage().getScaledInstance(
					TAILLE_BOUTON, TAILLE_BOUTON, Image.SCALE_SMOOTH));
			boutonImage.setIcon(icone);
			boutonImage.setName(gallerieA.getFichiers().get(i).getDossier());
			panelImage.add(boutonImage);
			boutonImage.addActionListener(new ClickImage());
			panelImageEtScroll.add(panelScroll);
			tableauBouton.add(boutonImage);

			boutonImage.setContentAreaFilled(false);
			boutonImage.setBorderPainted(false);
		}

		JButton ajoutImage = new JButton("ajout image");
		panelAjoutImage.setLayout(new FlowLayout());
		panelAjoutImage.add(ajoutImage);

		add(panelAjoutImage, BorderLayout.NORTH);
		ajoutImage.addActionListener(new Ajout());

		gallerie.add(panelImageEtScroll, BorderLayout.CENTER);

		// Affichage de la gallerie
		gallerie.setLayout(new FlowLayout());
		gallerie.setOpaque(false);
		gallerie.setPreferredSize(new Dimension(480, 683));
		add(gallerie);

	}

	public JButton CreationBoutonImage(JButton bouton) {
		bouton = new JButton();
		return bouton;
	}

	private class Ajout implements ActionListener {
		JFileChooser frameChoix = new JFileChooser();
		JFrame frame = new JFrame();

		public void actionPerformed(ActionEvent e) {
			frameChoix.setCurrentDirectory(new java.io.File("C:/Users"));
			frameChoix.setDialogTitle("choix d'image");
			frameChoix.setVisible(true);
			frameChoix.getFileView();

			frame.add(frameChoix);
			frame.setSize(new Dimension(480, 600));
			frame.setLocationRelativeTo(null);
			frame.setAlwaysOnTop(true);
			frame.setVisible(true);

			int returnVal = frameChoix.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = frameChoix.getSelectedFile();
				frame.setVisible(false);
				Path pathNouvelleImage = Paths.get(file.getPath());
				Path pathGallerie = Paths.get("src/photos/");
				try {
					Files.copy(pathNouvelleImage, pathGallerie,
							StandardCopyOption.COPY_ATTRIBUTES);
					guit.setCurrentPanel("gallerie");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(file);
			}
		}

	}

	private class ClickImage implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();
			List_directory ld = gallerieA.fichiers.get(tableauBouton
					.indexOf(button));

			// imageAAfficher = gallerieA.getDOSSIER().concat(button.getName());
			numeroImage = gallerieA.fichiers.indexOf(ld);

			guit.guiimage.update();

			if (guit.backPositionAppC == 0) {
				guit.guiimage.panelSuppressionImage();
			} else
				guit.guiimage.panelAddContact();

			guit.guiimage.validate();
			guit.setCurrentPanel("image");
			guit.setBackPosition(4);

			// imageAAfficher = gallerieA.getDOSSIER().concat(button.getName());

		}
	}

	public static String getImageAAfficher() {

		return imageAAfficher;
	}

	public static int getNumeroImage() {
		return numeroImage;
	}

	public static ArrayList<JButton> getTableauBouton() {
		return tableauBouton;
	}

	public void updateImage() {
		panelImage.removeAll();
		updateUI();
		tableauBouton.clear();
		affichageBouton();
	}

	public ArrayList<String> getFichiers2() {
		return fichiers2;
	}

	public void setFichiers2(ArrayList<String> fichiers2) {
		this.fichiers2 = fichiers2;
	}

	public static void setTableauBouton(ArrayList<JButton> tableauBouton) {
		GUIGallerie.tableauBouton = tableauBouton;
	}

	public static JPanel getPanelImage() {
		return panelImage;
	}

	public void setPanelImage(JPanel panelImage) {
		this.panelImage = panelImage;
	}

}
