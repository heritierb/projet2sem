package graphisme;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	ImageIcon image;

	public ImagePanel(ImageIcon image) 
	{
		this.image = image;
	}

	protected void paintComponent(Graphics g) 
	{
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}


//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JPanel;
//
//public class ImagePanel extends JPanel {
//
//    ImagePanel(ImageIcon imageIcon) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//
//	public void paintComponent(Graphics g){
//	    try {
//	      Image img = ImageIO.read(new File("C:/Users/Projet/Photo_Projet/wallpaper.jpg"));
//	     
//	  
//	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
//	    } catch (UnsupportedOperationException | IOException e) {
//	      e.printStackTrace();
//	    }                
//	  }  
//}
