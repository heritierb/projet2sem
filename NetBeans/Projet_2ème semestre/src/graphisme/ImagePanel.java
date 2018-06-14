package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * CREATION D'UN PANEL A PARTIR D'UNE IMAGE
 * @author ben
 */
public class ImagePanel extends JPanel {

	ImageIcon image;

	public ImagePanel(ImageIcon image) 
	{
		this.image = image;
	}
        /**
         * paintComponent
         * @param g 
         */
	@Override
	protected void paintComponent(Graphics g) 
	{
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}

