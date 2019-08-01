import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject {
	int speed;
	int movementType;
	int arcMovement = 0;
	int straightMovement = 1;
	int wiggleMovement = 2;
	static int rand = new Random().nextInt(2) +2;
public BufferedImage Emu=GamePanel.Emu;

	public Enemy(int x, int y, int width, int height, int movementType) {
		super(x, y, width, height);
		this.movementType = movementType;
		speed = rand;
		this.y = new Random().nextInt(901);
		this.x = new Random().nextInt(2) * 1000;
		if (this.x > 500) {
			speed = -speed;
		}
	}

	public void draw(Graphics g) {
		// g.setColor(Color.black);
		// g.fillRect(x, y, 15, 15);
		g.drawImage(Emu, x, y,27,27, null);
		if (x > 490 && x < 500) {
			speed = -speed;
			y += 6;
		}
		x += speed;
		System.out.println("enemy drawn");
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

}
