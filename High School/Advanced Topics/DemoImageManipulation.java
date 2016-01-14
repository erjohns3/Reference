import java.io.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

public class DemoImageManipulation {

	public static void main(String[] args) throws Throwable  {
		BufferedImage img = ImageIO.read(new File("lobster.gif"));
		
		int[] pixels = img.getRGB(0, 0, img.getWidth(), img.getHeight(),
				null, 0, img.getWidth());
		
		System.out.println(pixels.length);
		
		int idx = img.getWidth()*(img.getHeight()/2) + img.getWidth()/2;
		int blue = 0x000000FF & pixels[idx];
		int green = 0x000000FF & (pixels[idx] >> 8);
		int red = 0x000000FF & (pixels[idx] >> 16);
		int alpha = 0x000000FF & (pixels[idx] >> 24);
		
		System.out.println(alpha + " " + red + " " + green + " " +blue);
		
		for (int i = 0; i < pixels.length; i++) {
			blue = 0x000000FF & pixels[i];
			green = 0x000000FF & (pixels[i] >> 8);
			red = 0x000000FF & (pixels[i] >> 16);
			alpha = 0x000000FF & (pixels[i] >> 24);
			if (alpha != 0)
				pixels[i] = 212*0xFFFFFF + red*0xFFFF + green*0xFF + blue;
			
		}
		
		img.setRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 
				0, img.getWidth());
		
		ImageIO.write(img, "png", new File("lobster.png"));
		
		
	}

}






