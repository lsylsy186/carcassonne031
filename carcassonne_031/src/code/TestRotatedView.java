package code;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TestRotatedView extends JPanel {
	public void paintComponent(Graphics g){
		Image tilePiece;
		tilePiece = new ImageIcon("TileSet.jpg").getImage();
		Image icon = tilePiece;
		BufferedImage blankCanvas = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();
		g2.rotate(Math.toRadians(90),40,40);
		g2.drawImage(tilePiece, 0, 0, 80, 80, 41, 341, 121, 421, this);
		g.drawImage(blankCanvas,0,0,80,80,this);
	}
}
