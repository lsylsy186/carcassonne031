package code;

import java.awt.BorderLayout;
import java.awt.Component;
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

import javax.naming.TimeLimitExceededException;
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
	private HashSet<Point> _emptySlot = new HashSet<Point>(100);
	private HashSet<Point> _legalSlot = new HashSet<Point>(100);//a hashset of all available empty slots.  putTile will check and add
	//in as more occur.
	private int _turnNumber =0;
	private int _playersTurn=1;
	// emptySlot will be very useful once we build the view.
	private Tile _tile; 
	private HashMap<Point, Object> currentTile;
	private ArrayList<String> _meepleChecked = new ArrayList<String>();
	
	
	public Game(){
		setupDeck();
		newGame();
		
	}
	
	public void nextTile(){
		if(_tileList.size() != 0 || _tileList != null){
		currentTile = _tileList.remove(0);
	//	System.out.println("the tile is " +  currentTile.get(new Point(3,3)));
		refreshSlot();
		}
	}
	public void nextTurn(){
		_turnNumber++;
	}
	
	//int x should be the player number from one to _playerNumber
	//removes one meeple from the players supply
	public void meepleSupplyDecrease(int x){
		switch(x){
		case 1: _player1Supply --;
		break;
		case 2: _player2Supply --;
		break;
		case 3: _player3Supply --;
		break;
		case 4: _player4Supply --;
		break;
		case 5: _player5Supply --;
		break;
		}
		
	}
	public int get_playersTurn(){
		//players go from 1 to _playerNumber
		//on turn 0, the result will be 0 +1
		int playersTurn =  (_turnNumber%_playerNumber) +1;
		return playersTurn;
	}

	public void refreshSlot() {
		_legalSlot = new HashSet<Point>(100);
		int rotateNum =(char)(currentTile.get(new Point(3,4))) - '0';
		HashMap<Point, Object> rotatedTile = new HashMap(currentTile);
//		System.out.println(rotateNum);
		for(int i = 0; i < rotateNum; i++){
			rotatedTile=rotate(rotatedTile);
		}
//		System.out.println(_tile.toString(rotatedTile));
		
		for(Point p : _emptySlot){
//			int rotateNum =(char)(currentTile.get(new Point(3,4))) - '0';
//			System.out.println(rotateNum);
			if(checkPlacement(p.x,p.y,rotatedTile)){
				_legalSlot.add(p);
			}
		}
		
		
	}

	public void setUp(String[] list){
		if(list.length ==0){
			_playerList = new String[4];
			_playerList[0] = "Player 1";
			_playerList[1] = "Player 2";
			_playerList[2] = "Player 3";
			_playerList[3] = "Player 4";
			_playerNumber= 4;
		}
		else{
		_playerList = new String[list.length];
		for(int i = 0; i < list.length; i++){
			_playerList[i] = list[i];
			if(!(list[i] == null)) _playerNumber++;
		}
		}
		System.out.println(_playerNumber);
		
	}	
	
	public String getPlayer(int num){	
		return get_playerList()[num-1];
	}
	
		

	
	public void newGame(){
		_tile = new Tile();
		HashMap<Point,Object> startingTile = _tile.getStartTile();
		_emptySlot.add(new Point(50,50));
		_gameBoard = new HashMap<>();
		putTile(50,50, startingTile );
		nextTile();
		
		refreshSlot();
	
		
	}
	
	//each time topTile is called it returns the tile at the index and then increments the index.
	// this method will be used for the draw phase of the turn. 
	public HashMap<Point, Object> topTile(){
		return currentTile;
	}
	

	//Initializes _tileList as a list of all the tiles except the starting tile (essentially the deck or stack the player draws from)
	//and then randomizes them using Collections.shuffle
	private void setupDeck(){
		Tile t = new Tile();
		_tileList = t.get_tiles();
		Collections.shuffle(_tileList);
	}

	public boolean putTile(int x, int y, HashMap<Point, Object> tile){  
		char tileName =  (char) tile.get(new Point (3,3));
		System.out.println("putting "+ tileName + " at" + x + "," + y);
		int rotateNum =(char)(tile.get(new Point(3,4))) - '0';
		HashMap<Point, Object> rotatedTile = new HashMap(tile);
//		System.out.println(rotateNum);
		for(int i = 0; i < rotateNum; i++){
			rotatedTile=rotate(rotatedTile);
		}
		
//		System.out.println(_tile.toString(rotatedTile));
		//when calling putTile, must use int x and y for Point, and specify which tile you want to place.
		if(_emptySlot.contains(new Point(x,y)) && checkPlacement(x,y, rotatedTile) ){
			_gameBoard.put(new Point(x,y), rotatedTile);
			_emptySlot.remove(new Point(x,y));
			 //goes through all spaces next to the placed tile and checks which ones are empty.
				tryAddEmptySlot(x+1,y);
				tryAddEmptySlot(x,y+1);
				tryAddEmptySlot(x,y-1);
				tryAddEmptySlot(x-1,y);
				return true;
	    }
		else{ //else catch all. 
		
	    System.out.println("error, cannot place tile at:"+ x+ "and "+ y); //TODO feel free to change this to an exception handler 
		
		}
	
		return false;
	}
	
	
	//this method should only be used for forcibly putting a meeple on a tile, used in testing. 
	//do NOT call this method from View
	public  HashMap<Point, Object> forcePutMeep(int x, int y, HashMap<Point, Object> tile){
		Object part = tile.get(new Point(x,y));
		switch((char)part){
		case 'F':
			tile.put(new Point(x,y), 'f');
			return tile;
		case 'C':
			tile.put(new Point(x,y), 'c');
			return tile;
		case 'W':
			tile.put(new Point(x,y), 'w');
			return tile;
		case 'R':
			tile.put(new Point(x,y), 'r');
			return tile;
		case 'M':
			tile.put(new Point(x,y), 'm');
			return tile;
		}
		return tile;
	}
		
	private void tryAddEmptySlot(int x, int y){
		if(!_gameBoard.containsKey(new Point(x,y)))_emptySlot.add(new Point(x,y)); //if an empty slot is found, adds it to emptySlot
	}

	private boolean checkPlacement(int x, int y, HashMap<Point, Object> pTile) { //checks placement availability of adjacent tiles
		//pTile is placement tile. the tile you are trying to place.
		//first should check to see which _gameBoard Points are next to it.
		
		//checkUp and check down checks the tiles directly above and below pTile
		if(checkLeft(x,y, pTile)&& checkRight(x,y, pTile) && checkUp(x,y, pTile) && checkDown(x,y, pTile)){
			//put the rotate flag to the current tile
//			_tile.setRotateFlag(topTile(), (char)(BoarderView._rotateNum+'0'));
//			BoarderView._rotateNum = 0;
			return true;
		}
		return false;
	}

	private boolean checkDown(int x, int y, HashMap<Point, Object> pTile) { 
		Object pLeft = pTile.get(new Point(0,2));
		Object pMiddle = pTile.get(new Point (1,2));
		Object pRight = pTile.get(new Point(2,2));
		if(_gameBoard.containsKey(new Point(x, y+1))){
//			System.out.println("check down is called");
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
//			System.out.println("check up is called");
		 HashMap<Point,Object> uTile =_gameBoard.get(new Point(x, y-1));
		 Object left = uTile.get(new Point(0,2));
		 Object middle = uTile.get(new Point(1,2));
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
//			System.out.println("check right is called");
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
//			System.out.println("check left is called");
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
		char cA=  Character.toUpperCase((char) a);
		char cB=  Character.toUpperCase((char) b);
//		System.out.println("placed tile is"+ cB+  "  checked against"+ cA);
		switch(cA){
		
		case 'F': if(cB ==('F')|| cB ==('W')) return true;  //Field can be placed to Field and Wall
			else return false;
		case 'C': if(cB ==('C')|| cB ==('W')) return true;  //City can be placed next to City and Wall
			else return false;
		case 'W': if (cB ==('F')||cB ==('C')|| cB ==('W')) return true;  //Wall can be placed next to Field and City
			else return false;
		case 'R': if (cB ==('R')) return true;		//Road can only be placed next to road.
			else return false;
		default: System.out.println("default in swich statement in checkIndividual should never be triggered"); //this catchall default should never be triggered
		//this is because the objects fed in should always equal F,C,W, or R.
			return false;
		
		}
		
		
	}
	public static HashMap<Point,Object> rotate(HashMap<Point, Object> tile){
		Object temp0,temp1,temp2,temp3,temp5,temp6,temp7,temp8,temp9;
		HashMap<Point, Object> result = new HashMap<Point, Object>();
		result = tile;
		//temp0 - temp8 means the value of nine positions
		temp0 = tile.get(new Point(0,0));
		temp1 = tile.get(new Point(1,0));
		temp2 = tile.get(new Point(2,0));
		temp3 = tile.get(new Point(0,1));
		temp5 = tile.get(new Point(2,1));
		temp6 = tile.get(new Point(0,2));
		temp7 = tile.get(new Point(1,2));
		temp8 = tile.get(new Point(2,2));
		temp9 = tile.get(new Point(1,1));
		//rotate, position4 never changed
		result.put(new Point(2,2), temp6);
		 result.put(new Point(1,2), temp3);
		 result.put(new Point(0,2), temp0);
		 result.put(new Point(2,1), temp7);		
		 result.put(new Point(0,1), temp1);
		 result.put(new Point(2,0), temp8);
		 result.put(new Point(1,0), temp5);
		 result.put(new Point(0,0), temp2);
		 result.put(new Point(1,1), temp9);
		 return result;
	}
	
	
	//THIS is the method that should be called from view.  returns true if it put a meeple at the location and returns false if it cannot.
	//checkPutMeeple will check to see if a Meeple can be placed on the tile at the X, Y location on the Gameboard
	//the px and py are used to tell which of the nine points on that tile the meeple should be placed on
	// for example calling checkPutMeeple(49,50, 0,0) would be checking to see if you can legally place a meeple on the upper left point on a tile to the left of the start tile.
	public boolean putMeeple(int x, int y, int px, int py){
		//first gets the tile that is being placed.
		HashMap<Point, Object> pTile = _gameBoard.get(new Point (x,y));
		//finds where the meeple is trying to be placed (Field, City, Road, Wall, or Monetary )
		char meeplePoint = (char) pTile.get(new Point (px,py));
		System.out.println("the meeplePoint for putMeeple is "+ meeplePoint);
		
		switch(meeplePoint){
		case 'F':
			if(checkMeepleField(x,y,px,py)){
				pTile.put(new Point(px,py), 'f');
				_meepleChecked.clear();
				meepleSupplyDecrease(_playersTurn);
				return true;
			}
			else{
				_meepleChecked.clear();
				return false;
			}
						
		case 'C':
			
			if(checkMeepleCity(x,y,px,py)){
				pTile.put(new Point(px,py), 'c');
				_meepleChecked.clear();
				meepleSupplyDecrease(_playersTurn);
				return true;
			}
			else {
				_meepleChecked.clear();
				return false;
			}
		case 'W':
			if(checkMeepleField(x,y,px,py)){
				pTile.put(new Point(px,py), 'w');
				_meepleChecked.clear();
				meepleSupplyDecrease(_playersTurn);
				return true;
			}
			else{
				_meepleChecked.clear();
				return false;
			}
						
		case 'R':
			if(checkMeepleRoad(x,y, px, py)){
				pTile.put(new Point(px,py), 'r');
				_meepleChecked.clear();
				meepleSupplyDecrease(_playersTurn);
				return true;
			}
			else{
				_meepleChecked.clear();
				return false;
			}
			
		case 'M':
			pTile.put(new Point(px,py), 'm');
			meepleSupplyDecrease(_playersTurn);
			return true;
		default: 
			return false;
		}
		

	}
		
		
	
		private boolean checkMeepleField(int x, int y, int px, int py) {
			String point = "";
			point = point+"";
			point = point+x;
			point = point+y;
			//if the tile called is empty then return true
			// (a empty tile cannot contain a meeple so must return true)
			boolean containsTile = _gameBoard.containsKey(new Point(x,y));
			if (!containsTile) {
				System.out.println("checkMeepleField returned true because an empty tile was found");
				return true;
			}
			
			//if this tile has already been checked, return true.
				if(_meepleChecked.contains(point)){ 
				System.out.println("checkMeepleCity returns true because tile was already checked once");
				return true;
			}
			
			HashMap<Point, Object> tile = _gameBoard.get(new Point (x,y));
			char tileName = (char) tile.get(new Point(3,3));
			System.out.println("currently checking on tile " + tileName);
			boolean checkLeft = true;
			boolean checkRight = true;
			boolean checkUp = true;
			boolean checkDown = true;
			
			char top = (char) tile.get(new Point (1,0));
			char middle = (char) tile.get(new Point (1,1));
			char left = (char) tile.get(new Point (0,1));
			char right = (char) tile.get(new Point (2,1));
			char bottom = (char) tile.get(new Point (1,2));
			char topLeft = (char) tile.get(new Point (0,0));
			char topRight = (char) tile.get(new Point (2,0));
			char bottomRight = (char) tile.get(new Point (2,2));
			char bottomLeft = (char) tile.get(new Point (0,2));
			char entry = (char) tile.get(new Point(px, py));
			char entryLeftCorner = (char) tile.get(new Point(0,py));
			char entryRightCorner = (char) tile.get(new Point (2,py));
			char entryMiddleX = (char) tile.get(new Point (1,py));
			char entryMiddleY = (char) tile.get(new Point (px,1));
			char entryTopCorner = (char) tile.get(new Point (px, 0));
			char entryBottomCorner = (char) tile.get(new Point (px, 2));
			//this means that a meeple was immediately found at the point of entry and should return false.
			if(entry == 'f'||entry =='w')return false;
			//in these special cases, the tiles only have one point that needs to be checked, which is the point of entry. 
			if(tileName=='T'||tileName=='X'||tileName=='S')return true;
		//A,B,E,N,M,Q,I and R all only have one continuous field.
			if(tileName=='A'||tileName=='B'||tileName=='E'||tileName=='N'||tileName=='M'||tileName=='Q'||tileName=='I'||tileName=='R'){
				if(top=='f' || bottom=='f' || left=='f' || right=='f' || middle=='f'|| topLeft=='f' ||topRight =='f'||bottomLeft =='f' || bottomRight=='f')return false;
				//only needs middle and 4 corners because walls are only ever at those five points
				if(middle=='w'||topLeft=='w' ||topRight =='w'||bottomLeft =='w' || bottomRight=='w')return false;
			}
			if(tileName=='P'||tileName=='O'||tileName=='D'||tileName=='L'){
				if(middle=='w'||topLeft=='w' ||topRight =='w'||bottomLeft =='w' || bottomRight=='w')return false;
			}
			
			if(tileName=='P'||tileName=='O'||tileName=='L'){
				if(entry=='f')return false;
			}
			//special handling for G and F
			if(tileName=='G'||tileName=='F'){
				//if the points on the side of entry are WFW and this is not the first tile that is checked, then it should return true (it is an end point)
				if(entryMiddleX=='F'&&entryLeftCorner=='W'&&entryRightCorner=='W'&&!_meepleChecked.isEmpty()) return true;
				if(entryMiddleX=='f'||entryLeftCorner=='w'||entryRightCorner=='w') return false;	
			}
			//NOW add in this tile to checked point to prevent infinite looping.
			_meepleChecked.add(point);
			
			//cases for when the starting point is in one of the middle side points (1,0 or 0,1, or 2,1 or 1,2)
			if(px==1&& (py==0||py==2)){
				if(entryLeftCorner == 'F'){
					checkLeft = checkMeepleField(x-1, y, 2,py);
				}
				if(entryRightCorner == 'F'){
					checkRight = checkMeepleField(x+1, y, 0,py);
				}
				
			}
			if(py==1&& (px==0||px==2)){
				if(entryTopCorner == 'F'){
					checkUp = checkMeepleField(x,y-1,px,2);
				}
				if(entryBottomCorner == 'F'){
					checkDown = checkMeepleField(x,y+1, px,0);
				}
			}
			
			//finally checks for straight paths of field to see which tile should be checked next
			boolean pointsRight = ((entryMiddleX=='F'&&entryRightCorner=='F')||entryMiddleX=='C'||entryMiddleX=='c');
			boolean pointsLeft = ((entryMiddleX=='F'&&entryLeftCorner=='F')||entryMiddleX=='C'||entryMiddleX=='c');
			boolean pointsDown = ((entryMiddleY=='F'&&entryBottomCorner=='F')||entryMiddleX=='C'||entryMiddleX=='c');
			boolean pointsUp = ((entryMiddleY=='F'&&entryTopCorner=='F')||entryMiddleX=='C'||entryMiddleX=='c');
			System.out.println("right "+ pointsRight+ " left "+ pointsLeft+" Down "+pointsDown+" Up "+ pointsUp);
			
			if(px==0){
				if(pointsRight) checkRight = checkMeepleField(x+1, y, 0,py);
				checkLeft = checkMeepleField(x-1, y, 2,py);
			}
			if(py==0){
				if(pointsDown) checkDown = checkMeepleField(x,y+1, px,0);
				checkUp = checkMeepleField(x,y-1,px,2);
			}
			if(px==2){
				if(pointsLeft) checkLeft = checkMeepleField(x-1, y, 2,py);
				checkRight = checkMeepleField(x+1, y, 0,py);
			}
			if(py==2){
				if(pointsUp) checkUp = checkMeepleField(x,y-1,px,2);
				checkDown = checkMeepleField(x,y+1, px,0);
			}
			
			return checkUp&&checkDown&&checkLeft&&checkRight;
	}
		

		private boolean checkMeepleCity(int x, int y, int px, int py) {
			String point = "";
			point = point+"";
			point = point+x;
			point = point+y;
			//if the tile called is empty then return true
			// (a empty tile cannot contain a meeple so must return true)
			boolean containsTile = _gameBoard.containsKey(new Point(x,y));
			if (!containsTile) {
				System.out.println("checkMeepleCity returned true because an empty tile was found");
				return true;
			}
			
			//if this tile has already been checked, return true.
				if(_meepleChecked.contains(point)){ 
				System.out.println("checkMeepleCity returns true because tile was already checked once");
				return true;
			}
			
			HashMap<Point, Object> tile = _gameBoard.get(new Point (x,y));
			char tileName = (char) tile.get(new Point(3,3));
			System.out.println("currently checking on tile " + tileName);
			boolean checkLeft = true;
			boolean checkRight = true;
			boolean checkUp = true;
			boolean checkDown = true;
			
			char top = (char) tile.get(new Point (1,0));
			char middle = (char) tile.get(new Point (1,1));
			char left = (char) tile.get(new Point (0,1));
			char right = (char) tile.get(new Point (2,1));
			char bottom = (char) tile.get(new Point (1,2));
			char topLeft = (char) tile.get(new Point (0,0));
			char topRight = (char) tile.get(new Point (2,0));
			char bottomRight = (char) tile.get(new Point (2,2));
			char bottomLeft = (char) tile.get(new Point (0,2));
			char entry = (char) tile.get(new Point(px, py));
			
			//this means that a meeple was immediately found at the point of entry and should return false.
			if(entry == 'c'){
				System.out.println("the px, py equals 'c' is being thrown");
				return false;
			}
			
			//special case handling.
			if(tileName == 'H' || tileName == 'I') return true;

			//NOW add in this tile to checked point to prevent infinte looping.
			_meepleChecked.add(point);
			

			//now checks all the other points for a meeple on the in the city area
			if(top=='c' || bottom=='c' || left=='c' || right=='c' || middle=='c'|| topLeft=='c' ||topRight =='c'||bottomLeft =='c' || bottomRight=='c'){
				System.out.println("checkMeepleCity is returning false because a meeple ('c') was found");
				return false;
			}
			

			if(top == 'C'){
				System.out.println("checkUp is called");
				checkUp = checkMeepleCity(x,y-1,1,2);
			}
			if(bottom == 'C'){
				System.out.println("checkDown is called");
				checkDown = checkMeepleCity(x,y+1, 1,0);
			}
			if(left == 'C'){
				System.out.println("checkLeft is called");
				checkLeft = checkMeepleCity(x-1, y, 2,1);
			}
			if(right == 'C'){
				System.out.println("checkRight is called");
				checkRight = checkMeepleCity(x+1, y, 0,1);
			}
			
			

		return checkUp&&checkDown&&checkLeft&&checkRight;
	}

		private boolean checkMeepleRoad(int x, int y, int px, int py) {
			String point = "";
			point = point+"";
			point = point+x;
			point = point+y;
			//if the tile called is empty then return true
			// (a empty tile cannot contain a meeple so must return true)
			boolean containsTile = _gameBoard.containsKey(new Point(x,y));
			if (!containsTile) {
				System.out.println("checkMeepleRoad returned true because an empty tile was found");
				return true;
			}
			
			//if this tile has already been checked, return true.

				if(_meepleChecked.contains(point)){ 
				System.out.println("checkMeepleRoad returns true because tile was already checked once");
				return true;
			}
			//if the tile exists and it has not been checked yet, should immediately set to checked to prevent infinite looping with the recursive method
			_meepleChecked.add(point);
		
			System.out.println("size of meepleChecked is "+_meepleChecked.size());
			
			//getting and declaring all the variables for easier reading and writing.
			HashMap<Point, Object> tile = _gameBoard.get(new Point (x,y));
			System.out.println("currently checking on tile" + tile.get(new Point(3,3)));
			boolean checkLeft = true;
			boolean checkRight = true;
			boolean checkUp = true;
			boolean checkDown = true;
			
			
			char top = (char) tile.get(new Point (1,0));
			char middle = (char) tile.get(new Point (1,1));
			char left = (char) tile.get(new Point (0,1));
			char right = (char) tile.get(new Point (2,1));
			char bottom = (char) tile.get(new Point (1,2));
			

			char entry = (char) tile.get(new Point(px, py));
			
			String allRoadPoints = ""+ top+middle+left+right+bottom+entry;
			
			System.out.println(allRoadPoints);
			//this means that a meeple was immediately found at the point of entry and should return false.
			if(entry == 'r'){
				System.out.println("the px, py equals 'r' is being thrown");
				return false;
			}
			
			
			//if the middle tile is crossroad then it doesn't matter what's on the other points
			if(tile.get(new Point(1,1)).equals('T')) return true;
				
			
			
			
			
			//now checks all the other points for a meeple on the road
			if(top=='r' || bottom=='r' || left=='r' || right=='r' || middle=='r'){
				System.out.println("checkMeepleRoad is returning false because a meeple ('r') was found");
				return false;
			}
			
			
			
			if(top == 'R'){
				System.out.println("checkUp is called");
				checkUp = checkMeepleRoad(x,y-1,1,2);
			}
			if(bottom == 'R'){
				System.out.println("checkDown is called");
				checkDown = checkMeepleRoad(x,y+1, 1,0);
			}
			if(left == 'R'){
				System.out.println("checkLeft is called");
				checkLeft = checkMeepleRoad(x-1, y, 2,1);
			}
			if(right == 'R'){
				System.out.println("checkRight is called");
				checkRight = checkMeepleRoad(x+1, y, 0,1);
			}
			
			
		//returns true by default since all four checks are initialized to true	
		if(checkUp&&checkDown&&checkLeft&&checkRight){
			System.out.println("all 4 checks are true");
			return true;
		}
		return false;
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
		
		public HashSet<Point> get_Slot(){
			return _legalSlot;
			
		}
		
		public HashMap<Point,HashMap<Point,Object>> get_gameBoard(){
			
			return _gameBoard;
		}
		
		

}
