import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmuHunt {
	JFrame frame;
	final static int width = 500;
	final static int height = 800;
	GamePanel gp;
	
	public static void main(String[] args) {
		EmuHunt e = new EmuHunt();
		e.setup();
	}
	 
 public EmuHunt(){
	 frame = new JFrame();
	 gp= new GamePanel();
 }
 
 void setup() {
	 frame.add(gp);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
      frame.addKeyListener(gp);
		
	    frame.pack();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gp.startGame();

 }

private void setDefaultCloseOperation(int exitOnClose) {
	// TODO Auto-generated method stub
	
}


}
