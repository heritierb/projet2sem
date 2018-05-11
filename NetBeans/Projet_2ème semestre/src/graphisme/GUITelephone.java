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

	

	public GUITelephone() {
		JFrame fen = new JFrame("Téléphone");
		ImagePanel fondecran;
		JButton BoutonGallerie;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fondecran = new ImagePanel();
		fondecran.setPreferredSize(new Dimension(240, 400));
		
		ImageIcon ImageContact = new ImageIcon(
				"C:/Users/Projet/Photo_Projet/contact.jpg");
		Image ImageContactRedim = ImageContact.getImage().getScaledInstance(
				100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageContact = new ImageIcon(ImageContactRedim);
		JButton BoutonContact = new JButton(ImageContact);
		

		ImageIcon ImageGallerie = new ImageIcon(
				"C:/Users/Projet/Photo_Projet/gallerie.jpg");
		Image ImageGallerieRedim = ImageGallerie.getImage().getScaledInstance(
				100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageGallerie = new ImageIcon(ImageGallerieRedim);
		BoutonGallerie = new JButton(ImageGallerie);
		
		fen.setPreferredSize(new Dimension(480, 800));
		BoutonGallerie.setPreferredSize(new Dimension(100, 100));
		BoutonContact.setPreferredSize(new Dimension(100, 100));

		fondecran.add(BoutonGallerie);
		fondecran.add(BoutonContact);
		add(fondecran);
		
		BoutonGallerie.addActionListener(new MonListener());
		
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		

	}
	public class MonListener implements ActionListener {  
		public void actionPerformed(ActionEvent e) {  
			GUIGallerie picture = new GUIGallerie();
			picture.setVisible(true);
			dispose();
		}  
	}
}