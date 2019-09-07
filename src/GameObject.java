import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class GameObject {
	int x = 1;
	int y = 1;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionBox;
	static int frameCount = 0;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);

	}

	void update() {
		frameCount++;
		collisionBox.setBounds(x, y, width, height);
		if (ObjectManager.score >= 12 && ObjectManager.score < 18) {
			Enemy.rand = new Random().nextInt(3) + 4;
			ObjectManager.enemySpawnTime = 2300;
			
		//	ObjectManager.score = 49;
		}
		if (ObjectManager.score >= 18 && ObjectManager.score < 30) {
			Enemy.rand = new Random().nextInt(6) + 3;
			ObjectManager.enemySpawnTime = 2000;
		}
		if (ObjectManager.score >= 30 && ObjectManager.score < 35) {
			Enemy.rand = new Random().nextInt(7) + 4;
			ObjectManager.enemySpawnTime = 1000;
		}
		if (ObjectManager.score >= 35 && ObjectManager.score < 48) {
			Enemy.rand = new Random().nextInt(4) + 3;
			ObjectManager.enemySpawnTime = 30;
		}
		if (ObjectManager.score >= 48 && ObjectManager.score < 50) {
			Enemy.rand = new Random().nextInt(4) + 3;
			ObjectManager.enemySpawnTime = 2500;
		//	System.out.println("nack");

		}

		if (ObjectManager.score >= 50) {
			if (frameCount % 2000 == 0) {
				Enemy.rand++;
			}
			ObjectManager.enemySpawnTime+=2;
			if (ObjectManager.enemySpawnTime >= 300 && frameCount % 90 == 0) {
				ObjectManager.enemySpawnTime -= 299;
			}
			// System.out.println("happ");
		}

		if (Enemy.rand >= 15) {
			Enemy.rand = 4;
			// System.out.println("bap");
		}
		// System.out.println("happenighOUI");

	}

	void draw(Graphics g) {

	}
}
