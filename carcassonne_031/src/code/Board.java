package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 * Carcassonne is a board game involving the placement of 72 square tiles. The game begins with the "starting tile." A tile can be made up of a 
 * city, road, or a field, or any combination of the three types. Tiles can only be placed in an open space, but must be adjacent to another tile 
 * on at least one side. The adjacent sides must have a matching combination of types. A tile can be rotated to attempt to make the sides match. 
 * The game ends when all the tiles are placed.
 * 
 * The board is a two-dimensional array of size [144,144]. It is created with the starting tile already in place at (71,71). It has the ability
 * to hold any combination of the remaining 71 tiles with the implementation of several different methods: placeTile, isAdjacent, and matchingSide.
 * 
 * @author Katie
 *
 */
public class Board {
	/**
	 * Variable for the two dimensional array of Tiles that is the underlying structure of the Board
	 */
	private Tile[][] _board;
	/**
	 * Variable for the _view that the Board is associated with
	 */
	private View _view;
	/**
	 * 4 int variables the hold the maximum distance from the starting tile that a tile is currently located at to the right, left, above or below
	 */
	private int _xright;
	private int _xleft;
	private int _yup;
	private int _ydown;
	/**
	 * 2 int variables, _placements holds the number of times a tile has been successfully placed and _temp holds the number a times a tile has been
	 * successfully placed on the previous attempt
	 */
	private int _temp;
	private int _placements;
	/**
	 * Variable of type TileTypes that allows the board to pick a random tile from the ArrayList of tiles
	 */
	private TileTypes _tileTypes;
	/**
	 * Variable of type HashMap<String, Integer> in which the keys are the player's names and the values are the number of followers they have
	 */
	private HashMap<String, Integer> _meeple;
	/**
	 * Variable of type ArrayList<String> that holds all of the player names
	 */
	private ArrayList<String> _players;
	/**
	 * Variable of type Tile that holds a reference to the tile that was just placed
	 */
	private Tile _tile;
	
	/**
	 * The constructor of the Board class creates a 2D tile array of size [144][144], which is the maximum size the board may get if all of the tiles were 
	 * placed in one line. Whenever the board is initialized at the start of a new game the starting tile is placed automatically in the center of the board. 
	 * All of the instance variables are initialized inside of the constructor except _view, which is set by the setView() method.
	 * 
	 * @param players	The ArrayList<String> which holds the names of the players created by the command line input component of the Driver
	 */
	public Board(ArrayList<String> players){
		_board = new Tile[144][144];
		
		_players = players;
		
		//this creates and places the pre-determined "starting tile"
		String[] side1 = new String[] {"city", "city", "city"};
		String[] side2 = new String[] {"field", "road", "field"};
		String[] side3 = new String[] {"field", "field", "field"};
		String[] side4 = new String[] {"field", "road", "field"};
		String inside = null;
		ImageIcon img = new ImageIcon("resources/11.png");
		Tile startingTile = new Tile(side1,side2,side3,side4, inside, false, img, 9);
		_board[71][71] = startingTile;
		
		_xright = 0;
		_xleft = 0;
		_yup = 0;
		_ydown = 0;
		_temp = 0;
		_placements = 0;
		_tileTypes = new TileTypes();
		_tileTypes.createTiles();
		_meeple = new HashMap<String, Integer>();
		for(int i=0; i<_players.size(); i++) {
			_meeple.put(_players.get(i), 7);
		}
	}
	/**
	 * Gives the board a reference to a View object.
	 * 
	 * @param v		A reference to the View object that was instantiated in the PlayerTurns class.
	 */
	public void setView(View v) {
		_view = v;
	}
	
