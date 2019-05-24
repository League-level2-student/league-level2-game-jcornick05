import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	public static BufferedImage spaceImg;
	int currentSTATE = MENU_STATE;
	Font titleFont = new Font("LucidaSansTypewriter", Font.PLAIN, 48);
	Font description = new Font("Dialog", Font.PLAIN, 30);
public GamePanel() { 

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

	}

	ObjectManager om = new ObjectManager();

	void drawGameState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, EmuHunt.width, EmuHunt.height);
		om.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, EmuHunt.width, EmuHunt.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER!!", 400, 300);

		g.drawString("You killed " + om.score + "", 380, 500);

	}

	void updateMenuState() {

	}

	void updateGameState() {
		om.update();
		om.manageEnemies();
		om.checkCollision();
		om.purgeObjects();

	}

	void updateEndState() {

	}

	void startGame() {
		timer = new Timer(1000 / 60, this);
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
