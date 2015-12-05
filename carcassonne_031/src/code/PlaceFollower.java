package code;

import java.awt.AlphaComposite;
import java.awt.Composite;
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
 * 
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
	 * This method is run whenever a button that this ActionListener is added to is clicked. Overlays the appropriate
	 * image of a follower onto the image of the tile that was just placed. Unless followerPlaced returns false, in which case the button click does nothing.
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int i = _view.getFollowerPosition((JButton) e.getSource());
		String type = _view.getFollowerType((JButton)e.getSource());
		boolean followerPlaced = _board.followerOnTile(i, type);
		if(followerPlaced){
		ImageIcon img = new ImageIcon(getClass().getResource("/resources/follower"+PlayerTurns.color+".png"));
		ImageIcon tile = (ImageIcon) _button.getIcon();
		BufferedImage result = new BufferedImage(80, 80,BufferedImage.TYPE_3BYTE_BGR );
		Graphics2D g = (Graphics2D) result.getGraphics();
		Composite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		g.setComposite(composite);
		g.drawImage(tile.getImage(), 0, 0, null);
		g.drawImage(img.getImage(), i % 3 * 27 + 9, i / 3 * 27 + 9,i % 3 * 27 + 18,i / 3 *27 + 18,0,0,80,80, null);
		ImageIcon image = new ImageIcon(result);
		_button.setIcon(image);
		_frame.setVisible(false);
		
		}
		else{
			System.out.println("the follower cannot legally be placed here");
		}
		_view.setPressed(true);
		

	}
	
	
}
