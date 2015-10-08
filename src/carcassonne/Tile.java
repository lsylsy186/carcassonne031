package carcassonne;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Tile {
	
	private HashMap<Point, Object> _tileA = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileB = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileC = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileD = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileE = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileF = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileG = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileH = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileI = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileJ = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileK = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileL = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileM = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileN = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileO = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileP = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileQ = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileR = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileS = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileT = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileW = new HashMap<Point, Object>(); 
	private HashMap<Point, Object> _tileX = new HashMap<Point, Object>();
	private ArrayList<HashMap<Point, Object>> tiles = new ArrayList<HashMap<Point, Object>>();
	
	public Tile(){
		CreateAllTile();
		tiles.add(_tileA);
		tiles.add(_tileB);
		tiles.add(_tileC);
		tiles.add(_tileD);
		tiles.add(_tileE);
		tiles.add(_tileF);
		tiles.add(_tileG);
		tiles.add(_tileH);
		tiles.add(_tileI);
		tiles.add(_tileJ);
		tiles.add(_tileK);
		tiles.add(_tileL);
		tiles.add(_tileM);
		tiles.add(_tileN);
		tiles.add(_tileO);
		tiles.add(_tileP);
		tiles.add(_tileQ);
		tiles.add(_tileR);
		tiles.add(_tileS);
		tiles.add(_tileT);
		tiles.add(_tileU);
		tiles.add(_tileV);
		tiles.add(_tileW);
		tiles.add(_tileX);
		
		
		
	}
	public void CreateTile(HashMap<Point, Object> _tile,char position0,char position1,
			char position2, char position3, char position4, char position5, char position6, 
			char position7, char position8){
		
		_tile.put(new Point(0,0), position0);
		 _tile.put(new Point(0,1), position1);
		 _tile.put(new Point(0,2), position2);
		 _tile.put(new Point(1,0), position3);
		 _tile.put(new Point(1,1), position4);
		 _tile.put(new Point(1,2), position5);
		 _tile.put(new Point(2,0), position6);
		 _tile.put(new Point(2,1), position7);
		 _tile.put(new Point(2,2), position8);
	}
	public void CreateAllTile(){
		CreateTile(_tileA,  'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F'); 
		CreateTile(_tileB,  'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		CreateTile(_tileC,  'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tileD,  'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tileE,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileF,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileG,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		CreateTile(_tileH,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		CreateTile(_tileI,  'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileJ, 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileK, 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileL, 'F', 'R', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileM, 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'R', 'F');
		CreateTile(_tileN, 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F');
		CreateTile(_tileO, 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C');
		CreateTile(_tileP, 'F', 'R', 'W', 'F', 'R', 'C', 'F', 'R', 'W');
		CreateTile(_tileQ, 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		CreateTile(_tileR, 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileS, 'W', 'C', 'W', 'F', 'C', 'F', 'W', 'C', 'W');
		CreateTile(_tileT, 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W');
		CreateTile(_tileU, 'F', 'F', 'W', 'F', 'F', 'C', 'W', 'C', 'W');
		CreateTile(_tileV, 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileW, 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'F', 'W');
		CreateTile(_tileX, 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'R', 'W');
	}
	
	public void rotate(HashMap<Point, Object> tile){
		Object temp0,temp1,temp2,temp3,temp5,temp6,temp7,temp8;
		//temp0 - temp8 means the value of nine positions
		temp0 = tile.get(new Point(0,0));
		temp1 = tile.get(new Point(0,1));
		temp2 = tile.get(new Point(0,2));
		temp3 = tile.get(new Point(1,0));
		temp5 = tile.get(new Point(1,2));
		temp6 = tile.get(new Point(2,0));
		temp7 = tile.get(new Point(2,1));
		temp8 = tile.get(new Point(2,2));
		//rotate, position4 never changed
		 tile.put(new Point(0,0), temp6);
		 tile.put(new Point(0,1), temp3);
		 tile.put(new Point(0,2), temp0);
		 tile.put(new Point(1,0), temp7);		
		 tile.put(new Point(1,2), temp1);
		 tile.put(new Point(2,0), temp8);
		 tile.put(new Point(2,1), temp5);
		 tile.put(new Point(2,2), temp2);
	}
	
	public HashMap<Point, Object> getTile(char c){
		return tiles.get(c - 'A');
	}
	
	public String toString(HashMap<Point, Object> tile){
		String result = "";
		result =result + tile.get(new Point(0,0)) + tile.get(new Point(0,1)) + 
				tile.get(new Point(0,2)) + tile.get(new Point(1,0)) +
				tile.get(new Point(1,1)) + tile.get(new Point(1,2)) +
				tile.get(new Point(2,0)) + tile.get(new Point(2,1)) +
				tile.get(new Point(2,2));
		return result;
	}
	
	public char getPositionAtPoint(HashMap<Point,Object> tile, int x, int y){
		char result = (char) tile.get(new Point(x,y));
		System.out.println("char returned is"+result);
	 	return result;
	 	
	 	
	}
}
