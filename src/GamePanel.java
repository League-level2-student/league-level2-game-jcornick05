import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	Timer timer;
	static final int MENU_STATE = 0;
	static final int GAME_STATE = 1;
	static final int END_STATE = 2;

	static int currentSTATE = MENU_STATE;
	Font titleFont = new Font("LucidaSansTypewriter", Font.PLAIN, 48);
	Font description = new Font("Dialog", Font.PLAIN, 30);
	public static BufferedImage Emu;
	public static BufferedImage Crosshair;
	public static BufferedImage explosion;

	public GamePanel() {
		try {
			Emu = ImageIO.read(this.getClass().getResourceAsStream("Emu-Large.png"));
			Crosshair = ImageIO.read(this.getClass().getResourceAsStream("Crosshair.png"));
		  	explosion = ImageIO.read(this.getClass().getResourceAsStream("explosion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		if (currentSTATE == MENU_STATE) {
			drawMenuState(g);
		} else if (currentSTATE == GAME_STATE) {
			drawGameState(g);

		} else if (currentSTATE == END_STATE) {
			drawEndState(g);
		}

	}

	public void actionPerformed(ActionEvent e) {

		repaint();
		// System.out.println("action");
		if (currentSTATE == MENU_STATE) {
			updateMenuState();
		} else if (currentSTATE == GAME_STATE) {
			updateGameState();

		} else if (currentSTATE == END_STATE) {
			updateEndState();

		}

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, EmuHunt.width, EmuHunt.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Emu Hunt", 400, 300);
		g.setFont(description);
		g.drawString("Press ENTER To start", 380, 500);
		//g.drawString("Aim for the head!", 400, 400);
		g.setColor(Color.WHITE);
		g.drawString("To Shoot: spacebar    To Aim: mouse", 250, 740);
	}

	ObjectManager om = new ObjectManager();

	void drawGameState(Graphics g) {

		g.setColor(Color.CYAN);
		g.fillRect(0, 0, EmuHunt.width, EmuHunt.height);

		g.setColor(new Color(40, 90, 40));
		g.fillRect(0, 700, 1000, 300);
		g.setColor(Color.white);
		g.fillOval(120, 100, 150, 100);
		g.fillOval(900, 50, 150, 100);
		g.fillOval(450, 200, 150, 100);
		g.setColor(new Color(40, 100, 40));
		g.fillOval(-10, 600, 120, 130);
		g.fillOval(900, 600, 120, 130);
		g.setColor(Color.RED);
		g.drawOval(Target.targetX -15 , Target.targetY - 14, Target.targetWidth, Target.targetHeight);
		g.drawRect(Target.targetX-1, Target.targetY-1, 3, 3);
		
		g.drawString("Score:" + ObjectManager.score + " ", 500, 50);
		g.setColor(Color.BLACK);
		g.drawImage(Crosshair, Target.targetX - 19, Target.targetY - 19, 40, 40, null);
		g.drawString("Bullets: " + om.bullets, 900, 50);
		om.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, EmuHunt.width, EmuHunt.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER!!", 400, 300);

		g.drawString("You Killed " + ObjectManager.score + "!", 380, 500);

	}

	void updateMenuState() {
		ObjectManager.enemies.clear();
		ObjectManager.enemies.clear();
		ObjectManager.score=0; 
	ObjectManager.enemySpawnTime=2500;
	}

	void updateGameState() {
		om.update();
		om.purgeObjects();
		om.manageEnemies();
		om.updateEnemies();
		om.updateExplosions();

	}

	void updateEndState() {
		ObjectManager.bullets=60;
		
	}

	void startGame() {
		timer = new Timer(1000 / 60, this);
		timer.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
void drawBullet(Graphics f) {
		// TODO Auto-generated method stub
		//f.drawImage(explosion, Target.targetX-10, Target.targetY-10, 20, 20, null);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == 10) {
			System.out.println("hi");
			currentSTATE++;
			if (currentSTATE > END_STATE) {
				currentSTATE = MENU_STATE;
			}

		}
//		if (e.getKeyCode() == 61) {
//			System.out.println("hi");
//		}
		// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 32) {
			om.bullets--;
			om.checkCollision();
			om.addExplosions(new Explosion(Target.targetX,Target.targetY, 30, 30) );
		

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
