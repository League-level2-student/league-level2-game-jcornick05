import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager extends Target implements KeyListener {
	long enemyTimer = 0;
	static int enemySpawnTime = 2500;
	static int score = 0;
	boolean isAlive = true;
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	int bullets = 60;

	public int scoreGetter() {
		return score;

	}

	void actionPerformed(ActionEvent f) {

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
				bullets+=10;
			}

		}
	}

	public void checkCollision() {

		for (int i = 0; i < enemies.size(); i++) {



			if (Target.targetX >= enemies.get(i).getX() - 5 && Target.targetY >= enemies.get(i).getY() - 5
					&& (Target.targetX <= enemies.get(i).getX() + 5 && Target.targetY <= enemies.get(i).getY() + 5)) {
				enemies.get(i).isAlive = false;
				// System.out.println("check");
			}

		}
		
		// System.out.println(enemies.get(i).getX());

		// System.out.println(Target.targetX);
		// System.out.println(Target.targetY);

	}

	// public void update() {
	// Target.update();
	// }

	void remove(int y) {
		enemies.remove(y);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addEnemy(new Enemy(new Random().nextInt(EmuHunt.width), 0, 50, 50, enemySpawnTime));

			enemyTimer = System.currentTimeMillis();
		}
	}

	@Override
	public void keyTyped(KeyEvent f) {
		// TODO Auto-generated method stub
		System.out.println(f.getKeyCode());
		if (f.getKeyCode()==32) {
			bullets-=1;
			checkCollision();
			System.out.println(bullets);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
	}
}
