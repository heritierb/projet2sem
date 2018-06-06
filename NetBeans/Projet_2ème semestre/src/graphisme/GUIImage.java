package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import structure.AppContact;
import structure.Contact;

public class GUIImage extends JPanel {

	private Image imageRedim;

	private GUIGallerie guig = (GUIGallerie) SwingUtilities.getAncestorOfClass(
			GUIGallerie.class, GUIImage.this);

	// ** INSTANCE GUITelephone **
	// Recupere la method permettant de switch la card
	private GUITelephone guit = (GUITelephone) SwingUtilities
			.getAncestorOfClass(GUITelephone.class, GUIImage.this);

	private ImageIcon icon = new ImageIcon(GUIGallerie.getImageAAfficher());
	private JLabel img = new JLabel(icon);
	private JPanel panelImage = new JPanel();
	private JPanel panelImageEtScroll = new JPanel();
	private JPanel panelSupprimer = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JButton buttonSetImCt = new JButton(new ImageIcon(
			"src/images/addtouser.png"));
	private ImagePanel imageX = new ImagePanel(new ImageIcon(
			"src/images/wallpaper.png"));
	private JButton boutonSupprimer = new JButton();
	private ArrayList<Contact> arrayC;
	private JTextField txt = new JTextField("test");
	private int hauteurFinale = 600;
	private int largeurFinale = 480;
	private int ratio;
	GUIContacts guic;
	AppContact contactA;
	Contact contactZ;

	public GUIImage(GUITelephone guit, GUIContacts guic, AppContact contactA) {
		this.contactZ = contactZ;
		this.guit = guit;
		this.guic = guic;
		this.contactA = contactA;
		arrayC = contactA.getArrayContacts();

		icon = new ImageIcon(GUIGallerie.getImageAAfficher());
		JLabel img = new JLabel(icon);

	}

	public void update() {

		panelImageEtScroll.removeAll();
		panelSupprimer.removeAll();
		updateUI();

		icon = new ImageIcon(GUIGallerie.getImageAAfficher());
		JLabel img = new JLabel(icon);

		int hauteurOriginale = icon.getIconHeight();
		int largeurOriginale = icon.getIconWidth();

		if (hauteurOriginale > 600) {
			hauteurFinale = 600;
			ratio = hauteurOriginale / hauteurFinale;
			largeurFinale = largeurOriginale / ratio;
		} else
			hauteurFinale = hauteurOriginale;

		if (largeurOriginale > 480) {
			largeurFinale = 480;
			ratio = largeurOriginale / largeurFinale;
			hauteurFinale = hauteurOriginale / ratio;
		} else
			largeurFinale = largeurOriginale;

		imageRedim = icon.getImage().getScaledInstance(largeurFinale,
				hauteurFinale, java.awt.Image.SCALE_SMOOTH);
		panelImage.setLayout(new BorderLayout());
		panelImage.setOpaque(false);
		panelImage.setBackground(null);
		panelImage.setBorder(null);
		panelImage.setPreferredSize(new Dimension(480, 600));

		ImageIcon iconSupprimer = new ImageIcon("src/images/cancel.png");
		boutonSupprimer = new JButton(iconSupprimer);
		boutonSupprimer.addActionListener(new Suppression());

		panelSupprimer.setLayout(new FlowLayout());
		panelSupprimer.setBackground(Color.black);
		panelSupprimer.add(boutonSupprimer);

		panelImageEtScroll.setLayout(new BorderLayout());
		panelImageEtScroll.setOpaque(false);
		panelImageEtScroll.setBackground(null);
		panelImageEtScroll.setBorder(null);
		panelImageEtScroll.setPreferredSize(new Dimension(480, 600));

		img.setIcon(new ImageIcon(imageRedim));
		panelImageEtScroll.add(img);
		add(panelImageEtScroll, BorderLayout.CENTER);
		panelImageEtScroll.add(panelSupprimer, BorderLayout.SOUTH);
		this.validate();
		this.repaint();

	}

	private class Suppression implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			File aSupprimer = new File(GUIGallerie.getImageAAfficher());
			aSupprimer.delete();
			//refresh la guigallerie
			//revenir page précédente
			

		}
	}
}
