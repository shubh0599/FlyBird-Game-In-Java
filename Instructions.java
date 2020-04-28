//instructions page
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.event.*;

public class Instructions extends JPanel
{
	public Instructions()
	{
		setFocusable(true);
		repaint();
		//repaint method displays instructions
	}
	public void paintComponent(Graphics gc)
	{
		super.paintComponent(gc);
		gc.setColor(Color.black);
		gc.fillRect(0,0,250,330);
		Image image1=(new ImageIcon("instructionspic.jpg")).getImage();
		gc.drawImage(image1,0,0,250,300,null);
	}
}