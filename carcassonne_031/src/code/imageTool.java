package code;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class imageTool {
	
	public static void main(String[] args){
		imageTool it = new imageTool();
		JFrame trywindow = new JFrame();
		JPanel tryPanel = new JPanel();
		ImageIcon img = it.getImage("/resources/follower0.png");
		img = transparent(img);
		JButton tryButton = new JButton();
		tryButton.setIcon(img);
		tryPanel.add(tryButton);
		trywindow.add(tryPanel);
		trywindow.setVisible(true);
		trywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		}
	
	public static ImageIcon transparent(ImageIcon i){
		imageTool it = new imageTool();
//		BufferedImage buffFollower = new BufferedImage(i.getIconWidth(),i.getIconHeight(), BufferedImage.TYPE_3BYTE_BGR);
//		Graphics2D g = (Graphics2D) buffFollower.getGraphics();
//		g.setComposite(AlphaComposite.Src);
		
	//	g.dispose();
		ImageIcon tile = it.getImage("/resources/1.png");
//		BufferedImage buffTile = new BufferedImage(tile.getIconWidth(), tile.getIconHeight(), BufferedImage.TYPE_3BYTE_BGR);
//		g = (Graphics2D) buffTile.getGraphics();
//		g.setComposite(AlphaComposite.Src);
	//	g.dispose();
		BufferedImage result = new BufferedImage(80, 80,BufferedImage.TYPE_3BYTE_BGR );
		Graphics2D g = (Graphics2D) result.getGraphics();
		Composite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		g.setComposite(composite);
			
		g.drawImage(tile.getImage(), 0, 0, null);
		g.drawImage(i.getImage(), 0, 0, null);
	//	g.dispose();
		return new ImageIcon(result);
	}
	
	public  ImageIcon getImage(String location){
		imageTool it = new imageTool();
		ImageIcon img = new ImageIcon(getClass().getResource(location));
		return img;
	}
}
