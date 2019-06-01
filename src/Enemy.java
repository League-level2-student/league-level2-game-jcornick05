import java.awt.Graphics;
import java.util.Random;

public class Enemy extends GameObject {
int speed;
int movementType;
int arcMovement=0;
int straightMovement=1;
int wiggleMovement=2;
int rand = new Random().nextInt(6);
int side = new Random().nextInt(2)*1000;
int height = new Random().nextInt(1001);
	public Enemy(int x, int y, int width, int height, int speed, int movementType) {
		super(x, y, width, height);
		this.speed = speed;
		this.movementType=movementType;
		speed= rand;
	}
	public void draw(Graphics g) {
		g.fillRect(side, height, 15, 15);
		
		if (side>490&&side<510) {
			speed=-speed;
		}
		side-=speed;
		
	}
}
