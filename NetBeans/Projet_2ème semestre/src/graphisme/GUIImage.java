package graphisme;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIImage extends JPanel {
    
    private ImagePanel image = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUIImage.this);
    
    public GUIImage(GUITelephone guit){
        this.guit = guit;
        add(image);
        
        
    }
    

	
}
