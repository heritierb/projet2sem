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
		ImageIcon image2;
		
		icon.getIconHeight();
		int hauteurOriginale=icon.getIconHeight();
		int largeurOriginale=icon.getIconWidth();
		int hauteurFinale=600;
		int largeurFinale=480;
		int ratio;
		
		if (hauteurOriginale>600){
			hauteurFinale=600;
			ratio=hauteurOriginale/hauteurFinale;
			largeurFinale=largeurOriginale/ratio;
		}
		else
			hauteurFinale=hauteurOriginale;
		
		if(largeurOriginale>480){
			largeurFinale=480;
			ratio=largeurOriginale/largeurFinale;
			hauteurFinale=hauteurOriginale/ratio;
		}
		else
			largeurFinale=largeurOriginale;
		
		imageRedim = icon.getImage().getScaledInstance(largeurFinale, hauteurFinale,
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
		
		img.setIcon(new ImageIcon(imageRedim));
		panelImageEtScroll.add(img);
		add(panelImageEtScroll, BorderLayout.CENTER);

		this.validate();
		this.repaint();
		
		

	}

}
