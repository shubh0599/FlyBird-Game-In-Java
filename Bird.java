//This is the main game part 
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.event.*;
public class Bird extends JPanel implements ActionListener
{
	//declaring variables
	JLabel label;
	JFrame frame = new JFrame("Game Over!");
	int birdY = 100;
	int birdX = 100;
	int height=50;
	int vertJump = 2;
	int vertRate=1;
	int level;
	int x1;
	int y1;
	int x2;
	int y2;
	int x3;
	int x4;
	boolean flag=false;
	String a;
	boolean found=true;
	boolean block1=true;
	boolean block2=false;
	int highscore=0;
	boolean gameover = false;
	int y3;
	Timer t1 = new Timer (5,this);
	int score=0;
	JPanel panel = new JPanel(new BorderLayout());
	Scanner fileScan = null;
	//constructor [1 is for easy level and 2 is for hard level]
	public Bird(int b)
	{
		try
		{
			//reading the currrent high score from the file
			fileScan = new Scanner(new File("Highscore.txt")); //Highscore is stored in this file.
			a=fileScan.next();
			highscore=Integer.parseInt(a);
			fileScan.close();
		}
		catch(FileNotFoundException e)
		{
		}
		level=b;
		Random n = new Random();
		x1 = n.nextInt (20)+800;
		y1 = n.nextInt (200)+50;
		x2 = n.nextInt (20)+1200;
		y2 = n.nextInt (200)+50;
		x3 = n.nextInt (20)+1332;
		y3 = n.nextInt (200)+50;
		x4=1000;
		setFocusable( true );
	}
	public void paintComponent(Graphics gc)
	{
		super.paintComponent(gc);
		//Adding mouse listner
		MouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		//Adding cloud image in background
		Image image4 = (new ImageIcon("clouds.jpg")).getImage();
		gc.drawImage(image4, 0,50,800,300,null);
		//Adding a flag for highscore
		Image image3 = (new ImageIcon("flag.png")).getImage();
		//The flag apperas when the score reaches highscore.
		if (score>=(highscore-x4))
		{
			gc.drawImage(image3, birdX+(highscore-score)+25,230,50,150,null);
		}
		//Adding bird and dead bird images to show up at right time.
		Rectangle bird = new Rectangle (birdX,birdY,50,50);
		Image image1 = (new ImageIcon("bird.png")).getImage();
		Image image2 = (new ImageIcon("dead.png")).getImage();
		if (gameover==false)
			gc.drawImage(image1, birdX,birdY,50,50,null);
		if (gameover==true)
		{
			gc.drawImage(image2, birdX,birdY,50,50,null);
		}
		gc.setColor(Color.black);
		//Top and Bottom.
		Rectangle top = new Rectangle (0,0,800,height);
		Rectangle bottom = new Rectangle (0,400-height,800,height);
		gc.fillRect(top.x,top.y,top.width,top.height);
		gc.fillRect(bottom.x,bottom.y,bottom.width,bottom.height);
		//blocks
		Rectangle r1 = new Rectangle (x1,y1,20,100);
		gc.fillRect (r1.x,r1.y,r1.width,r1.height);
		Rectangle r2 = new Rectangle (x2,y2,20,100);
		gc.fillRect (r2.x,r2.y,r2.width,r2.height);
		gc.setColor(Color.white);
		//displays a label that shows score
		gc.drawString("Score: "+score,  20,  20);
		//starts timer
		t1.start();
		//collision detections
		if (bird.intersects(r1))
		{
			t1.stop();
			gameover=true;
			repaint();
		}
		if (bird.intersects(r2))
		{
			t1.stop();
			gameover=true;
			repaint();
		}
		if (bird.intersects(top))
		{
			t1.stop();
			gameover=true;
			repaint();
		}
		if (bird.intersects(bottom))
		{
			t1.stop();
			gameover=true;
			repaint();
		}
		//when game is over, opens the game over page
		if (gameover==true&&frame.isShowing()==false)
		{
			GameOver gameoverr = new GameOver(score,highscore);
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.add(gameoverr);
			inputoutput();
		}
	}
	//writes new highscore to file when required
	public void inputoutput()
	{
		String file = "Highscore.txt";
		PrintWriter outFile;
		try
		{
			if (score>highscore)
			{
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw); 
				outFile = new PrintWriter(bw);
				outFile.println(score);
				outFile.close();
			}
		}
		catch (FileNotFoundException e)
		{
		}
		catch (IOException e)
		{
		}
	}
	private class MyMouseListener implements MouseMotionListener, MouseListener
	{
		public void mouseMoved(MouseEvent event)
		{
		}
		public void mouseDragged(MouseEvent event)
		{
		}
		public void mouseClicked(MouseEvent event)
		{
		}
		//definitions for unused events. Must Include
		public void mouseExited(MouseEvent event)
		{
		}
		public void mouseEntered(MouseEvent event)
		{
		}
		//Invoked when the mouse enters a component.
		public void mouseReleased(MouseEvent event)
		{
			//causes bird's vertical direction to be down when mouse is released
			vertJump=1*vertRate;
		}
		//Invoked when the mouse is released.
		public void mousePressed(MouseEvent event)
		{
			//causes bird's vertical direction to be up when mouse is pressed
			vertJump=-1*vertRate;
		}
		//Invoked when the mouse is pressed.
	}
	public void actionPerformed(ActionEvent e)
	{
		//creates moving blocks when level mode is hard
		if (level==2 && block1==true && y1<250)
		{
			y1++;
		}
		if (level==2 && block1==true && y1==250)
		{
			block1=false;
		}
		if (level==2 && block1==false && y1>50)
		{
			y1--;
		}
		if (level==2 && block1==false && y1==50)
		{
			block1=true;
		}
		if (level==2 && block2==false && y2<250)
		{
			y2++;
		}
		if (level==2 && block2==false && y2==250)
		{
			block2=true;
		}
		if (level==2 && block2==true && y2>50)
		{
			y2--;
		}
		if (level==2 && block2==true && y2==50)
		{
			block2=false;
		}
		//moves and creates blocks
		if (score>(highscore-1000))
		{
			x4=x4-2;
		}
 		if (x1<-20)
		{
 			Random n = new Random();
    		x1 = n.nextInt (20)+800;
			y1= n.nextInt (400)-50;
 		}
 		else
		{
 			x1=x1-2;//*level;
 		}
 		if (x2<-20)
		{
 			Random n = new Random();
    		x2 = n.nextInt (20)+800;
			y2 = n.nextInt (400)-50;
 		}
 		else
		{
 			x2=x2-2;//*level;
 		}
		//keeps track of score
		score=score+2;
		//moves bird
 		birdY = birdY + vertJump;
 		if (gameover==false)
		{
			repaint();
		}
	}
}