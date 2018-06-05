package graphisme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class GUIImage extends JPanel {

	private GUIGallerie guig = (GUIGallerie) SwingUtilities.getAncestorOfClass(
			GUIGallerie.class, GUIImage.this);
	private JPanel panelImage = new JPanel();
	private JPanel panelImageEtScroll = new JPanel();
	private JScrollPane panelScroll = new JScrollPane(panelImage);

	public GUIImage(GUITelephone guit) {

	}
	

	

	
	public void update(){
		this.removeAll();
		ImageIcon icon = new ImageIcon(GUIGallerie.getImageAAfficher());
		JLabel img = new JLabel(icon);
		ImagePanel image = new ImagePanel(new ImageIcon("y"));
		
		
				
		panelImage.setLayout(new FlowLayout());
		panelImage.setOpaque(false);
		panelImage.setBackground(null);
		panelImage.setBorder(null);
		
		
		panelImageEtScroll.setLayout(new BorderLayout());
		panelImageEtScroll.setOpaque(false);
		panelImageEtScroll.setBackground(null);
		panelImageEtScroll.setBorder(null);
		panelImageEtScroll.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
		
		panelScroll.getViewport().setOpaque(false);
		panelScroll.setOpaque(false);
		panelScroll.setPreferredSize(new Dimension(15, 600));
		
		image.add(img);
		add(image);
		
		
		
		add(panelImageEtScroll, BorderLayout.CENTER);
		
	}

}
