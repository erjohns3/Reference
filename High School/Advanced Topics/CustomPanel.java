import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class CustomPanel extends JPanel {
	BufferedImage img;
	static Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	public CustomPanel() {
		try {
			img = ImageIO.read(new File("green_screen.png"));
		}
		catch(IOException io) {
			io.printStackTrace();
		}
	}
	

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(img, 50,50,null);
	}
	
	public void changeBackground() {
		int cInd = (int)(Math.random()*colors.length);
		Color c = colors[cInd];
		int topLeft = img.getRGB(0,0);
		Color topLeftColor = null;
		int topLeftBlue = 0x000000FF&topLeft;
		int topLeftGreen = 0x000000FF&(topLeft>>8);
		int topLeftRed = 0x000000FF&(topLeft>>16);
		int topLeftAlpha = 0x000000FF&(topLeft>>24);
		topLeftColor = new Color(topLeftRed, topLeftGreen, topLeftBlue);
		System.out.println("Old: " + topLeftColor + "\tNew:" + c);
		
		int[] pixels = img.getRGB(0,0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
		for (int i = 0; i < pixels.length; i++) {
			int blue = 0x000000FF&pixels[i];
			int green = 0x000000FF&(pixels[i]>>8);
			int red = 0x000000FF&(pixels[i]>>16);
			int alpha = 0x000000FF&(pixels[i]>>24);
			if (blue==topLeftBlue && green==topLeftGreen && red==topLeftRed) {
				pixels[i] = alpha*0x1000000 + c.getRed()*0x10000 + c.getGreen()*0x100 + c.getBlue();
			}
		}
		img.setRGB(0,0,img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());
		repaint();
	}
	
	public void changeBackround(Color c) {
		
	}
	
}
