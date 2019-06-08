import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmuHunt {
	public static JFrame frame;
	final static int width = 1000;
	final static int height = 1000;
	GamePanel gp;

	public static void main(String[] args) {
		EmuHunt e = new EmuHunt();
		e.setup();

	}

	public EmuHunt() {
		frame = new JFrame();
		gp = new GamePanel();
	}

	void setCursor() {
		BufferedImage cursor;
		BufferedImage blankCursor = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		String path = Paths.get("").toAbsolutePath().toString();
		try {
			cursor = ImageIO.read(new File(path + "/src/Crosshair.png"));
			Cursor crosshair = Toolkit.getDefaultToolkit().createCustomCursor(blankCursor, new Point(0, 0),
					"blank cursor");
			frame.getContentPane().setCursor(crosshair);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	void setup() {
		frame.add(gp);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.addKeyListener(gp);

		frame.pack();
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setCursor();
		gp.startGame();

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

}
