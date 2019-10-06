import java.awt.Graphics;

public class Timer {
	static float countdown;
	static float endCountdown;
	static float countdownDuration = 5;

	public Timer() {

		endCountdown = System.currentTimeMillis() + countdownDuration;
	}

	public void update() {
		if (System.currentTimeMillis() > endCountdown) {
			GamePanel.currentSTATE = GamePanel.END_STATE;
		}

	}

}
