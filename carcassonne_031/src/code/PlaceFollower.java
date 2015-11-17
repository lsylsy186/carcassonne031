package code;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * PlaceFollower is an event handler that was added to the JButtons in the follower frame. Ideally, it gets the image
 * of the Tile that was just placed, gets the position at which the player wants to place a follower and then overlays
 * the image of a follower at that position onto the image of the tile and sets that image to the JButton onto which 
 * a tile was just placed. Unfortunately, we have been unable to get BufferedImages to layer on top of each other. 
 * The code that is commented out was what we were attempting to do, but it results in the image disappearing from
 * the JButton. If we change the static variable between Transparency.BITMASK, BufferedImage.TYPE_INT_ARGB and 
 * BufferedImag.TYPE_INT_RGB we get different results, but none of them overlay any images successfully. With this 
 * code commented out, this ActionListener simply closes the JFrame when a button is clicked.
 * 
 * @author Katie
 *
 */
public class PlaceFollower implements ActionListener {
/**
 * Variables that hold references to the View, Board, JButton that a tile was just placed on and the follower JFrame.
 */
	private View _view;
	private JButton _button;
	private JFrame _frame;
	private Board _board;
	
	/**
	 * The constructor initializes all of the instance variables to objects that are passed in.
	 * 
	 * @param v		The View
	 * @param b		The JButton on which a tile was just placed
	 * @param f		The frame that popped up to display the JButtons to which this ActionListener was added
	 * @param bd	The Board
	 */
	public PlaceFollower(View v, JButton b, JFrame f, Board bd){
		_view = v;
		_button = b;
		_frame = f;
		_board = bd;
		
	}
	
	/**
	 * This method is run whenever a button that this ActionListener is added to is clicked. It should overlay the appropriate
	 * image of a follower onto the image of the tile that was just placed. However, it simply places a follower on the Tile in 
	 * the Board and closes the JFrame of the button that was just clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int i = _view.getFollowerPosition((JButton) e.getSource());
		_board.followerOnTile(i);
		/*ImageIcon img = new ImageIcon(getClass().getResource("/resources/follower"+i+".png"));
		BufferedImage buffFollower = new BufferedImage(img.getIconWidth(),img.getIconHeight(), Transparency.BITMASK);
		Graphics2D g = (Graphics2D) buffFollower.getGraphics();
		g.setComposite(AlphaComposite.Src);
		g.drawImage(buffFollower, 0, 0, null);
		g.dispose();
		ImageIcon tile = (ImageIcon) _button.getIcon();
		BufferedImage buffTile = new BufferedImage(tile.getIconWidth(), tile.getIconHeight(), Transparency.BITMASK);
		g = (Graphics2D) buffTile.getGraphics();
		g.setComposite(AlphaComposite.Src);
		g.drawImage(buffTile, 0, 0, null);
		g.dispose();
		BufferedImage buffImage = new BufferedImage(tile.getIconWidth(), tile.getIconHeight(), Transparency.BITMASK);
		g = (Graphics2D) buffImage.getGraphics();
		g.setComposite(AlphaComposite.Src);
		g.drawImage(buffTile, 0, 0, null);
		g.drawImage(buffFollower, 0, 0, null);
		g.dispose();
		ImageIcon image = new ImageIcon(buffImage);
		_button.setIcon(image);*/
		_frame.setVisible(false);
	}
}
