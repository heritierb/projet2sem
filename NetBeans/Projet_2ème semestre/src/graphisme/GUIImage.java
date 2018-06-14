package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import structure.AppContact;
import structure.AppGallerie;
import structure.Contact;

public class GUIImage extends JPanel {

    private Image imageRedim;

    // ** INSTANCE GUITelephone **
    // Recupere la method permettant de switch la card
    private GUITelephone guit = (GUITelephone) SwingUtilities
            .getAncestorOfClass(GUITelephone.class, GUIImage.this);
    // private ImageIcon icon = new ImageIcon(GUIGallerie.getImageAAfficher());
    private ImageIcon iconSupprimer = new ImageIcon("src/images/cancel.png");
    private ImageIcon iconX;
    private ImageIcon confirm = new ImageIcon("src/images/confirm.png");
    private ImageIcon delete = new ImageIcon("src/images/delete.png");
    private JLabel img = new JLabel(iconX);
    private JPanel panelImage = new JPanel();
    private JPanel panelImageEtScroll = new JPanel();
    private JPanel panelSupprimer = new JPanel();
    private JPanel panelSouth = new JPanel();
    private JLabel sure = new JLabel("<html>Etes-vous sûr de vouloir<br/>supprimer cette image ?</html>");
    private JButton buttonSetImCt = new JButton(new ImageIcon(
            "src/images/addtouser.png"));
    private JButton boutonSupprimer = new JButton(delete);
    private JButton buttonConfirm = new JButton(confirm);
    private JButton buttonCancel2 = new JButton(iconSupprimer);
    private ArrayList<Contact> arrayC;
    private int hauteurFinale = 600;
    private int largeurFinale = 480;
    private int ratio;
    private int hauteurOriginale;
    private int largeurOriginale;
    Font fonto = new Font("Dialog", Font.BOLD, 15);
    GUIContacts guic;
    AppContact contactA;
    Contact contactZ;
    AppGallerie gallerieA;
    GUINewContact guinewcontact;
    GUIEditContact guieditcontact;
    GUIGallerie guig;
    int retour = 0;

