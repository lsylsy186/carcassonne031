package code;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Tile {
	
	private HashMap<Point, Object> _tileA1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileA2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileB1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileB2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileB3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileB4 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileC1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileDS = new HashMap<Point, Object>(); //DS for D starting tile
	private HashMap<Point, Object> _tileD1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileD2= new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileD3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileE1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileE2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileE3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileE4 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileE5 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileF1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileF2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileG1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileH1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileH2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileH3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileI1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileI2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileJ1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileJ2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileJ3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileK1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileK2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileK3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileL1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileL2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileL3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileM1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileM2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileN3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileN1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileN2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileO1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileO2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileP1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileP2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileP3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileQ1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileR1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileR2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileR3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileS1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileS2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileT1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU4 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU5 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU6 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU7 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileU8 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV1 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV2 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV3 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV4 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV5 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV6 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV7 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV8 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileV9 = new HashMap<Point, Object>();
	private HashMap<Point, Object> _tileW1 = new HashMap<Point, Object>(); 
	private HashMap<Point, Object> _tileW2 = new HashMap<Point, Object>(); 
	private HashMap<Point, Object> _tileW3 = new HashMap<Point, Object>(); 
	private HashMap<Point, Object> _tileW4 = new HashMap<Point, Object>(); 
	private HashMap<Point, Object> _tileX1 = new HashMap<Point, Object>();
	ArrayList<HashMap<Point, Object>> _tiles = new ArrayList<HashMap<Point, Object>>();
	
	public Tile(){
		CreateAllTile(); 
		//has to be kept in this order so getTile will still work for testing.
		get_tiles().add(_tileA1);
		get_tiles().add(_tileB1);
		get_tiles().add(_tileC1);
		get_tiles().add(_tileD1);
		get_tiles().add(_tileE1);
		get_tiles().add(_tileF1);
		get_tiles().add(_tileG1);
		get_tiles().add(_tileH1);
		get_tiles().add(_tileI1);
		get_tiles().add(_tileJ1);
		get_tiles().add(_tileK1);
		get_tiles().add(_tileL1);
		get_tiles().add(_tileM1);
		get_tiles().add(_tileN1);
		get_tiles().add(_tileO1);
		get_tiles().add(_tileP1);
		get_tiles().add(_tileQ1);
		get_tiles().add(_tileR1);
		get_tiles().add(_tileS1);
		get_tiles().add(_tileT1);
		get_tiles().add(_tileU1);
		get_tiles().add(_tileV1);
		get_tiles().add(_tileW1);
		get_tiles().add(_tileX1);
		
		get_tiles().add(_tileA2);
		get_tiles().add(_tileB2);
		get_tiles().add(_tileB3);
		get_tiles().add(_tileB4);
		get_tiles().add(_tileD2);
		get_tiles().add(_tileD3);
		get_tiles().add(_tileE2);
		get_tiles().add(_tileE3);
		get_tiles().add(_tileE4);
		get_tiles().add(_tileE5);
		get_tiles().add(_tileF2);
		get_tiles().add(_tileH2);
		get_tiles().add(_tileH3);
		get_tiles().add(_tileI2);
		get_tiles().add(_tileJ2);
		get_tiles().add(_tileJ3);
		get_tiles().add(_tileK2);
		get_tiles().add(_tileK3);
		get_tiles().add(_tileL2);
		get_tiles().add(_tileL3);
		get_tiles().add(_tileM2);
		get_tiles().add(_tileN2);
		get_tiles().add(_tileN3);
		get_tiles().add(_tileO2);
		get_tiles().add(_tileP2);
		get_tiles().add(_tileP3);
		get_tiles().add(_tileR2);
		get_tiles().add(_tileR3);
		get_tiles().add(_tileS2);
		get_tiles().add(_tileU2);
		get_tiles().add(_tileU3);
		get_tiles().add(_tileU4);
		get_tiles().add(_tileU5);
		get_tiles().add(_tileU6);
		get_tiles().add(_tileU7);
		get_tiles().add(_tileU8);
		get_tiles().add(_tileV2);
		get_tiles().add(_tileV3);
		get_tiles().add(_tileV4);
		get_tiles().add(_tileV5);
		get_tiles().add(_tileV6);
		get_tiles().add(_tileV7);
		get_tiles().add(_tileV8);
		get_tiles().add(_tileV8);
		get_tiles().add(_tileW2);
		get_tiles().add(_tileW3);
		get_tiles().add(_tileW4);
		
		
		
	}
	public void CreateTile(HashMap<Point, Object> _tile, char name ,char position0,char position1,
			char position2, char position3, char position4, char position5, char position6, 
			char position7, char position8,char rotateFlag){
		
		_tile.put(new Point(0,0), position0);
		 _tile.put(new Point(0,1), position1);
		 _tile.put(new Point(0,2), position2);
		 _tile.put(new Point(1,0), position3);
		 _tile.put(new Point(1,1), position4);
		 _tile.put(new Point(1,2), position5);
		 _tile.put(new Point(2,0), position6);
		 _tile.put(new Point(2,1), position7);
		 _tile.put(new Point(2,2), position8);
		 _tile.put(new Point(3,3), name);
		 _tile.put(new Point(3,4), rotateFlag);
	}
	// goes from left to right and top to bottom.  (top left, top middle, top right,  middle left,... and so on) 
	public void CreateAllTile(){
		CreateTile(_tileA1, 'A', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'R', 'F', '0');
		CreateTile(_tileA2, 'A', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'R', 'F', '0');
		
		CreateTile(_tileB1, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F', '0');
		CreateTile(_tileB2, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F', '0');
		CreateTile(_tileB3, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F', '0');
		CreateTile(_tileB4, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F', '0');
		
		CreateTile(_tileC1, 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C','0');
		
		CreateTile(_tileDS, 'D', 'F', 'R', 'W', 'F', 'R', 'C', 'F', 'R', 'W','0');
		CreateTile(_tileD1, 'D', 'F', 'R', 'W', 'F', 'R', 'C', 'F', 'R', 'W','0');
		CreateTile(_tileD2, 'D', 'F', 'R', 'W', 'F', 'R', 'C', 'F', 'R', 'W','0');
		CreateTile(_tileD3, 'D', 'F', 'R', 'W', 'F', 'R', 'C', 'F', 'R', 'W','0');
		
		CreateTile(_tileE1, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F','0');
		CreateTile(_tileE2, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F','0');
		CreateTile(_tileE3, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F','0');
		CreateTile(_tileE4, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F','0');
		CreateTile(_tileE5, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F','0');
		
		CreateTile(_tileF1, 'F', 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W','0');
		CreateTile(_tileF2, 'F', 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W','0');
		
		CreateTile(_tileG1, 'G', 'W', 'C', 'W', 'F', 'C', 'F', 'W', 'C', 'W','0');
		
		CreateTile(_tileH1, 'H', 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W','0');
		CreateTile(_tileH2, 'H', 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W','0');
		CreateTile(_tileH3, 'H', 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W','0');
		
		CreateTile(_tileI1, 'I', 'F', 'F', 'W', 'F', 'F', 'C', 'W', 'C', 'W','0');
		CreateTile(_tileI2, 'I', 'F', 'F', 'W', 'F', 'F', 'C', 'W', 'C', 'W','0');
		
		CreateTile(_tileJ1, 'J', 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F','0');
		CreateTile(_tileJ2, 'J', 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F','0');
		CreateTile(_tileJ3, 'J', 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F','0');
		
		CreateTile(_tileK1, 'K', 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'F', 'W','0');
		CreateTile(_tileK2, 'K', 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'F', 'W','0');
		CreateTile(_tileK3, 'K', 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'F', 'W','0');
		
		CreateTile(_tileL1, 'L', 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'R', 'W','0');
		CreateTile(_tileL2, 'L', 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'R', 'W','0');
		CreateTile(_tileL3, 'L', 'F', 'R', 'W', 'R', 'R', 'C', 'F', 'R', 'W','0');
		//do we want the middle of M to be field or wall
		CreateTile(_tileM1, 'M', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F','0'); 
		CreateTile(_tileM2, 'M', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F','0'); 
		
		CreateTile(_tileN1, 'N', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F','0');
		CreateTile(_tileN2, 'N', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F','0');
		CreateTile(_tileN3, 'N', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F','0');
		
		CreateTile(_tileO1, 'O', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F','0');
		CreateTile(_tileO2, 'O', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F','0');
		CreateTile(_tileP1, 'P', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F','0');
		CreateTile(_tileP2, 'P', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F','0');
		CreateTile(_tileP3, 'P', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F','0');
		CreateTile(_tileQ1, 'Q', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W','0');
		CreateTile(_tileR1, 'R', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W','0');
		CreateTile(_tileR2, 'R', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W','0');
		CreateTile(_tileR3, 'R', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W','0');
		CreateTile(_tileS1, 'S', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W','0');
		CreateTile(_tileS2, 'S', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W','0');
		CreateTile(_tileT1, 'T', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W','0');
		
		CreateTile(_tileU1, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileU2, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileU3, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileU4, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileU5, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileU6, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileU7, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileU8, 'U', 'F', 'R', 'F', 'F', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV1, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV2, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV3, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV4, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV5, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV6, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV7, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV8, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileV9, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F','0');
		CreateTile(_tileW1, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F','0');
		CreateTile(_tileW2, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F','0');
		CreateTile(_tileW3, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F','0');
		CreateTile(_tileW4, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F','0');
		CreateTile(_tileX1, 'X', 'F', 'R', 'F', 'R', 'R', 'R', 'F', 'R', 'F','0');
	}
	
	public  char getName(HashMap<Point,Object> tile){
		if(tile == null){
			return '*';
		}
		return (char) tile.get(new Point(3,3));
	}
	public void setRotateFlag(HashMap<Point,Object> tile, char flag){
		if(tile != null) tile.put(new Point(3,4), flag);
	}
	
	
	public HashMap<Point, Object> getTile(char c){ // this still holds with the addition of the tiles,  will only return A1 through X1, however.
		return get_tiles().get(c - 'A');
	}
	
	public String toString(HashMap<Point, Object> tile){
		String result = "";
		//goes from left to right, top to bottom.
		result =result + tile.get(new Point(0,0)) + tile.get(new Point(1,0)) + 
				tile.get(new Point(2,0)) + tile.get(new Point(0,1)) +
				tile.get(new Point(1,1)) + tile.get(new Point(2,1)) +
				tile.get(new Point(0,2)) + tile.get(new Point(1,2)) +
				tile.get(new Point(2,2));
		return result;
	}
	
	public char getPositionAtPoint(HashMap<Point,Object> tile, int x, int y){
		char result = (char) tile.get(new Point(x,y));
		System.out.println("char returned is"+result);
	 	return result;
	 	
	 	
	}
	public ArrayList<HashMap<Point, Object>> get_tiles() {
		return _tiles;
	}
	public void set_tiles(ArrayList<HashMap<Point, Object>> _tiles) {
		this._tiles = _tiles;
	}
	public HashMap<Point, Object> getStartTile(){
		return _tileDS;
	}
}
