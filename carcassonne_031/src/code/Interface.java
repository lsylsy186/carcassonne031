package code;
import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
public class Interface extends JPanel implements MouseListener, MouseMotionListener {
	static int x,y;
	static int squareSize = 80;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.red);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		
		for(int i = 0; i < 10000; i++ ){
			g.setColor(Color.black);
			g.fillRect((i%100)* squareSize+ (i%100+1) *1,(i/100) * squareSize +(i/100 + 1), 
					squareSize, squareSize);
		}
		Image tilePiece ;
		tilePiece = new ImageIcon("TileSet.jpg").getImage();
		g.drawImage(tilePiece,x, y,x+80,y+80,42,341,122,421,this);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
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
		// TODO Auto-generated method stub
		
	}
}
