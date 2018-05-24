package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

    AppContact contactA;

    private ArrayList<Contact> arrayCc;
    private ImagePanel contacts = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUIContacts.this);
    private JPanel panelnorth = new JPanel();
    private JPanel panelcenter = new JPanel();
    private JPanel panelntm = new JPanel();
    private JPanel empty = new JPanel();
    private JScrollPane scroll = new JScrollPane();
    ImageIcon addContact = new ImageIcon("src/images/addContact.png");
    private JButton buttonAddContact = new JButton(addContact);

    private JLabel list = new JLabel();
    private JLabel label2 = new JLabel(" Last name ");
    private JLabel lContact = new JLabel();

    public GUIContacts(GUITelephone guit, AppContact contactA) {
        this.guit = guit;
        this.contactA = contactA;
        add(contacts);
        deserializeObject();
        contacts.setBorder(new EmptyBorder(0, 0, 0, 0));
        contacts.setLayout(new BorderLayout());
        contacts.setOpaque(false);

        // **** AJOUT DU PANEL ADD CONTACT **** //
        contacts.add(panelnorth, BorderLayout.NORTH);
        panelnorth.setOpaque(false);
        panelnorth.setLayout(new BorderLayout());
        panelnorth.add(panelntm, BorderLayout.NORTH);
        panelntm.setLayout(new FlowLayout());
        panelntm.setOpaque(false);
        panelntm.add(buttonAddContact);
        panelnorth.add(empty, BorderLayout.SOUTH);
        empty.setPreferredSize(new Dimension(480, 5));
        empty.setOpaque(true);
        buttonAddContact.addActionListener(new ClickNewContact());
        buttonAddContact.setContentAreaFilled(false);
        buttonAddContact.setBorderPainted(false);

        // **** AJOUT DE LA LISTE DES CONTACTS **** //
        
        panelcenter.setOpaque(false);
        panelcenter.setLayout(new GridLayout(20,1));
        panelcenter.setPreferredSize(new Dimension(480, 600));   
        afficheUnit();
        JScrollPane panelScroll = new JScrollPane(panelcenter);
        contacts.add(panelScroll, BorderLayout.CENTER);

    }

    public void afficheUnit() {
        arrayCc = contactA.getArrayContacts();
        System.out.println("test1 affichage");
        for (int i = 0; i < contactA.getArrayContacts().size(); i++) {
                JButton migna = new JButton();
                JButton cpt = CreationBoutonContact(migna);
                cpt.setText(contactA.getArrayContacts().get(i).getPrenom() + " " + contactA.getArrayContacts().get(i).getNom());
                cpt.setPreferredSize(new Dimension(10,10));
                panelcenter.add(cpt);
        }
    }

    public JButton CreationBoutonContact(JButton bouton) {
        bouton = new JButton();
        return bouton;
    }

    public void refresh() {
        panelcenter.removeAll();

        updateUI();
        afficheUnit();
        System.out.println("test refresh");
    }

    private class ClickNewContact implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            guit.setCurrentPanel("newcontact");
            guit.setBackPosition(3);
            refresh();
        }
    }

    public void deserializeObject() {
        try {
            FileInputStream fichier = new FileInputStream("src/svg.ser");
            ObjectInputStream obfichier = new ObjectInputStream(fichier);
            arrayCc = (ArrayList<Contact>) obfichier.readObject();
            obfichier.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("test deseri");
    }

    public void serializeObject() {
        try {
            FileOutputStream fichier = new FileOutputStream("src/svg.ser");
            ObjectOutputStream obfichier = new ObjectOutputStream(fichier);
            obfichier.writeObject(arrayCc);
            obfichier.flush();
            obfichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("test seri");
    }
}
