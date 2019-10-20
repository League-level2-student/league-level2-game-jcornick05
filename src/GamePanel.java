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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	Timer timer;
	Timer gameTimeTimer;
	int gameTime=0;
	static final int MENU_STATE = 0;
	static final int GAME_STATE = 1;
	static final int END_STATE = 2;
	ObjectManager om = new ObjectManager();
	static int currentSTATE = MENU_STATE;
	Font titleFont = new Font("LucidaSansTypewriter", Font.BOLD, 48);
	Font description = new Font("Dialog", Font.PLAIN, 30);
	Font frenzy = new Font("Dialog", Font.BOLD, 60);
	public static BufferedImage EmuLeft;
	public static BufferedImage EmuRight;
	public static BufferedImage Crosshair;
	public static BufferedImage explosion;
	public static BufferedImage cloud;
	public static BufferedImage Bush;
	// Timer SplatTimer = new Timer(125, om);
	Random rc = new Random();

	public GamePanel() {
		try {
			EmuRight = ImageIO.read(this.getClass().getResourceAsStream("Emu-largeCopy.png"));
			EmuLeft = ImageIO.read(this.getClass().getResourceAsStream("Emu-large.png"));
			Crosshair = ImageIO.read(this.getClass().getResourceAsStream("Crosshair.png"));
			explosion = ImageIO.read(this.getClass().getResourceAsStream("explosion.png"));
			cloud = ImageIO.read(this.getClass().getResourceAsStream("Cloud.png"));
			Bush = ImageIO.read(this.getClass().getResourceAsStream("Bush.png"));
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
		if (e.getSource() == timer) {

			repaint();
			// System.out.println("action");
			if (currentSTATE == MENU_STATE) {
				updateMenuState();
			} else if (currentSTATE == GAME_STATE) {
				updateGameState();

			} else if (currentSTATE == END_STATE) {
				updateEndState();

			}

		}else {
			gameTime++;
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
		// g.drawString("Aim for the head!", 400, 400);
		g.setColor(Color.WHITE);
		g.drawString("To Shoot: spacebar    To Aim: mouse", 250, 740);
		g.drawString("If The Red bar disappears you lose!!", 200, 100);
		g.drawString("You have 30 bullets", 650, 50);
	}

	void drawGameState(Graphics g) {

		g.setColor(Color.CYAN);
		g.fillRect(0, 0, EmuHunt.width, EmuHunt.height);

		g.setColor(new Color(40, 90, 40));
		g.fillRect(0, 700, 1000, 300);
		g.setColor(Color.white);
		// g.fillOval(120, 100, 150, 100);
		// g.fillOval(900, 50, 150, 100);
		// g.fillOval(450, 200, 150, 100);
		g.setColor(new Color(40, 100, 40));
		// g.fillOval(-10, 600, 120, 130);
		// g.fillOval(900, 600, 120, 130);
		g.setColor(Color.RED);

		g.setColor(Color.BLACK);
		g.drawImage(cloud, 115, 100, 170, 120, null);
		g.drawImage(cloud, 900, 50, 170, 120, null);
		g.drawImage(cloud, 450, 200, 170, 120, null);
		g.drawImage(Bush, -30, 600, 220, 200, null);
		g.drawImage(Bush, 840, 600, 220, 200, null);
		g.drawImage(Crosshair, Target.targetX - 19, Target.targetY - 19, 40, 40, null);
		g.drawString("" + om.bullets, Target.targetX-30, Target.targetY-7);
		g.drawOval(Target.targetX - 15, Target.targetY - 14, Target.targetWidth, Target.targetHeight);
		g.drawRect(Target.targetX - 1, Target.targetY - 1, 3, 3);
		g.setColor(Color.RED);
		g.fillRect(Target.targetX+17, Target.targetY-18+gameTime/2, 15, 40-gameTime);
		om.draw(g);
		g.setColor(Color.darkGray);
		g.drawString("Score:" + ObjectManager.score + " ", 500, 50);
	
		//g.drawString("Game Time: " + gameTime  ,250, 50);
		//countdown 
		if (om.score > 35 && om.score < 48) {
			Color flash = new Color(rc.nextInt(255),rc.nextInt(255),rc.nextInt(255));
			g.setColor(flash);
			g.setFont(frenzy);
			g.drawString("FRENZY", 400, 150);

		}
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
		ObjectManager.score = 0;
		Enemy.rand = new Random().nextInt(3) + 3;
		om.enemySpawnTime=2500;
		gameTime=0;
	}

	void updateGameState() {
		om.update();	
		om.manageEnemies();
		
		om.updateEnemies();
		//om.checkCollision();	
		om.updateExplosions();
		om.purgeObjects();
		
		if (gameTime==40) {
			currentSTATE = END_STATE;
		}

	}

	void updateEndState() {
		ObjectManager.bullets = 30;
		//ObjectManager.score=0;
		gameTime=0;

	}

	void startGame() {
		timer = new Timer(1000 / 60, this);
		timer.start();
		gameTimeTimer = new Timer(1000 / 8, this);
		gameTimeTimer.start();
		gameTime=0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	void drawBullet(Graphics f) {
		// TODO Auto-generated method stub
		// f.drawImage(explosion, Target.targetX-10, Target.targetY-10, 20, 20, null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.bullets--;
			
			om.addExplosions(new Explosion(Target.targetX -= 15, Target.targetY -= 15, 30, 30));
			gameTime=0;
			om.checkCollision();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.explosions.clear();
			}
		}
	}

