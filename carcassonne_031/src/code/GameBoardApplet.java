package code;

import java.applet.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameBoardApplet extends Applet {
	public static int rows = 5;
	public static int columns = 5;
	
	
	
	class BackgroundPanel extends Panel{
		Image temp;
		Image img;
		
		public BackgroundPanel(){
			try {
				temp = ImageIO.read(new File("J3yzJYD.jpg"));
				// modify the picture to fit our grid.
				img = temp.getScaledInstance(300,300,Image.SCALE_SMOOTH);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		  
		public void paint(Graphics g){
			g.drawImage(img, 0, 0, null);
		}
		
	}
	
	
	public void init(){
		//initialize a 2D array to hold the position of the panels.
		Panel[][] panelHolder = new Panel[rows][columns];
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				Panel temp = new Panel();
				temp.setBackground(Color.BLACK);
				panelHolder[i][j] = temp;
			}
		}
		setLayout(new GridLayout(rows, columns,10,10));
		// set the specific coordinate  to the specific panel;
		panelHolder[2][2] = new BackgroundPanel();
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				Panel panel = panelHolder[i][j];
			
				
				add(panel);
			}
		}
	}
}
