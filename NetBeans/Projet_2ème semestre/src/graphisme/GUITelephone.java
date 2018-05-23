package graphisme;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import structure.AppContact;

public class GUITelephone extends JFrame implements Serializable {

    // **** DECLARATION COMPOSANTS **** //
    private JPanel northpanel = new JPanel();
    private JPanel northpanelE = new JPanel();
    private JPanel northpanelW = new JPanel();
    private JPanel southpanel = new JPanel();
    private JPanel apps = new JPanel(new GridBagLayout());
    private JPanel status = new JPanel();
    private JPanel empty = new JPanel();
    private JButton boff = new JButton(new ImageIcon("src/images/off.png"));
    private JButton bhome = new JButton(new ImageIcon("src/images/homebutton.png"));
    private JButton back = new JButton(new ImageIcon("src/images/back.png"));
    private JButton icontacts = new JButton(new ImageIcon("src/images/contacts.png"));
    private JButton igallerie = new JButton(new ImageIcon("src/images/gallery.png"));
    private JButton cadre0 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre1 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre2 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre3 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre4 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre5 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre6 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre7 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre8 = new JButton(new ImageIcon("src/images/empty.png"));
    private JButton cadre9 = new JButton(new ImageIcon("src/images/empty.png"));
    private ImagePanel bluethooth = new ImagePanel(new ImageIcon("src/images/bluethooth.png"));
    private ImagePanel alarm = new ImagePanel(new ImageIcon("src/images/alarm.png"));
    private ImagePanel battery = new ImagePanel(new ImageIcon("src/images/battery.png"));
    private ImagePanel wifi = new ImagePanel(new ImageIcon("src/images/wifi.png"));
    private ImagePanel signal = new ImagePanel(new ImageIcon("src/images/signal.png"));
    private ImagePanel logo = new ImagePanel(new ImageIcon("src/images/logo.png"));
    private ImagePanel mainP = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
    private ImagePanel phoneP = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    // POSITION FOR THE BUTTON BACK
    private int backPosition = 0;

    // **** APPLICATIONS **** //
    private GUIGallerie guigallerie = new GUIGallerie(this);
    private GUIContacts guicontacts = new GUIContacts(this);
    private GUINewContact guinewcontact = new GUINewContact(this);
    private GUIImage guiimage = new GUIImage(this);

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
        setUndecorated(true);

        // **** CONFIG CARDS PANEL **** //
        setContentPane(phoneP);
        phoneP.setOpaque(false);
        phoneP.setLayout(new BorderLayout());
        phoneP.add(cardP, BorderLayout.CENTER);

        // **** AJOUT DES CARTES APPLICATIONS **** //
        cardP.add(mainP, "main");
        cardP.add(guigallerie, "gallerie");
        cardP.add(guicontacts, "contacts");
        cardP.add(guinewcontact, "newcontact");
        cardP.add(guiimage, "image");
       

        // **** "SAC" DE BOUTONS D'APPLICATIONS **** //
        mainP.setLayout(new BorderLayout());
        mainP.add(apps, BorderLayout.CENTER);
        apps.setOpaque(false);
        apps.setBorder(new EmptyBorder(20, 20, 20, 20));
        bag.fill = GridBagConstraints.BOTH;
        bag.insets = new Insets(10, 10, 10, 10);
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
        bag.gridx = 1;
        bag.gridy = 0;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(icontacts, bag);
        icontacts.setContentAreaFilled(false);
        icontacts.setBorderPainted(false);
        icontacts.addActionListener(new ClickContacts());

