package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import structure.AppContact;
import structure.AppGallerie;

public class GUITelephone extends JFrame implements Serializable {

    // **** DECLARATION APPLICATIONS **** //
    private AppContact contactA;
    private AppGallerie gallerieA;
    private GUIGallerie guigallerie;
    private GUIContacts guicontacts;
    private GUINewContact guinewcontact;
    private GUIImage guiimage;
    private GUIEditContact guieditcontact;

    // **** DECLARATION PANELS **** //
    private JPanel northpanel = new JPanel();
    private JPanel northpanelE = new JPanel();
    private JPanel northpanelW = new JPanel();
    private JPanel southpanel = new JPanel();
    private JPanel apps = new JPanel(new GridBagLayout());
    private JPanel status = new JPanel();
    private JPanel empty = new JPanel();

    // **** DECLARATION BOUTONS **** // depuis le package images
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

    // **** DECLARATION IMAGES **** // depuis le package images
    private ImagePanel bluethooth = new ImagePanel(new ImageIcon("src/images/bluethooth.png"));
    private ImagePanel alarm = new ImagePanel(new ImageIcon("src/images/alarm.png"));
    private ImagePanel battery = new ImagePanel(new ImageIcon("src/images/battery.png"));
    private ImagePanel wifi = new ImagePanel(new ImageIcon("src/images/wifi.png"));
    private ImagePanel signal = new ImagePanel(new ImageIcon("src/images/signal.png"));
    private ImagePanel logo = new ImagePanel(new ImageIcon("src/images/logo.png"));
    private ImagePanel mainP = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private ImagePanel phoneP = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private JTextField time = new JTextField();
    int hour;
    int minute;
    private JTextField batteryS = new JTextField();
    Font fonto = new Font("Dialog", Font.BOLD, 15);

    // **** POSITION BOUTON BACK **** // permet en fonction du panel afficher de retourner au panel supérieur
    private int backPosition = 0;

    // **** FORMAT JEU DE CARTES **** // Panel avec gridbag sur un cardlayout
    private CardLayout cardL = new CardLayout();
    private JPanel cardP = new JPanel(cardL);
    private GridBagConstraints bag = new GridBagConstraints();

    // **** CONSTRUCTEUR **** // avec comme paramètre l'instance contactA et gallerieA
    public GUITelephone(AppContact contactA, AppGallerie gallerieA) {

        // **** REPRISE DES INSTANCES DANS LE CONSTRUCTEUR **** //
        this.contactA = contactA;
        this.gallerieA = gallerieA;
        this.guigallerie = new GUIGallerie(this, gallerieA);
        this.guicontacts = new GUIContacts(this, contactA);
        this.guinewcontact = new GUINewContact(this, contactA);
        this.guiimage = new GUIImage(this);
        this.guieditcontact = new GUIEditContact(this, contactA, guicontacts);

        // **** CONFIG FRAME **** // Position+size
        Calendar cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(480, 800));
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setUndecorated(true);

        // **** CONFIGURATION CARDS PANEL **** // 
        setContentPane(phoneP);
        phoneP.setOpaque(false);
        phoneP.setLayout(new BorderLayout());
        phoneP.add(cardP, BorderLayout.CENTER);

        // **** AJOUT DES CARTES APPLICATIONS **** // main = GUITelephone, gallerie = GUIGallerie, contacts = GUIContacts,..
        cardP.add(mainP, "main");
        cardP.add(guigallerie, "gallerie");
        cardP.add(guicontacts, "contacts");
        cardP.add(guinewcontact, "newcontact");
        cardP.add(guiimage, "image");
        cardP.add(guieditcontact, "editcontact");

        // **** "SAC" DE BOUTONS D'APPLICATIONS **** // GridbagLayout, panelcenter
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
        northpanelE.add(time);
        time.setText((hour + ":" + minute));
        time.setRequestFocusEnabled(false);
        time.setOpaque(false);
        time.setForeground(Color.WHITE);
        time.setFont(fonto);
        time.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        northpanelE.add(bluethooth);
        bluethooth.setPreferredSize(new Dimension(16, 16));
        northpanelE.add(alarm);
        alarm.setPreferredSize(new Dimension(16, 16));
        northpanelE.add(battery);
        battery.setPreferredSize(new Dimension(16, 16));
        northpanelW.add(signal);
        signal.setPreferredSize(new Dimension(16, 16));
        northpanelW.add(logo);
        logo.setPreferredSize(new Dimension(53, 14));
        northpanelW.add(wifi);
        wifi.setPreferredSize(new Dimension(16, 16));
        northpanel.setOpaque(false);
        northpanelE.setOpaque(false);
        northpanelW.setOpaque(false);
        northpanel.setPreferredSize(new Dimension(480, 24));

        // **** PANEL SOUTH **** //
        phoneP.add(southpanel, BorderLayout.SOUTH);
        southpanel.setOpaque(false);
        southpanel.setPreferredSize(new Dimension(480, 95));
        southpanel.setLayout(new BorderLayout());
        bhome.setContentAreaFilled(false);
        bhome.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        boff.setContentAreaFilled(false);
        boff.setBorderPainted(false);
        southpanel.add(bhome, BorderLayout.CENTER);
        southpanel.add(back, BorderLayout.EAST);
        southpanel.add(boff, BorderLayout.WEST);
        boff.setPreferredSize(new Dimension(200, 95));
        back.setPreferredSize(new Dimension(200, 95));
        // **** ACTIONLISTENERS **** //
        bhome.addActionListener(new ClickHome());
        back.addActionListener(new ClickBack());
        boff.addActionListener(new ClickOff());

        // **** BASICS OPTIONS **** // 
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    // **** CHANGEMENT DE CARTE **** // +refresh du panel contact 
    public void setCurrentPanel(String currentPanel) {
        cardL.show(cardP, currentPanel);
        if (currentPanel == "contacts") {
            guicontacts.refresh();
        } else if (currentPanel == "editcontact") {
            guieditcontact.refreshE();
        }
    }

    // **** OUVERTURE PANEL GUIGallerie **** //
    private class ClickGallerie implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            cardL.show(cardP, "gallerie");
            backPosition = 1;
            guicontacts.afficheUnit();
        }
    }

    // **** OUVERTURE PANEL GUIContacts **** //
    private class ClickContacts implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            cardL.show(cardP, "contacts");
            backPosition = 2;
        }
    }

    // **** RETOUR SUR GUITelephone **** //
    private class ClickHome implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            cardL.show(cardP, "main");
            backPosition = 0;
        }
    }

    // **** RETOUR SUR LE PANEL PRECEDANT **** // recupere le backPosition
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
            } else if (backPosition == 4) {
                cardL.show(cardP, "gallerie");
                backPosition = 1;
            }
        }
    }

    // **** ETEINDS L'APPLICATION + SERIALISATION **** //
    private class ClickOff implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            serializeObject();
            dispose();
        }
    }

    // **** GETTERS&SETTERS **** //
    public int getBackPosition() {
        return backPosition;
    }

    public void setBackPosition(int backPosition) {
        this.backPosition = backPosition;
    }

    // **** SERIALISE L'INSTANCE contactA de AppContact **** //
    public void serializeObject() {
        try {
            FileOutputStream fichier = new FileOutputStream("src/svg.ser");
            ObjectOutputStream obfichier = new ObjectOutputStream(fichier);
            obfichier.writeObject(contactA);
            obfichier.flush();
            obfichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
