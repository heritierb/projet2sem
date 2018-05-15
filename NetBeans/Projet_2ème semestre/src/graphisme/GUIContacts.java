package graphisme;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIContacts extends JPanel {
        private ImagePanel contacts = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
        private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUIContacts.this);
        private JPanel panelnorth = new JPanel();
        ImageIcon addContact = new ImageIcon("src/images/addContact.png");
        private JButton buttonAddContact = new JButton(addContact);
        
        public GUIContacts(GUITelephone guit){
            this.guit = guit;
            setLayout(new BorderLayout());
            add(contacts);
            
            contacts.add(panelnorth, BorderLayout.NORTH);
            panelnorth.add(buttonAddContact);
            panelnorth.setOpaque(false);
            
            buttonAddContact.addActionListener(new ClickNewContact ());
            buttonAddContact.setContentAreaFilled(false);
            buttonAddContact.setBorderPainted(false);
                        System.out.println(" contact  : " +this.getAlignmentY());

            
        }

        private class ClickNewContact implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			guit.setCurrentPanel("newcontact");
                        guit.setBackPosition(3);
		}
	}
        
}