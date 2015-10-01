package carcassonne;

import java.awt.Point;
import java.util.HashMap;

public class Tile {
	private HashMap<Point, Object> _tile1;
	private HashMap<Point, Object> _tile2;
	private HashMap<Point, Object> _tile3;
	private HashMap<Point, Object> _tile4;
	private HashMap<Point, Object> _tile5;
	private HashMap<Point, Object> _tile6;
	private HashMap<Point, Object> _tile7;
	private HashMap<Point, Object> _tile8;
	private HashMap<Point, Object> _tile9;
	private HashMap<Point, Object> _tile10;
	private HashMap<Point, Object> _tile11;
	private HashMap<Point, Object> _tile12;
	private HashMap<Point, Object> _tile13;
	private HashMap<Point, Object> _tile14;
	private HashMap<Point, Object> _tile15;
	private HashMap<Point, Object> _tile16;
	private HashMap<Point, Object> _tile17;
	private HashMap<Point, Object> _tile18;
	private HashMap<Point, Object> _tile19;
	private HashMap<Point, Object> _tile20;
	private HashMap<Point, Object> _tile21;
	private HashMap<Point, Object> _tile22;
	private HashMap<Point, Object> _tile23;
	private HashMap<Point, Object> _tile24;
	
	public Tile(){
		CreateAllTile();
	}
	public void CreateTile(HashMap<Point, Object> _tile,char position0,char position1,char position2, char position3, char position4, char position5, char position6, char position7, char position8){
		
		 _tile = new HashMap<>();
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
		CreateTile(_tile1,  'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		CreateTile(_tile2,  'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		CreateTile(_tile3,  'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tile4,  'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tile5,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tile6,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tile7,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		CreateTile(_tile8,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		CreateTile(_tile9,  'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tile10, 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tile11, 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tile12, 'F', 'R', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tile13, 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'R', 'F');
		CreateTile(_tile14, 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F');
		CreateTile(_tile15, 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C');
		CreateTile(_tile16, 'F', 'R', 'W', 'F', 'R', 'C', 'F', 'R', 'W');
		CreateTile(_tile17, 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		CreateTile(_tile18, 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tile19, 'W', 'C', 'W', 'F', 'C', 'F', 'W', 'C', 'W');
		CreateTile(_tile20, 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W');
		CreateTile(_tile21, 'F', 'F', 'W', 'F', 'F', 'C', 'W', 'C', 'W');
		CreateTile(_tile22, 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tile23, 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'F', 'W');
		CreateTile(_tile24, 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'R', 'W');
		
	}
	/*	public void Create( ){
		Tile tM = new Tile (  _tile1, 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		Tile tN = new Tile (  _tile2, 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		Tile tO = new Tile (  _tile3,'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		Tile tP = new Tile (  _tile4,'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		Tile tQ = new Tile (  _tile5, 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		Tile tR = new Tile (  _tile6,  'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		Tile tS = new Tile (  _tile7, 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		Tile tT = new Tile (  _tile8, 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		Tile tU = new Tile (  _tile9, 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		Tile tV = new Tile (  _tile10, 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		Tile tW = new Tile (  _tile11, 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		Tile tX = new Tile (  _tile12, 'F', 'R', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		Tile tA = new Tile (  _tile13, 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'R', 'F');  // M stands for monastery.
		Tile tB = new Tile (  _tile14, 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F');
		Tile tC = new Tile (  _tile15, 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C');
		Tile tD = new Tile (  _tile16, 'F', 'R', 'W', 'F', 'R', 'C', 'F', 'R', 'W');  // the right half from top to bottom is W,C,W. This will allow code to  //simply check a tile for at least one C, and the W in the corners can be checked for legal placement.
		Tile tE = new Tile (  _tile17, 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		Tile tF = new Tile (  _tile18, 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W');
		Tile tG = new Tile (  _tile19, 'W', 'C', 'W', 'F', 'C', 'F', 'W', 'C', 'W');
		Tile tH = new Tile (  _tile20, 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W');
		Tile tI = new Tile (  _tile21, 'F', 'F', 'W', 'F', 'F', 'C', 'W', 'C', 'W');
		Tile tJ = new Tile (  _tile22, 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F');
		Tile tK = new Tile (  _tile23, 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'F', 'W');
		Tile tL = new Tile (  _tile24, 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'R', 'W');
	}*/
	
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
}
