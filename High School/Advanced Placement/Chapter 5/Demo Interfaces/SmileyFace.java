import java.awt.*;
import java.awt.image.*;

public class SmileyFace {

	/***************************************************/
	/* Instance variables - (also called attributes)   */
	/***************************************************/
	private int xPos, yPos;
	private double radius;
	private boolean isSmiling;
	private Component component;
	private Color color; 
	
	/************************************************************/
	/* Constructor                                              */
	/*   Parameters: x and y position for center of smiley face */
	/*				 r is radius of the smiley face             */
	/*               comp is the GUI component upon which the   */
	/*                  smiley face will be drawn               */
	/************************************************************/
	public SmileyFace(int x, int y, int r, Component comp) {
		radius = r;
		xPos = x;
		yPos = y;
		component = comp;
		isSmiling = true;
		color = Color.YELLOW;
		draw();
	}

	public SmileyFace(int x, int y, int r, Color c, Component comp) {
		radius = r;
		xPos = x;
		yPos = y;
		component = comp;
		isSmiling = true;
		color = c;
		draw();
	}

	/************************************************************/
	/* Method: draw                                             */
	/*	 Parameters: none                                       */
	/*	 Return value: none                                     */
	/*                                                          */
	/* Draw the smiley face on the GUI component (with a smile) */
	/************************************************************/
	private void draw() {
		Graphics g;
		if (component == null) {
			g = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB).getGraphics();
		}
		else {
			g = component.getGraphics();
		}
		int radius = (int)this.radius;
		int arcLength = 90;
		int smileHeight = (int)(radius*2.5);		// max height of oval - should be relative to radius
		int smileWidth = (int)(radius*1.5);
		int smileX = xPos-smileWidth/2;
		int smileY = yPos-(int)(radius*2.1);

