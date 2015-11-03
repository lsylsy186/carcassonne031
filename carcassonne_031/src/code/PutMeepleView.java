package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PutMeepleView extends JPanel {
	
	private Game _game;
	
	public void paintComponent(Graphics g){
		Image tilePiece = BoarderView.tilePiece;
		tilePiece = scaledImage(tilePiece, 240, 240);
		g.drawImage(tilePiece, 0, 0, this);
		
		g.setColor(Color.black);
		g.drawLine(0, 0, 240, 0);
		g.drawLine(0, 0, 0, 240);
		g.drawLine(80, 0, 80, 240);
		g.drawLine(0, 80, 240, 80);
		g.drawLine(160, 0, 160,240);
		g.drawLine(0, 160, 240, 160);
		g.drawLine(0, 240, 240, 240);
		g.drawLine(240, 0, 240, 240);
	}
	private Image scaledImage(Image img, int w, int h){
		BufferedImage resizedImage = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		return resizedImage;
	}
	
	public void addGame(Game g) {
		_game = g;
		
	}

}
