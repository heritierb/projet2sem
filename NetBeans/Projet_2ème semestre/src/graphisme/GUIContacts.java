package graphisme;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import structure.AppContact;
import structure.Contact;

public class GUIContacts extends JPanel implements Serializable {

    // **** INSTANCE GUITelephone **** // Recupere la method permettant de switch la card
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUIContacts.this);

    // **** INSTANCE AppContact **** // Recupere le tableau de contacts
    AppContact contactA;
    private ArrayList<Contact> arrayCc;

    // **** CREATION D'UNE LISTE DE BOUTONS DE CONTACTS **** //
    ArrayList<JButton> arrayButton = new ArrayList<>();
    Contact edit;

    // **** CREATIONS PANELS **** //
    private ImagePanel contacts = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private JPanel panelnorth = new JPanel();
    private JPanel panelcenter = new JPanel();
    private JPanel panelcentscroll = new JPanel();
    private JPanel panelntm = new JPanel();
    private JPanel empty = new JPanel();

    // **** CREATION SCROLLBAR **** //
    private JScrollPane panelScroll = new JScrollPane(panelcenter);

    // **** AUTRES COMPOSANTS **** // 
    ImageIcon addContact = new ImageIcon("src/images/addContact.png");
    private JButton buttonAddContact = new JButton(addContact);
    Font ecriture = new Font("SANS_SERIF", 50, 30);
    private JLabel list = new JLabel();
    private JLabel label2 = new JLabel(" Last name ");
    private JLabel lContact = new JLabel();
    Color blanc = new Color(255, 255, 255);
    UUID ID;
    int indexC;
    ImageIcon icon;
    int switcheditadd = 0;

    public GUIContacts(GUITelephone guit, AppContact contactA) {

        //**** RECUPERE LES INSTANCES DANS LE CONSTRUCTEUR **** //
        this.guit = guit;
        this.contactA = contactA;
        this.arrayButton = arrayButton;

        // **** CONFIG DE BASE **** //
        add(contacts);
        contacts.setBorder(new EmptyBorder(0, 0, 0, 0));
        contacts.setLayout(new BorderLayout());
        contacts.setOpaque(false);
        contacts.setBackground(null);

        // **** AJOUT DU PANEL NORD **** // bouton add un contact
        contacts.add(panelnorth, BorderLayout.NORTH);
        panelntm.add(buttonAddContact);
        panelnorth.setLayout(new BorderLayout());
        panelnorth.add(panelntm, BorderLayout.NORTH);
        panelntm.setLayout(new FlowLayout());
        panelnorth.add(empty, BorderLayout.SOUTH);
        panelnorth.setOpaque(false);
        panelntm.setOpaque(false);
        empty.setOpaque(true);
        empty.setPreferredSize(new Dimension(480, 5));
        buttonAddContact.addActionListener(new ClickNewContact());
        buttonAddContact.setContentAreaFilled(false);
        buttonAddContact.setBorderPainted(false);

        // **** AJOUT DE LA LISTE DES CONTACTS **** // Appelle afficheUnit qui donne la liste des contacts
        panelcentscroll.setLayout(new BorderLayout());
        panelcentscroll.setOpaque(false);
        panelcentscroll.setBackground(null);
        panelcentscroll.setBorder(null);
        panelcenter.setOpaque(false);
        panelcenter.setBackground(null);
        panelcenter.setBorder(null);
        panelScroll.getViewport().setOpaque(false);
        panelScroll.setOpaque(false);
        panelcentscroll.setPreferredSize(new Dimension(480, 606));
        panelScroll.setPreferredSize(new Dimension(15, 606));
        panelScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        afficheUnit();
        contacts.add(panelcentscroll, BorderLayout.CENTER);

    }

    // **** RECUPERE LA LISTE DES CONTACTS ET CREE DES BOUTONS PRENOM+NOM **** //
    public void afficheUnit() {
        arrayCc = contactA.getArrayContacts();

        for (int i = 0; i < contactA.getArrayContacts().size(); i++) {
            JButton migna = new JButton();
            JButton cpt = CreationBoutonContact(migna);

            cpt.setText(contactA.getArrayContacts().get(i).getPrenom() + " " + contactA.getArrayContacts().get(i).getNom());
            icon = new ImageIcon(new ImageIcon(contactA.getArrayContacts().get(i).getImageContact().getImage()).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            cpt.setIcon(icon);

            cpt.setIconTextGap(10);
            cpt.setMaximumSize(new Dimension(480, 50));
            cpt.setMinimumSize(new Dimension(480, 50));
            cpt.setContentAreaFilled(false);
            cpt.setHorizontalAlignment(10);
            cpt.setFont(ecriture);
            cpt.setForeground(blanc);
            cpt.addActionListener(new ClickContact());
            panelcenter.setPreferredSize(new Dimension(463, 52 * contactA.arrayContacts.size()));
            arrayButton.add(cpt);
            panelcenter.add(cpt);
            panelcenter.setLayout(new BoxLayout(panelcenter, BoxLayout.Y_AXIS));
            panelcentscroll.setPreferredSize(new Dimension(480, 585));
            panelcentscroll.add(panelScroll, BorderLayout.CENTER);
        }
    }

    // **** POUR CHAQUE BOUTON DE LA BOUCLE AFFICHEUNIT **** //
    public JButton CreationBoutonContact(JButton bouton) {
        bouton = new JButton();
        return bouton;
    }

    // **** EFFACE ET RECREE LA LISTE DE CONTACTS **** //
    public void refresh() {
        panelcenter.removeAll();
        updateUI();
        arrayButton.clear();
        afficheUnit();
    }

    // **** BOUTON POUR AJOUTER UN CONTACT **** //
    private class ClickNewContact implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            guit.setCurrentPanel("newcontact");
            guit.setBackPosition(3);
            refresh();
        }
    }

    // **** BOUTON POUR MODIFIER UN CONTACT **** //
    private class ClickContact implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton boutonClicked = (JButton) e.getSource();
            Contact edit = contactA.arrayContacts.get(arrayButton.indexOf(boutonClicked));
            indexC = contactA.arrayContacts.indexOf(edit);
            guit.setCurrentPanel("editcontact");
            guit.setBackPosition(3);
        }
    }

    public Contact getEdit() {
        return edit;
    }

    public void setEdit(Contact edit) {
        this.edit = edit;
    }

    public ArrayList<JButton> getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(ArrayList<JButton> arrayButton) {
        this.arrayButton = arrayButton;
    }

    public int getSwitcheditadd() {
        return switcheditadd;
    }

    public void setSwitcheditadd(int switcheditadd) {
        this.switcheditadd = switcheditadd;
    }

}
