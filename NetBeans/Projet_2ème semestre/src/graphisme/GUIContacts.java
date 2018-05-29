package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.SANS_SERIF;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    // **** CREATIONS PANELS **** //
    private ImagePanel contacts = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
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
    Font ecriture = new Font("SANS_SERIF",50,30);
    private JLabel list = new JLabel();
    private JLabel label2 = new JLabel(" Last name ");
    private JLabel lContact = new JLabel();

    public GUIContacts(GUITelephone guit, AppContact contactA) {
        
        //**** RECUPERE LES INSTANCES DANS LE CONSTRUCTEUR **** //
        this.guit = guit;
        this.contactA = contactA;
        
        // **** CONFIG DE BASE **** //
        add(contacts);
        contacts.setBorder(new EmptyBorder(0, 0, 0, 0));
        contacts.setLayout(new BorderLayout());
        contacts.setOpaque(false);

        // **** AJOUT DU PANEL NORD **** // bouton add un contact
        contacts.add(panelnorth, BorderLayout.NORTH);
        panelntm.add(buttonAddContact);
        panelnorth.setLayout(new BorderLayout());
        panelnorth.add(panelntm, BorderLayout.NORTH);
        panelntm.setLayout(new FlowLayout());
        panelnorth.add(empty, BorderLayout.SOUTH);
        panelnorth.setOpaque(false);
        panelntm.setOpaque(true);
        empty.setOpaque(true);
        empty.setPreferredSize(new Dimension(480, 5));
        buttonAddContact.addActionListener(new ClickNewContact());
        buttonAddContact.setContentAreaFilled(false);
        buttonAddContact.setBorderPainted(false);

        // **** AJOUT DE LA LISTE DES CONTACTS **** // Appelle afficheUnit qui donne la liste des contacts
        panelcentscroll.setLayout(new BorderLayout());
        panelcenter.setLayout(new GridLayout(12, 1));
        panelcentscroll.setOpaque(false);
        panelcenter.setOpaque(false);
        panelScroll.setOpaque(false);
        panelcentscroll.setPreferredSize(new Dimension(480, 605));
        panelcenter.setPreferredSize(new Dimension(463, 605));
        panelScroll.setPreferredSize(new Dimension(15, 605));
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
            cpt.setPreferredSize(new Dimension(10, 10));
            cpt.setContentAreaFilled(false);
            cpt.setHorizontalAlignment(10);
            cpt.setFont(ecriture);
            panelcenter.add(cpt);
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
        afficheUnit();
        System.out.println("test refresh");
    }
    // **** BOUTON POUR AJOUTER UN CONTACT **** //
    private class ClickNewContact implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            guit.setCurrentPanel("newcontact");
            guit.setBackPosition(3);
            refresh();
        }
    }
}
