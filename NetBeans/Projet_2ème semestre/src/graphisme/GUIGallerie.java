package graphisme;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIGallerie {

	GUIGallerie() {
		JFrame fen = new JFrame("Gallerie");
		JPanel pan = new JPanel();
		ImageIcon icon = new ImageIcon(
				"C:/Users/oppik/Pictures/Screenshots/Capture.jpg");
		
		JButton img = new JButton(icon);
		img.setPreferredSize(new Dimension(20, 20));
		pan.add(img);
		
		fen.add(pan);
		fen.pack();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);

	}
}
