import java.util.Random;

public class Enemy extends GameObject {
int speed;
int movementType;
int arcMovement=0;
int straightMovement=1;
int wiggleMovement=2;
int rand = new Random().nextInt(3);

	public Enemy(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
		
	}
}
