/*******************************************************************/
/* This server limits the number of guesses a player can make      */
/* It keeps going after a winning guess, with another number       */
/*******************************************************************/
import java.text.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class GuessANumberServer extends JPanel implements ActionListener {
	/**************************************************************************/
	/* Class level variables - can be "seen" by all methods	                  */
	/**************************************************************************/
	String hostName, ip;
	int maxNum = Integer.MAX_VALUE-1;
	int minNum = Integer.MIN_VALUE+1;
	int maxNumGuesses;
	Font f;
	DecimalFormat df;
	HashMap<String, Integer> players;
	ServerSocket ss;
	Socket s;
	InputStreamReader ir;
	OutputStreamWriter ow;
	long guess;
	long low;
	String lowPlayer;
	long high;
	String highPlayer;
	boolean gameOver;
	String winner;
	String status;

	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;


	public GuessANumberServer() {
		try {
			InetAddress a = InetAddress.getLocalHost();
			hostName = a.getHostName();
			ip = a.getHostAddress();
		}
		catch(UnknownHostException uhe) {
			hostName = "unknown";
			ip = "0.0.0.0";
		}

		players = new HashMap<String, Integer>();
		f = new Font(Font.SANS_SERIF, Font.BOLD, 36);
		df = new DecimalFormat("###,###,###,###,###,###,###");
		high = maxNum;
		// calculate maxNumGuesses
		long temp = ((long)maxNum-minNum)/2;
		maxNumGuesses = 1;
		while (temp != 0) {
			maxNumGuesses++;
			temp /= 2;
		}
		maxNumGuesses *= 2;		// double that
		System.out.println("Maximum number of client guesses: " + maxNumGuesses);
		
		low = 1;
		highPlayer = "";
		lowPlayer = "";
		status = "wating...";
	}
	
	/***********************************************************************************/
	/* This method gets called automatically when the user clicks a registered JButton */
	/***********************************************************************************/
	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics();		// local variable to hold the graphics to draw on

		if (e.getSource() == btnOne) 	{	// button 1 clicked
			playTheGame();
		}
		else if (e.getSource() == btnTwo)	{	// button 2 clicked
		}
		else if (e.getSource() == btnThree)	{	// button 3 clicked
		}
		else if (e.getSource() == btnFour)	{	// button 4 clicked
		}
	}
	public void playTheGame() {
			btnOne.setEnabled(false);
			new Thread(new Runnable() {
			  public void run() {
			    try {
					begin();	
			    }
				catch (IOException ioe) {}
			  }
			}).start();
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,0,getWidth(),getHeight());
		g2d.setFont(f);
		
		g2d.setColor(new Color(200, 200, 200));
		g2d.drawString("Host name: " + hostName, 20, 40);
		g2d.drawString("IP Address: " + ip, getWidth()/2, 40);
		g2d.drawString(status, 20, getHeight()/4);
		
		int quarterH = getHeight()*7/12;
		int halfH = getHeight()*2/3;
		int halfW = getWidth()*3/4;

		if (!gameOver) {
			
			g2d.setColor(new Color(150, 200, 255));
			g2d.drawString("Low Guess:", 20, quarterH);
			g2d.drawString(lowPlayer, 300, quarterH);
			String l = df.format(low);
			Rectangle2D lowR = f.getStringBounds(l, g2d.getFontRenderContext());
			g2d.drawString(l, getWidth()-(int)(lowR.getWidth())-100, quarterH);

			g2d.setColor(new Color(255, 200, 150));
			g2d.drawString("High Guess:", 20, halfH);
			g2d.drawString(highPlayer, 300, halfH);
			String h = df.format(high);
			Rectangle2D highR = f.getStringBounds(h, g2d.getFontRenderContext());
			g2d.drawString(h, getWidth()-(int)(highR.getWidth())-100, halfH);
			
		}
		else {
			g2d.setColor(new Color(150, 200, 150));
			g2d.drawString("Game Over!", 20, quarterH);

			g2d.drawString("Winner:", 20, halfH);
			g2d.drawString(winner, 300, halfH);
			String h = df.format(guess);
			Rectangle2D highR = f.getStringBounds(h, g2d.getFontRenderContext());
			g2d.drawString(h, getWidth()-(int)(highR.getWidth())-100, halfH);
		}
	}
	
	public void begin() throws IOException {
		try {
			long temp = (long)(Math.random()*((long)maxNum-minNum));
			guess = (int)(temp + minNum);
			System.out.println(guess);
			highPlayer = "";
			lowPlayer = "";
			high = maxNum;
			low = minNum;
			gameOver = false;
			
			repaint();
						
			ss = new ServerSocket(2011);	// start listening on port 2008
			
			while (!gameOver) {
				//System.out.println("Waiting for a connection....");
				Socket s = ss.accept();

				InetAddress a = s.getInetAddress();
				//System.out.println("I got a connection from client: " + a.getHostName() + " at " + a.getHostAddress());

				s.setSoTimeout(1000);

				ow = new OutputStreamWriter(s.getOutputStream());
				
				ir = new InputStreamReader(s.getInputStream());

				// get input
				String data = "";
				try {
					data = "";
					int ch = ir.read();
					System.out.print("Received: ");
					while (ch != -1 && ch != ';') {
						// process the input
						data += (char)ch;
						System.out.print((char)ch);
						ch = ir.read();
					}
					System.out.print("\tSent: ");
					//System.out.println();
					// process input
					String[] parts = data.split(":");
					//System.out.println("Got " + parts.length + " parts");
					for (int i = 0; i < parts.length; i++) {
						parts[i] = parts[i].trim().toLowerCase();
					}
	
					if (parts.length == 0) {
						ow.write("invalid command;");
						System.out.println("invalid command;");
						ow.flush();
					}
					else if (parts[0].equals("register")) {
						if (parts.length < 2) {
							ow.write("denied;");
							System.out.println("denied;");
							ow.flush();
						}
						else if (parts[1].charAt(0) == '!') {
							ow.write("denied;");
							System.out.println("denied;");
							ow.flush();
						}
						else if (parts[1].length() == 0) {
								ow.write("denied;");
								System.out.println("denied;");
								ow.flush();
						}
						else {
							players.put(parts[1], 0);
							ow.write("accepted;");
							System.out.println("accepted;");
							ow.flush();
							status = parts[1] + " " + "registered";
						}
					}
					else if (parts[0].equals("guess")) {
						if (parts.length < 3) {
							ow.write("invalid command;");
							System.out.println("invalid command;");
							ow.flush();
						}
						else if (!players.containsKey(parts[1])) {
							ow.write("not registered;");
							System.out.println("not registered;");
							ow.flush();
						}
						else { 
							try {
								long playerGuess = Long.parseLong(parts[2]);
								processGuess(parts[1], playerGuess);
							}
							catch (NumberFormatException nfe) {
								ow.write("not a number;");
								System.out.println("not a number;");
								ow.flush();
							}
						}	
					}
					else {
						ow.write("invalid command;");
						System.out.println("invalid command;");
						ow.flush();
					}

				}
				catch (SocketTimeoutException soe) {
					System.out.println();
					System.out.println("Timeout");
				}
				catch (SocketException soe) {
					System.out.println();
					System.out.println("Socket Exception");
				}
				ow.close();
				ir.close();
				
				s.close();
				repaint();
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			if (ir != null) {
				ir.close();
			}
			if (ow != null) {
				ow.close();
			}
			if (s != null) {
				s.close();
			}
			if (ss != null) {
				ss.close();
			}
			btnOne.setEnabled(true);
			repaint();
			try {
				Thread.sleep(2000);
				playTheGame();

			}
			catch (InterruptedException ie) {
			}

		}
	}

	public void processGuess(String player, long g) throws IOException {
		status = player + " guessed " + df.format(g);
		int timesGuessed = players.get(player);

		if (gameOver) {
			ow.write("game over:" + winner + ":" + guess + ";");
			System.out.println("game over:" + winner + ":" + guess + ";");
			ow.flush();
		}
		else if(timesGuessed > maxNumGuesses) {
			ow.write("too many guesses;");
			System.out.println("too many guesses;");
			ow.flush();
		}
		else if (g == guess) {	// win
			gameOver = true;
			players.put(player, ++timesGuessed);
			winner = player;			
			ow.write("you win;");
			System.out.println("you win;");
			ow.flush();

		}
		else if (g > low && g < guess) {		// new low 
			players.put(player, ++timesGuessed);
			lowPlayer = player;
			low = g;
			ow.write("accepted:" + lowPlayer + ":" + low + ":" + highPlayer + ":" + high + ";");
			System.out.println("accepted:" + lowPlayer + ":" + low + ":" + highPlayer + ":" + high + ";");
			ow.flush();
		}
		else if (g < high && g > guess) {		// new high 
			players.put(player, ++timesGuessed);
			highPlayer = player;
			high = g;
			ow.write("accepted:" + lowPlayer + ":" + low + ":" + highPlayer + ":" + high + ";");
			System.out.println("accepted:" + lowPlayer + ":" + low + ":" + highPlayer + ":" + high + ";");
			ow.flush();
		}
		else {		// must be superceded guess
			players.put(player, ++timesGuessed);
			ow.write("superceded:" + lowPlayer + ":" + low + ":" + highPlayer + ":" + high + ";");
			System.out.println("superceded:" + lowPlayer + ":" + low + ":" + highPlayer + ":" + high + ";");
			ow.flush();
		}
	}
	
	/**************************************************************************/
	/* Set up GUI - gets called by the main method                            */
	/**************************************************************************/
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);				// give JFrame nice decorations
		JFrame frame = new JFrame("Guess A Number Server");			// create the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end the program when it closes
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());

		GuessANumberServer panel = new GuessANumberServer();

		panel.setBackground(Color.BLACK);						// the the background to black

		panel.btnOne = new JButton("New Number");				// instantiate a swing button
		panel.btnOne.addActionListener(panel);					// register the panel with the button
		panel.btnTwo = new JButton("Button 2");					// instantiate a swing button
		panel.btnTwo.addActionListener(panel);					// register the panel with the button
		panel.btnThree = new JButton("Button 3");
		panel.btnThree.addActionListener(panel);
		panel.btnFour = new JButton("Button 4");							// instantiate a swing button
		panel.btnFour.addActionListener(panel);					// register the panel with the button

		Panel buttonPanel = new Panel();							// instantiate the panel for buttons
		buttonPanel.add(panel.btnOne);									// add the swing button the the button panel
		buttonPanel.add(panel.btnTwo);
		buttonPanel.add(panel.btnThree);
		buttonPanel.add(panel.btnFour);

		c.add(panel,BorderLayout.CENTER);					// add the drawing panel to the frame (take up the entire frame)
		c.add(buttonPanel,BorderLayout.SOUTH);						// add the button panel to the bottom of the frame

        //panel.setOpaque(true); 											// content panes must be opaque
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);										// display the frame
		panel.playTheGame();

	}
	
	/**************************************************************************/
	/* Main method - runs automatically when program starts                   */
	/**************************************************************************/
	public static void main(String[] args) {							// called when the program starts
		javax.swing.SwingUtilities.invokeLater(new Runnable() {			// Start the createAndShowGUI method in a separate thread
			public void run() {
				createAndShowGUI(); 
			}
		});
	}
}
