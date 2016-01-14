import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DemoImageAnimation {

	public static void main(String[] args) throws Throwable {
		JFrame frame = new JFrame("Image Animation");
		frame.setSize(500, 500);
		frame.setVisible(true);

		Container c = frame.getContentPane();
		c.setBackground(Color.BLACK);
		Graphics2D g2d = (Graphics2D) c.getGraphics();

		BufferedImage img = ImageIO.read(new File("pokemonSpriteSheet.png"));
		// g2d.drawImage(img, 0, 0, null);
		int w = img.getWidth();
		int h = img.getHeight();

		ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();

		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 25; j++) {
				BufferedImage tmpImg = frame.getGraphicsConfiguration()
						.createCompatibleImage(w/25, h/20);
				Graphics2D tmpg2d = (Graphics2D) tmpImg.getGraphics();
				tmpg2d.drawImage(img, 
						0, 0, w/25, h/20, 
						j*w/25, i*h/20, (j+1)*w/25, (i+1)*h/20, 
					null);

				imgs.add(tmpImg);

			}
		
		g2d.drawImage(imgs.get((int)(Math.random()*100)), 0, 0, null);

	}

}
