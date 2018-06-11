package graphisme;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AfficheImage {

	public static void main(String[] args) {

		JFrame fen = new JFrame("Ordinateur ");
		JPanel pan = new JPanel();
		ImageIcon icon = new ImageIcon("src/photos/geneva-2379789__340.jpg");
		JLabel img = new JLabel(icon);
		pan.add(img);
		fen.add(pan);
		fen.pack();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);

	}
}