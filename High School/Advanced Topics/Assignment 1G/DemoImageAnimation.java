import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class DemoImageAnimation extends JFrame {
	
	public DemoImageAnimation(GraphicsConfiguration c) {
		super(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end the program when it closes
	}
	
	public void begin() {
		setUndecorated(true);
		setIgnoreRepaint(true);

		// get system graphics information
		GraphicsConfiguration gc = getGraphicsConfiguration();
		BufferCapabilities bc = gc.getBufferCapabilities();
		
		// set up the window depending on buffering capabilities of the graphics card
		if (bc.isFullScreenRequired()) {		// is full screen required for page flipping?
			gc.getDevice().setFullScreenWindow(this);	// go into full screen mode
		}
		else {
			setSize((int)(gc.getBounds().getWidth()), (int)(gc.getBounds().getHeight()));	// make a big window
			setVisible(true);
		}

		// set up page flipping... (rather than double buffering)
		createBufferStrategy(2);	
		BufferStrategy bs = getBufferStrategy();

		// read in the big image from disk - it should have a transparent background for the best effect.
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("cats.gif"));
		}
		catch (Throwable t) {
			t.printStackTrace();
		}

		// divide the image up into smaller components and store them into an array
		BufferedImage[] cats = new BufferedImage[6];	// six cat sub-images
		int catW = img.getWidth()/6;	// width of a sub-image
		int catH = img.getHeight();		// height of a sub-image
		// create the small images and put them in the array
		for (int i = 0; i < 6; i++) {	
			// ask the graphics config to create an image - it will support transparency by doing it this way
			cats[i] = gc.createCompatibleImage(catW, catH);
			Graphics2D gr = cats[i].createGraphics();	// ask the new image for its graphics object
			gr.drawImage(img,							// draw a cat from the big image INTO a small image
				0, 0, catW, catH,						// x,y,width,height of the small image
				i*catW, 0, (i+1)*catW, catH,			// w,y,width,height of the sub-image within the large image
				null);									// no listening for image updates
			gr.dispose();								// done with the graphics object
		}
		
		// start the animation loop
		while (true) {

			// clear the buffer
			Graphics g = bs.getDrawGraphics();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
			

			// calculate and draw our animated objects




			// dispose of the graphics object and flip the video hardware's page pointer
			g.dispose();
			bs.show();			
		}
		
	}
		
	public static void main(String[] args) {
		GraphicsEnvironment e = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
				
		// use the last screen device (if there are more than one)
		GraphicsDevice d = e.getScreenDevices()[e.getScreenDevices().length-1];
		
		DemoImageAnimation demo = 
			new DemoImageAnimation(d.getDefaultConfiguration());
		
		demo.begin();
				
	}
}
