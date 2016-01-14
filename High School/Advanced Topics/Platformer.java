import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Platformer extends JFrame implements KeyListener {

	double startTime;
	double endTime;
	double currentTime;
	double elapsedTime;
	double previousTime;
	double movingStartTimeX;
	double movingElapsedTimeX;
	double movingStartTimeY;
	double movingElapsedTimeY;

	int imgNum1 = 0;
	int imgNum2 = 0;

	double xPos1 = 300;
	double yPos1 = 100;
	
	double xPos2;
	double yPos2;
	
	double yPos1Int = 100;

	double xVel = 0;
	double yVel = 0;
	double yVelInt = 0;

	double yAcl = -1000;

	double speed = 360;

	double[] keys = new double[4];

	boolean jump = false;
	boolean jumpAccum = false;

	boolean rightContact;
	boolean leftContact;
	boolean topContact;
	boolean bottomContact = false;

	boolean topContactAccum = false;

	public Platformer(GraphicsConfiguration c) {
		super(c);
	}

	public void begin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		setIgnoreRepaint(true);
		setBackground(Color.lightGray);

		GraphicsConfiguration gc = getGraphicsConfiguration();
		GraphicsDevice gd = gc.getDevice();

		int width = 800;
		int height = 600;

		setSize(width, height);
		setVisible(true);

		createBufferStrategy(2);
		BufferStrategy buffer = getBufferStrategy();

		BufferedImage bi = gc.createCompatibleImage(width, height);

		Graphics graphics = null;
		Graphics2D g2d = null;

		BufferedImage player1 = null;
		try {
			player1 = ImageIO.read(new File("playerMeme.png"));
		} catch (Throwable t) {
			t.printStackTrace();
		}

		BufferedImage environment = null;
		try {
			environment = ImageIO.read(new File("environment.png"));
		} catch (Throwable t) {
			t.printStackTrace();
		}

		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("background.png"));
		} catch (Throwable t) {
			t.printStackTrace();
		}

		int imgSize = environment.getWidth() * environment.getHeight();
		int[] pixels = environment.getRGB(0, 0, environment.getWidth(),
				environment.getHeight(), null, 0, environment.getWidth());
		int[] alphaPix = new int[imgSize];

		for (int i = 0; i < imgSize; i++) {
			alphaPix[i] = 0x000000FF & (pixels[i] >> 24);
		}

		BufferedImage[] playerAnim = new BufferedImage[6];
		int playerW = player1.getWidth() / 8;
		int playerH = player1.getHeight();

		for (int i = 0; i < 6; i++) {
			playerAnim[i] = gc.createCompatibleImage(playerW, playerH,
					BufferedImage.BITMASK);
			Graphics2D gr = playerAnim[i].createGraphics();
			gr.drawImage(player1, 0, 0, playerW, playerH, i * playerW, 0,
					(i + 1) * playerW, playerH, null);
			gr.dispose();
		}

		startTime = System.nanoTime() / 1000000000.0;
		currentTime = System.nanoTime() / 1000000000.0;
		movingStartTimeX = currentTime;
		movingStartTimeY = currentTime;

		while (true) {
			try {
				previousTime = currentTime;
				currentTime = System.nanoTime() / 1000000000.0;
				elapsedTime = currentTime - previousTime;
				movingElapsedTimeX = currentTime - movingStartTimeX;
				movingElapsedTimeY = currentTime - movingStartTimeY;

				g2d = bi.createGraphics();
				g2d.drawImage(background, 0, 0, null);
				g2d.drawImage(environment, 0, 0, null);

				rightContact = false;
				leftContact = false;
				bottomContact = false;
				topContact = false;

				xVel = keys[0] - keys[1];

				for (int i = (int) (((int) yPos1 * width) + xPos1 + playerW - 4); i < (int) ((((int) yPos1 + playerH - 4) * width)
						+ xPos1 + playerW - 4); i = i + width) {
					if (alphaPix[i] != 0 || xPos1 >= width) {
						rightContact = true;
					}
				}

				for (int i = (int) (((int) yPos1 * width) + xPos1 + 3); i < (int) ((((int) yPos1
						+ playerH - 4) * width)
						+ xPos1 + 3); i = i + width) {
					if (alphaPix[i] != 0 || xPos1 <= 0) {
						leftContact = true;
					}
				}

				for (int i = (int) ((((int) yPos1 + playerH + 1) * width) + xPos1 + 5); i < (int) ((((int) yPos1
						+ playerH + 1) * width)
						+ xPos1 + playerW - 5); i++) {
					if (alphaPix[i] != 0 || yPos1 >= height) {
						bottomContact = true;
					}
				}

				for (int i = (int) (((int) yPos1 * width) + xPos1 + 5); i < (int) (((int) yPos1 * width)
						+ xPos1 + playerW - 5); i++) {
					if (alphaPix[i] != 0 || yPos1 <= 0) {
						topContact = true;
					}
				}

				if (xVel < 0) {
					imgNum1 = ((int) (movingElapsedTimeX * 10) % 3) + 3;
				} else if (xVel > 0) {
					imgNum1 = ((int) (movingElapsedTimeX * 10) % 3);
				}

				if (jump && jumpAccum) {
					jump = false;
					jumpAccum = false;
					bottomContact = false;
				}

				if (jump) {
					yPos1Int = yPos1;
					movingStartTimeY = currentTime;
					bottomContact = false;
					yVelInt = 650;
					jumpAccum = true;
				}

				if (rightContact) {
					xVel = -keys[1];
				}

				if (leftContact) {
					xVel = keys[0];
				}

				if (bottomContact) {
					yPos1Int = yPos1;
					yPos1 = yPos1Int;
					yVelInt = 0;
					movingStartTimeY = currentTime;
					topContactAccum = true;
				} else {
					movingElapsedTimeY = currentTime - movingStartTimeY;
					yPos1 = yPos1Int - (yVelInt * movingElapsedTimeY)
							- ((yAcl * Math.pow(movingElapsedTimeY, 2)) / 2);
					yVel = yVelInt - (yAcl * movingElapsedTimeY);
				}

				if (topContact) {
					if (topContactAccum) {
						movingStartTimeY = currentTime;
						topContactAccum = false;
					}
					yPos1Int = yPos1;
					yPos1 = yPos1Int;
					yVelInt = 0;
				}

				xPos1 += xVel * elapsedTime;

				g2d.drawImage(playerAnim[imgNum1], (int) xPos1, (int) yPos1, null);
				
				//g2d.drawImage(playerAnim[imgNum2], (int) xPos2, (int) yPos2, null);

				if (xVel > 0) {
					imgNum1 = 0;
				} else if (xVel < 0) {
					imgNum1 = 3;
				}

				graphics = buffer.getDrawGraphics();
				graphics.drawImage(bi, 0, 0, null);

				if (!buffer.contentsLost()) {
					buffer.show();
				}
			} finally {
				if (graphics != null) {
					graphics.dispose();
				}
				if (g2d != null) {
					g2d.dispose();
				}
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'd') {
			keys[0] = speed;
			if (xVel == 0) {
				movingStartTimeX = currentTime;
			}
		}
		if (e.getKeyChar() == 'a') {
			keys[1] = speed;
			if (xVel == 0) {
				movingStartTimeX = currentTime;
			}
		}
		if (e.getKeyChar() == 'w') {
			if (bottomContact) {
				jump = true;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == 'd') {
			keys[0] = 0;
		}
		if (e.getKeyChar() == 'a') {
			keys[1] = 0;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GraphicsEnvironment ge = GraphicsEnvironment
						.getLocalGraphicsEnvironment();
				GraphicsDevice gd = null;
				GraphicsConfiguration gc = null;

				GraphicsDevice defaultGD = ge.getDefaultScreenDevice();
				gd = defaultGD;
				GraphicsConfiguration defaultGC = gd.getDefaultConfiguration();
				gc = defaultGC;

				final Platformer demo = new Platformer(gc);
				demo.addKeyListener(demo);
				demo.requestFocus();
				Thread t = new Thread() {
					public void run() {
						demo.begin();
					}
				};
				t.start();
			}
		});
	}
}
