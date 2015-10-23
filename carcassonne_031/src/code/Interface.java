package code;
import java.awt.*;

import javax.swing.*; 

import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
public class Interface extends JPanel implements MouseListener, MouseMotionListener {
	static int x,y;
	static int squareSize = 80;
	Random _ran = new Random();
	//TileGenerator _tG;
	public Interface(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Color.red);
		_tG = new TileGenerator();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		
		
		for(int i = 0; i < 10000; i++ ){
			g.setColor(Color.black);
			g.fillRect((i%100)* squareSize+ (i%100+1) *1,(i/100) * squareSize +(i/100 + 1), 
					squareSize, squareSize);
		}
		Image tilePiece ;
		tilePiece = new ImageIcon("TileSet.jpg").getImage();
		g.drawImage(tilePiece,x, y,x+80,y+80,42,341,122,421,this);
		 
		HashMap<Point,HashMap<Point,Object>> gameBoard = Game._gameBoard;
		for(HashMap.Entry<Point,HashMap<Point,Object>> entry : gameBoard.entrySet()){
			int j = -1, k = -1; // using j,k to indicate where are the tiles locate in our picture.
			Point position = entry.getKey();
			int xp = (int) position.getX();
			int yp = (int) position.getY();
			char tile = (char) entry.getValue().get(new Point(3,3));
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
			
		g.drawImage(tilePiece,xp*(squareSize + 1) + 1, yp*(squareSize + 1) + 1,xp*(squareSize + 1) + 81,yp*(squareSize + 1) + 81,42+120*k,341+160*j,122+120*k,421+160*j,this);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX() - 40;
		y = e.getY() - 40;
		repaint();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		x = e.getX();
//		y = e.getY();// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x = (e.getX()/(squareSize+1))*(squareSize+1)+1;
		y = (e.getY()/(squareSize+1))*(squareSize+1)+1;
		TileGenerator.randomNumber = _ran.nextInt(24);
		repaint();
		//TileGenerator().refreshTile();
			// TODO Auto-generated method s
		
	}
}
