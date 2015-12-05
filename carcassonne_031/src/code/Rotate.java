package code;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Rotate is the ActionListener called on the Tile which the player can place during their turn. It will rotate
 * both the String[] sides as well as the .png image every time the JButton on the player view is clicked. Each 
 * rotation is 90 degrees clockwise. This ActionListener will not work outside of the JButton in the player frame.
 * 
 * 
 */
public class Rotate implements ActionListener {
	
	/**
	 * Instance variable to connect the view and this class
	 */
	private View _view;
	
	/**
	 * Used to reference the JButton where the Tile being rotated is located 
	 */
	private JButton _button;
	
	/**
	 * ImageIcon variable to reference the .png that needs to be rotated
	 */
	private ImageIcon _tileImage; 
	
	/**
	 * The constructor initializes the _view and _button variables with the View and JButton that are passed in as parameters.
	 * 
	 * @param v	Variable which holds the View class
	 * @param b Variable which holds the JButton in the player view which they can click to call this class
	 */
	public Rotate(View v, JButton b) {
		_view = v;
		_button = b;
	}

	/**
	 * This method is a method of the implemented ActionListener. When the button is clicked (which is the action that is being performed),
	 * the Tile and its image are accessed. The rotateIcon method within this class is used to turn the image 90 degrees and the rotate method 
	 * of the tile is used to "rotate" the String[] for each side.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Tile tile = _view.getTile();
		int rotationTimes = tile.get_rotateTimes();
		_tileImage = _view.getImage();
		rotateIcon(_tileImage, _button);
		_button.setIcon(_tileImage);
		_view.updateImage(_tileImage);
		_view.updateTile(tile);
		tile.rotate(1); 
		rotationTimes++;
		tile.set_rotateTimes(rotationTimes);//A 1 specifies the number of times the rotate method runs
	}
	
	/**
	 * RotateIcon takes in the ImageIcon of the Tile being held in the JButton which is passed in. To complete one rotation the ImageIcon is converted
	 * to a BufferedImage, then a Graphics2D image in order to properly utilize the AfflineTransform class and its rotate method. The image is then
	 * converted back to an ImageIcon and replaced on the Tile that was originally accessed.
	 * 
	 * @param icon	The original image from the Tile on the JButton
	 * @param b1	The JButton which holds the Tile being manipulated
	 */
    private void rotateIcon(ImageIcon icon, JButton b1) {
    	int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        BufferedImage image = new BufferedImage(h, w, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        double x = (h - w)/2.0;
        double y = (w - h)/2.0;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.rotate(Math.toRadians(90), w/2.0, h/2.0);
        g2.drawImage(icon.getImage(), at, b1);
        g2.dispose();
        _tileImage = new ImageIcon(image);
    }

}
