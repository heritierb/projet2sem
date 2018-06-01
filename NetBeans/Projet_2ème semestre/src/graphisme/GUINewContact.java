package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import com.sun.xml.internal.bind.v2.model.core.ID;
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
import javax.swing.border.EmptyBorder;
import structure.AppContact;
import structure.Contact;

public class GUINewContact extends JPanel {

    AppContact contactA;
    GUIContacts guicontacts;
    private GUIContacts guic = (GUIContacts) SwingUtilities.getAncestorOfClass(GUIContacts.class, GUINewContact.this);
    private ArrayList<Contact> arrayC;
    private ImagePanel newcontact = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUINewContact.this);
    private JPanel panel_center = new JPanel();
    private JPanel panel_west = new JPanel();
    private JPanel panel_east = new JPanel();
    private JPanel panel_north = new JPanel();
    private JPanel panel_ntm = new JPanel();
    private JPanel empty = new JPanel();

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
    ImageIcon done = new ImageIcon("src/images/done.png");
    ImageIcon cancel = new ImageIcon("src/images/cancel.png");
    ImageIcon addImage = new ImageIcon("src/images/addImage.png");
    ImageIcon symbol = new ImageIcon("src/images/symbol.png");
    private JButton buttonCancel = new JButton(cancel);
    private JButton buttonDone = new JButton(done);
    private JLabel symbolP = new JLabel(symbol);
    JButton BaddImage = new JButton(addImage);
    Color blanc = new Color(255, 255, 255);
    Color blancasse = new Color(250, 250, 250);
    Font ecriture = new Font("SANS_SERIF", Font.ITALIC, 18);
    Font ecritureI = new Font("SANS_SERIF", 50, 18);
    int n = 0;

    public GUINewContact(GUITelephone guit, AppContact contactA) {
        this.guit = guit;
        this.contactA = contactA;
        add(newcontact);
        arrayC = contactA.getArrayContacts();
        newcontact.setLayout(new BorderLayout());
        newcontact.setAlignmentY(0);
        newcontact.setPreferredSize(new Dimension(480, 683));
        newcontact.setOpaque(false);

        // **** WEST **** //
        panel_west.setLayout(new GridLayout(10, 1, 0, 0));
        for (int i = 0; i < 7; i++) {
            symbolP = new JLabel(CreationImageIcon(symbol));
            panel_west.add(symbolP);
            symbolP.setBackground(blanc);
            symbolP.setOpaque(false);
        }
        panel_west.setPreferredSize(new Dimension(40, 600));
        // **** EAST **** //
        panel_east.setPreferredSize(new Dimension(40, 600));

        // **** CENTER **** //
        panel_center.setLayout(new GridLayout(10, 1, 0, 0));
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
        panel_center.setPreferredSize(
                new Dimension(340, 683));

        // **** NORTH **** //
        panel_north.setLayout(new BorderLayout());
        buttonDone.setContentAreaFilled(false);
        buttonCancel.setContentAreaFilled(false);
        BaddImage.setContentAreaFilled(false);
        buttonDone.setPreferredSize(new Dimension(35, 35));
        buttonCancel.setPreferredSize(new Dimension(35, 35));
        BaddImage.setPreferredSize(new Dimension(70, 70));
        buttonDone.setBorderPainted(false);
        buttonCancel.setBorderPainted(false);
        BaddImage.setBorderPainted(false);
        panel_north.add(panel_ntm, BorderLayout.NORTH);
        panel_ntm.setLayout(new FlowLayout());
        panel_ntm.setOpaque(false);
        panel_ntm.add(buttonDone);
        panel_ntm.add(BaddImage);
        panel_ntm.add(buttonCancel);
        panel_north.add(empty, BorderLayout.SOUTH);
        empty.setPreferredSize(new Dimension(480, 5));
        empty.setOpaque(true);
        panel_north.setPreferredSize(new Dimension(280, 83));

        // **** COLOR+DISPOSITION **** //
        newcontact.add(panel_west, BorderLayout.WEST);
        newcontact.add(panel_east, BorderLayout.EAST);
        newcontact.add(panel_north, BorderLayout.NORTH);
        newcontact.add(panel_center);
        panel_center.setOpaque(false);
        panel_north.setOpaque(false);
        panel_east.setOpaque(false);
        panel_west.setOpaque(false);
        panel_north.setBorder(new EmptyBorder(0, 0, 0, 0));

        // **** ACTION LISTENERS ****//
        buttonDone.addActionListener(new doneClick());
        buttonCancel.addActionListener(new cancelClick());
        symbolP.requestFocus();
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
            Contact cc = new Contact(UUID.randomUUID(),txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(), txt5.getText(), txt6.getText(), txt7.getText());
            contactA.addC(cc);
            refreshC();
            guit.setCurrentPanel("contacts");
        }

        public int incr(int n) {
            return ++n;
        }
    }

// **** ANNULE LA CREATION DE CONTACTS ET REVIENT SUR LA LISTE DE CONTACTS **** //
    private class cancelClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            refreshC();
            guit.setCurrentPanel("contacts");
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
    }
}
