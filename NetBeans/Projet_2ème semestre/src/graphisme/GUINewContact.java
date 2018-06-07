package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import structure.AppContact;
import structure.Contact;

public class GUINewContact extends JPanel {

    AppContact contactA;
    private GUIContacts guic = (GUIContacts) SwingUtilities.getAncestorOfClass(GUIContacts.class, GUINewContact.this);
    private ArrayList<Contact> arrayC;
    private ImagePanel newcontact = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUINewContact.this);
    private JPanel panel_center = new JPanel();
    private JPanel panel_west = new JPanel();
    private JPanel panel_east = new JPanel();
    private JPanel panelNorth = new JPanel();
    private JPanel panel_ntm = new JPanel();
    private JPanel empty = new JPanel();
    private JPanel panelSud = new JPanel();
    private JPanel panelImageContact = new JPanel();

    //1.Prenom 2.Nom 3.Numero 4.Email 5.Adresse 6.Anni 7.Groupe
    JTextField txt = new JTextField();
    JTextField txtboucle = new JTextField();
    String parametre = "";
    String vide = "";
    private String prenomB = "Entrez le prénom";
    private String nomB = "Entrez le nom";
    private String numeroB = "Entrez le numéro";
    private String emailB = "Entrez l'email";
    private String adresseB = "Entrez l'adresse";
    private String anniB = "Entrez la date de naissance";
    private String groupeB = "Entrez le groupe";
    private JTextField txt1 = new JTextField();
    private JTextField txt2 = new JTextField();
    private JTextField txt3 = new JTextField();
    private JTextField txt4 = new JTextField();
    private JTextField txt5 = new JTextField();
    private JTextField txt6 = new JTextField();
    private JTextField txt7 = new JTextField();
    ImageIcon done = new ImageIcon("src/images/save.png");
    ImageIcon symbol = new ImageIcon("src/images/symbol.png");
    private JButton buttonSave = new JButton(done);
    private JLabel symbolP = new JLabel(symbol);
    private JButton buttonImageContact = new JButton();
    Color blanc = new Color(255, 255, 255);
    Color blancasse = new Color(250, 250, 250);
    Font ecriture = new Font("SANS_SERIF", Font.ITALIC, 18);
    ImageIcon user = new ImageIcon("src/images/user.png");
    ImageIcon icone;
    ImageIcon iconeR;

    public GUINewContact(GUITelephone guit, AppContact contactA, GUIContacts guic) {
        this.guit = guit;
        this.contactA = contactA;
        this.guic = guic;
        add(newcontact);
        arrayC = contactA.getArrayContacts();
        newcontact.setLayout(new BorderLayout());
        newcontact.setAlignmentY(0);
        newcontact.setPreferredSize(new Dimension(480, 683));
        newcontact.setOpaque(false);

        // **** WEST **** //
        panel_west.setLayout(new GridLayout(8, 1, 0, 0));
        for (int i = 0; i < 7; i++) {
            symbolP = new JLabel(CreationImageIcon(symbol));
            panel_west.add(symbolP);
            symbolP.setBackground(blanc);
            symbolP.setOpaque(false);
        }
        panel_west.setPreferredSize(new Dimension(40, 600));
        // **** EAST **** //
        panel_east.setPreferredSize(new Dimension(40, 600));

        // **** SOUTH **** //
        //panelSud.setLayout(new BoxLayout(panelSud, BoxLayout.Y_AXIS));
        panelSud.setPreferredSize(new Dimension(480, 200));
        panelSud.add(panelImageContact);
        panelSud.setOpaque(false);
        icone = new ImageIcon(user.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        buttonImageContact.setIcon(icone);
        panelImageContact.setPreferredSize(new Dimension(150, 150));
        buttonImageContact.setContentAreaFilled(false);
        buttonImageContact.setBorder(new EmptyBorder(0, 0, 0, 0));
        buttonImageContact.addActionListener(new GUINewContact.addPhotoClick());
        panelImageContact.setOpaque(false);
        panelImageContact.add(buttonImageContact);

        // **** NORTH **** //
        panelNorth.setLayout(new BorderLayout());
        buttonSave.setContentAreaFilled(false);
        buttonSave.setBorderPainted(false);
        panelNorth.add(panel_ntm, BorderLayout.CENTER);
        panel_ntm.setOpaque(false);
        panel_ntm.add(buttonSave);
        panelNorth.add(empty, BorderLayout.SOUTH);
        empty.setPreferredSize(new Dimension(480, 5));
        empty.setOpaque(true);
        panelNorth.setPreferredSize(new Dimension(280, 85));
        panelNorth.setOpaque(false);
        buttonSave.addActionListener(new GUINewContact.doneClick());

        // **** COLOR+DISPOSITION **** //
        newcontact.add(panel_west, BorderLayout.WEST);
        newcontact.add(panel_east, BorderLayout.EAST);
        newcontact.add(panelNorth, BorderLayout.NORTH);
        newcontact.add(panelSud, BorderLayout.SOUTH);
        newcontact.add(panel_center, BorderLayout.CENTER);
        panel_center.setOpaque(false);
        panelNorth.setOpaque(false);
        panel_east.setOpaque(false);
        panel_west.setOpaque(false);
        panelNorth.setBorder(new EmptyBorder(0, 0, 0, 0));
        symbolP.requestFocus();

        // **** CENTER **** //
        panel_center.setLayout(new GridLayout(8, 1, 0, 0));
        for (int i = 0; i < 7; i++) {
            txtboucle = CreationFieldContact(txt);
            txtboucle.setOpaque(false);
            txtboucle.setHorizontalAlignment(SwingConstants.CENTER);
            txtboucle.setForeground(blanc);
            txtboucle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
            txtboucle.setFont(ecriture);

            switch (i) {
                case 0:
                    txt1 = txtboucle;
                    txtboucle.setText(prenomB);
                    break;
                case 1:
                    txt2 = txtboucle;
                    txtboucle.setText(nomB);
                    break;
                case 2:
                    txt3 = txtboucle;
                    txtboucle.setText(numeroB);
                    break;
                case 3:
                    txt4 = txtboucle;
                    txtboucle.setText(emailB);
                    break;
                case 4:
                    txt5 = txtboucle;
                    txtboucle.setText(adresseB);
                    break;
                case 5:
                    txt6 = txtboucle;
                    txtboucle.setText(anniB);
                    break;
                case 6:
                    txt7 = txtboucle;
                    txtboucle.setText(groupeB);
                    break;
            }
            panel_center.add(txtboucle);
        }
        txt1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                if (txt1.getText().equals(prenomB)) {
                    txt1.setText(vide);
                }
            }

            public void focusLost(FocusEvent arg0) {
                if (txt1.getText().equals(vide)) {
                    txt1.setText(prenomB);
                }
            }
        });
        txt2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                if (txt2.getText().equals(nomB)) {
                    txt2.setText(vide);
                }
            }

            public void focusLost(FocusEvent arg0) {
                if (txt2.getText().equals(vide)) {
                    txt2.setText(nomB);
                }
            }
        });
        txt3.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                if (txt3.getText().equals(numeroB)) {
                    txt3.setText(vide);
                }
            }

            public void focusLost(FocusEvent arg0) {
                if (txt3.getText().equals(vide)) {
                    txt3.setText(numeroB);
                }
            }
        });
        txt4.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                if (txt4.getText().equals(emailB)) {
                    txt4.setText(vide);
                }
            }

            public void focusLost(FocusEvent arg0) {
                if (txt4.getText().equals(vide)) {
                    txt4.setText(emailB);
                }
            }
        });
        txt5.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                if (txt5.getText().equals(adresseB)) {
                    txt5.setText(vide);
                }
            }

            public void focusLost(FocusEvent arg0) {
                if (txt5.getText().equals(vide)) {
                    txt5.setText(adresseB);
                }
            }
        });
        txt6.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                if (txt6.getText().equals(anniB)) {
                    txt6.setText(vide);
                }
            }

            public void focusLost(FocusEvent arg0) {
                if (txt6.getText().equals(vide)) {
                    txt6.setText(anniB);
                }
            }
        });
        txt7.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                if (txt7.getText().equals(groupeB)) {
                    txt7.setText(vide);
                }
            }

            public void focusLost(FocusEvent arg0) {
                if (txt7.getText().equals(vide)) {
                    txt7.setText(groupeB);
                }
            }
        });
        panel_center.setPreferredSize(new Dimension(340, 683));
    }

    // **** POUR CHAQUE TXT DE LA BOUCLE DES CHAMPS **** //
    public JTextField CreationFieldContact(JTextField txt) {
        txt = new JTextField();
        return txt;
    }

    public ImageIcon CreationImageIcon(ImageIcon symbol) {
        symbol = new ImageIcon("src/images/symbol.png");
        return symbol;
    }

    // **** ENREGISTRE LE CONTACT ET REVIENT SUR LA LISTE DE CONTACTS **** //
    private class doneClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (txt1.getText().equals(prenomB)) {
                txt1.setText(vide);
            }
            if (txt2.getText().equals(nomB)) {
                txt2.setText(vide);
            }
            if (txt3.getText().equals(numeroB)) {
                txt3.setText(vide);
            }
            if (txt4.getText().equals(emailB)) {
                txt4.setText(vide);
            }
            if (txt5.getText().equals(adresseB)) {
                txt5.setText(vide);
            }
            if (txt6.getText().equals(anniB)) {
                txt6.setText(vide);
            }
            if (txt7.getText().equals(groupeB)) {
                txt7.setText(vide);
            }
            Contact cc = new Contact(UUID.randomUUID(), txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(), txt5.getText(), txt6.getText(), txt7.getText(), user);
            contactA.addC(cc);
            refreshC();
            guit.setCurrentPanel("contacts");
        }
    }

    // **** AJOUTE UNE PHOTO EN APPELANT L'APP GALLERIE **** //
    private class addPhotoClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            guit.setCurrentPanel("gallerie");
            guic.switcheditadd = 3;
            guit.backPosition = 5;
            guit.backPositionAppC = 1;
        }
    }

// **** VIDE LES CHAMPS DE TEXTE **** //
    public void refreshC() {
        txt1.setText(prenomB);
        txt2.setText(nomB);
        txt3.setText(numeroB);
        txt4.setText(emailB);
        txt5.setText(adresseB);
        txt6.setText(anniB);
        txt7.setText(groupeB);
        user = new ImageIcon("src/images/user.png");
        iconeR = new ImageIcon(user.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        buttonImageContact.setIcon(iconeR);
        System.out.println("refresh image");
    }

    // **** ACTUALISE LA PHOTO **** //
    public void refreshPhoto() {
        panelImageContact.removeAll();
        updateUI();
        icone = new ImageIcon(user.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        buttonImageContact.setIcon(icone);
        panelImageContact.add(buttonImageContact);
    }

    public ImageIcon getUser() {
        return user;
    }

    public void setUser(ImageIcon user) {
        this.user = user;
    }

}
