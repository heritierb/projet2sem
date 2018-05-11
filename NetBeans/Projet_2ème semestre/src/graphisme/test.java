package graphisme;

import javax.swing.JFrame;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GUIGallerie test = new GUIGallerie();
                test social = new test();
              
                
	}
        public test(){
            JFrame tamere = new JFrame();
            ImagePanel pan = new ImagePanel();
            
            tamere.add(pan);
            
            tamere.setVisible(true);
            
        }
}
