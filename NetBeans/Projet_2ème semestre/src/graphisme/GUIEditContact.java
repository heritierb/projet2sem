package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
    int i = 2;

    public GUIEditContact(GUITelephone guit, AppContact contactA) {
        this.guit = guit;
        this.contactA = contactA;
        add(contactDetails);
        contactDetails.setOpaque(false);
        contactDetails.setPreferredSize(new Dimension(480,683));

        contactDetails.setLayout(new BorderLayout());

        for (int j = 0; j < 7; j++) {
            txtboucle = CreationFieldContact(txt);
            txtboucle.setOpaque(false);
            txtboucle.setHorizontalAlignment(SwingConstants.CENTER);
            txtboucle.setForeground(blanc);
            txtboucle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
            txtboucle.setFont(ecriture);
            txtboucle.setEditable(false);
            switch (j) {
                case 0:
                    txt1 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(i).getPrenom());
                    break;
                case 1:
                    txt2 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(i).getNom());
                    break;
                case 2:
                    txt3 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(i).getNumero());
                    break;
                case 3:
                    txt4 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(i).getEmail());
                    break;
                case 4:
                    txt5 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(i).getAdresse());
                    break;
                case 5:
                    txt6 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(i).getAnniversaire());
                    break;
                case 6:
                    txt7 = txtboucle;
                    txtboucle.setText(contactA.arrayContacts.get(i).getGroupe());
                    break;
            }
            panelDetails.add(txtboucle);
            panelDetails.setOpaque(false);
        }

        panelDetails.setLayout(new GridLayout(10, 1, 0, 0));
        contactDetails.add(panelDetails, BorderLayout.CENTER);

    }
    // **** POUR CHAQUE TXT DE LA BOUCLE DES CHAMPS **** //

    public JTextField CreationFieldContact(JTextField txt) {
        txt = new JTextField();
        return txt;
    }

}
