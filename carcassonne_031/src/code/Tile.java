package code;

import javax.swing.ImageIcon;
/**
 * Tile is an array of size four that holds String arrays of size three. The four String arrays hold the combination of types (city, road, or 
 * field) on each side of the Tile as well as a series of other properties. A tile can be manipulated by the rotate method.
 * 
 * @author knjames
 *
 */
public class Tile {
	/**
	 * The place on which a follower is located on a tile
	 */
	private int _followerSpot;
	/**
	 * The four arrays of three strings that represent the sides
	 */
	private String[] _side1;
	private String[] _side2;
	private String[] _side3;
	private String[] _side4;
	/**
	 * The feature that is located at the center of the tile, could be "cloister", "road end", "city", "road", or "field" 
	 */
	private String _inside;
	/**
	 * A boolean that is true if the tile has a shield and is false if it does not
	 */
	private boolean _shield;
	/**
	 * An array of all of the side arrays
	 */
	private String[][] _sides;
	/**
	 * The image of the tile
	 */
	private ImageIcon _image;
	
	/**
	 * The constructor initializes all of the instance variables to values that are specified when a tile is created
	 * 
	 * @param a		Array of strings that represent the top side of the tile
	 * @param b		Array of strings that represent the right side of the tile 
	 * @param c		Array of strings that represent the bottom side of the tile
	 * @param d		Array of strings that represent the left side of the tile
	 * @param inside	A String that describes what feature is in the middle of the tile
	 * @param s		A boolean that is true if the tile has a shield and is false if it does not
	 * @param img	The ImageIcon of the tile
	 * @param f		The int that describes the location of a follower. It is initialized to 9 because that is not a valid follower position
	 */
	public Tile(String[] a,String[] b,String[] c,String[] d, String inside, boolean s, ImageIcon img, int f) {
		
		//this puts the four String arrays in the correct configuration on a Tile
		//this also puts the String (the extra feature) onto the Tile configuration 
		_side1 = a;
		_side2 = b;
		_side3 = c;
		_side4 = d;	
		_inside = inside;
		_shield = s;
		_image = img;
		_sides = new String[][] {_side1, _side2, _side3, _side4};
		_followerSpot = 9;
	}
	
	/**
	 * This method takes in an int i which determines the number of times that a tile is rotated. It maintains the configuration where the top of
	 * the tile is side 1, the right side is side 2, the bottom is side 3, and the left side is side 4.
	 * 
	 * @param i		The number of times the tile should be rotated by 90 degrees
	 */
	public void rotate(int i) {
		
		String[][] temp = new String[4][3];
		for(int j=0; j<i%4; j++) {
			for(int k=0; k<4; k++) {
				temp[(k+1)%4] = _sides[k];
			}
			_sides = temp;
		}
	}
	
	/**
	 * This method is used in the matchingSide method of the Board. It returns the String array of the side asked for by int i.
	 * 
	 * @param i		The side number that is being accessed
	 * @return		The array of strings of the side being accessed
	 */
	public String[] accessSides(int i){
		return _sides[i-1];
	}
	
	/**
	 * This method accesses the feature at the center of a Tile, which could be "cloister", "road end", "city", "road", or "field".
	 * 
	 * @return		The string of the center feature
	 */
	public String accessCenter(){
		return _inside;
	}
	
	/**
	 * This method is a getter for the ImageIcon that is a visual representation of the Tile.
	 * 
	 * @return		ImageIcon of the tile
	 */
	public ImageIcon getImage(){
		return _image;
	}
	
	/**
	 * This method allows a follower to be placed on a tile at the position specific by the int that is passed in.
	 * 
	 * @param f		The int representing the position of the follower
	 * @return		The int representing the position of the follower
	 */
	public int getFollower(int f){
		_followerSpot = f;
		return _followerSpot;
	}
}
