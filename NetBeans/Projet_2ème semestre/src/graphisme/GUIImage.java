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
import structure.AppGallerie;
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
	private ImageIcon iconSupprimer = new ImageIcon("src/images/cancel.png");
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
	private JTextField txt = new JTextField("test");
	private int hauteurFinale = 600;
	private int largeurFinale = 480;
	private int ratio;
	private int hauteurOriginale;
	private int largeurOriginale;
	GUIContacts guic;
	AppContact contactA;
	Contact contactZ;
	AppGallerie gallerieA;
	GUINewContact guinewcontact;
	GUIEditContact guieditcontact;
	private ArrayList<Contact> arrayC;
	String test = " ";
	private ImageIcon iconX;

	public GUIImage(GUITelephone guit, GUIContacts guic, AppContact contactA,
			GUINewContact guinewcontact, GUIEditContact guieditcontact, AppGallerie gallerieA) {
		this.guieditcontact = guieditcontact;
		this.guinewcontact = guinewcontact;
		this.guit = guit;
		this.guic = guic;
		this.contactA = contactA;
		this.gallerieA = gallerieA;
		arrayC = contactA.getArrayContacts();

		//icon = new ImageIcon(GUIGallerie.getImageAAfficher());
		JLabel img = new JLabel(iconX);

		panelImage.setLayout(new BorderLayout());
		panelImage.setOpaque(false);
		panelImage.setBackground(null);
		panelImage.setBorder(null);
		panelImage.setPreferredSize(new Dimension(480, 600));

		panelImageEtScroll.setLayout(new BorderLayout());
		panelImageEtScroll.setOpaque(false);
		panelImageEtScroll.setBackground(null);
		panelImageEtScroll.setBorder(null);
		panelImageEtScroll.setPreferredSize(new Dimension(480, 600));

		panelImageEtScroll.add(img);
		add(panelImageEtScroll, BorderLayout.CENTER);
	}

	public void update() {
		panelImageEtScroll.removeAll();
		panelSupprimer.removeAll();
		updateUI();
		iconX = new ImageIcon(gallerieA.getFichiers().get(guig.getNumeroImage()).getImageI().getImage());
		img = new JLabel(iconX);

		hauteurOriginale = iconX.getIconHeight();
		largeurOriginale = iconX.getIconWidth();

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

		imageRedim = iconX.getImage().getScaledInstance(largeurFinale,
				hauteurFinale, java.awt.Image.SCALE_SMOOTH);
		img.setIcon(new ImageIcon(imageRedim));
		panelImageEtScroll.add(img);
		panelImageEtScroll.add(panelSupprimer, BorderLayout.SOUTH);
		this.validate();
		this.repaint();

	}

	public void panelSuppressionImage() {
		updateUI();
		boutonSupprimer = new JButton(iconSupprimer);
		boutonSupprimer.addActionListener(new Suppression());
		panelSupprimer.setLayout(new FlowLayout());
		panelSupprimer.setBackground(Color.black);
		panelSupprimer.add(boutonSupprimer);

		panelImageEtScroll.add(panelSupprimer, BorderLayout.SOUTH);

		this.validate();
		this.repaint();

	}

	public class Suppression implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			File aSupprimer = new File(GUIGallerie.getImageAAfficher());
			aSupprimer.delete();
			gallerieA.fichiers.remove(guig.getNumeroImage());
			guit.setCurrentPanel("gallerie");
		}
	}

	public void panelAddContact() {
		panelSouth.removeAll();
		updateUI();
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setOpaque(false);
		buttonSetImCt.setContentAreaFilled(false);
		buttonSetImCt.setPreferredSize(new Dimension(120, 120));
		buttonSetImCt.setBorderPainted(false);
		panelSouth.add(buttonSetImCt);
		buttonSetImCt.addActionListener(new GUIImage.setImCtClick());
	}

	// ** CHANGE LA PHOTO EN APPELANT L'APP GALLERIE ** //

	private class setImCtClick implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (guic.switcheditadd == 3) {
				guinewcontact.user = new ImageIcon(
						GUIGallerie.getImageAAfficher());
				guit.setCurrentPanel("newcontact");
				guinewcontact.refreshPhoto();
				guit.backPosition = 5;

			} else if (guic.switcheditadd == 2) {
				guieditcontact.icone = new ImageIcon(
						GUIGallerie.getImageAAfficher());
				guit.setCurrentPanel("editcontact");
				guieditcontact.refreshPhoto();
				guit.backPosition = 6;
			}
		}
	}
}