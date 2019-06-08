import java.awt.MouseInfo;
import java.awt.Point;

public class Target {
	static int targetX;
	static int targetY;
	static int targetWidth = 22;
	static int targetHeight = 20;
static Point clicked;
	public Target() {

	}

	public static void update() {
Point mouse = MouseInfo.getPointerInfo().getLocation();
Point frame = EmuHunt.frame.getLocation();
clicked = new Point((int)(mouse.getX()-frame.getX()),(int)(mouse.getY()-frame.getY()));
targetX=(int) clicked.getX();
targetY=(int) clicked.getY();



}

}
