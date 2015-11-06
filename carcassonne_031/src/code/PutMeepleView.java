package code;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PutMeepleView extends JPanel implements MouseListener, MouseMotionListener{
	
	private Game _game;
	static int x,y;
	private Image _meeple;
	private Image _meepleColor;
	public PutMeepleView(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		_meeple = new ImageIcon("meeple.gif").getImage();
		_meepleColor = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
	}
	
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
		g.drawImage(_meepleColor, x, y, this);
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
		x = (e.getX()/(80))*(80);
		y = (e.getY()/(80))*(80);
		_meepleColor = cutImage();
		_meepleColor = makeColorTransparent((BufferedImage) _meepleColor,Color.WHITE);
		repaint();
		
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
	public Image cutImage(){
		
		BufferedImage blankCanvas = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();

		g2.drawImage(_meeple, 0, 0, 80, 80, 130 ,5,174,52, this);
		return blankCanvas;
	}
	
	 public static Image makeColorTransparent(final BufferedImage im, final Color color)  
	   {  
	      final ImageFilter filter = new RGBImageFilter()  
	      {  
	         // the color we are looking for (white)... Alpha bits are set to opaque  
	         public int markerRGB = color.getRGB() | 0xFFFFFFFF;  
	  
	         public final int filterRGB(final int x, final int y, final int rgb)  
	         {  
	            if ((rgb | 0xFF000000) == markerRGB)  
	            {  
	               // Mark the alpha bits as zero - transparent  
	               return 0x00FFFFFF & rgb;  
	            }  
	            else  
	            {  
	               // nothing to do  
	               return rgb;  
	            }  
	         }  
	      };  
	  
	      final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);  
	      return Toolkit.getDefaultToolkit().createImage(ip);  
	   }  
	 public void reset(){
		 _meepleColor = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
	 }
	  
}
