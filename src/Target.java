import java.awt.MouseInfo;
import java.awt.Point;

public class Target {
	int targetX;
	int targetY;
	int targetWidth = 25;
	int targetHeight = 20;
Point clicked;
	public Target() {

	}

	void update() {
Point mouse = MouseInfo.getPointerInfo().getLocation();
Point frame = EmuHunt.frame.getLocation();
clicked = new Point((int)(mouse.getX()-frame.getX()),(int)(mouse.getY()-frame.getY()));
targetX=(int) clicked.getX();
targetY=(int) clicked.getY();



}

}
