package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import static java.util.UUID.randomUUID;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import structure.Contact;

public class GUINewContact extends JPanel {
    
    private ImagePanel newcontact = new ImagePanel(new ImageIcon("src/images/wallpaper.png"));
    private GUITelephone guit;
    private JPanel panel_center = new JPanel();
    private JPanel panel_west = new JPanel();
    private JPanel panel_east = new JPanel();
    private JPanel panel_north = new JPanel();
    private JPanel panel_south = new JPanel();
   
    //0.ID 1.Nom 2.Prenom 3.Numero 4.Email 5.Adresse 6.Anni 7.Groupe
    private JLabel label1 = new JLabel("     First name ");
    private JLabel label2 = new JLabel("     Last name ");
    private JLabel label3 = new JLabel("     add number ");
    private JLabel label4 = new JLabel("     add email ");
    private JLabel label5 = new JLabel("     add address ");
    private JLabel label6 = new JLabel("     add birthday ");
    private JLabel label7 = new JLabel("     add group ");
    private JTextField txt1 = new JTextField(25);
    private JTextField txt2 = new JTextField(25);
    private JTextField txt3 = new JTextField(25);
    private JTextField txt4 = new JTextField(25);
    private JTextField txt5 = new JTextField(25);
    private JTextField txt6 = new JTextField(25);
    private JTextField txt7 = new JTextField(25);
    private JButton buttonDone = new JButton("Done");
    private JButton buttonCancel = new JButton("Cancel");
    ImageIcon addImage = new ImageIcon("src/images/addImage.jpg");
    JButton BaddImage = new JButton(addImage);
    Color blanc = new Color(255,255,255);
    Color blancasse = new Color (250,250,250);


    	public GUINewContact(GUITelephone guit) {
            this.guit = guit;
            add(newcontact);
            newcontact.setLayout(new BorderLayout());
            newcontact.setBorder(new EmptyBorder(0, 0, 0, 0));
            

                // **** CENTER **** //
                panel_center.setLayout(new GridLayout(7, 1, 12, 70));
                panel_center.add(txt1);
                panel_center.add(txt2);
                panel_center.add(txt3);
                panel_center.add(txt4);
                panel_center.add(txt5);
                panel_center.add(txt6);
                panel_center.add(txt7);
                txt1.setBackground(blanc);
                txt2.setBackground(blanc);
                txt3.setBackground(blanc);
                txt4.setBackground(blanc);
                txt5.setBackground(blanc);
                txt6.setBackground(blanc);
                txt7.setBackground(blanc);
                txt1.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt2.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt3.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt4.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt5.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt6.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt7.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                //panel_center.setPreferredSize(new Dimension(280,600));
                
                // **** WEST **** //
                panel_west.setLayout(new GridLayout(7, 1, 12, 70));
                panel_west.add(label1);
                panel_west.add(label2);
                panel_west.add(label3);
                panel_west.add(label4);
                panel_west.add(label5);
                panel_west.add(label6);
                panel_west.add(label7);
                label1.setForeground(blanc);label1.setSize(new Dimension(1,1));
                label2.setForeground(blanc);
                label3.setForeground(blanc);
                label4.setForeground(blanc);
                label5.setForeground(blanc);
                label6.setForeground(blanc);
                label7.setForeground(blanc);
                panel_west.setPreferredSize(new Dimension(100,600));
                
                // **** EAST **** //
                panel_east.setPreferredSize(new Dimension(100,600));
                
                // **** NORTH **** //
                buttonDone.setContentAreaFilled(false);
                buttonDone.setPreferredSize(new Dimension(80,28));
                buttonCancel.setContentAreaFilled(false);
                buttonCancel.setPreferredSize(new Dimension(80,28));
                BaddImage.setContentAreaFilled(false);
                BaddImage.setPreferredSize(new Dimension(80,70));
               
                panel_north.add(buttonDone);
                panel_north.add(BaddImage);
                panel_north.add(buttonCancel);
                //panel_north.setPreferredSize(new Dimension(480,78));
                
                // **** SOUTH **** //
                //panel_south.setPreferredSize(new Dimension(100,100));
                
                // **** COLOR+DISPOSITION **** //
                newcontact.add(panel_west, BorderLayout.WEST);
                newcontact.add(panel_east, BorderLayout.EAST);
                newcontact.add(panel_north, BorderLayout.NORTH);
                newcontact.add(panel_center, BorderLayout.CENTER);
//                newcontact.add(panel_south, BorderLayout.SOUTH);
                panel_center.setOpaque(false);
                panel_north.setOpaque(false);
                panel_south.setOpaque(false);
                panel_east.setOpaque(false);
                panel_west.setOpaque(false);
                panel_north.setBorder(new EmptyBorder(0, 0, 0, 0));
               // newcontact.setPreferredSize(new Dimension(480,700));
                
                // **** ACTION LISTENERS ****//
                buttonDone.addActionListener(new doneClick());

                newcontact.setOpaque(false);

                
	}
        
        public class doneClick implements ActionListener {  
		public void actionPerformed(ActionEvent e) { 
                    Contact joselasticot = new Contact(randomUUID(), txt1.getText(),txt2.getText(),txt3.getText(),txt4.getText(),txt5.getText(),txt6.getText(),txt7.getText());
                    joselasticot.addC();
                    
		}  
	}
}
