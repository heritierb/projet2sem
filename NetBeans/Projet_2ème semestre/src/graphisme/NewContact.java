package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class NewContact extends JFrame{
    
    private JFrame fen = new JFrame("New contact");
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
  

    
    	public NewContact() {
                setTitle("New contact");
        	setPreferredSize(new Dimension(480, 800));
                ImagePanel fondecran = new ImagePanel();
		setResizable(false);
                add(fondecran, BorderLayout.NORTH);
                
		add(panel_center, BorderLayout.CENTER);
                panel_center.setLayout(new GridLayout(7, 1, 14, 50));
                panel_center.add(txt1);
                panel_center.add(txt2);
                panel_center.add(txt3);
                panel_center.add(txt4);
                panel_center.add(txt5);
                panel_center.add(txt6);
                panel_center.add(txt7);
                txt1.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt1.setBackground(fondecran.getBackground());
                txt2.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt2.setBackground(fondecran.getBackground());
                txt3.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt3.setBackground(fondecran.getBackground());
                txt4.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt4.setBackground(fondecran.getBackground());
                txt5.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt5.setBackground(fondecran.getBackground());
                txt6.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt6.setBackground(fondecran.getBackground());
                txt7.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
                txt7.setBackground(fondecran.getBackground());
                panel_center.setPreferredSize(new Dimension(10,800));
                
                panel_west.setLayout(new GridLayout(7, 1, 14, 50));
                panel_west.add(label1);
                panel_west.add(label2);
                panel_west.add(label3);
                panel_west.add(label4);
                panel_west.add(label5);
                panel_west.add(label6);
                panel_west.add(label7);
                panel_west.setPreferredSize(new Dimension(100,800));
                add(panel_west, BorderLayout.WEST);
                
                panel_east.setPreferredSize(new Dimension(50,800));
                add(panel_east, BorderLayout.EAST);
                panel_north.setPreferredSize(new Dimension(100,100));
                add(panel_north, BorderLayout.NORTH);
                panel_south.setPreferredSize(new Dimension(100,100));
                add(panel_south, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
                setVisible(true);
                
	}
    
}
