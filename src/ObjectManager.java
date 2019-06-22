import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 2500;
	int score = 0;
	boolean isAlive = true;
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public int scoreGetter() {
		return score;

	}

	void addEnemy(Enemy a) {
		enemies.add(a);
	}

	void draw(Graphics g) {
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		System.out.println(enemies.size());
	}

	void purgeObjects() {
		if (isAlive == false) {
		score++;

		}
	}

	public void checkCollision() {
		for (int i = 0; i < enemies.size(); i++) {
		
		if (Target.targetX == enemies.get(i).getX() && Target.targetY == enemies.get(i).getY()) {
			isAlive = false;
		}
		}
	}

	void update() {
		Target.update();
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addEnemy(new Enemy(new Random().nextInt(EmuHunt.width), 0, 50, 50, enemySpawnTime));

			enemyTimer = System.currentTimeMillis();
		}
	}
}
