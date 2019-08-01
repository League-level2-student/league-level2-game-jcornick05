import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class GameObject {
	  int x = 1;
	 int y = 1;
	int width;
	int height;
	boolean isAlive = true;
	 static Rectangle collisionBox;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);

	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
        if (ObjectManager.score>=12) {
        	Enemy.rand = new Random().nextInt(3) +4;
		}
	}

	void draw(Graphics g) {

	}
}
