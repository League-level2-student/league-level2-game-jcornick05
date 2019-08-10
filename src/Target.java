import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;

public class Target extends GameObject {
	static int targetX;
	static int targetY;
	static int targetWidth = 30;
	static int targetHeight = 28;
	static Point clicked;
	static Rectangle hitbox=new Rectangle(20,20,20,20);

	public Target() {
super(0,0,targetWidth, targetHeight);

	}

	public  void update() {
		//super.update();
		hitbox.setBounds(x-1, y-1, 3, 3);
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		Point frame = EmuHunt.frame.getLocation();
		clicked = new Point((int) (mouse.getX() - frame.getX()), (int) (mouse.getY() - frame.getY()));
		targetX = (int) clicked.getX();
		targetY = (int) clicked.getY();
//System.out.println("58599525");
	}

}
