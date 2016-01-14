import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class DoubleBuffering1 {

	public static void main(String[] args) throws Throwable {
		JFrame frame = new JFrame("DoubleBuffering");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBackground(new Color(0,0,0));
		//GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		GraphicsConfiguration gc = frame.getGraphicsConfiguration();
		GraphicsDevice gd = gc.getDevice();
		
		double w = gc.getBounds().getWidth();
		double h = gc.getBounds().getHeight();
		System.out.println(w + " " + h);
		frame.setSize((int)w, (int)h-1);
		frame.setVisible(true);

		System.out.println("Full Screen Allowed: " + 
				gd.isFullScreenSupported());
		//if (gd.isFullScreenSupported()) {
		//	gd.setFullScreenWindow(frame);
		//}
		
		// Create a general double-buffering strategy
		
		frame.createBufferStrategy(2);
		BufferStrategy bufferStrat = frame.getBufferStrategy();
		
		//frame.setVisible(true);

		int x2 = 0;
		
		long start = System.nanoTime();
		int radius = 300;
		double velocity = 3;	// radians per second 
		
		
		while (true) {
			Graphics2D g2d = (Graphics2D)bufferStrat.getDrawGraphics(); 
			g2d.clearRect(0, 0, (int)w, (int)h);
			g2d.setColor(new Color(0,255,0));
			g2d.drawLine(0, 0, x2, (int)h);
			
		
			// oval
			double elSec = (System.nanoTime()-start)/1000000000.0;
			double angle = (velocity*elSec)%(2*Math.PI);
			int x = (int)(Math.cos(angle)*radius+w/2);
			int y = (int)(Math.sin(angle)*radius+h/2);
			
			g2d.setColor(Color.BLUE);
			g2d.fillOval(x, y, 50, 50);
			
			x2++;
			bufferStrat.show();	// flips the video pointer
			//Thread.sleep(10);
			
		}
			
		
		
		
		
		
		
	}

}
