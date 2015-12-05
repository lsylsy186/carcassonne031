package code;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * EventHandler which implements ActionListener is used by the JButtons displayed on the View. If a JButton is clicked,
 * the Tile the player is attempting to place will be put on that JButton's spot in the View and its coordinates will be
 * stored in the Board, so that no other Tile can be placed in the same spot.
 * 
 * 
 */
public class EventHandler implements ActionListener {

	/**
	 * Instance variables which will reference the Board and View
	 */
	private View _view;
	private Board _board;
	
	/**
	 * Used to determine if a Tile was correctly placed in the Board.
	 */
	private boolean _placed;
		
	/**
	 * Constructor which initializes the View and Board.
	 * 
	 * @param v	Variable which holds a reference to the View class
	 * @param b	Variable which holds a reference to the Board class
	 */
	public EventHandler(View v, Board b){
		_view = v;
		_board = b;
	}
	
	/**
	 * When a button on the View is clicked this method runs. The JButton that was pressed is accessed and its location is 
	 * found. The Tile that the player is attempting to place is checked with the Board using the boolean _placed. If the 
	 * Tile is able to be placed, the Board and View are updated with the new information and the image of the Tile on the 
	 * clicked JButton is displayed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		Point p = _view.getButtonCoordinates(button);
		int x = (int) p.getX();
		int y =(int) p.getY();
		Tile t = _view.getTile();
		_placed = _board.placeTile(t,x,y);
		if(_placed){
			button.removeActionListener(this);
			_view.updateImage(null);
		}
	}	
}