		g.setColor(color);
		g.fillOval(xPos-radius, yPos-radius, radius*2, radius*2);
		g.setColor(Color.BLACK);
		g.fillOval(xPos-radius/2, yPos-radius/2, (int)(radius/5), (int)(radius/3));
		g.fillOval(xPos+radius/3, yPos-radius/2, (int)(radius/5), (int)(radius/3));
		if (isSmiling) 
			g.drawArc(smileX, smileY, smileWidth, smileHeight, 270-arcLength/2, arcLength);
		else
			g.drawArc(smileX, smileY+smileHeight, smileWidth, smileHeight, 90-arcLength/2, arcLength);
	}

	/********************************************************************/
	/* Method: clear                                                    */
	/*   parameters: none                                               */
	/*   return type: none                                              */
	/*                                                                  */
	/* Clears the smiley face from the GUI component                    */
	/********************************************************************/
	private void clear() {
		Graphics g;
		if (component == null) {
			g = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB).getGraphics();
		}
		else {
			g = component.getGraphics();
		}
		int radius = (int)this.radius;
		g.setColor(Color.BLACK);
		g.fillOval(xPos-radius, yPos-radius, radius*2, radius*2);
	}

	/********************************************************************/
	/* Method: smile                                                    */
	/*   parameters: none                                               */
	/*   return type: none                                              */
	/*                                                                  */
	/* If the smiley face is frowning, this method will transition it   */
	/*   to a smile                                                     */
	/********************************************************************/
	public void smile() {
		if (isSmiling) { 	// if it's already frowning, return
			return;
		}
		Graphics g;
		if (component == null) {
			g = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB).getGraphics();
		}
		else {
			g = component.getGraphics();
		}
		int radius = (int)this.radius;
		int arcLength = 90;
		int smileHeight = (int)(radius*2.5);		// max height of oval - should be relative to radius
		int smileWidth =  (int)(radius*1.5);
		int smileX = xPos-smileWidth/2;
		int smileY = yPos-(int)(radius*2.1);

		int increment = Math.max(smileHeight / 30, 1); 

		for (int i = smileHeight; i>=0; i-=increment) {
			g.setColor(Color.BLACK);
			g.drawArc(smileX, smileY+smileHeight, smileWidth, i, 90-arcLength/2, arcLength);
			try {Thread.sleep(10);}
			catch (InterruptedException e) 	{}
			g.setColor(color);
			g.drawArc(smileX, smileY+smileHeight, smileWidth, i, 90-arcLength/2, arcLength);
		}

		for (int i = 0; i<=smileHeight; i+=increment) {
			g.setColor(Color.BLACK);
			g.drawArc(smileX, smileY+(smileHeight-i), smileWidth, i, 270-arcLength/2, arcLength);
			try {Thread.sleep(10);}
			catch (InterruptedException e) 	{}
			g.setColor(color);
			g.drawArc(smileX, smileY+(smileHeight-i), smileWidth, i, 270-arcLength/2, arcLength);
		}
		g.setColor(Color.BLACK);
		g.drawArc(smileX, smileY, smileWidth, smileHeight, 270-arcLength/2, arcLength);


		isSmiling=true;
	}
	
	
	/********************************************************************/
	/* Method: frown                                                    */
	/*   parameters: none                                               */
	/*   return type: none                                              */
	/*                                                                  */
	/* If the smiley face is smiling, this method will transition it    */
	/*   to a frown                                                     */
	/********************************************************************/
	public void frown() {
		if (!isSmiling) { 	// if it's already frowning, return
			return;
		}
		Graphics g;
		if (component == null) {
			g = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB).getGraphics();
		}
		else {
			g = component.getGraphics();
		}
		int radius = (int)this.radius;

		int arcLength = 90;
		int smileHeight = (int)(radius*2.5);		// max height of oval - should be relative to radius
		int smileWidth  = (int)(radius*1.5);
		int smileX = xPos-smileWidth/2;
		int smileY = yPos-(int)(radius*2.1);

		int increment = Math.max(smileHeight / 30, 1); 

		for (int i = smileHeight; i>=0; i-=increment) {
			g.setColor(Color.BLACK);
			g.drawArc(smileX, smileY+(smileHeight-i), smileWidth, i, 270-arcLength/2, arcLength);
			try {Thread.sleep(10);}
			catch (InterruptedException e) 	{}
			g.setColor(color);
			g.drawArc(smileX, smileY+(smileHeight-i), smileWidth, i, 270-arcLength/2, arcLength);
		}
		for (int i = 0; i<=smileHeight; i+=increment) {
			g.setColor(Color.BLACK);
			g.drawArc(smileX, smileY+smileHeight, smileWidth, i, 90-arcLength/2, arcLength);
			try {Thread.sleep(10);}
			catch (InterruptedException e) 	{}
			g.setColor(color);
			g.drawArc(smileX, smileY+smileHeight, smileWidth, i, 90-arcLength/2, arcLength);
		}
		g.setColor(Color.BLACK);
		g.drawArc(smileX, smileY+smileHeight, smileWidth, smileHeight, 90-arcLength/2, arcLength);
		isSmiling=false;
	}
	
	/********************************************************************/
	/* Method: grow                                                     */
	/*   parameters: x is the factor to grow by, can be positive        */
	/*               or negative                                        */
	/*   return type: none                                              */
	/*                                                                  */
	/* Grows or shrinks the smiley by changing the radius.  The radius  */
	/*   is increased or decreased by the factor of the parameter       */
	/*   For example, if the radius is 100, and x is .5, the new radius */
	/*   will be .5 times as big as the old radius (or 150)             */
	/*   The smiley will visually grow or shrink on the screen          */
	/********************************************************************/
	public void grow(double x) {
		int numIntervals = 50;
		int newRadius = (int)(radius + radius*x);
		double increment = (double)(newRadius - radius) / numIntervals;
		
		for (int i = 0; i < numIntervals; i++) {
			clear();
			radius += increment;
			draw();
			try {Thread.sleep(20);}
			catch (InterruptedException e) {}
		}
	}

	/********************************************************************/
	/* Method: setRadius                                                */
	/*   parameters: r is the new radius for the smiley face            */
	/*   return type: none                                              */
	/*                                                                  */
	/* Makes the smiley face the new size given by r (the radius).      */
	/* Visually changes the size on the screen                          */
	/********************************************************************/
	public void setRadius(int r) {
		int numIntervals = 10;
		double increment = (double)(r - radius) / numIntervals;
		
		for (int i = 0; i < numIntervals; i++) {
			clear();
			radius += increment;
			draw();
			try {Thread.sleep(20);}
			catch (InterruptedException e) {}
		}
	}
	/********************************************************************/
	/* Method: getArea                                                  */
	/*   parameters: none                                               */
	/*   return type: the area (in pixels) occupied by the smiley face  */
	/*                on the screen (a double value)                    */ 
	/*                                                                  */
	/* Calculates the area of the smiley face as pi times the radius    */
	/*     squared                                                      */
	/********************************************************************/
	public double getArea() {
		double area = Math.pow(radius,2) * Math.PI;
		return area;
	}

	/********************************************************************/
	/* Method: getRadius                                                */
	/*   parameters: none                                               */
	/*   return type: the radius of the smiley face (an int)            */
	/*                                                                  */
	/* Returns the radius of the smiley face                            */
	/********************************************************************/
	public double getRadius() {
		return radius;
	}

}
