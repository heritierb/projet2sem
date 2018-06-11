package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	// **** CREATION D'UN PANEL A PARTIR D'UNE IMAGE **** //
	ImageIcon image;

	public ImagePanel(ImageIcon image) 
	{
		this.image = image;
	}
	@Override
	protected void paintComponent(Graphics g) 
	{
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}

