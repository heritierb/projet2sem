package graphisme;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIImage extends JPanel {

	

	private GUIGallerie guig = (GUIGallerie) SwingUtilities.getAncestorOfClass(
			GUIGallerie.class, GUIImage.this);

	public GUIImage(GUITelephone guit) {

		
		ImageIcon icon = new ImageIcon(GUIGallerie.getImageAAfficher());
		JLabel img = new JLabel(icon);
		img.setPreferredSize(new Dimension(480, 683));
		
	
		
		System.out.println(GUIGallerie.getImageAAfficher());
	}

}
