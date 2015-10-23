package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

public class TileGeneratorView extends JPanel implements MouseListener{
	
	
	int k = 0, j = 0;
    int randomNumber;
    Random _ran;
	
	public TileGeneratorView(){
		_ran = new Random();
		this.addMouseListener(this);
	}
	public void paintComponent(Graphics g){
		Image tilePiece;
		tilePiece = new ImageIcon("TileSet.jpg").getImage();
		randomNumber = _ran.nextInt(24);
		
		char tile = (char)('A' + randomNumber);
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
	
		g.drawImage(tilePiece,0, 0 ,80 ,80 ,42+120*k,341+160*j,122+120*k,421+160*j,this);

	}
	public void refreshTile(){
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}