    public GUIImage(GUITelephone guit, GUIContacts guic, AppContact contactA,
            GUINewContact guinewcontact, GUIEditContact guieditcontact,
            AppGallerie gallerieA, GUIGallerie guig) {
        this.guieditcontact = guieditcontact;
        this.guinewcontact = guinewcontact;
        this.guit = guit;
        this.guic = guic;
        this.guig = guig;
        this.contactA = contactA;
        this.gallerieA = gallerieA;
        arrayC = contactA.getArrayContacts();
        setLayout(new BorderLayout());
        panelImage.setLayout(new BorderLayout());
        panelImage.setOpaque(true);
        panelImage.setBackground(Color.BLACK);
        panelImage.setBorder(null);
        panelImage.setPreferredSize(new Dimension(480, 600));
        panelImageEtScroll.setLayout(new BorderLayout());
        panelImageEtScroll.setOpaque(true);
        panelImageEtScroll.setBackground(Color.BLACK);
        panelImageEtScroll.setBorder(null);
        panelImageEtScroll.setPreferredSize(new Dimension(480, 600));
        panelImageEtScroll.add(img);
        add(panelImageEtScroll, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        panelSouth.setPreferredSize(new Dimension(120, 120));
        setBackground(Color.BLACK);
    }

    /**
     *  méthode qui sert à afficher l'image sélectionnée dans la gallerie
     */
    public void update() {
        panelImageEtScroll.removeAll();
        panelSupprimer.removeAll();
        panelSouth.removeAll();
        updateUI();
        iconX = new ImageIcon(gallerieA.getFichiers()
                .get(guig.getNumeroImage()).getImageI().getImage());
        img = new JLabel(iconX);

        hauteurOriginale = iconX.getIconHeight();
        largeurOriginale = iconX.getIconWidth();

        if (hauteurOriginale > 600) {
            hauteurFinale = 600;
            ratio = hauteurOriginale / hauteurFinale;
            largeurFinale = largeurOriginale / ratio;
        } else {
            hauteurFinale = hauteurOriginale;
        }

        if (largeurOriginale > 480) {
            largeurFinale = 480;
            ratio = largeurOriginale / largeurFinale;
            hauteurFinale = hauteurOriginale / ratio;
        } else {
            largeurFinale = largeurOriginale;
        }

        imageRedim = iconX.getImage().getScaledInstance(largeurFinale,
                hauteurFinale, java.awt.Image.SCALE_SMOOTH);
        img.setIcon(new ImageIcon(imageRedim));
        panelImageEtScroll.add(img, BorderLayout.CENTER);
    }

    /**
     * méthode qui sert à afficher un panel pour supprimer l'image
     */
    public void panelSuppressionImage() {
        panelSouth.removeAll();
        updateUI();
        boutonSupprimer.addActionListener(new deleteFirstClick());
        boutonSupprimer.setContentAreaFilled(false);
        boutonSupprimer.setBorderPainted(false);
        panelSouth.setBackground(Color.BLACK);
        panelSouth.setOpaque(false);
        panelSouth.add(boutonSupprimer);
    }

    /**
     * afficher un panel pour ajouter l'image à un contact
     */
    public void panelAddContact() {
        panelSouth.removeAll();
        updateUI();
        panelSouth.setLayout(new BorderLayout());
        panelSouth.setOpaque(false);
        buttonSetImCt.setContentAreaFilled(false);
        buttonSetImCt.setPreferredSize(new Dimension(120, 120));
        buttonSetImCt.setBorderPainted(false);
        panelSouth.add(buttonSetImCt);
        buttonSetImCt.addActionListener(new GUIImage.setImCtClick());
    }
    /**
     * DEMANDE LA CONFIRMATION DE SUPPRESSION D'UN CONTACT
     * @author oppik
     *
     */

    private class deleteFirstClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            panelSouth.removeAll();
            updateUI();
            panelSouth.setLayout(new FlowLayout());  
            buttonConfirm.setContentAreaFilled(false);
            buttonCancel2.setContentAreaFilled(false);
            buttonConfirm.setPreferredSize(new Dimension(50, 50));
            buttonCancel2.setPreferredSize(new Dimension(50, 50));
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
            buttonConfirm.addActionListener(new Suppression());
            buttonCancel2.addActionListener(new deleteReturnClick());
        }
    }
        /**
         * ANNULE LA SUPPRESSION ET REMET L'ICONE SUPPRESSION
         * @author oppik
         *
         */
    private class deleteReturnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panelSuppressionImage();
        }
    }
    /**
     * class servant au listener de suppression d'image
     * @author oppik
     *
     */

    public class Suppression implements ActionListener {
        /**
         *  méthode qui supprime le fichier et change de panel 
         */

        public void actionPerformed(ActionEvent e) {

            File aSupprimer = new File(GUIGallerie.getImageAAfficher());
            aSupprimer.delete();
            gallerieA.fichiers.remove(GUIGallerie.getNumeroImage());
            guit.setCurrentPanel("gallerie");
        }
    }

    /**
     *  CHANGE LA PHOTO EN APPELANT L'APP GALLERIE 
     */
    private class setImCtClick implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (guic.switcheditadd == 3) {
                guinewcontact.user = new ImageIcon(gallerieA.getFichiers().get(guig.getNumeroImage()).getImageI().getImage());
                guit.setCurrentPanel("newcontact");
                guinewcontact.refreshPhoto();
                guit.backPosition = 3;
                guit.backPositionAppC = 0;

            } else if (guic.switcheditadd == 2) {
                guieditcontact.icone = new ImageIcon(gallerieA.getFichiers().get(guig.getNumeroImage()).getImageI().getImage());
                guit.setCurrentPanel("editcontact");
                guieditcontact.refreshPhoto();
                guit.backPosition = 3;
                retour = 1;
                guit.backPositionAppC = 0;
            }
        }
    }
}