        // **** AUTRES BOUTONS VIDES **** //
        bag.gridx = 2;
        bag.gridy = 0;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre0, bag);
        cadre0.setContentAreaFilled(false);
        cadre0.setBorderPainted(false);
        cadre0.addActionListener(new ClickTest());
        bag.gridx = 0;
        bag.gridy = 1;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre1, bag);
        cadre1.setContentAreaFilled(false);
        cadre1.setBorderPainted(false);
        bag.gridx = 1;
        bag.gridy = 1;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre2, bag);
        cadre2.setContentAreaFilled(false);
        cadre2.setBorderPainted(false);
        bag.gridx = 2;
        bag.gridy = 1;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre3, bag);
        cadre3.setContentAreaFilled(false);
        cadre3.setBorderPainted(false);
        bag.gridx = 0;
        bag.gridy = 2;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre4, bag);
        cadre4.setContentAreaFilled(false);
        cadre4.setBorderPainted(false);
        bag.gridx = 1;
        bag.gridy = 2;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre5, bag);
        cadre5.setContentAreaFilled(false);
        cadre5.setBorderPainted(false);
        bag.gridx = 2;
        bag.gridy = 2;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre6, bag);
        cadre6.setContentAreaFilled(false);
        cadre6.setBorderPainted(false);
        bag.gridx = 0;
        bag.gridy = 3;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre7, bag);
        cadre7.setContentAreaFilled(false);
        cadre7.setBorderPainted(false);
        bag.gridx = 1;
        bag.gridy = 3;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre8, bag);
        cadre8.setContentAreaFilled(false);
        cadre8.setBorderPainted(false);
        bag.gridx = 2;
        bag.gridy = 3;
        bag.gridwidth = 1;
        bag.gridheight = 1;
        apps.add(cadre9, bag);
        cadre9.setContentAreaFilled(false);
        cadre9.setBorderPainted(false);

        // **** PANEL NORTH **** //
        phoneP.add(northpanel, BorderLayout.NORTH);
        northpanel.setLayout(new BorderLayout());
        northpanel.add(northpanelW, BorderLayout.WEST);
        northpanel.add(northpanelE, BorderLayout.EAST);
        northpanelE.setLayout(new FlowLayout());
        northpanelW.setLayout(new FlowLayout());
        northpanelE.add(bluethooth);
        northpanelE.add(alarm);
        northpanelE.add(battery);
        northpanelW.add(signal);
        northpanelW.add(logo);
        northpanelW.add(wifi);
        northpanel.setOpaque(false);
        northpanelE.setOpaque(false);
        northpanelW.setOpaque(false);
        bluethooth.setPreferredSize(new Dimension(16, 16));
        alarm.setPreferredSize(new Dimension(16, 16));
        battery.setPreferredSize(new Dimension(16, 16));
        signal.setPreferredSize(new Dimension(16, 16));
        logo.setPreferredSize(new Dimension(53, 14));
        wifi.setPreferredSize(new Dimension(16, 16));
        northpanel.setPreferredSize(new Dimension(480, 22));

        // **** PANEL SOUTH **** //
        phoneP.add(southpanel, BorderLayout.SOUTH);
        southpanel.setOpaque(false);
        southpanel.setPreferredSize(new Dimension(480, 95));
        southpanel.setLayout(new BorderLayout());
        bhome.setContentAreaFilled(false);
        bhome.setBorderPainted(false);
        southpanel.add(bhome, BorderLayout.CENTER);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        southpanel.add(back, BorderLayout.EAST);
        southpanel.add(boff, BorderLayout.WEST);
        boff.setContentAreaFilled(false);
        boff.setBorderPainted(false);
        boff.setPreferredSize(new Dimension(200, 95));
        back.setPreferredSize(new Dimension(200, 95));
        //ACTIONLISTENERS
        bhome.addActionListener(new ClickHome());
        back.addActionListener(new ClickBack());
        boff.addActionListener(new ClickOff());

        // **** BASICS OPTIONS **** //
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public void setCurrentPanel(String currentPanel) {
        cardL.show(cardP, currentPanel);
    }

    private class ClickGallerie implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            cardL.show(cardP, "gallerie");
            backPosition = 1;
            guicontacts.afficheUnit();
        }
    }

    private class ClickContacts implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            cardL.show(cardP, "contacts");
            backPosition = 2;
        }
    }

    private class ClickHome implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            cardL.show(cardP, "main");
            backPosition = 0;
        }
    }

    private class ClickBack implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // reviens sur le home depuis la gallerie
            if (backPosition == 1) {
                cardL.show(cardP, "main");
                backPosition = 0;
            } // reviens sur le home depuis les contacts
            else if (backPosition == 2) {
                cardL.show(cardP, "main");
                backPosition = 0;
            } else if (backPosition == 3) {
                cardL.show(cardP, "contacts");
                backPosition = 2;
            }
        }
    }

    private class ClickTest implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            cardL.show(cardP, "newcontact");
            backPosition = 3;
        }
    }

    private class ClickOff implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            guicontacts.serializeObject();
            dispose();
        }
    }

    public int getBackPosition() {
        return backPosition;
    }

    public void setBackPosition(int backPosition) {
        this.backPosition = backPosition;
    }

}
