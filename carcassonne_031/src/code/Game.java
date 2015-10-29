package code;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class Game {
	private int _playerNumber;
	private int _player1Supply = 7;
	private int _player2Supply = 7;
	private int _player3Supply = 7;
	private int _player4Supply = 7;
	private int _player5Supply = 7;
	private String[] _playerList;
	private PlayerButtonView _view;
	private ArrayList<HashMap<Point, Object>> _tileList;
	private HashMap<Point, HashMap<Point,Object>> _gameBoard;
	private HashSet<Point> _emptySlot = new HashSet<Point>(100);//a hashset of all available empty slots.  putTile will check and add
	//in as more occur.
	
	// emptySlot will be very useful once we build the view.
	private Tile _tile; 
	private HashMap<Point, Object> currentTile;
	private int _tileDeckIndex = 0;
	
	public Game(){
		setupDeck();
		newGame();
		
	}
	
	public void nextTile(){
		if(_tileList.size() != 0 || _tileList != null){
		currentTile = _tileList.remove(0);
		}
	}

	public void setUp(String[] list){
		_playerList = new String[list.length];
		for(int i = 0; i < list.length; i++){
			_playerList[i] = list[i];
			if(!(list[i] == null)) _playerNumber++;
		}
	}	
	
	public String getPlayer(int num){	
		return get_playerList()[num-1];
	}
	
		

	
	public void newGame(){
		_tile = new Tile();
		HashMap<Point,Object> startingTile = _tile.getStartTile();
		
		_gameBoard = new HashMap<>();
		_gameBoard.put(new Point(50,50), startingTile );
		nextTile();
		_emptySlot.add(new Point(49,50));
		_emptySlot.add(new Point(50,49));
		_emptySlot.add(new Point(50,51));
		_emptySlot.add(new Point(51,50));
	
		
	}
	
	//each time topTile is called it returns the tile at the index and then increments the index.
	// this method will be used for the draw phase of the turn. 
	public HashMap<Point, Object> topTile(){
		HashMap<Point, Object> topTile = _tileList.get(_tileDeckIndex);
		return topTile;
	}
	

	//Initializes _tileList as a list of all the tiles except the starting tile (essentially the deck or stack the player draws from)
	//and then randomizes them using Collections.shuffle
	private void setupDeck(){
		Tile t = new Tile();
		_tileList = t.get_tiles();
		Collections.shuffle(_tileList);
	}

	public boolean putTile(int x, int y, HashMap<Point, Object> tile){  
		//when calling putTile, must use int x and y for Point, and specify which tile you want to place.
		if(_emptySlot.contains(new Point(x,y)) && checkPlacement(x,y, tile) ){
			_gameBoard.put(new Point(x,y), tile);
			_emptySlot.remove(new Point(x,y));
			 //goes through all spaces next to the placed tile and checks which ones are empty.
				tryAddEmptySlot(x+1,y);
				tryAddEmptySlot(x,y+1);
				tryAddEmptySlot(x,y-1);
				tryAddEmptySlot(x-1,y);
				return true;
	    }
		else{ //else catch all. 
		
	    System.out.println("error, cannot place tile at:"+ x+ "and "+ y); // feel free to change this to an exception handler 
		
		}
		return false;
	}
	
	
	
	public boolean putMeep(int x, int y, HashMap<Point, Object> tile){
		Object part = tile.get(new Point(x,y));
		switch((char)part){
		case 'F':
			tile.put(new Point(x,y), 'f');
			break;
		case 'C':
			tile.put(new Point(x,y), 'c');
			break;
		case 'W':
			tile.put(new Point(x,y), 'w');
			break;
		case 'R':
			tile.put(new Point(x,y), 'r');
			break;
		case 'M':
			tile.put(new Point(x,y), 'm');
			break;
		default: 
			return false; //default catch all that should never be called.
		}
		

		return true;
	}
		
	private void tryAddEmptySlot(int x, int y){
		if(!_gameBoard.containsKey(new Point(x,y)))_emptySlot.add(new Point(x,y)); //if an empty slot is found, adds it to emptySlot
	}

	private boolean checkPlacement(int x, int y, HashMap<Point, Object> pTile) { //checks placement availability of adjacent tiles
		//pTile is placement tile. the tile you are trying to place.
		//first should check to see which _gameBoard Points are next to it.
		
		//checkUp and check down checks the tiles directly above and below pTile
		if(checkLeft(x,y, pTile)&& checkRight(x,y, pTile) && checkUp(x,y, pTile) && checkDown(x,y, pTile)){
			return true;
		}
		return false;
	}

	private boolean checkDown(int x, int y, HashMap<Point, Object> pTile) { 
		Object pLeft = pTile.get(new Point(0,2));
		Object pMiddle = pTile.get(new Point (1,2));
		Object pRight = pTile.get(new Point(2,2));
		if(_gameBoard.containsKey(new Point(x, y+1))){
			System.out.println("check down is called");
		 HashMap<Point,Object> dTile =_gameBoard.get(new Point(x, y+1));
		 Object left = dTile.get(new Point(0,0));
		 Object middle = dTile.get(new Point(1,0));
		 Object right = dTile.get(new Point(2,0));
		 boolean checkLeft = checkIndividual(left, pLeft);
		 boolean checkMiddle = checkIndividual(middle, pMiddle);
		 boolean checkRight = checkIndividual(right, pRight);
		
		 if(checkLeft&& checkMiddle&& checkRight){
			 return true; //if all three checks pass then check right returns true and the block is placed
		 }
		 else { // unless all of the checks pass, this will be run by default. 
			 return false;
		 }
		}
		else{ 
			return true; //if the tile to the left is empty, should return true.
		}
	
	}

	private boolean checkUp(int x, int y, HashMap<Point, Object> pTile) {
		Object pLeft = pTile.get(new Point(0,0));
		Object pMiddle = pTile.get(new Point (1,0));
		Object pRight = pTile.get(new Point(2,0));
		if(_gameBoard.containsKey(new Point(x,y-1))){
			System.out.println("check up is called");
		 HashMap<Point,Object> uTile =_gameBoard.get(new Point(x, y-1));
		 Object left = uTile.get(new Point(0,2));
		 Object middle = uTile.get(new Point(2,1));
		 Object right = uTile.get(new Point(2,2));
		 boolean checkLeft = checkIndividual(left, pLeft);
		 boolean checkMiddle = checkIndividual(middle, pMiddle);
		 boolean checkRight = checkIndividual(right, pRight);
		
		 if(checkLeft&& checkMiddle&& checkRight){
			 return true; //if all three checks pass then check right returns true and the block is placed
		 }
		 else { // unless all of the checks pass, this will be run by default. 
			 return false;
		 }
		}
		else{ 
			return true; //if the tile to the left is empty, should return true.
		}
	
	}

	private boolean checkRight(int x, int y, HashMap<Point, Object> pTile) {
		Object pTop = pTile.get(new Point(2,0));
		Object pMiddle = pTile.get(new Point (2,1));
		Object pBottom = pTile.get(new Point(2,2));
		if(_gameBoard.containsKey(new Point(x+1, y))){
			System.out.println("check right is called");
		 HashMap<Point,Object> rTile =_gameBoard.get(new Point(x+1, y));
		 Object top = rTile.get(new Point(0,0));
		 Object middle = rTile.get(new Point(0,1));
		 Object bottom = rTile.get(new Point(0,2));
		 boolean checkTop = checkIndividual(top, pTop);
		 boolean checkMiddle = checkIndividual(middle, pMiddle);
		 boolean checkBottom = checkIndividual(bottom, pBottom);
		
		 if(checkTop&& checkMiddle&& checkBottom){
			 return true; //if all three checks pass then check right returns true and the block is placed
		 }
		 else { // unless all of the checks pass, this will be run by default. 
			 return false;
		 }
		}
		else{ 
			return true; //if the tile to the left is empty, should return true.
		}
	}

	private boolean checkLeft(int x, int y, HashMap<Point, Object> pTile) {
		Object pTop = pTile.get(new Point(0,0));
		Object pMiddle = pTile.get(new Point (0,1));
		Object pBottom = pTile.get(new Point(0,2));
		if(_gameBoard.containsKey(new Point(x-1, y))){
			System.out.println("check left is called");
		 HashMap<Point,Object> lTile =_gameBoard.get(new Point(x-1, y));
		 Object top = lTile.get(new Point(2,0));
		 Object middle = lTile.get(new Point(2,1));
		 Object bottom = lTile.get(new Point(2,2));
		 
		 boolean checkTop = checkIndividual(top, pTop);
		 boolean checkMiddle = checkIndividual(middle, pMiddle);
		 boolean checkBottom = checkIndividual(bottom, pBottom);
		
		 if(checkTop&& checkMiddle&& checkBottom){
			 
			 return true; //if all three checks pass then check left returns true and the block is placed
		 }
			 
		 
		 else { // unless all of the checks pass, this will be run by default. 
			 return false;
		 }
		  
		}

		else{ 
			return true; //if the tile to the left is empty, should return true.
		
		}
		
	}

	private boolean checkIndividual(Object a, Object b) {  //checks individual positions in a single tile against each other
		char cA= (char) a;
		char cB= (char) b;
		System.out.println("placed tile is"+ cB+  "  checked against"+ cA);
		switch(cA){
		
		case 'F': if(b.equals('F')|| b.equals('W')) return true;  //Field can be placed to Field and Wall
			else return false;
		case 'C': if(b.equals('C')|| b.equals('W')) return true;  //City can be placed next to City and Wall
			else return false;
		case 'W': if (b.equals('F')||b.equals('C')|| b.equals('W')) return true;  //Wall can be placed next to Field and City
			else return false;
		case 'R': if (b.equals('R')) return true;		//Road can only be placed next to road.
			else return false;
		default: System.out.println("default in swich statement in checkIndividual should never be triggered"); //this catchall default should never be triggered
		//this is because the objects fed in should always equal F,C,W, or R.
			return false;
		
		}
		
		
	}
	
	
		public void addView(PlayerButtonView v){
		_view = v;
	}
		public String[] get_playerList() {
			return _playerList;
		}
		public void set_playerList(String[] _playerList) {
			this._playerList = _playerList;
		}

		public int get_playerNumber() {
			return _playerNumber;
		}

		public void set_playerNumber(int _playerNumber) {
			this._playerNumber = _playerNumber;
		}
		
		public HashSet<Point> get_emptySlot(){
			return _emptySlot;
			
		}
		
		public HashMap<Point,HashMap<Point,Object>> get_gameBoard(){
			
			return _gameBoard;
		}

}
