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
	static int initialX,initialY;
	static  Image _tilePiece;
	static int _imageState = 0;
	private int _rotateNum ;
	static Image _tempTile;
	static int _confirmTileState = 0;
	private Image _record;
	private TileGeneratorView _tG;
	private HashSet<Point> _emptySlot;
	private Game _game;
	private Random _ran = new Random();
	static Image tilePiece ;
	
	
	public BoarderView(TileGeneratorView a ){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Color.red);
		_tG = a;
		_tilePiece =  new ImageIcon("TileSet.jpg").getImage();
		initialX = _ran.nextInt(4);
		initialY = _ran.nextInt(4);
		_record = cutImage(initialX,initialY);
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
	public Image rotateImage(Image tilePiece, int degree){
		
		ImageIcon icon = new ImageIcon(tilePiece);
		BufferedImage blankCanvas = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();
		g2.rotate(Math.toRadians(degree),40,40);
		g2.drawImage(tilePiece,0,0,this);
		return  blankCanvas;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		_tG.readTile((char)_game.topTile().get(new Point(3,3)));
		_rotateNum = (char)(_game.topTile().get(new Point(3,4))) - '0';
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
		_tilePiece = cutImage(TileGeneratorView.k,TileGeneratorView.j);
		for(int i = 0; i < _rotateNum; i ++ ){
			_tilePiece = rotateImage(_tilePiece, 90);
		}
			
		
		tilePiece = _tilePiece;
		g.drawImage(tilePiece,x, y ,80 ,80 ,this);

		
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
			int rotateNumber = 0;
			char rotateNum = (char) entry.getValue().get(new Point(3,4));
			switch(rotateNum){
			case '0':
				rotateNumber = 0;
				break;
			case '1':
				rotateNumber = 1;
				break;
			case '2':
				rotateNumber = 2;
				break;
			case '3':
				rotateNumber = 3;
				break;
			}
			
			tempTile = rotateImage(tempTile,rotateNumber * 90);
			g.drawImage(tempTile,xp*(squareSize + 1) + 1, yp*(squareSize + 1) + 1,80 ,80 ,this);
			
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
//		_rotateNum = 0;
		_imageState = 0;
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
	public void setRecord(Image img){
		_record = img;
	}
}
