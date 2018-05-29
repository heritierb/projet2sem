package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import structure.AppContact;
import structure.Contact;

public class GUINewContact extends JPanel {

    AppContact contactA;
    GUIContacts guicontacts;
    private GUIContacts guic = (GUIContacts) SwingUtilities.getAncestorOfClass(GUIContacts.class, GUINewContact.this);
    private ArrayList<Contact> arrayC;
    private ImagePanel newcontact = new ImagePanel(new ImageIcon("src/images/wallpaper2.png"));
    private GUITelephone guit = (GUITelephone) SwingUtilities.getAncestorOfClass(GUITelephone.class, GUINewContact.this);
    private JPanel panel_center = new JPanel();
    private JPanel panel_west = new JPanel();
    private JPanel panel_east = new JPanel();
    private JPanel panel_north = new JPanel();
    private JPanel panel_ntm = new JPanel();
    private JPanel empty = new JPanel();

    //1.Nom 2.Prenom 3.Numero 4.Email 5.Adresse 6.Anni 7.Groupe
    private JLabel label1 = new JLabel(" First name ");
    private JLabel label2 = new JLabel(" Last name ");
    private JLabel label3 = new JLabel(" add number ");
    private JLabel label4 = new JLabel(" add email ");
    private JLabel label5 = new JLabel(" add address ");
    private JLabel label6 = new JLabel(" add birthday ");
    private JLabel label7 = new JLabel(" add group ");
    private JTextField txt1 = new JTextField(25);
    private JTextField txt2 = new JTextField(25);
    private JTextField txt3 = new JTextField(25);
    private JTextField txt4 = new JTextField(25);
    private JTextField txt5 = new JTextField(25);
    private JTextField txt6 = new JTextField(25);
    private JTextField txt7 = new JTextField(25);
    ImageIcon done = new ImageIcon("src/images/done.png");
    ImageIcon cancel = new ImageIcon("src/images/cancel.png");
    ImageIcon addImage = new ImageIcon("src/images/addImage.png");
    private JButton buttonCancel = new JButton(cancel);
    private JButton buttonDone = new JButton(done);
    JButton BaddImage = new JButton(addImage);
    Color blanc = new Color(255, 255, 255);
    Color blancasse = new Color(250, 250, 250);

    public GUINewContact(GUITelephone guit, AppContact contactA) {
        this.guit = guit;
        this.contactA = contactA;
        add(newcontact);
        arrayC = contactA.getArrayContacts();
        newcontact.setLayout(new BorderLayout());
        newcontact.setAlignmentY(0);
        newcontact.setPreferredSize(new Dimension(480, 683));
        newcontact.setOpaque(false);

        // **** CENTER **** //
        panel_center.setLayout(new GridLayout(8, 1, 15, 50));
        panel_center.add(txt1);txt1.setBackground(blanc);
        panel_center.add(txt2);txt2.setBackground(blanc);
        panel_center.add(txt3);txt3.setBackground(blanc);
        panel_center.add(txt4);txt4.setBackground(blanc);
        panel_center.add(txt5);txt5.setBackground(blanc);
        panel_center.add(txt6);txt6.setBackground(blanc);
        panel_center.add(txt7);txt7.setBackground(blanc);
        txt1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        txt2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        txt3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        txt4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        txt5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        txt6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        txt7.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        panel_center.setPreferredSize(new Dimension(280, 683));

        // **** WEST **** //
        panel_west.setLayout(new GridLayout(8, 1, 15, 50));
        panel_west.add(label1);label1.setForeground(blanc);
        panel_west.add(label2);label2.setForeground(blanc);
        panel_west.add(label3);label3.setForeground(blanc);
        panel_west.add(label4);label4.setForeground(blanc);
        panel_west.add(label5);label5.setForeground(blanc);
        panel_west.add(label6);label6.setForeground(blanc);
        panel_west.add(label7);label7.setForeground(blanc);
        panel_west.setPreferredSize(new Dimension(100, 600));

        // **** EAST **** //
        panel_east.setPreferredSize(new Dimension(100, 600));

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

    }
    // **** ENREGISTRE LE CONTACT ET REVIENT SUR LA LISTE DE CONTACTS **** //
    private class doneClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Contact cc = new Contact(txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(), txt5.getText(), txt6.getText(), txt7.getText());
            contactA.addC(cc);
            refreshC();
            guit.setCurrentPanel("contacts");
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
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        System.out.println("test refresh");
    }
}
