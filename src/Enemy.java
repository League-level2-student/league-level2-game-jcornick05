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
public BufferedImage Crosshair=GamePanel.Crosshair;
public BufferedImage explosion = GamePanel.explosion;
	public Enemy(int x, int y, int width, int height, int movementType) {
		super(x, y, width, height);
		this.movementType = movementType;
		speed = rand;
		//speed=1;
		this.y = new Random().nextInt(650);
		this.x = new Random().nextInt(2) * 1000;
		if (this.x > 500) {
			speed = -speed;
		}
		collisionBox.setBounds(this.x, this.y, width, height);
	}

	public void draw(Graphics g) {
		 g.setColor(Color.black);
		 //g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		
		g.drawImage(Emu, x, y,width,height, null);
		
		//System.out.println("enemy drawn");
	}
	public void update() {
		super.update();
		if (x > 490 && x < 500) {
			speed = -speed;
			y += 6;
		}
		x += speed;
	//	System.out.println("1234");
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

}
