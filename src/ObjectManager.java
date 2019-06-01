import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;
    ArrayList <GameObject> enemies = new ArrayList<GameObject>();
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
	}

	void purgeObjects() {

	}

	public void checkCollision() {

	}

	void update() {
Target.update();
	}
	
	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addEnemy(new Enemy(new Random().nextInt(EmuHunt.width), 0, 50, 50, enemySpawnTime, enemySpawnTime));

			enemyTimer = System.currentTimeMillis();
		}
	}
}

























