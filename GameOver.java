//game over page
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.event.*;

public class GameOver extends JPanel implements ActionListener
{
	int score;
	int highscore;
	int x=0;
	boolean right=true;
	Timer t1=new Timer(5,this);
	public GameOver(int s,int hs)
	{
		setFocusable(true);
		score=s;
		highscore=hs;
		repaint();
	}
	public void paintComponent(Graphics gc)
	{
		super.paintComponent(gc);
		gc.setColor(Color.black);
		gc.fillRect(0,0,400,400);
		Image image1=(new ImageIcon("gameoverimage2.jpg")).getImage();
		gc.drawImage(image1,x,50,300,200,null);
		//shows score when the score is higher than old highscore
		if(score>highscore)
		{
			gc.setColor(Color.white);
			gc.drawString("New Highscore!",140,270);
			gc.drawString("Score: "+score,150,250);
		}
		else
		{
			//displays current score and current highscore when score is not higher than old highscore
			gc.setColor(Color.white);
			gc.drawString("Current Highscore: "+highscore,140,270);
			gc.drawString("Your Score: "+score,150,250);
		}
		//starts timer
		t1.start();
	}
	//moves game over picture left and right
	public void actionPerformed(ActionEvent e)
	{
		if(right==true&&x<100)
		x++;
		if(right==true&&x==100)
		right=false;
		if(right==false&&x>0)
		x--;
		if(right==false&&x==0)
		right=true;
		repaint();
	}
}