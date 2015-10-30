package code;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.*;

public class TileGeneratorView extends JPanel  {
	
	
	static int k = 0, j = 0;
    private Game _game;
    static Image tilePiece;
    
	
	public void paintComponent(Graphics g){
		
		
		
		readTile((char)_game.topTile().get(new Point(3,3)));
		tilePiece = cutImage(j, k);
		g.drawImage(tilePiece,0,0,80,80,this);
		
	}

	public void readTile(char tile){
		switch(tile){
		case 'A':
			j = 3;
			k = 4;
			break;
		case 'B':
			j = 3;
			k = 3;
			break;
		case 'C':
			j = 1;
			k = 2;
			break;
		case 'D':
			j = 2;
			k = 0;
			break;
		case 'E':
			j = 0;
			k = 0;
			break;
		case 'F':
			j = 1;
			k = 1;
			break;
		case 'G':
			j = 1;
			k = 0;
			break;
		case 'H':
			j = 0;
			k = 2;
			break;
		case 'I':
			j = 0;
			k = 1;
			break;
		case 'J':
			j = 2;
			k = 2;
			break;
		case 'K':
			j = 2;
			k = 1;
			break;
		case 'L':
			j = 3;
			k = 2;
			break;
		case 'M':
			j = 0;
			k = 4;
			break;
		case 'N':
			j = 0;
			k = 3;
			break;
		case 'O':
			j = 2;
			k = 4;
			break;
		case 'P':
			j = 2;
			k = 3;
			break;
		case 'Q':
			j = 1;
			k = 4;
			break;
		case 'R':
			j = 1;
			k = 3;
			break;
		case 'S':
			j = 3;
			k = 1;
			break;
		case 'T':
			j = 3;
			k = 0;
			break;
		case 'U':
			j = 4;
			k = 0;
			break;
		case 'V':
			j = 4;
			k = 1;
			break;
		case 'W':
			j = 4;
			k = 2;
			break;
		case 'X':
			j = 4;
			k = 3;
			break;
			
		}
	}
	public void addGame(Game g) {
		_game = g;
		
	}
	public Image cutImage(int row, int column){
		Image tilePiece;
		tilePiece = new ImageIcon("TileSet.jpg").getImage();
		Image icon = tilePiece;
		BufferedImage blankCanvas = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();

		g2.drawImage(tilePiece, 0, 0, 80, 80, 42+120*row,341+160*column,122+120*row,421+160*column, this);
		return blankCanvas;
	}
	public Image rotateImage(Image img){
		ImageIcon icon = new ImageIcon(img);
		BufferedImage blankCanvas = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();
		g2.rotate(Math.toRadians(90),40,40);
		g2.drawImage(img,0,0,this);
		return blankCanvas;
	}
	
	
}
