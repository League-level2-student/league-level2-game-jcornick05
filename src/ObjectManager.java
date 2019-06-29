import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 2500;
	int score = 0;
	boolean isAlive = true;
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

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
		// System.out.println(enemies.size());
	}

	void purgeObjects() {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).isAlive == false) {
				enemies.remove(i);
				score++;
			}
		}
	}

	public void checkCollision() {
		for (int i = 0; i < enemies.size(); i++) {
if (Target.collisionBox) {
	
}
//			if (Target.targetX >= enemies.get(i).getX() - 5 && Target.targetY >= enemies.get(i).getY() - 5
//					&& (Target.targetX <= enemies.get(i).getX() + 5 && Target.targetY <= enemies.get(i).getY() + 5)) {
//				enemies.get(i).isAlive = false;
//				System.out.println("check");
//			}
			// System.out.println(enemies.get(i).getX());
		}
		// System.out.println(Target.targetX);
		// System.out.println(Target.targetY);

	}

	void update() {
		Target.update();
	}

	void remove(int y) {
		enemies.remove(y);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addEnemy(new Enemy(new Random().nextInt(EmuHunt.width), 0, 50, 50, enemySpawnTime));

			enemyTimer = System.currentTimeMillis();
		}
	}
}
