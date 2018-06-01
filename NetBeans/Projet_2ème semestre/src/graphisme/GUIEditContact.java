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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import static java.util.UUID.randomUUID;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import structure.AppContact;
import structure.Contact;

public class GUIEditContact extends JPanel implements Serializable {

    // **** INSTANCE GUITelephone **** // Recupere la method permettant de switch la card
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUIEditContact.this);

    // **** INSTANCE AppContact **** // Recupere le tableau de contacts
    AppContact contactA;
    private ArrayList<Contact> arrayCc;

    private ImagePanel contactDetails = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private JPanel panelDetails = new JPanel();
    private JPanel panelNorth = new JPanel();
    private JPanel panelWest = new JPanel();
    private JPanel panelNtm = new JPanel();
    private JPanel empty = new JPanel();
    private JPanel panelSouth = new JPanel();
    private JPanel panelEast = new JPanel();
    ImageIcon done = new ImageIcon("src/images/done.png");
    ImageIcon cancel = new ImageIcon("src/images/cancel.png");
    ImageIcon addImage = new ImageIcon("src/images/addImage.png");
    ImageIcon symbol = new ImageIcon("src/images/symbol.png");
    ImageIcon delete = new ImageIcon("src/images/delete.png");
    ImageIcon refresh = new ImageIcon("src/images/refresh.png");
    private JButton buttonCancel = new JButton(cancel);
    private JButton buttonDone = new JButton(done);
    private JButton buttonCancel2 = new JButton(cancel);
    private JButton buttonDone2 = new JButton(done);
    private JLabel symbolP = new JLabel(symbol);
    private JButton buttonDelete = new JButton(delete);
    private JLabel refreshP = new JLabel(refresh);
    JButton BaddImage = new JButton(addImage);
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
    Color blanc = new Color(255, 255, 255);
    Font ecriture = new Font("SANS_SERIF", 50, 30);
    int indexC;
    Contact contactX;
    GUIContacts guic;

    public GUIEditContact(GUITelephone guit, AppContact contactA, GUIContacts guic) {
        this.guit = guit;
        this.guic = guic;
        this.contactA = contactA;

        add(contactDetails);
        refreshE();
        contactDetails.setOpaque(false);
        contactDetails.setPreferredSize(new Dimension(480, 683));
        contactDetails.setLayout(new BorderLayout());

        panelDetails.setLayout(new GridLayout(10, 1, 0, 0));
        contactDetails.add(panelDetails, BorderLayout.CENTER);
        contactDetails.add(panelNorth, BorderLayout.NORTH);
        contactDetails.add(panelSouth, BorderLayout.SOUTH);
        contactDetails.add(panelWest, BorderLayout.EAST);
        contactDetails.add(panelEast, BorderLayout.WEST);

        // **** WEST **** //
        panelWest.setLayout(new GridLayout(10, 1, 0, 0));
        panelWest.setPreferredSize(new Dimension(40, 600));
        panelWest.setOpaque(false);
        for (int i = 0; i < 7; i++) {
            refreshP = new JLabel(CreationImageIcon(refresh));
            panelWest.add(refreshP);
            refreshP.setBackground(blanc);
            refreshP.setOpaque(false);
        }
        // **** EAST **** //
        panelEast.setPreferredSize(new Dimension(40, 600));
        panelEast.setOpaque(false);

        // **** NORTH **** //
        panelNorth.setLayout(new BorderLayout());
        buttonDone.setContentAreaFilled(false);
        buttonCancel.setContentAreaFilled(false);
        BaddImage.setContentAreaFilled(false);
        buttonDone.setPreferredSize(new Dimension(35, 35));
        buttonCancel.setPreferredSize(new Dimension(35, 35));
        BaddImage.setPreferredSize(new Dimension(70, 70));
        buttonDone.setBorderPainted(false);
        buttonCancel.setBorderPainted(false);
        BaddImage.setBorderPainted(false);
        panelNorth.add(panelNtm, BorderLayout.NORTH);
        panelNtm.setLayout(new FlowLayout());
        panelNtm.setOpaque(false);
        panelNtm.add(buttonDone);
        panelNtm.add(BaddImage);
        panelNtm.add(buttonCancel);
        panelNorth.add(empty, BorderLayout.SOUTH);
        empty.setPreferredSize(new Dimension(480, 5));
        empty.setOpaque(true);
        panelNorth.setPreferredSize(new Dimension(280, 83));
        panelNorth.setOpaque(false);

        buttonDone.addActionListener(new GUIEditContact.doneClick());
        buttonCancel.addActionListener(new GUIEditContact.cancelClick());
        refreshP.requestFocus();

        // **** SOUTH **** //
        panelSouthRefresh();

    }

    // **** POUR CHAQUE TXT DE LA BOUCLE DES CHAMPS **** //
    public JTextField CreationFieldContact(JTextField txt) {
        txt = new JTextField();
        return txt;
    }

    public void refreshE() {
        panelDetails.removeAll();
        updateUI();
        //Si le tableau de contacts n'existe pas, ne fais rien
        if (contactA.arrayContacts.size() != 0) {
            contactX = contactA.arrayContacts.get(guic.indexC);
            indexC = contactA.arrayContacts.indexOf(contactX);
            afficheEdit();
        }
    }

    // **** AVEC UNE BOUCLE AFFICHE LES DETAILS DU CONTACT **** //
    public void afficheEdit() {
        for (int j = 0; j < 7; j++) {
            txtboucle = CreationFieldContact(txt);
            txtboucle.setOpaque(false);
            txtboucle.setHorizontalAlignment(SwingConstants.CENTER);
            txtboucle.setForeground(blanc);
            txtboucle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
            txtboucle.setFont(ecriture);
            switch (j) {
                case 0:
                    txt1 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getPrenom());
                    break;
                case 1:
                    txt2 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getNom());
                    break;
                case 2:
                    txt3 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getNumero());
                    break;
                case 3:
                    txt4 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getEmail());
                    break;
                case 4:
                    txt5 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getAdresse());
                    break;
                case 5:
                    txt6 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getAnniversaire());
                    break;
                case 6:
                    txt7 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getGroupe());
                    break;
            }
            // **** SUR CHAQUE ACTIONLISTENER : SI LE TEXTE EST VIDE LE REMPLACE PAR UN TEXTE PAR DEFAUT **** //
            // **** LORSQUE QU'ON CLIQUE SUR UN TEXTE PAR DEFAUT, VIDE LE CHAMP **** //
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
            panelDetails.add(txtboucle);
            panelDetails.setOpaque(false);
        }

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
            contactX.setPrenom(txt1.getText());
            contactX.setNom(txt2.getText());
            contactX.setNumero(txt3.getText());
            contactX.setEmail(txt4.getText());
            contactX.setAdresse(txt5.getText());
            contactX.setAnniversaire(txt6.getText());
            contactX.setGroupe(txt7.getText());
            contactA.editC(contactX);
            guit.setCurrentPanel("contacts");
        }
    }

    public void panelSouthRefresh() {
        panelSouth.removeAll();
        updateUI();
        panelSouth.setLayout(new BorderLayout());
        panelSouth.setOpaque(false);
        buttonDelete.setContentAreaFilled(false);
        buttonDelete.setPreferredSize(new Dimension(120, 120));
        buttonDelete.setBorderPainted(false);
        panelSouth.add(buttonDelete);
        buttonDelete.addActionListener(new GUIEditContact.deleteFirstClick());
    }

    // **** ANNULE L'EDITION DU ET REVIENT SUR LA LISTE DE CONTACTS **** //
    private class cancelClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            guit.setCurrentPanel("contacts");
        }
    }

    // **** CONFIRME LA SUPPRESSION ET REVIENT SUR LA LISTE DE CONTACTS **** //
    private class deleteSecondClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            contactA.arrayContacts.remove(contactX);
            guit.setCurrentPanel("contacts");
            panelSouthRefresh();
        }
    }

    // **** DEMANDE LA CONFIRMATION DE SUPPRESSION D'UN CONTACT **** //
    private class deleteFirstClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            panelSouth.removeAll();
            updateUI();
            panelSouth.setLayout(new FlowLayout());
            buttonDone2.setContentAreaFilled(false);
            buttonCancel2.setContentAreaFilled(false);
            buttonDone2.setPreferredSize(new Dimension(35, 35));
            buttonCancel2.setPreferredSize(new Dimension(35, 35));
            buttonDone2.setBorderPainted(false);
            buttonCancel2.setBorderPainted(false);
            panelSouth.add(buttonDone2);
            panelSouth.add(buttonCancel2);
            panelSouth.setPreferredSize(new Dimension(120, 120));
            buttonDone2.addActionListener(new GUIEditContact.deleteSecondClick());
            buttonCancel2.addActionListener(new GUIEditContact.deleteReturnClick());
        }
    }

    // **** ANNULE LA SUPPRESSION ET REMET L'ICONE SUPPRESSION **** //
    private class deleteReturnClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            panelSouthRefresh();
        }
    }

    public ImageIcon CreationImageIcon(ImageIcon refresh) {
        refresh = new ImageIcon("src/images/refresh.png");
        return refresh;
    }
}
