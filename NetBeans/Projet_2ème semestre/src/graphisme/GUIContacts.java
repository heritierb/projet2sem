package graphisme;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GUIContacts extends JPanel {
        private ImagePanel contacts = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
        private GUITelephone guit;
        
        public GUIContacts(GUITelephone guit){
            this.guit = guit;
            setLayout(new BorderLayout());
            add(contacts);
        }
}