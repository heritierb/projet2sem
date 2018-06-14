package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import structure.AppContact;
import structure.Contact;

// **** PANEL D'EDITION DE CONTACT, ACCES POUR SAUVEGARDER UNE MODIF + APPGALLERIE POUR CHANGER LA PHOTO **** //
public class GUIEditContact extends JPanel implements Serializable {

    // **** INSTANCE GUITelephone **** // Recupere la method permettant de switch la card
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUIEditContact.this);

    // **** INSTANCES **** // + Recupere le tableau de contacts
    AppContact contactA;
    Contact contactX;
    GUIContacts guic;
    private ArrayList<Contact> arrayCc;

    private ImagePanel contactDetails = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private JPanel panelCenter = new JPanel();
    private JPanel panelDetails = new JPanel();
    private JPanel panelNorth = new JPanel();
    private JPanel panelWest = new JPanel();
    private JPanel panelNtm = new JPanel();
    private JPanel empty = new JPanel();
    private JPanel empty2 = new JPanel();
    private JPanel panelSouth = new JPanel();
    private JPanel panelEast = new JPanel();
    private JPanel panelSud = new JPanel();
    private JPanel panelImageContact = new JPanel();

    private ImageIcon save = new ImageIcon("src/images/save.png");
    private ImageIcon cancel = new ImageIcon("src/images/cancel.png");
    private ImageIcon addImage = new ImageIcon("src/images/addImage.png");
    private ImageIcon symbol = new ImageIcon("src/images/symbol.png");
    private ImageIcon delete = new ImageIcon("src/images/delete.png");
    private ImageIcon delete2 = new ImageIcon("src/images/delete2.png");
    private ImageIcon refresh = new ImageIcon("src/images/refresh.png");
    private ImageIcon confirm = new ImageIcon("src/images/confirm.png");
    private ImageIcon user;
    ImageIcon icone = new ImageIcon("src/images/user.png");
    private ImageIcon iconeX;

    private JButton buttonImageContact = new JButton();
    private JButton buttonCancel = new JButton(cancel);
    private JButton buttonSave = new JButton(save);
    private JButton buttonCancel2 = new JButton(delete2);
    private JButton buttonConfirm = new JButton(confirm);
    private JButton buttonDelete = new JButton(delete);
    private JButton BaddImage = new JButton(addImage);

    private JLabel symbolP = new JLabel(symbol);
    private JLabel refreshP = new JLabel(refresh);
    private JLabel sure = new JLabel("<html>Etes-vous sûr de vouloir<br/>supprimer ce contact ?</html>");

    private String parametre = "";
    private String vide = "";
    private String prenomB = "Entrez le prénom";
    private String nomB = "Entrez le nom";
    private String numeroB = "Entrez le numéro";
    private String emailB = "Entrez l'email";
    private String adresseB = "Entrez l'adresse";
    private String anniB = "Entrez la date de naissance";
    private String groupeB = "Entrez le groupe";

    private JTextField txt = new JTextField();
    private JTextField txtboucle = new JTextField();
    private JTextField txt1 = new JTextField();
    private JTextField txt2 = new JTextField();
    private JTextField txt3 = new JTextField();
    private JTextField txt4 = new JTextField();
    private JTextField txt5 = new JTextField();
    private JTextField txt6 = new JTextField();
    private JTextField txt7 = new JTextField();

    private Color blanc = new Color(255, 255, 255);
    private Font ecriture = new Font("SANS_SERIF", Font.ITALIC, 18);
    private int indexC;
    private Font fonto = new Font("Dialog", Font.BOLD, 15);

    // **** CONSTRUCTEUR **** //
    public GUIEditContact(GUITelephone guit, AppContact contactA, GUIContacts guic) {
        // **** Récupération instances GUITelephone, GUIContacts, AppContact **** //
        this.guit = guit;
        this.guic = guic;
        this.contactA = contactA;

        // **** AJOUT DU PANEL PRINCIPAL **** //
        add(contactDetails);
        // **** APPELLE LA METHODE QUI REFRESH LES CHAMPS DU CONTACT **** //
        refreshE();
        // **** OPTIONS DE BASE **** //
        contactDetails.setOpaque(false);
        setBackground(Color.BLACK);
        contactDetails.setPreferredSize(new Dimension(480, 683));
        contactDetails.setLayout(new BorderLayout());
        contactDetails.add(panelCenter, BorderLayout.CENTER);
        contactDetails.add(panelNorth, BorderLayout.NORTH);
        contactDetails.add(panelSud, BorderLayout.SOUTH);
        contactDetails.add(panelWest, BorderLayout.EAST);
        contactDetails.add(panelEast, BorderLayout.WEST);
        panelDetails.setOpaque(false);
        panelDetails.setPreferredSize(new Dimension(480, 580));
        empty2.setOpaque(false);

        // **** CENTER **** // CHAMPS DU CONTACT + IMAGE DU CONTACT
        buttonImageContact.setContentAreaFilled(false);
        buttonImageContact.setBorder(BorderFactory.createLineBorder(WHITE));
        panelImageContact.setOpaque(false);
        buttonImageContact.addActionListener(new changePhotoClick());
        panelImageContact.add(buttonImageContact);
        panelDetails.setLayout(new GridLayout(7, 1, 0, 0));
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setOpaque(false);
        panelCenter.add(panelDetails, BorderLayout.CENTER);

        // **** WEST **** // BOUCLE POUR RAJOUTER DES LOGOS DE REFRESH
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

        // **** NORTH **** // BOUTON SAVE DU CONTACT
        panelNorth.setLayout(new BorderLayout());
        buttonSave.setContentAreaFilled(false);
        buttonSave.setBorderPainted(false);
        panelNorth.add(panelNtm, BorderLayout.CENTER);
        panelNtm.setOpaque(false);
        panelNtm.add(buttonSave);
        //panelNorth.add(empty, BorderLayout.SOUTH);
        empty.setPreferredSize(new Dimension(480, 5));
        empty.setOpaque(true);
        panelNorth.setPreferredSize(new Dimension(280, 85));
        panelNorth.setOpaque(false);
        buttonSave.addActionListener(new GUIEditContact.doneClick());
        refreshP.requestFocus();

        // **** SOUTH **** // SUPPRESSION DU CONTACT + CONFIRMATION SUPPRESSION
        panelSud.setLayout(new BoxLayout(panelSud, BoxLayout.Y_AXIS));
        panelSud.setPreferredSize(new Dimension(480, 100));
        panelSud.add(panelSouth);
        panelSud.setOpaque(false);
        panelSouthRefresh();
    }

    public GUIEditContact() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // **** POUR CHAQUE TXT DE LA BOUCLE DES CHAMPS, CREE UN NOUVEAU TXT **** //
    public JTextField CreationFieldContact(JTextField txt) {
        txt = new JTextField();
        return txt;
    }

    // **** REPAINT DU PANELDETAILS => APPELLE DE LA METHODE D'AFFICHAGE **** //
    public void refreshE() {
        panelDetails.removeAll();
        updateUI();
        //Si le tableau de contacts est vide, n'appelle pas la méthode d'affichage
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
            txtboucle.setMaximumSize(new Dimension(480, 50));
            txtboucle.setMinimumSize(new Dimension(480, 50));
            // **** DE 0 à 6 POUR LE PRENOM, NOM, NUMERO, EMAIL, ADRESSE, ANNIVERSAIRE, GROUPE **** //
            //SI LE TEXTE EST VIDE => REMPLISSAGE AVEC UN TEXTE PAR DEFAUT
            //SI LE TEXTE EST REMPLI, LE RECUPERE
            switch (j) {
                case 0:
                    txt1 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getPrenom());
                    if (txt1.getText().equals(vide)) {
                        txt1.setText(prenomB);
                    }
                    break;
                case 1:
                    txt2 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getNom());
                    if (txt2.getText().equals(vide)) {
                        txt2.setText(nomB);
                    }
                    break;
                case 2:
                    txt3 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getNumero());
                    if (txt3.getText().equals(vide)) {
                        txt3.setText(numeroB);
                    }
                    break;
                case 3:
                    txt4 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getEmail());
                    if (txt4.getText().equals(vide)) {
                        txt4.setText(emailB);
                    }
                    break;
                case 4:
                    txt5 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getAdresse());
                    if (txt5.getText().equals(vide)) {
                        txt5.setText(adresseB);
                    }
                    break;
                case 5:
                    txt6 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getAnniversaire());
                    if (txt6.getText().equals(vide)) {
                        txt6.setText(anniB);
                    }
                    break;
                case 6:
                    txt7 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(indexC).getGroupe());
                    if (txt7.getText().equals(vide)) {
                        txt7.setText(groupeB);
                    }
                    break;
            }
            // **** SUR CHAQUE ACTIONLISTENER : SI LE TEXTE EST VIDE LE REMPLACE PAR UN TEXTE PAR DEFAUT **** //
            // FOCUSGAIN : LORSQUE QU'ON CLIQUE SUR UN TEXTE PAR DEFAUT, VIDE LE CHAMP
            // FOCUSLOST : LORSQUE QU'ON CLIQUE AILLEURS, LE TEXTE PAR DEFAUT REVIENT SI ON N'A RIEN REMPLI
            txt1.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent arg0) {
                    if (txt1.getText().equals(prenomB)) {
                        txt1.setText(vide);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    if (txt1.getText().equals(vide)) {
                        txt1.setText(prenomB);
                    }
                }
            });
            txt2.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent arg0) {
                    if (txt2.getText().equals(nomB)) {
                        txt2.setText(vide);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    if (txt2.getText().equals(vide)) {
                        txt2.setText(nomB);
                    }
                }
            });
            txt3.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent arg0) {
                    if (txt3.getText().equals(numeroB)) {
                        txt3.setText(vide);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    if (txt3.getText().equals(vide)) {
                        txt3.setText(numeroB);
                    }
                }
            });
            txt4.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent arg0) {
                    if (txt4.getText().equals(emailB)) {
                        txt4.setText(vide);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    if (txt4.getText().equals(vide)) {
                        txt4.setText(emailB);
                    }
                }
            });
            txt5.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent arg0) {
                    if (txt5.getText().equals(adresseB)) {
                        txt5.setText(vide);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    if (txt5.getText().equals(vide)) {
                        txt5.setText(adresseB);
                    }
                }
            });
            txt6.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent arg0) {
                    if (txt6.getText().equals(anniB)) {
                        txt6.setText(vide);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    if (txt6.getText().equals(vide)) {
                        txt6.setText(anniB);
                    }
                }
            });
            txt7.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent arg0) {
                    if (txt7.getText().equals(groupeB)) {
                        txt7.setText(vide);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    if (txt7.getText().equals(vide)) {
                        txt7.setText(groupeB);
                    }
                }
            });

            refreshP.requestFocus();
            panelDetails.add(txtboucle);
            panelCenter.add(panelImageContact, BorderLayout.SOUTH);
            // **** AJOUT DE L'IMAGE DU CONTACT **** //
            buttonImageContact.setIcon(user);
            user = new ImageIcon(new ImageIcon(contactA.getArrayContacts().get(indexC).getImageContact().getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            panelImageContact.setPreferredSize(new Dimension(158, 158));
        }
    }

    // **** ENREGISTRE LE CONTACT ET REVIENT SUR LA LISTE DE CONTACTS **** //
    private class doneClick implements ActionListener {

        @Override
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
            if(guit.guiimage.retour == 1){
            contactX.setImageContact(icone);
            }
            contactA.editCI(contactX);
            guit.setCurrentPanel("contacts");
        }
    }

    // **** REPAINT => SUPPRESSION A CONFIRMATION **** //
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

    // **** CONFIRME LA SUPPRESSION ET REVIENT SUR LA LISTE DE CONTACTS **** //
    private class deleteSecondClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            contactA.arrayContacts.remove(contactX);
            guit.setCurrentPanel("contacts");
            panelSouthRefresh();
        }
    }

    // **** DEMANDE LA CONFIRMATION DE SUPPRESSION D'UN CONTACT **** //
    private class deleteFirstClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panelSouth.removeAll();
            updateUI();
            panelSouth.setLayout(new FlowLayout());
            buttonConfirm.setContentAreaFilled(false);
            buttonCancel2.setContentAreaFilled(false);
            buttonConfirm.setPreferredSize(new Dimension(120, 120));
            buttonCancel2.setPreferredSize(new Dimension(120, 120));
            buttonConfirm.setBorderPainted(false);
            sure.setOpaque(false);
            sure.setRequestFocusEnabled(false);
            sure.setOpaque(false);
            sure.setForeground(Color.WHITE);
            sure.setFont(fonto);
            sure.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
            buttonCancel2.setBorderPainted(false);
            panelSouth.add(buttonConfirm);
            panelSouth.add(sure);
            panelSouth.add(buttonCancel2);
            panelSouth.setPreferredSize(new Dimension(120, 120));
            buttonConfirm.addActionListener(new GUIEditContact.deleteSecondClick());
            buttonCancel2.addActionListener(new GUIEditContact.deleteReturnClick());
        }
    }

    // **** ANNULE LA SUPPRESSION ET REMET L'ICONE SUPPRESSION **** //
    private class deleteReturnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panelSouthRefresh();
        }
    }

    // **** CHANGE LA PHOTO EN APPELANT L'APP GALLERIE **** //
    private class changePhotoClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            guit.setCurrentPanel("gallerie");
            guic.switcheditadd = 2;
            guit.backPosition = 6;
            guit.backPositionAppC = 2;
        }
    }

    // **** POUR CHAQUE LOGO DE LA BOUCLE,  CREE UN NOUVEAU LOGO **** //
    public ImageIcon CreationImageIcon(ImageIcon refresh) {
        refresh = new ImageIcon("src/images/refresh.png");
        return refresh;
    }

    // **** ACTUALISE LA PHOTO **** //
    public void refreshPhoto() {
        panelImageContact.removeAll();
        updateUI();
        iconeX = new ImageIcon(icone.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        buttonImageContact.setIcon(iconeX);
        panelImageContact.add(buttonImageContact);
    }
}