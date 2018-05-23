package graphisme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import structure.AppContact;
import structure.Contact;

public class GUIContacts extends JPanel implements Serializable {

    AppContact contactA = new AppContact() {
    };
    private ArrayList<Contact> arrayCc = contactA.getArrayContacts();
    private ImagePanel contacts = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUIContacts.this);
    private JPanel panelnorth = new JPanel();
    private JPanel panelcenter = new JPanel();
    private JPanel panelntm = new JPanel();
    private JPanel empty = new JPanel();
    ImageIcon addContact = new ImageIcon("src/images/addContact.png");
    private JButton buttonAddContact = new JButton(addContact);
    private JLabel list = new JLabel();
    private JLabel label2 = new JLabel(" Last name ");

    public GUIContacts(GUITelephone guit) {
        this.guit = guit;
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
        contacts.add(panelcenter, BorderLayout.CENTER);
        panelcenter.setOpaque(false);
        panelcenter.setLayout(new GridLayout());
        panelcenter.setPreferredSize(new Dimension(480, 600));
        afficheUnit();

    }

    public void afficheUnit() {
        for (int i = 0; i < arrayCc.size(); i++) {
            JButton cpt = CreationBoutonContact(arrayCc.get(i).getPrenom() + "test");
            panelcenter.add(cpt);
            System.out.println("test affichage contacts"+i);
        }
    }

    public static JButton CreationBoutonContact(String par) {
        JPanel panelcontact = null;
        JButton bouton = new JButton((Icon) panelcontact);
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
