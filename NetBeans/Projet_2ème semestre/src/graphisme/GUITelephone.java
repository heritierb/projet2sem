package graphisme;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GUITelephone extends JFrame  {
    
    // **** DECLARATION COMPOSANTS **** //
    private JPanel northpanel = new JPanel();
    private JPanel southpanel = new JPanel();
    private JPanel apps = new JPanel(new GridBagLayout());
    private JPanel status = new JPanel();
    private ImageIcon homeI = new ImageIcon("C:/Users/Projet/Photo_Projet/homebutton.png");
    private JButton bhome = new JButton(homeI);
    private JButton icontacts = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/contacts.png"));
    private JButton igallerie = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/gallery.png"));
    private JButton cadre0 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre1 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre2 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre3 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre4 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre5 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre6 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre7 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre8 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private JButton cadre9 = new JButton(new ImageIcon("C:/Users/Projet/Photo_Projet/empty.png"));
    private ImagePanel mainP = new ImagePanel(new ImageIcon("C:/Users/Projet/Photo_Projet/wallpaper2.png"));
    private ImagePanel phoneP = new ImagePanel(new ImageIcon("C:/Users/Projet/Photo_Projet/wallpaper.png"));
    
    // **** APPLICATIONS **** //
    private GUIGallerie guigallerie = new GUIGallerie(this);
    private GUIContacts guicontacts = new GUIContacts(this);
    
    // **** FORMAT JEU DE CARTES **** //
    private CardLayout cardL = new CardLayout();
    private JPanel cardP = new JPanel(cardL);
    private GridBagConstraints bag = new GridBagConstraints();
    
	public GUITelephone() {
		// **** CONFIG FRAME **** //
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(480, 800));
                setLocationRelativeTo(null);
                setAlwaysOnTop(true);
                //setUndecorated(true);

                // **** CONFIG CARDS PANEL **** //
		setContentPane(phoneP);
                phoneP.setOpaque(false);
                phoneP.setLayout(new BorderLayout());
                phoneP.add(cardP, BorderLayout.CENTER);
                
                // **** AJOUT DES CARTES APPLICATIONS **** //
                cardP.add(mainP, "main");
                cardP.add(guigallerie, "GUIGallerie");
                cardP.add(guicontacts, "contacts");
                
                // **** "SAC" DE BOUTONS D'APPLICATIONS **** //
                mainP.setLayout(new BorderLayout());
                mainP.add(apps, BorderLayout.CENTER);
                apps.setOpaque(false);
                apps.setBorder(new EmptyBorder(20, 20, 20, 20));
                bag.fill = GridBagConstraints.BOTH;
                bag.insets = new Insets(10, 10, 10 , 10);
                // **** NOMBRE DE LIGNES + COLONNES **** //
                bag.weightx = 3;
                bag.weighty = 4;
                
                // **** BOUTON GALLERIE **** //
                bag.gridx = 0;
		bag.gridy = 0;
		bag.gridwidth = 1;
		bag.gridheight = 1;
		apps.add(igallerie, bag);
                igallerie.setContentAreaFilled(false);
                igallerie.setBorderPainted(false);
		igallerie.addActionListener(new ClickGallerie());
                
                // **** BOUTON CONTACTS **** //
                bag.gridx =1;
		bag.gridy = 0;
		bag.gridwidth = 1;
		bag.gridheight = 1;
		apps.add(icontacts, bag);
                icontacts.setContentAreaFilled(false);
                icontacts.setBorderPainted(false);
		icontacts.addActionListener(new ClickContacts());
                
                // **** AUTRES BOUTONS VIDES **** //
                bag.gridx =2;
		bag.gridy = 0;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre0, bag);
                cadre0.setContentAreaFilled(false);
                cadre0.setBorderPainted(false);
                bag.gridx = 0;
		bag.gridy = 1;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre1, bag);
                cadre1.setContentAreaFilled(false);
                cadre1.setBorderPainted(false);
                bag.gridx =1;
		bag.gridy = 1;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre2, bag);
                cadre2.setContentAreaFilled(false);
                cadre2.setBorderPainted(false);
                bag.gridx =2;
		bag.gridy = 1;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre3, bag);
                cadre3.setContentAreaFilled(false);
                cadre3.setBorderPainted(false);
                bag.gridx =0;
		bag.gridy = 2;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre4, bag);
                cadre4.setContentAreaFilled(false);
                cadre4.setBorderPainted(false);
                bag.gridx =1;
		bag.gridy = 2;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre5, bag);
                cadre5.setContentAreaFilled(false);
                cadre5.setBorderPainted(false);
                bag.gridx =2;
		bag.gridy = 2;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre6, bag);
                cadre6.setContentAreaFilled(false);
                cadre6.setBorderPainted(false);
                bag.gridx =0;
		bag.gridy = 3;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre7, bag);
                cadre7.setContentAreaFilled(false);
                cadre7.setBorderPainted(false);
                bag.gridx =1;
		bag.gridy = 3;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre8, bag);
                cadre8.setContentAreaFilled(false);
                cadre8.setBorderPainted(false);
                bag.gridx =2;
		bag.gridy = 3;
		bag.gridwidth = 1;
		bag.gridheight = 1;
                apps.add(cadre9, bag);
                cadre9.setContentAreaFilled(false);
                cadre9.setBorderPainted(false);
                
                
                // **** PANEL NORTH **** //
                phoneP.add(northpanel, BorderLayout.NORTH);
		northpanel.setOpaque(false);
		northpanel.setPreferredSize(new Dimension(480, 20));

                
                // **** PANEL SOUTH **** //
                phoneP.add(southpanel, BorderLayout.SOUTH);
		southpanel.setOpaque(false);
		southpanel.setPreferredSize(new Dimension(480, 95));
                bhome.setContentAreaFilled(false);
                bhome.setBorderPainted(false);
                southpanel.add(bhome);
                bhome.addActionListener(new ClickHome());
                
                // **** BASICS OPTIONS **** //
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
        
        class ClickGallerie implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			cardL.show(cardP, "GUIGallerie");
		}
	}
        class ClickContacts implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			cardL.show(cardP, "contacts");
		}
	}
        class ClickHome implements ActionListener{
                public void actionPerformed(ActionEvent e) 
		{
			cardL.show(cardP, "main");
		}
        }
        
        
                       
}