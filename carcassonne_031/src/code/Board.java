package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 * Carcassonne is a board game involving the placement of 72 square tiles. The game begins with the "starting tile." A tile can be made up of a 
 * city, road, or a field, or any combination of the three types. Tiles can only be placed in an open space, but must be adjacent to another tile 
 * on at least one side. The adjacent sides must have a matching combination of types. A tile can be rotated to attempt to make the sides match. 
 * The game ends when all the tiles are placed.
 * 
 * The board is a two-dimensional array of size [144,144]. It is created with the starting tile already in place at (71,71). It has the ability
 * to hold any combination of the remaining 71 tiles with the implementation of several different methods: placeTile, isAdjacent, and matchingSide.
 * 
 * 
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
	
	// 2 int variables which store the x y location of the most recently placed tile on the board.
	
	private int _xplaced;
	private int _yplaced;
	
	private ArrayList<Tile> riverList ;
	private ArrayList<Tile> tileList ;
	private ArrayList<Tile> riverListOriginal;
	private ArrayList<Tile> tileListOriginal ;
	
	
	private ArrayList<Tile> _tileChecked = new ArrayList<Tile>();
	
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
	
	private boolean _roadScore = false;
	
	private int _roadEndNum = 0;
	
	private int[] _followerCheck = new int [5];
	
	private boolean[] _playerScored = new boolean[5];
	private PlayerTurns _pt;
	
	/**
	 * The constructor of the Board class creates a 2D tile array of size [144][144], which is the maximum size the board may get if all of the tiles were 
	 * placed in one line. Whenever the board is initialized at the start of a new game the starting tile is placed automatically in the center of the board. 
	 * All of the instance variables are initialized inside of the constructor except _view, which is set by the setView() method.
	 * 
	 * @param players	The ArrayList<String> which holds the names of the players created by the command line input component of the Driver
	 */
	public Board(ArrayList<String> players, PlayerTurns playerTurns){
		_board = new Tile[144][144];
		
		_players = players;
		
		_pt = playerTurns;
		
		//this creates and places the pre-determined "starting tile"
		String[] side1 = {"field", "field","field"};
		String[] side2 = {"field", "field","field"};
		String[] side3 = {"field", "river","field"};
		String[] side4 = {"field", "field","field"};
		String inside = "river";
		ImageIcon img = new ImageIcon(getClass().getResource("/resources/25.png"));
		Tile startingTile = new Tile(side1, side2, side3, side4, inside, false, img, 9,"RA");
	

		_board[71][71] = startingTile;
		
		_xright = 0;
		_xleft = 0;
		_yup = 0;
		_ydown = 0;
		_temp = 0;
		_xplaced =0;
		_yplaced = 0;
		_placements = 0;
		_tileTypes = new TileTypes();
		_tileTypes.createTiles();
		_meeple = new HashMap<String, Integer>();
		for(int i=0; i<_players.size(); i++) {
			_meeple.put(_players.get(i), 7);
		}
		 riverList = _tileTypes.getRiverTileList();
		 tileList = _tileTypes.getTileList();
		 riverListOriginal = _tileTypes.getRiverTileList();
		 tileListOriginal = _tileTypes.getTileList();
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
					_xplaced = x;
					_yplaced = y;
					
					_placements++;
					
					
					_tile.setPlayerPlaced(_pt.getPlayerTurn());
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
		String[] fieldRiverField = {"field", "river","field"};
		System.out.println("tile placed on "+ x+" and "+y);
		
		if(_board[x-1][y] != null) {
			String[] placed = _board[x-1][y].accessSides(2);	
			String[] possible = t.accessSides(4);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
			
			//Guarantees that river tiles are always placed to continue the stream of the river
			if((Arrays.equals(t.accessSides(1), fieldRiverField) || Arrays.equals(t.accessSides(2), fieldRiverField) || 
					Arrays.equals(t.accessSides(3), fieldRiverField) || Arrays.equals(t.accessSides(4), fieldRiverField)) 
					&& !Arrays.equals(placed, fieldRiverField)){
				
				return false;
			}
			
			//Checks immediate U-Turns of the river
			if((Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(1), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x-1][y].accessSides(1), fieldRiverField))
					
					||(Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(3), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x-1][y].accessSides(3), fieldRiverField))){
				
				return false;
				}
			}
		if(_board[x+1][y] != null) {
			String[] placed = _board[x+1][y].accessSides(4);
			String[] possible = t.accessSides(2);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
			
			//Guarantees that river tiles are always placed to continue the stream of the river
			if((Arrays.equals(t.accessSides(1), fieldRiverField) || Arrays.equals(t.accessSides(2), fieldRiverField) || 
					Arrays.equals(t.accessSides(3), fieldRiverField) || Arrays.equals(t.accessSides(4), fieldRiverField)) 
					&& !Arrays.equals(placed, fieldRiverField)){
				
				return false;
			}
			
			//Checks immediate U-Turns of the river
			if((Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(1), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x+1][y].accessSides(1), fieldRiverField))
					
					||(Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(3), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x+1][y].accessSides(3), fieldRiverField))){
				
				return false;
			}
		}
		if(_board[x][y-1] != null) {
			String[] placed = _board[x][y-1].accessSides(1);
			String[] possible = t.accessSides(3);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
			
			//Guarantees that river tiles are always placed to continue the stream of the river
			if((Arrays.equals(t.accessSides(1), fieldRiverField) || Arrays.equals(t.accessSides(2), fieldRiverField) || 
					Arrays.equals(t.accessSides(3), fieldRiverField) || Arrays.equals(t.accessSides(4), fieldRiverField)) 
					&& !Arrays.equals(placed, fieldRiverField)){
				
				return false;
			}
			
			//Checks immediate U-Turns of the river
			if((Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(2), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x][y-1].accessSides(2), fieldRiverField))
					
					||(Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(4), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x][y-1].accessSides(4), fieldRiverField))){
				
				return false;
			}
		}
		if(_board[x][y+1] != null) {
			String[] placed = _board[x][y+1].accessSides(3);
			String[] possible = t.accessSides(1);
			if (! Arrays.equals(placed, possible)) {
				return false;
			}
			//Guarantees that river tiles are always placed to continue the stream of the river
			if((Arrays.equals(t.accessSides(1), fieldRiverField) || Arrays.equals(t.accessSides(2), fieldRiverField) || 
					Arrays.equals(t.accessSides(3), fieldRiverField) || Arrays.equals(t.accessSides(4), fieldRiverField)) 
					&& !Arrays.equals(placed, fieldRiverField)){
				
				return false;
			}
			
			//Checks immediate U-Turns of the river
			if((Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(2), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x][y+1].accessSides(2), fieldRiverField))
					
					||(Arrays.equals(possible, fieldRiverField) && Arrays.equals(t.accessSides(4), fieldRiverField)) &&
					(Arrays.equals(placed, fieldRiverField) && Arrays.equals(_board[x][y+1].accessSides(4), fieldRiverField))){
			
				return false;
			}
		}
			return true;
	}
		
		/**
		 * This method takes the ArrayList<Tile> that holds all of the tiles used during gameplay and shuffles them so that a random tile is pulled each time this method is called.
		 * The river tiles are used first and after the array is emptied, the regular Carcassone tiles are used.
		 * 
		 * @return	Returns the tile that is displayed to the user as the tile which can be placed
		 */
	
	public void score(){
		if(_tile.containsRoad()){
			if(checkRoadScore(_xplaced,_yplaced, 4)) scoreRoad();
			if(_roadScore) scoreRoad();
			
			_roadScore=false;
			_tileChecked.clear();
			
		}
		
		
	}
	
	private void scoreRoad() {
		for(Tile t : _tileChecked)
		if(t.getFollowerType().equals("road")){
			addFollowerCheck(t);
			int temp = _meeple.get(_players.get((t.getPlayerNumber())));
			_meeple.put(_players.get((t.getPlayerNumber())),temp+1);
		};
		
		for(int j = 0; j<5;j++){
			for(int i = 0;i<5;i++){
				if((_followerCheck[i]>=_followerCheck[j])&&(_followerCheck[j]>0||_followerCheck[i]>0)){
					_playerScored[i] = true;
				}
				else _playerScored[i] = false;
		}	
		}
			for(int i = 0;i<5;i++){
					_followerCheck[i] = 0;
				}
	
		
		
		
		
		// TODO Auto-generated method stub
		
	}
	
	private void addFollowerCheck(Tile t) {
		int n = t.getPlayerNumber();
		_followerCheck[n-1]++; 
	}
	private boolean checkRoadScore(int x, int y, int entry) {
		if(_board[x][y] == null) return false;
		
		Tile t = _board[x][y];
		if(_tileChecked.contains(t)) return true;
		_tileChecked.add(t);
		
		boolean check = true;
		
		if(t.getRoadEnd()) _roadEndNum++;
		if(_roadEndNum>1) _roadScore = true;
		
		
			if(Arrays.asList(t.accessSides(1)).contains("road") && check) check= checkFollowerRoad(x, y+1,7);
			if(Arrays.asList(t.accessSides(2)).contains("road")&& check) check= checkFollowerRoad(x+1, y,3);
			if(Arrays.asList(t.accessSides(3)).contains("road")&& check) check= checkFollowerRoad(x, y-1,1);
			if(Arrays.asList(t.accessSides(4)).contains("road") && check) check= checkFollowerRoad(x-1, y,5);

		
		return check;
	}
	
	/**
	 * This method takes the ArrayList<Tile> that holds all 72 tiles used during gameplay and shuffles them so that a random tile is pulled each time this method is called.
	 * 
	 * @return	Returns the tile that is displayed to the user as the tile which can be placed
	 */
	
		
	public Tile pickTile(){
		ArrayList<Tile> riverList = _tileTypes.getRiverTileList();
		ArrayList<Tile> tileList = _tileTypes.getTileList();
		ArrayList<Tile> temp = new ArrayList<Tile>();
		Tile tile = new Tile(null, null, null, null, null, false, null, _placements, null);
		
		if(riverList.isEmpty()){
			//Returns a regular tile
			Collections.shuffle(tileList);
			tile = tileList.get(0);
			tileList.remove(0);
		}
		else{
			//Shuffles the tiles and adds the end tile as the last
			temp.add(riverList.get(riverList.size()-1));
			riverList.remove(riverList.size()-1);
			Collections.shuffle(riverList);
			riverList.add(temp.get(0));
			
			//Returns a river tile
			tile = riverList.get(0);
			riverList.remove(0);
		}
		
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
	 * @return placed 	The boolean value indicated if the follower was placed or not.
	 */
	public boolean followerOnTile(int i, String type){
		//	System.out.println(type);
			boolean allowed=false;
			_tileChecked.clear();
			
			if(type.equals("road")){
				_tileChecked.clear();
				allowed = checkFollowerRoad(_xplaced, _yplaced, i);
				if(allowed)_tile.putFollower(i);
				if(allowed) _tile.setFollowerType("road");
			}
			else if (type.equals("field")){
				_tileChecked.clear();
				allowed = checkFollowerField(_xplaced, _yplaced, i);
				if(allowed) _tile.setFollowerType("field");
				if(allowed)_tile.putFollower(i);
				if(allowed) System.out.println("a field follower has been placed");
			}
			else if(type.equals("city")){
				if(_tile.getTileName().equals("B")&&(i == 0||i ==2 ||i ==8 || i ==6)){
					System.out.println("Sorry, you cannot place a follower there because it is ambiguous");
					return false;
				}
				_tileChecked.clear();
				allowed = checkFollowerCity(_xplaced, _yplaced, i);
				if(allowed) _tile.setFollowerType("city");
				if(allowed)_tile.putFollower(i);
				if(allowed) System.out.println("a city follower has been placed");	
			}
			else if(type.equals("cloister")||type.equals("river cloister")){
				_tile.setFollowerType(type);
				_tile.putFollower(i);
				System.out.println("a cloister follower has been placed");
				return true;
			}
			
				
			else{
				System.out.println("Sorry, please choose a different location to place the follower");
				return false;
			}
			return allowed;

		}
	

	

	/**
	 * 
	 * @param x  the x value of location of the tile being checked.
	 * @param y	 the y value of the location of the tile being checked.
	 * @param entry  	the value from 0 to 8 of where on the tile the follower is being placed.  
	 * 		When the method is called recursively, this value will indicate on which side the check needs to occur. 	 
	 * @return		returns if it can be legally placed.
	 */
	private boolean checkFollowerCity(int x, int y, int entry) {
		boolean checkDown = true;
		boolean checkUp = true;
		boolean checkLeft = true;
		boolean checkRight = true;
		
		boolean tCity;
		boolean rCity;
		boolean bCity;
		boolean lCity;
		
		boolean lrCity = false;
		boolean tbCity = false;
		
		
		
		if(_board[x][y] == null) return true;
	
		Tile t = _board[x][y];
		if(_tileChecked.contains(t)) return true;
		int follower = t.getFollowerSpot();
		String followerType = t.getFollowerType();
		
		tCity = t.accessSides(1)[1].equals("city");
		rCity = t.accessSides(2)[1].equals("city");
		bCity = t.accessSides(3)[1].equals("city");
		lCity = t.accessSides(4)[1].equals("city");
		
		boolean checkEntrySide = false;
		
		
		if(rCity&&lCity&&!t.accessCenter().equals("city")) lrCity = true;
		if(tCity&&bCity&&!t.accessCenter().equals("city")) tbCity = true;
		boolean b = false;
		if(t.getTileName().equals("B")) b = true;
		
		if(((entry ==0)||(entry == 1)||(entry ==2))&&(tbCity||b)&& (follower ==0||follower==1||follower==2)&& followerType.equals("city")) checkEntrySide = true;
		if(((entry ==2)||(entry == 5)||(entry ==8))&&(lrCity||b)&& (follower ==2||follower==5||follower==8)&& followerType.equals("city")) checkEntrySide = true;
		if(((entry ==6)||(entry == 7)||(entry ==8))&&(tbCity||b)&& (follower ==6||follower==7||follower==8)&& followerType.equals("city")) checkEntrySide = true;
		if(((entry ==0)||(entry == 3)||(entry ==6))&&(lrCity||b)&& (follower ==0||follower==3||follower==6)&& followerType.equals("city")) checkEntrySide = true;
		
		if(!checkEntrySide&&(tbCity||lrCity||b)){
			_tileChecked.add(t);
			if((entry ==0)||(entry == 1)||(entry ==2)&&(tbCity)) return checkFollowerCity(x,y+1,7);
			if((entry ==2)||(entry == 5)||(entry ==8)&&(lrCity)) return checkFollowerCity(x+1,y,3);
			if((entry ==6)||(entry == 7)||(entry ==8)&&(tbCity)) return checkFollowerCity(x,y-1,1);
			if((entry ==0)||(entry == 3)||(entry ==6)&&(lrCity)) return checkFollowerCity(x-1,y,5);
		}
		
		
		if(followerType.equals("city")) return false;
		else{
			_tileChecked.add(t);
			if(tCity) checkUp = checkFollowerCity(x,y+1,7);
			if(rCity) checkRight = checkFollowerCity(x+1,y,3);
			if(bCity) checkDown = checkFollowerCity(x,y-1,1);
			if(lCity) checkLeft = checkFollowerCity(x-1,y,5);
			
		}
		
		if(entry == follower&& followerType.equals("city")){
			System.out.println("tile returns false since entry== follower");
			return false;
		}
		
		boolean check = checkUp&&checkRight&&checkDown&&checkLeft;
		
		
		return check;
	}
	/**
	 * 
	 * @param x  the x value of location of the tile being checked.
	 * @param y	 the y value of the location of the tile being checked.
	 * @param entry  	the value from 0 to 8 of where on the tile the follower is being placed.  
	 * 		When the method is called recursively, this value will indicate on which side the check needs to occur. 	 
	 * @return		returns if it can be legally placed.
	 */
	private boolean checkFollowerField(int x, int y, int entry) {
		//top, right, bottom, and left boolean variables indicated if the path is blocked or not
		boolean tmBlocked;
		boolean rmBlocked;
		boolean bmBlocked;
		boolean lmBlocked;
		
		//each corner indicating if the path is open
		//(top left, top right, bottom left, bottom right, et cetera)
	
		
		boolean tOpen;
		boolean lOpen;
		boolean rOpen;
		boolean bOpen;
		
		boolean rFullOpen;
		boolean lFullOpen;
		boolean tFullOpen;
		boolean bFullOpen;
		
		boolean checkDown = true;
		boolean checkUp = true;
		boolean checkLeft = true;
		boolean checkRight = true;
		
		boolean lrCity = false;
		boolean tbCity = false;
		
	
		
		
		

		if(_board[x][y] == null) return true;

		Tile t = _board[x][y];
		if(_tileChecked.contains(t)) return true;
		int follower = t.getFollowerSpot();
		
		boolean checkEntrySide = false;
		
		
		String followerType = t.getFollowerType();
		//if a follower was found at the entrance point, should return false.
		
		
		System.out.println("tile at "+x+", "+y+ "  and entry ="+ entry  +"  and Follower ="+follower + "and type= " + followerType);
		
		if(entry == follower&& followerType.equals("field")){
			System.out.println("tile returns false since Entry== follower");
			return false;
		}
		
		lrCity = (t.accessSides(2)[1].equals(t.accessSides(4)[1]));
		tbCity = (t.accessSides(1)[1].equals(t.accessSides(3)[1]));		
		
		tmBlocked = (t.accessSides(1)[1].equals("road")||t.accessSides(1)[1].equals("river")&&!t.accessCenter().equals("river city road"));
		rmBlocked = (t.accessSides(2)[1].equals("road")||t.accessSides(2)[1].equals("river")&&!t.accessCenter().equals("river city road"));
		bmBlocked = (t.accessSides(3)[1].equals("road")||t.accessSides(3)[1].equals("river")&&!t.accessCenter().equals("river city road"));
		lmBlocked = (t.accessSides(4)[1].equals("road")||t.accessSides(4)[1].equals("river")&&!t.accessCenter().equals("river city road"));
		
		tOpen = (t.accessSides(1)[0].equals("field")&&!t.accessCenter().equals("river city road"));
		rOpen = (t.accessSides(2)[0].equals("field")&&!t.accessCenter().equals("river city road"));
		bOpen = (t.accessSides(3)[0].equals("field")&&!t.accessCenter().equals("river city road"));
		lOpen = (t.accessSides(4)[0].equals("field")&&!t.accessCenter().equals("river city road"));
		
		tFullOpen = (t.accessSides(1)[0].equals("field")&&t.accessSides(1)[1].equals("field")&&t.accessSides(1)[2].equals("field"));
		rFullOpen = (t.accessSides(2)[0].equals("field")&&t.accessSides(2)[1].equals("field")&&t.accessSides(2)[2].equals("field"));
		bFullOpen = (t.accessSides(3)[0].equals("field")&&t.accessSides(3)[1].equals("field")&&t.accessSides(3)[2].equals("field"));
		lFullOpen = (t.accessSides(4)[0].equals("field")&&t.accessSides(4)[1].equals("field")&&t.accessSides(4)[2].equals("field"));
		
		if(((entry ==0)||(entry == 1)||(entry ==2))&&lrCity&&!tmBlocked&& (follower ==0||follower==1||follower==2)&& followerType.equals("field")) checkEntrySide = true;
		if(((entry ==2)||(entry == 5)||(entry ==8))&&tbCity&&!rmBlocked&& (follower ==2||follower==5||follower==8)&& followerType.equals("field")) checkEntrySide = true;
		if(((entry ==6)||(entry == 7)||(entry ==8))&&lrCity&&!bmBlocked&& (follower ==6||follower==7||follower==8)&& followerType.equals("field")) checkEntrySide = true;
		if(((entry ==0)||(entry == 3)||(entry ==6))&&tbCity&&!lmBlocked&& (follower ==0||follower==3||follower==6)&& followerType.equals("field")) checkEntrySide = true;

		
		if(t.accessCenter().equals("city")){
			if(checkEntrySide) return false;
			if(!_tileChecked.isEmpty()&&!checkEntrySide){
				return true;
			}
			else if(entry == 0){
				_tileChecked.add(t);
				if(tbCity) return checkFollowerField (x-1,y,2);
				else if(lrCity) return checkFollowerField(x,y+1,6);
			}
			
			else if(entry == 1){
				_tileChecked.add(t);
				return checkFollowerField(x,y+1,6);
			}
			else if(entry == 2){
				_tileChecked.add(t);
				if(tbCity)return checkFollowerField (x+1,y,0);
				else if(lrCity) return checkFollowerField(x,y+1,8);
			}
			else if(entry == 5){
				_tileChecked.add(t);
				return checkFollowerField(x+1,y,3);
			}
			
			else if(entry == 8){
				_tileChecked.add(t);
				if(tbCity)return checkFollowerField (x+1,y,6);
				else if(lrCity) return checkFollowerField(x,y-1,2);
			}
			
			else if(entry == 7){
				_tileChecked.add(t);
				return checkFollowerField(x,y-1,1);
			}
			
			
			
			else if(entry ==6){
				_tileChecked.add(t);
				if(tbCity)return checkFollowerField (x-1,y,8);
				else if(lrCity) return checkFollowerField(x,y-1,0);
			}
			
			else if(entry == 3){
				_tileChecked.add(t);
				return checkFollowerField(x-1,y,5);
			}
			
		}
		
		else if(t.getTileName().equals("RH")){
			switch(entry){
			case 0:
					if(follower ==8) return false;
					checkLeft = checkFollowerField(x-1,y, 2);
					checkUp = checkFollowerField(x,y+1,6);
					checkDown = checkFollowerField(x,y-1,2);
					checkRight = checkFollowerField(x+1,y,6);
			break;
			case 2:
					if(follower ==6) return false;
					checkLeft = checkFollowerField(x-1,y, 8);
					checkUp = checkFollowerField(x,y+1,8);
					checkDown = checkFollowerField(x,y-1,0);
					checkRight = checkFollowerField(x+1,y,0);
			break;
			case 8:
					if(follower ==0) return false;
					checkLeft = checkFollowerField(x-1,y, 2);
					checkUp = checkFollowerField(x,y+1,6);
					checkDown = checkFollowerField(x,y-1,2);
					checkRight = checkFollowerField(x+1,y,6);
			break;
			case 6:
				if(follower ==2) return false;
				checkLeft = checkFollowerField(x-1,y, 8);
				checkUp = checkFollowerField(x,y+1,8);
				checkDown = checkFollowerField(x,y-1,0);
				checkRight = checkFollowerField(x+1,y,0);
			}
			
			
			
			
		}
		
		else if(t.accessCenter().equals("river city road")){
			
			if(entry == 0){
				_tileChecked.add(t);
				if(tOpen)checkUp = checkFollowerField(x,y+1,6);
				if(lOpen) checkLeft = checkFollowerField (x-1,y,2);
			}
			
			if(entry == 2){
				_tileChecked.add(t);
				if(tOpen)checkUp = checkFollowerField(x,y+1,8);
				if(rOpen) checkRight = checkFollowerField (x+1,y,0);
			}
			
			if(entry ==6){
				_tileChecked.add(t);
				if(lOpen) checkLeft = checkFollowerField (x-1,y,8);
				if (bOpen) checkDown = checkFollowerField(x,y-1,0);
			}
			if(entry == 8){
				_tileChecked.add(t);
				if(bOpen) checkDown = checkFollowerField(x,y-1,2);
				if(rOpen) checkRight = checkFollowerField (x+1,y,6);
			}
			
		}
		
		else if(t.accessCenter().equals("cloister")|| t.accessCenter().equals("river end")){
			if(followerType.equals("field")) return false;
			_tileChecked.add(t);
			checkUp = checkFollowerField(x,y+1,6);
			checkLeft = checkFollowerField (x-1,y,2);
			checkDown = checkFollowerField(x,y-1,2);
			checkRight = checkFollowerField (x+1,y,0);
			
			if(checkUp) checkUp = checkFollowerField(x,y+1,8);
			if(checkLeft) checkLeft = checkFollowerField (x-1,y,8);
			if(checkDown) checkDown = checkFollowerField(x,y-1,0);
			if(checkRight) checkRight = checkFollowerField (x+1,y,6);
			
		}
		
		else if  (t.accessCenter().equals("field")){
			if(followerType.equals("field")) return false;
			_tileChecked.add(t);
				if(tFullOpen)checkUp = checkFollowerField(x,y+1,7);
				if(lFullOpen) checkLeft = checkFollowerField (x-1,y,5);
				if(bFullOpen) checkDown = checkFollowerField(x,y-1,1);
				if(rFullOpen) checkRight = checkFollowerField (x+1,y,3);
		}
		
		else{
			switch(entry){
			case 0: 
				if((follower == 1||follower == 3) && followerType.equals("field")) return false;
				_tileChecked.add(t);
				if(lOpen) checkLeft = checkFollowerField (x-1,y,2);
				if(tOpen) checkUp = checkFollowerField(x,y+1,6);
				if(!tmBlocked){
					if((follower == 1||follower == 2) && followerType.equals("field")) return false;
					if (rOpen) checkRight = checkFollowerField (x+1,y,0);
					if(!rmBlocked){
						if((follower == 5||follower == 8|| follower == 7) && followerType.equals("field")) return false;
						if(bOpen)checkDown = checkFollowerField(x,y-1,2);
						
						if(!bmBlocked){
							if(((follower == 6|| follower ==3) && followerType.equals("field"))) return false;
							if(checkLeft && lOpen) checkLeft = checkFollowerField (x-1,y,8);
						}
					}
					
				}
				if(!lmBlocked){
					if((follower == 3||follower == 6||follower == 7) && followerType.equals("field")) return false;
					if(bOpen)checkDown = checkFollowerField(x,y-1,0);
					if(!bmBlocked){
						if(((follower == 8) && followerType.equals("field"))) return false;
						if(checkRight && rOpen) checkRight = checkFollowerField (x+1,y,6);
						
						if(!rmBlocked){
							if((follower ==2||follower ==5 || follower ==1)&& followerType.equals("field")) return false;
							if(checkUp && tOpen) checkUp = checkFollowerField(x,y+1,8);
						}
					}			
				}
			break;
			case 1:
				if((follower == 0||follower == 2) && followerType.equals("field")) return false;
				_tileChecked.add(t);
				if(lOpen) checkLeft= checkFollowerField (x-1,y,2);
				if(rOpen) checkRight = checkFollowerField (x+1,y,0);
				checkUp = checkFollowerField(x,y+1,7);
				if(!rmBlocked){
					if((follower == 5||follower == 8||follower ==7) && followerType.equals("field")) return false;
					if(bOpen)checkDown = checkFollowerField(x,y-1,2);
					if(!bmBlocked){
						if(((follower == 6) && followerType.equals("field"))) return false;
						if(checkLeft && lOpen) checkLeft = checkFollowerField (x-1,y,8);
					}
				}
				if(!lmBlocked){
					if((follower == 3||follower == 6||follower ==7) && followerType.equals("field")) return false;
					if(bOpen)checkDown = checkFollowerField(x,y-1,0);
					if(!bmBlocked){
						if(((follower == 8) && followerType.equals("field"))) return false;
						if(checkRight && rOpen) checkRight = checkFollowerField (x+1,y,6);
					}
				}
			break;
			case 2:
				if((follower == 1||follower == 5) && followerType.equals("field")) return false;
				_tileChecked.add(t);
				if(rOpen)checkRight = checkFollowerField (x+1,y,0);
				if(tOpen) checkUp = checkFollowerField(x,y+1,8);
				if(!rmBlocked){
					if((follower == 5||follower == 8||follower ==7) && followerType.equals("field")) return false;
					if(bOpen)checkDown = checkFollowerField(x,y-1,2);
					if(!bmBlocked){
						if(((follower == 6) && followerType.equals("field"))) return false;
						if(checkLeft && lOpen) checkLeft = checkFollowerField (x-1,y,8);
					}
				}
				if(!tmBlocked){
					if(((follower == 1)||follower == 0) && followerType.equals("field")) return false;
					if(checkLeft && lOpen) checkLeft = checkFollowerField (x-1,y,2);
					if(!lmBlocked){
						if((follower == 3||follower == 6||follower ==7) && followerType.equals("field")) return false;
						if(bOpen)checkDown = checkFollowerField(x,y-1,0);
						if(!bmBlocked){
							if(((follower == 8) && followerType.equals("field"))) return false;
							if(checkRight && rOpen) checkRight = checkFollowerField (x+1,y,6);
						}
					}
					}
			break;
			case 5:
			
				if(((follower == 2)||follower == 8) && followerType.equals("field")) return false;
				_tileChecked.add(t);
				checkRight = checkFollowerField (x+1,y,3);
				if(bOpen) checkDown = checkFollowerField(x,y-1,2);
				if(tOpen) checkUp = checkFollowerField(x,y+1,8);
				if(!tmBlocked){
					if((follower == 0||follower == 1||follower ==3) && followerType.equals("field")) return false;
					if(lOpen)checkLeft = checkFollowerField(x-1,y,2);
					if(!lmBlocked){
						if(((follower == 6||follower ==7) && followerType.equals("field"))) return false;
						if(checkDown && bOpen) checkDown = checkFollowerField (x,y-1,0);
					}
				}
				if(!bmBlocked){
					if((follower == 7||follower == 6||follower ==3) && followerType.equals("field")) return false;
					if(lOpen &&checkLeft) checkLeft = checkFollowerField(x-1,y,8);
					if(!lmBlocked){
						if(((follower == 0) && followerType.equals("field"))) return false;
						if(checkUp && tOpen) checkUp = checkFollowerField (x,y+1,6);
					}
				}
			break;
			case 8:
				if((follower == 7||follower == 5) && followerType.equals("field")) return false;
				_tileChecked.add(t);
				if(rOpen)checkRight = checkFollowerField (x+1,y,6);
				if(bOpen)checkDown = checkFollowerField(x,y-1,2);
				if(!rmBlocked){
					if((follower == 2||follower == 5|| follower == 7 || follower == 1) && followerType.equals("field")) return false;
					if(tOpen) checkUp = checkFollowerField(x,y+1,8);
					if(!tmBlocked){
						if(((follower == 0||follower ==3) && followerType.equals("field"))) return false;
						if(lOpen) checkLeft = checkFollowerField (x-1,y,2);
						if(!lmBlocked){
							if(((follower == 6) && followerType.equals("field"))) return false;
							if(checkDown && bOpen) checkDown = checkFollowerField(x,y-1,0);
							
						}
					}
				}
				if(!bmBlocked){
					if(((follower == 6)||follower == 7|| follower == 3||follower == 5) && followerType.equals("field")) return false;
					if(lOpen && checkLeft)checkLeft = checkFollowerField (x-1,y,8);
					if(!lmBlocked){
						if((follower == 3||follower == 0||follower ==1) && followerType.equals("field")) return false;
						if(tOpen)checkUp = checkFollowerField(x,y+1,6);
						if(!tmBlocked){
							if(((follower == 2) && followerType.equals("field"))) return false;
							if(checkRight && rOpen) checkRight = checkFollowerField (x+1,y,0);
						}
					}
					}
			break;
			case 7:
			if((follower == 6||follower == 8) && followerType.equals("field")) return false;
			_tileChecked.add(t);
			if(lOpen) checkLeft= checkFollowerField (x-1,y,8);
			if(rOpen) checkRight = checkFollowerField (x+1,y,6);
			checkDown = checkFollowerField(x,y-1,1);
			if(!rmBlocked){
				if((follower == 5||follower == 8||follower ==2||follower == 1) && followerType.equals("field")) return false;
				if(tOpen)checkUp = checkFollowerField(x,y+1,8);
				if(!tmBlocked){
					if(((follower == 0||follower == 3) && followerType.equals("field"))) return false;
					if(checkLeft && lOpen) checkLeft = checkFollowerField (x-1,y,2);
				}
			}
			if(!lmBlocked){
				if((follower == 3||follower == 6||follower ==0||follower == 1) && followerType.equals("field")) return false;
				if(tOpen)checkUp = checkFollowerField(x,y+1,6);
				if(!tmBlocked){
					if(((follower == 2||follower == 5) && followerType.equals("field"))) return false;
					if(checkRight && rOpen) checkRight = checkFollowerField (x+1,y,0);
				}
			}
			break;
			case 6:
				if((follower == 7||follower == 3) && followerType.equals("field")) return false;
				_tileChecked.add(t);
				if(lOpen) checkLeft = checkFollowerField (x-1,y,8);
				if(bOpen)checkDown = checkFollowerField(x,y-1,0);
				if(!lmBlocked){
					if((follower == 3||follower == 0||follower ==1) && followerType.equals("field")) return false;
					if(tOpen) checkUp = checkFollowerField(x,y+1,6);
					if(!tmBlocked){
						if(((follower == 2||follower == 5) && followerType.equals("field"))) return false;
						if(rOpen) checkRight = checkFollowerField (x+1,y,0);
						if(!rmBlocked){
							if(((follower == 8||follower == 7) && followerType.equals("field"))) return false;
							if(checkDown && bOpen) checkDown = checkFollowerField(x,y-1,2);
						}
					}
				}
				if(!bmBlocked){
					if(((follower == 8)||follower == 7|| follower == 3) && followerType.equals("field")) return false;
					if(rOpen) checkRight = checkFollowerField (x+1,y,6);
					if(!rmBlocked){
						if((follower == 5||follower == 2||follower ==1) && followerType.equals("field")) return false;
						if(tOpen && checkUp)checkUp = checkFollowerField(x,y+1,8);
						if(!tmBlocked){
							if(((follower == 0) && followerType.equals("field"))) return false;
							if(checkLeft && lOpen) checkLeft = checkFollowerField (x-1,y,2);
						}
					}
					}
			break;
			case 3:
			if(((follower == 0)||follower == 6) && followerType.equals("field")) return false;
			_tileChecked.add(t);
			checkLeft = checkFollowerField (x-1,y,5);
			if(bOpen) checkDown = checkFollowerField(x,y-1,0);
			if(tOpen) checkUp = checkFollowerField(x,y+1,6);
			if(!tmBlocked){
				if((follower == 1||follower == 2||follower ==5) && followerType.equals("field")) return false;
				if(rOpen)checkRight = checkFollowerField(x+1,y,0);
				if(!rmBlocked){
					if(((follower == 8||follower ==7) && followerType.equals("field"))) return false;
					if(checkDown && bOpen) checkDown = checkFollowerField (x,y-1,2);
				}
			}
			if(!bmBlocked){
				if((follower == 7||follower == 8||follower ==5) && followerType.equals("field")) return false;
				if(rOpen &&checkRight) checkRight = checkFollowerField(x+1,y,6);
				if(!rmBlocked){
					if(((follower == 2) && followerType.equals("field"))) return false;
					if(checkUp && tOpen) checkUp = checkFollowerField (x,y+1,8);
				}
			}
			break;
				
				
			}

		}
			
		System.out.println("tile" + x +","+y + "has the following boolean values: up " +checkUp+"  Down "+ checkDown+ " Left " +checkLeft+"  Right " + checkRight+". ");
		
		 boolean checkAll = checkUp&&checkDown&&checkLeft&&checkRight;	
		System.out.println("check all is :"+checkAll) ;
		
		if(checkAll){
			System.out.println("tile" + x +","+y + "has returned as true");
			return true;
		}
		else{
			System.out.println("tile" + x +","+y + "has returned as false");
			return false;
		}
	}
	/**
	 * 
	 * @param x  the x value of location of the tile being checked.
	 * @param y	 the y value of the location of the tile being checked.
	 * @param entry  	the value from 0 to 8 of where on the tile the follower is being placed.  
	 * 		When the method is called recursively, this value will indicate on which side the check needs to occur. 	 
	 * @return		returns if it can be legally placed.
	 */
	private boolean checkFollowerRoad(int x, int y, int entry) {
		
		boolean check = true;
		System.out.println("tile at "+x+", "+y);
		if(_board[x][y] == null) return true;
		
		Tile t = _board[x][y];
		
		if(_tileChecked.contains(t)) return true;
		int follower = t.getFollowerSpot();
		//if a follower was found at the entrance point, should return false.
		if(entry == follower) return false;
		//Since no follower was found, returns true if the road ends in the middle. 
		if((t.accessCenter().equals("road end")||t.accessCenter().equals("river cloister")||t.accessCenter().equals("cloister"))&&!_tileChecked.isEmpty()) return true;
		
		else if((t.accessCenter().equals("road end")||t.accessCenter().equals("river cloister")||t.accessCenter().equals("cloister"))&&_tileChecked.isEmpty()){
			switch(entry){
			case 1: return checkFollowerRoad(x, y+1,7);
			case 5: return checkFollowerRoad(x+1, y,3);
			case 7: return checkFollowerRoad(x, y-1,1);
			case 3: return checkFollowerRoad(x-1, y,5);
			}
			
		}
		
		if(Arrays.asList(t.accessSides(1)).contains("road")&& follower==1) return false;
		if(Arrays.asList(t.accessSides(2)).contains("road")&& follower==5) return false;
		if(Arrays.asList(t.accessSides(3)).contains("road")&& follower==7) return false;
		if(Arrays.asList(t.accessSides(4)).contains("road")&& follower==3) return false;
		if(Arrays.asList(t.accessCenter()).contains("road")&& follower ==4) return false;
		_tileChecked.add(t);
		if(Arrays.asList(t.accessSides(1)).contains("road") && check) check= checkFollowerRoad(x, y+1,7);
		if(Arrays.asList(t.accessSides(2)).contains("road")&& check) check= checkFollowerRoad(x+1, y,3);
		if(Arrays.asList(t.accessSides(3)).contains("road")&& check) check= checkFollowerRoad(x, y-1,1);
		if(Arrays.asList(t.accessSides(4)).contains("road") && check) check= checkFollowerRoad(x-1, y,5);

		return check;
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
	public void saveCurrentState() {
		JFileChooser fileSave = new JFileChooser();
		fileSave.showSaveDialog(fileSave);
		saveFile(fileSave.getSelectedFile());
	}
	private  void saveFile(File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(PlayerTurns.firstline);
			writer.write("\n");
			writer.write(getBoard());
			writer.write("\n");
			writer.write(getTileUnplayed());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getBoard(){
		String result = "";
		int xloc = 0;
		int yloc = 0;
		for(int i = 71 + _yup; i >= 71 + _ydown; i-- ){
			xloc = 0;
			for(int j = 71+ _xleft; j <= 71 + _xright; j++){
				Tile currentTile = _board[j][i];
				if(currentTile != null){
					result = result + currentTile.getTileName() + currentTile.get_rotateTimes() + "(" + xloc 
							+ "," + yloc +")" ;
					if(currentTile.getFollowerSpot() != 9){		
					result = result	+ "[" + currentTile.getPlayerString() + "," + currentTile.getFollowerSpot()
							+ "]";
					}
				}
				xloc++;
				System.out.println(j +"," + i);
			}
			yloc++;
		}
		System.out.println(result);
		return result;
	}
	public String getTileUnplayed(){
		String result = "";
		for(int i = 0; i< tileListOriginal.size() - 1; i++){
			Tile t = tileListOriginal.get(i);
			result = result + t.getTileName() + ",";
		}
		if(riverListOriginal.isEmpty()){
			result = result + tileListOriginal.get(tileListOriginal.size() -1 ).getTileName();
		}else{
			result = result + tileListOriginal.get(tileListOriginal.size() -1 ).getTileName() + ",";
		
			for(int i = 0; i< riverListOriginal.size() - 1; i++){
				Tile t = riverListOriginal.get(i);
				result = result + t.getTileName() + ",";
			}
			result = result + riverListOriginal.get(riverListOriginal.size() -1 ).getTileName();
		}
		return result;
	}
}
