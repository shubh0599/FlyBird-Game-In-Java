//This is the Main Menu part
//This is the start file.

import java.io.*;
import java.awt.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MainMenu extends JFrame implements ActionListener
{
	JButton play,play2,instruction,quit;
	JFrame frame=new JFrame("Fly Bird");
	JFrame iframe=new JFrame("Instructions");
	ImageIcon easymode=new ImageIcon("easy.jpg");
	ImageIcon hardmode=new ImageIcon("hard.jpg");
	ImageIcon instructions=new ImageIcon("instructionsb.jpg");
	ImageIcon quits=new ImageIcon("quitb.jpg");
	JLabel background,title,name;
	public MainMenu() 
	{
		background=new JLabel(new ImageIcon("white.jpg"));
		title=new JLabel(new ImageIcon("logo.png"));
		name=new JLabel("Developed by: Shubham Sharma");
		play=new JButton();
		play.setIcon(easymode);
		play2=new JButton();
		play2.setIcon(hardmode);
		instruction=new JButton();
		instruction.setIcon(instructions);
		quit=new JButton();
		quit.setIcon(quits);
		
		//creating panel
		JPanel panel=new JPanel(new FlowLayout());
		
		//adds action listener to buttons
		play.addActionListener(this);
		play2.addActionListener(this);
		instruction.addActionListener(this);
		quit.addActionListener(this);
		panel.add(background);
		background.add(title);
		background.add(play);
		background.add(play2);
		background.add(instruction);
		background.add(quit);
		background.add(name);
		
		//setting cordinates
		background.setBounds(0,-20,383,1000);
		title.setBounds(81,10,220,220);
		play.setBounds(50,250,128,96);
		play2.setBounds(200,250,128,96);
		instruction.setBounds(112,360,159,38);
		quit.setBounds(112,420,159,43);
		name.setBounds(100,480,500,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(383,1000);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setResizable(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==play)
		{
			frame.setVisible(false);
			Bird bird=new Bird(1);
			JFrame gframe=new JFrame("Fly Bird");
			gframe.setSize(800,400);
			gframe.setLocationRelativeTo(null);
			gframe.setVisible(true);
			gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gframe.setResizable(false);
			gframe.add(bird);
		}
		if(e.getSource()==play2)
		{
			frame.setVisible(false);
			Bird bird=new Bird(2);
			JFrame gframe=new JFrame("Fly Bird");
			gframe.setSize(800,400);
			gframe.setLocationRelativeTo(null);
			gframe.setVisible(true);
			gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gframe.setResizable(false);
			gframe.add(bird);
		}
		else if(e.getSource()==instruction&&iframe.isShowing()==false)
		{
			Instructions instructions=new Instructions();
			iframe.setSize(250,330);
			iframe.setLocationRelativeTo(null);
			iframe.setVisible(true);
			iframe.setResizable(false);
			iframe.add(instructions);
		}
		else if(e.getSource()==quit)
		{
			System.exit(1);
		}
	}
	public static void main(String[] args)
	{
		new MainMenu();
	}
}