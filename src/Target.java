import java.awt.MouseInfo;
import java.awt.Point;

public class Target extends GameObject {
	static int targetX;
	static int targetY;
	static int targetWidth = 30;
	static int targetHeight = 28;
	static Point clicked;

	public Target() {
super(0,0,targetWidth, targetHeight);
	}

	public  void update() {
		super.update();
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		Point frame = EmuHunt.frame.getLocation();
		clicked = new Point((int) (mouse.getX() - frame.getX()), (int) (mouse.getY() - frame.getY()));
		targetX = (int) clicked.getX();
		targetY = (int) clicked.getY();

	}

}