	/**
	 * This method tests if a tile is able to be placed on the board at the position (x,y). If yes, the tile is placed on the board and the method
	 * returns true. If no, the tile is not placed and the method returns false.
	 * 
	 * @param t		The tile to be placed
	 * @param x		The x coordinate where the tile will be placed on the board
	 * @param y		The y coordinate where the tile will be placed on the board
	 * @return		Returns true if the tile is placed, false if the tile is not
	 */
	public boolean placeTile(Tile t, int x, int y) {
		_tile = t;
		if (_board[x][y] == null) {
			if (isAdjacent(x,y)) {
				if(matchingSide(t,x,y)) {
					_board[x][y] = t;
					int tempx = x-71;
					int tempy = y-71;
					if(tempx > _xright){
						_xright = tempx;
						_view.updateRight(t,x,y);
					} else if(tempx < 0 && tempx < _xleft){
						_xleft = tempx;
						_view.updateLeft(t,x,y);
					} else if(tempy > _yup){
						_yup = tempy;
						_view.updateUp(t,x,y);
					} else if(tempy < 0 && tempy < _ydown){
						_ydown = tempy;
						_view.updateDown(t,x,y);
					} else {
						_view.update(t,x,y);
					}
					_placements++;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method looks to see if there is at least one tile on one of the four sides of (x,y). It is used inside of the placeTile method.
	 * 
	 * @param x	The x coordinate of the tile being placed
	 * @param y	The y coordinate of the tile being placed
	 * @return	True if there is a tile in a position next to the chosen coordinate. False if there is no adjacent tile, meaning the tile cannot be placed at the chosen coordinates
	 */
	private boolean isAdjacent(int x, int y) {	
		if(_board[x-1][y] != null) {
			return true;
		}
		if(_board[x+1][y] != null) {
			return true;
		}
		if(_board[x][y-1] != null) {
			return true;
		}
		if(_board[x][y+1] != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method compares the type arrays on adjacent sides to see if they match with the new tile.This method is used in the placeTile method.
	 * 
	 * @param t	The new tile that the player is attempting to place on the board/view
	 * @param x	The x coordinate of the tile being placed
	 * @param y	The y coordinate of the tile being placed
	 * @return	 If the ArrayList<String> of adjacent given tiles are the same, the method returns true. If they are different, the method returns false and a tile is not placed. 
	 */
	private boolean matchingSide(Tile t, int x, int y) {		
		if(_board[x-1][y] != null) {
			String[] placed = _board[x-1][y].accessSides(2);	
			String[] possible = t.accessSides(4);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
		}
		if(_board[x+1][y] != null) {
			String[] placed = _board[x+1][y].accessSides(4);
			String[] possible = t.accessSides(2);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
		}
		if(_board[x][y-1] != null) {
			String[] placed = _board[x][y-1].accessSides(1);
			String[] possible = t.accessSides(3);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
		}
		if(_board[x][y+1] != null) {
			String[] placed = _board[x][y+1].accessSides(3);
			String[] possible = t.accessSides(1);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method takes the ArrayList<Tile> that holds all 72 tiles used during gameplay and shuffles them so that a random tile is pulled each time this method is called.
	 * 
	 * @return	Returns the tile that is displayed to the user as the tile which can be placed
	 */
	public Tile pickTile(){
		ArrayList<Tile> tileList = _tileTypes.getTileList();
		Collections.shuffle(tileList);
		Tile tile = tileList.get(0);
		tileList.remove(0);
		return tile;	
	}
	
	/**
	 * This method compares two int values. The _placements variable is a counter that keeps track of how many times a tile has been placed. The _temp variable stores the 
	 * value of _placements before a tile is potentially placed. In this method, the value of _temp is assigned to a local variable, _temp is updated to the current value
	 * _placements and the local variable is compared to _placements. If they are different, then a Tile has been placed in the Board.
	 * 
	 * @return	If a tile is placed in the board, the method returns true. If a tile is not placed in the board, the method returns false.
	 */
	public boolean tilePlaced(){
		int temp = _temp;
		_temp = _placements;
		return !(temp == _placements);
	}
	
	/**
	 * This method returns the size of the ArrayList of Tiles from the TileTypes class.
	 * 
	 * @return		Returns the size of the ArrayList of Tiles from the TileTypes class as an int
	 */
	public int getTileList(){
		return _tileTypes.getTileList().size();
	}
	
	/**
	 * This method takes in the index of a player in the ArrayList of the players. Using that index, the String returned by the getting the name out of the
	 * ArrayList, _players, is used to get the number of Followers associated with that player in the HashMap<String, Integer>. If the number of Followers is greater than zero, it decrements that by one
	 * and puts that number in the HashMap with the key value of the current player's name. It then returns the updated number of followers for that player. If the number of followers is not greater than
	 * zero, it returns 0.
	 * 
	 * @param i		An int value that is the index of the current player's turn in the ArrayList of the player names
	 * @return		Returns the number of followers the player has as an int after they placed a follower.
	 */
	public int placeFollower(int i) {
		int number = _meeple.get(_players.get(i));
		if(number > 0){
			number = number -1;
			_meeple.put(_players.get(i), number);
			return number;
		}
		return 0;
	}
	
	/**
	 * This method calls getFollower() on the tile that was most recently placed, passing in the int that represents
	 * the position of the follower on the tile.
	 * 
	 * @param i		Takes in an int that represents a follower position on a Tile
	 */
	public void followerOnTile(int i){
		_tile.getFollower(i);
	}
	
	/**
	 * This is a getter for the ArrayList of players names.
	 * 
	 * @return		Returns the ArrayList of player names
	 */
	public ArrayList<String> getPlayers(){
		return _players;
	}
	
	/**
	 * This method returns the current number of followers a player has.
	 * 
	 * @param s		Takes in the player's name as a String
	 * @return		Returns the number of followers the player has
	 */
	public int getHash(String s){
		return _meeple.get(s);
	}
}
