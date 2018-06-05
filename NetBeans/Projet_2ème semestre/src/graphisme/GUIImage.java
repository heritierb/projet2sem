package graphisme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class GUIImage extends JPanel {
	
	Image imageRedim;

	private GUIGallerie guig = (GUIGallerie) SwingUtilities.getAncestorOfClass(
			GUIGallerie.class, GUIImage.this);
	private GUITelephone guit = (GUITelephone) SwingUtilities
			.getAncestorOfClass(GUITelephone.class, GUIImage.this);
	private JPanel panelImage = new JPanel();
	private JPanel panelImageEtScroll = new JPanel();
	private JScrollPane panelScroll = new JScrollPane(panelImage);

	public GUIImage(GUITelephone guit) {

	}

	public void update() {

		panelImageEtScroll.removeAll();
		updateUI();
		
		ImageIcon icon = new ImageIcon(GUIGallerie.getImageAAfficher());
		JLabel img = new JLabel(icon);
		ImagePanel image = new ImagePanel(new ImageIcon("y"));
		ImageIcon image2;
		
		imageRedim = icon.getImage().getScaledInstance(480, 600,
				java.awt.Image.SCALE_SMOOTH);
		image2 = new ImageIcon(imageRedim);

		panelImage.setLayout(new FlowLayout());
		panelImage.setOpaque(false);
		panelImage.setBackground(null);
		panelImage.setBorder(null);
		panelImage.setPreferredSize(new Dimension(480, image2.getIconHeight()));

		panelImageEtScroll.setLayout(new BorderLayout());
		panelImageEtScroll.setOpaque(false);
		panelImageEtScroll.setBackground(null);
		panelImageEtScroll.setBorder(null);
		panelImageEtScroll.setPreferredSize(new Dimension(480, 650));
		
		
		//image.add(img);
		img.setIcon(new ImageIcon(imageRedim));
		panelImageEtScroll.add(img);
		add(panelImageEtScroll, BorderLayout.CENTER);

		this.validate();
		this.repaint();
		
		

	}
	void retour(){
		
		guit.remove(panelImageEtScroll);
	}

}
