import java.awt.Graphics;

public class Explosion extends GameObject {
	float duration = 1000;
	float time;
	float endTime;

	public Explosion(int x, int y, int width, int height) {
		super(x, y, width, height);
endTime=System.currentTimeMillis()+duration;
	}

	public void update() {
if (System.currentTimeMillis()>endTime) {
	isAlive=false;
}
	}
	public void draw(Graphics g) {
	g.drawImage(GamePanel.explosion, x, y, width, height, null);
	}
}
