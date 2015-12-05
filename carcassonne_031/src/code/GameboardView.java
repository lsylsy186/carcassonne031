package code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
 /**
  * This class used to draw background image in the JPanel
  * 
  *
  */
public class GameboardView extends JPanel{
	
	public void paintComponent(Graphics g){
		int x = 0, y = 0;
		java.net.URL imgURL = getClass().getResource("/resources/CarcassonneGameBoard.png");
		ImageIcon icon = new ImageIcon(imgURL);
		g.drawImage(icon.getImage(), 0, 0, getSize().width,getSize().height,this);
		while(true){
			g.drawImage(icon.getImage(), x, y, this);
			if(x>getSize().width && y > getSize().height)break;
			if(x>getSize().width){
				x = 0;
				y += icon.getIconHeight();
			}
			else
				x+=icon.getIconWidth();
		}
		
	}
}