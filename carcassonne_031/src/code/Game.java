package code;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;


public class Game {
	private String[] _playerList;
	private View _view;
	private HashMap<Point, HashMap<Point,Object>> _gameBoard;
	HashSet<Point> emptySlot = new HashSet<Point>(100);//a hashset of all available empty slots.  putTile will check and add
	//in as more occur.
	
	// emptySlot will be very useful once we build the view.
	Tile tile; 
	
	public void setUp(String[] list){
		set_playerList(new String[list.length]);
		for(int i = 0; i < list.length; i++){

			
			
			get_playerList()[i] = list[i];	
		}
	}	
	public String getPlayerNumber(int num){
			
		return get_playerList()[num-1];
		
	}
		
		
	
	
	public void newGame(){
		tile = new Tile();
		HashMap<Point,Object> tD = tile.getTile('D');
		
		_gameBoard = new HashMap<>(100);
		_gameBoard.put(new Point(50,50), tD );		
		emptySlot.add(new Point(49,50));
		emptySlot.add(new Point(50,49));
		emptySlot.add(new Point(50,51));	
		emptySlot.add(new Point(51,50));
		
	}
	private void tryAddEmptySlot(int x, int y){
		if(!_gameBoard.containsKey(new Point(x,y)))emptySlot.add(new Point(x,y)); //if an empty slot is found, adds it to emptySlot
				
	}
		
	public boolean putTile(int x, int y, HashMap<Point, Object> tile){  //when calling putTile, must use int x and y for Point, and specify which tile you want to place.
		if(emptySlot.contains(new Point(x,y))&& checkPlacement(x,y, tile) ){
			_gameBoard.put(new Point(x,y), tile);
			emptySlot.remove(new Point(x,y));
			 //goes through all spaces next to the placed tile and checks which ones are empty.
			tryAddEmptySlot(x+1,y);
			tryAddEmptySlot(x,y+1);
			tryAddEmptySlot(x,y-1);
			tryAddEmptySlot(x-1,y);
				return true;
			}
		else{ //else catchall. should never be encountered
		
			System.out.println("error, cannot place tile at:"+ x+ "and "+ y); // feel free to change this to an exception handler 
		
		}
		return false;
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
		Object pLeft = pTile.get(new Point(2,0));
		Object pMiddle = pTile.get(new Point (2,1));
		Object pRight = pTile.get(new Point(2,2));
		if(_gameBoard.containsKey(new Point(x, y-1))){
		 HashMap<Point,Object> dTile =_gameBoard.get(new Point(x, y-1));
		 Object left = dTile.get(new Point(0,0));
		 Object middle = dTile.get(new Point(0,1));
		 Object right = dTile.get(new Point(0,2));
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
		Object pMiddle = pTile.get(new Point (0,1));
		Object pRight = pTile.get(new Point(0,2));
		if(_gameBoard.containsKey(new Point(x,y+1))){
		 HashMap<Point,Object> uTile =_gameBoard.get(new Point(x, y+1));
		 Object left = uTile.get(new Point(2,0));
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
		Object pTop = pTile.get(new Point(0,2));
		Object pMiddle = pTile.get(new Point (1,2));
		Object pBottom = pTile.get(new Point(2,2));
		if(_gameBoard.containsKey(new Point(x+1, y))){
		 HashMap<Point,Object> rTile =_gameBoard.get(new Point(x+1, y));
		 Object top = rTile.get(new Point(0,0));
		 Object middle = rTile.get(new Point(1,0));
		 Object bottom = rTile.get(new Point(2,0));
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
		Object pMiddle = pTile.get(new Point (1,0));
		Object pBottom = pTile.get(new Point(2,0));
		if(_gameBoard.containsKey(new Point(x-1, y))){
		 HashMap<Point,Object> lTile =_gameBoard.get(new Point(x-1, y));
		 Object top = lTile.get(new Point(0,2));
		 Object middle = lTile.get(new Point(1,2));
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
		System.out.println(cA);
		switch(cA){
		
		case 'F': if(b.equals('F')|| b.equals('W')) return true;  //Field can be placed to Field and Wall
			else return false;
		case 'C': if(b.equals('C')|| b.equals('W')) return true;  //City can be placed next to City and Wall
			else return false;
		case 'W': if (b.equals('F')||b.equals('C')) return true;  //Wall can be placed next to Field and City
			else return false;
		case 'R': if (b.equals('R')) return true;		//Road can only be placed next to road.
			else return false;
		default: System.out.println("default in swich statement in checkIndividual should never be triggered"); //this catchall default should never be triggered
		//this is because the objects fed in should always equal F,C,W, or R.
			return false;
		
		}
		
		
	}
		public void addView(View v){
		_view = v;
	}
		public String[] get_playerList() {
			return _playerList;
		}
		public void set_playerList(String[] _playerList) {
			this._playerList = _playerList;
		}

	
	

}
