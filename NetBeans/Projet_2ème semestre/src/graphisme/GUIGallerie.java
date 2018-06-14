 package graphisme;
 
 
 import graphisme.GUIImage.Suppression;
 import graphisme.GUIImage.Suppression;

 import javax.imageio.stream.FileCacheImageInputStream;
 import javax.imageio.stream.FileCacheImageInputStream;
 import javax.swing.JButton;
 import javax.swing.JButton;

 import java.awt.BorderLayout;
 import java.awt.BorderLayout;
 import java.awt.Color;
 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 import java.nio.file.StandardCopyOption;
 import java.util.ArrayList;
 import java.util.ArrayList;
 import java.util.prefs.BackingStoreException;
 import java.util.prefs.BackingStoreException;

 import javax.swing.ImageIcon;
 import javax.swing.ImageIcon;
 import javax.swing.JFileChooser;
 import javax.swing.JFileChooser;
 import javax.swing.JFrame;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JScrollPane;
 import javax.swing.SwingUtilities;
 import javax.swing.SwingUtilities;

 import structure.AppGallerie;
 import structure.AppGallerie;
 import structure.Photo;
 import structure.Photo;

public class GUIGallerie extends JPanel {

    Photo ld;
    AppGallerie gallerieA;
    ImageIcon icone;
    String DIR = "src/photos/";
    static int TAILLE_BOUTON = 100;
    private ImagePanel GALERIE = new ImagePanel(new ImageIcon(
            "src/images/wallpaper.png"));
    private GUITelephone guit = (GUITelephone) SwingUtilities
            .getAncestorOfClass(GUITelephone.class, GUIGallerie.this);
    private ArrayList<String> fichiers2;
    private JPanel panelAjoutImage = new JPanel();
    private JPanel panelImageEtScroll = new JPanel();
    private JScrollPane panelScroll = new JScrollPane(panelImage,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private ImageIcon addImage = new ImageIcon("src/images/addImage.png");
    private JButton ajoutImage = new JButton(addImage);
    private int tailleScroll;
    private static JPanel panelImage = new JPanel();
    private static int numeroImage;
    private static ArrayList<JButton> tableauBouton = new ArrayList<JButton>();
    private static String imageAAfficher = "chemin image pas trouvé";

    public GUIGallerie(GUITelephone guit, AppGallerie gallerieA) {
        this.gallerieA = gallerieA;
        
        this.guit = guit;        
        File file = new File(DIR);
        if (file.isDirectory()) {
            String names[] = file.list();
            ArrayList<String> names_ok = new ArrayList<>();
            for (int i = 0; i < names.length; i++) {
                String m1 = names[i].concat(".jpg");
                if (m1 != null) {
                    names_ok.add(names[i]);
                }
                icone = new ImageIcon(DIR.concat(names[i]));
                Photo ldd = new Photo(DIR, ".jpg", icone);
                gallerieA.fichiers.add(ldd);
            }
        }
        affichageBouton();
        setBackground(Color.BLACK);
    }

    // **** création d'un panel avec toutes les photos. **** //
    public void affichageBouton() {

        tailleScroll = (gallerieA.getFichiers().size() / 3 + 1) * 116;

        panelImage.setLayout(new FlowLayout());
        panelImage.setOpaque(false);
        panelImage.setBackground(null);
        panelImage.setBorder(null);
        panelImage.setPreferredSize(new Dimension(480, tailleScroll));
        panelScroll.getViewport().setOpaque(false);
        panelScroll.setOpaque(false);
        panelScroll.setPreferredSize(new Dimension(15, 600));
        panelImageEtScroll.setLayout(new BorderLayout());
        panelImageEtScroll.setOpaque(false);
        panelImageEtScroll.setBackground(null);
        panelImageEtScroll.setBorder(null);
        panelImageEtScroll.setPreferredSize(new Dimension(480, 606));
        panelAjoutImage.setLayout(new FlowLayout());
        panelAjoutImage.setBackground(Color.BLACK);
        panelAjoutImage.setPreferredSize(new Dimension(480, 50));
        panelAjoutImage.add(ajoutImage);
        ajoutImage.setContentAreaFilled(false);
        ajoutImage.setBorderPainted(false);
        ajoutImage.setPreferredSize(new Dimension (32,32));
        add(panelAjoutImage, BorderLayout.NORTH);

        ajoutImage.addActionListener((ActionListener) new Ajout());
        for (int i = 0; i < gallerieA.getFichiers().size(); i++) {
            CreationBoutonImage(i);
        }
        // **** Affichage de la gallerie **** //
        GALERIE.add(panelImageEtScroll, BorderLayout.CENTER);
        GALERIE.setLayout(new FlowLayout());
        GALERIE.setOpaque(false);
        GALERIE.setPreferredSize(new Dimension(480, 683));
        add(GALERIE);

    }

    // **** Pour chaque image du dossier, céer un bouton avec un nom**** //
    public void CreationBoutonImage(int i) {

        JButton boutonImage = new JButton();
        icone = new ImageIcon(new ImageIcon(gallerieA.getFichiers().get(i)
                .getImageI().getImage()).getImage().getScaledInstance(
                TAILLE_BOUTON, TAILLE_BOUTON, Image.SCALE_SMOOTH));
        boutonImage.setIcon(icone);
        boutonImage.setName(gallerieA.getFichiers().get(i).getImageI()
                .toString());

        panelImage.add(boutonImage);
        boutonImage.addActionListener(new ClickImage());
        panelImageEtScroll.add(panelScroll);
        tableauBouton.add(boutonImage);
        boutonImage.setContentAreaFilled(false);
        boutonImage.setBorderPainted(false);
    }

    // **** Vide le panel avec images et boutons puis les réaffichent **** //
    public void updateImage() {
        panelImage.removeAll();
        GALERIE.removeAll();
        updateUI();
        tableauBouton.clear();
        affichageBouton();
    }

    // **** class Ajout pour le listener**** //
    private class Ajout implements ActionListener {

        JFileChooser frameChoix = new JFileChooser();
        JFrame frame = new JFrame();

        public void actionPerformed(ActionEvent e) {
            frameChoix.setCurrentDirectory(new java.io.File("C:/Users"));
            frameChoix.setDialogTitle("choix d'image");
            frameChoix.setPreferredSize(new Dimension(480, 500));
            frameChoix.setVisible(true);
            frameChoix.getFileView();
            add(frameChoix);
            frame.setAlwaysOnTop(true);
            int returnVal = frameChoix.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = frameChoix.getSelectedFile();
                Path pathNouvelleImage = Paths.get(file.getPath());
                Path pathGallerie = Paths.get("src/photos/".concat(file
                        .getName()));
                try {
                    // copie de l'image dans le dossier où toutes les photos du
                    // téléphone sont
                    Files.copy(pathNouvelleImage, pathGallerie,
                            StandardCopyOption.COPY_ATTRIBUTES);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // ajout de la nouvelle image au dossier "DIR"
                icone = new ImageIcon(DIR.concat(file.getName()));
                Photo ldd = new Photo(DIR, ".jpg", icone);
                gallerieA.fichiers.add(ldd);
                CreationBoutonImage(gallerieA.getFichiers().size() - 1);
                // le numéro de l'image -1 car la première image a le n°0

            }
        }

    }

    // **** classe pour le listener mis à chaque bouton image **** //
    private class ClickImage implements ActionListener {
        // **** chaque image ouvre la classe GUIImage **** //

        public void actionPerformed(ActionEvent e) {

            JButton button = (JButton) e.getSource();
            Photo ld = gallerieA.fichiers.get(tableauBouton
                    .indexOf(button));
            imageAAfficher = button.getName();

            numeroImage = gallerieA.fichiers.indexOf(ld);
            guit.guiimage.update();

            if (guit.backPositionAppC == 0) {
                guit.guiimage.panelSuppressionImage();
            } else if (guit.backPositionAppC == 1) {
                guit.guiimage.panelAddContact();
            } else if (guit.backPositionAppC == 2) {
                guit.guiimage.panelAddContact();
            }
            guit.guiimage.validate();
            guit.setCurrentPanel("image");
            guit.setBackPosition(4);

        }
    }

    // **** GETTERS&SETTERS **** //
    public ArrayList<String> getFichiers2() {
        return fichiers2;
    }

    public void setFichiers2(ArrayList<String> fichiers2) {
        this.fichiers2 = fichiers2;
    }

    public static void setTableauBouton(ArrayList<JButton> tableauBouton) {
        GUIGallerie.tableauBouton = tableauBouton;
    }

    public static JPanel getPanelImage() {
        return panelImage;
    }

    public void setPanelImage(JPanel panelImage) {
        this.panelImage = panelImage;
    }

    public static String getImageAAfficher() {

        return imageAAfficher;
    }

    public static int getNumeroImage() {
        return numeroImage;
    }

    public static ArrayList<JButton> getTableauBouton() {
        return tableauBouton;
    }
}
