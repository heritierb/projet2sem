package graphisme;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUITelephone extends JFrame  {

	private JFrame fen = new JFrame("Téléphone");
	private ImagePanel fondecran;
	private ArrayList<JButton> listBoutons = new ArrayList<JButton>();
	private JButton BoutonGallerie;

	public GUITelephone() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fondecran = new ImagePanel();

		ImageIcon ImageContact = new ImageIcon(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/contact.jpg");
		Image ImageContactRedim = ImageContact.getImage().getScaledInstance(
				100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageContact = new ImageIcon(ImageContactRedim);
		JButton BoutonContact = new JButton(ImageContact);
		listBoutons.add(BoutonContact);
		fondecran.add(listBoutons.get(listBoutons.size() - 1));

		ImageIcon ImageGallerie = new ImageIcon(
				"F:/HES-Informatique De Gestion/poo/Projet/Photo_Projet/gallerie.jpg");
		Image ImageGallerieRedim = ImageGallerie.getImage().getScaledInstance(
				100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageGallerie = new ImageIcon(ImageGallerieRedim);
		BoutonGallerie = new JButton(ImageGallerie);
		listBoutons.add(BoutonGallerie);
		fondecran.add(listBoutons.get(listBoutons.size() - 1));

		fen.setPreferredSize(new Dimension(480, 800));
		BoutonGallerie.setPreferredSize(new Dimension(100, 100));
		BoutonContact.setPreferredSize(new Dimension(100, 100));

		fondecran.add(BoutonGallerie);
		fondecran.add(BoutonContact);
		add(fondecran);
		
		BoutonGallerie.addActionListener(new MonListener());
		
		
		pack();
		setVisible(true);
		

	}
	public class MonListener implements ActionListener {  
		public void actionPerformed(ActionEvent e) {  
			GUIGallerie picture = new GUIGallerie();
			picture.setVisible(true);
			System.out.println("ta mere");
		}  
	}
}