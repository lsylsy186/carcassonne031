package carcassonne;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;

public class Game {
	
	private HashMap<Point, HashMap<Point,Object>> _gameBoard;
	HashSet<Point> emptySlot = new HashSet<Point>(100);
	Tile tile = new Tile();  //a hashset of all avaliable empty slots.  putTile will check and add
														//in as more occur.
	
	public void newGame(){
		Tile tile = new Tile();
		HashMap<Point,Object> tD = tile.getTile('d');
		
		_gameBoard = new HashMap<>(100);
		_gameBoard.put(new Point(50,50), tD );
		emptySlot.add(new Point(49,49));
		emptySlot.add(new Point(49,50));
		emptySlot.add(new Point(49,51));
		emptySlot.add(new Point(50,49));
		emptySlot.add(new Point(50,51));
		emptySlot.add(new Point(51,49));
		emptySlot.add(new Point(51,50));
		emptySlot.add(new Point(51,51));
	}
	
	public void putTile(int x, int y, HashMap<Point, Object> tile){
		if(emptySlot.contains(new Point(x,y))&& checkPlacement(x,y, tile) ){
			_gameBoard.put(new Point(x,y), tile);
			emptySlot.remove(new Point(x,y));			
		}
		
		else{ //else catchall. should never be encountered
			
			System.out.println("error, cannot place tile at:"+ x+ "and "+ y); // feel free to change this to an exception handler 
		}
		
		
		
		
	}

	private boolean checkPlacement(int x, int y, HashMap<Point, Object> pTile) { //checks placement availability of adjacent tiles
		//pTile is placement tile. the tile you are trying to place.
		//first should check to see which _gameBoard Points are next to it.
		if(checkLeft(x,y, pTile)&& checkRight(x,y, pTile) && checkUp(x,y, pTile) && checkDown(x,y, pTile)){
			return true;
		}
		
			
			
	
		
		return false;
	}

	private boolean checkDown(int x, int y, HashMap<Point, Object> pTile) { 
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkUp(int x, int y, HashMap<Point, Object> pTile) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkRight(int x, int y, HashMap<Point, Object> pTile) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkLeft(int x, int y, HashMap<Point, Object> pTile) {
		Object pTop = pTile.get(new Point(0,0));
		Object pMiddle = pTile.get(new Point (0,1));
		Object pBottom = pTile.get(new Point(0,2));
		if(_gameBoard.containsKey(new Point(x-1, y))){
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

	private boolean checkIndividual(Object a, Object b) {
		char cA= (char) a;
		System.out.println(cA);
		switch(cA){
		
		case 'F': if(b.equals('F')|| b.equals('W')) return true;
			else return false;
		case 'C': if(b.equals('C')|| b.equals('W')) return true;
			else return false;
		case 'W': if (b.equals('F')||b.equals('C')) return true;
			else return false;
		case 'R': if (b.equals('R')) return true;
			else return false;
		default: System.out.println("default in swich statement in checkIndividual should never be triggered"); 
			return false;
		
		}
		
		
	}
	
	

}
