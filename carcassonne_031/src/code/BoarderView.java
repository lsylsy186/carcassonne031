package code;
import java.awt.*;

import javax.swing.*; 

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
public class BoarderView extends JPanel implements MouseListener, MouseMotionListener {
	static int x,y;
	static int squareSize = 80;
	static int currentX,currentY;
	static  Image _tilePiece;
	private TileGeneratorView _tG;
	private HashSet<Point> _emptySlot;
	private Game _game;
	private Random _ran = new Random();
	
	
	
	public BoarderView(TileGeneratorView a ){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Color.red);
		_tG = a;
		currentX = TileGeneratorView.k;
		currentY = TileGeneratorView.j;
		_tilePiece =  new ImageIcon("TileSet.jpg").getImage();
		

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
	public void rotateImage(){
		ImageIcon icon = new ImageIcon(_tilePiece);
		BufferedImage blankCanvas = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();
		g2.rotate(Math.toRadians(90),40,40);
		g2.drawImage(_tilePiece,0,0,this);
		_tilePiece = blankCanvas;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		_emptySlot = _game.get_Slot();
		
		
		
		for(int i = 0; i < 10000; i++ ){
			g.setColor(Color.black);
			g.fillRect((i%100)* squareSize+ (i%100+1) *1,(i/100) * squareSize +(i/100 + 1), 
					squareSize, squareSize);
		}
		for(Point p : _emptySlot){
			g.setColor(Color.green);
			g.fillRect(p.x*(squareSize + 1) + 1, p.y*(squareSize + 1) + 1, 80, 80);
		}
//		Image tilePiece ;
		_tilePiece = cutImage(TileGeneratorView.k,TileGeneratorView.j);
		
		//tilePiece = rotateImage(tilePiece);
		g.drawImage(_tilePiece,x, y ,80 ,80 ,this);

		
		HashMap<Point,HashMap<Point,Object>> gameBoard = _game.get_gameBoard();
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
			Image tempTile;
			tempTile = cutImage(k,j);
			
			g.drawImage(tempTile,xp*(squareSize + 1) + 1, yp*(squareSize + 1) + 1,80 ,80 ,this);	
		//g.drawImage(tilePiece,xp*(squareSize + 1) + 1, yp*(squareSize + 1) + 1,xp*(squareSize + 1) + 81,yp*(squareSize + 1) + 81,42+120*k,341+160*j,122+120*k,421+160*j,this);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = (e.getX()/(squareSize+1))*(squareSize+1)+1;
		y = (e.getY()/(squareSize+1))*(squareSize+1)+1;
		
		repaint();
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
		
		
		//TileGenerator().refreshTile();
			// TODO Auto-generated method s
		
	}
	public void addGame(Game g) {
		_game = g;
		
	}
	public Image getCurrentTilePiece(){
		return _tilePiece;
	}
}
