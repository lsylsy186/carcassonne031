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
	static ArrayList<HashMap<Point, Object>> _tiles = new ArrayList<HashMap<Point, Object>>();
	
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
	public void CreateTile(HashMap<Point, Object> _tile,char name ,char position0,char position1,
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
		 _tile.put(new Point(3,3), name);
	}
	public void CreateAllTile(){
		CreateTile(_tileA1, 'A', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'R', 'F');
		CreateTile(_tileA2, 'A', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'R', 'F');
		CreateTile(_tileB1, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F');
		CreateTile(_tileB2, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F');
		CreateTile(_tileB3, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F');
		CreateTile(_tileB4, 'B', 'F', 'F', 'F', 'F', 'M', 'F', 'F', 'F', 'F');
		CreateTile(_tileC1, 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'C');	
		CreateTile(_tileDS, 'D', 'W', 'C', 'W', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileD1, 'D', 'W', 'C', 'W', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileD2, 'D', 'W', 'C', 'W', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileD3, 'D', 'W', 'C', 'W', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileE1, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		CreateTile(_tileE2, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		CreateTile(_tileE3, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		CreateTile(_tileE4, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		CreateTile(_tileE5, 'E', 'W', 'C', 'W', 'F', 'F', 'F', 'F', 'F', 'F');
		CreateTile(_tileF1, 'F', 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileF2, 'F', 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileG1, 'G', 'W', 'F', 'W', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileH1, 'H', 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W');
		CreateTile(_tileH2, 'H', 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W');
		CreateTile(_tileH3, 'H', 'W', 'F', 'W', 'C', 'F', 'C', 'W', 'F', 'W');
		CreateTile(_tileI1, 'I', 'W', 'C', 'W', 'C', 'F', 'F', 'W', 'F', 'F');
		CreateTile(_tileI2, 'I', 'W', 'C', 'W', 'C', 'F', 'F', 'W', 'F', 'F');
		CreateTile(_tileJ1, 'J', 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileJ2, 'J', 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileJ3, 'J', 'W', 'C', 'W', 'F', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileK1, 'K', 'W', 'C', 'W', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileK2, 'K', 'W', 'C', 'W', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileK3, 'K', 'W', 'C', 'W', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileL1, 'L', 'W', 'C', 'W', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileL2, 'L', 'W', 'C', 'W', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileL3, 'L', 'W', 'C', 'W', 'R', 'R', 'R', 'F', 'R', 'F');	
		CreateTile(_tileM1, 'M', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F'); 
		CreateTile(_tileM2, 'M', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F'); 
		CreateTile(_tileN1, 'N', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		CreateTile(_tileN2, 'N', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		CreateTile(_tileN3, 'N', 'C', 'C', 'W', 'C', 'W', 'F', 'W', 'F', 'F');
		CreateTile(_tileO1, 'O', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tileO2, 'O', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tileP1, 'P', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tileP2, 'P', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tileP3, 'P', 'C', 'C', 'W', 'C', 'W', 'R', 'W', 'R', 'F');
		CreateTile(_tileQ1, 'Q', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileR1, 'R', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileR2, 'R', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileR3, 'R', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'F', 'W');
		CreateTile(_tileS1, 'S', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		CreateTile(_tileS2, 'S', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		CreateTile(_tileT1, 'T', 'C', 'C', 'C', 'C', 'C', 'C', 'W', 'R', 'W');
		CreateTile(_tileU1, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileU2, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileU3, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileU4, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileU5, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileU6, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileU7, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileU8, 'U', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'F', 'F');
		CreateTile(_tileV1, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV2, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV3, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV4, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV5, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV6, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV7, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV8, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileV9, 'V', 'F', 'F', 'F', 'R', 'R', 'F', 'F', 'R', 'F');
		CreateTile(_tileW1, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileW2, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileW3, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileW4, 'W', 'F', 'F', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
		CreateTile(_tileX1, 'X', 'F', 'R', 'F', 'R', 'R', 'R', 'F', 'R', 'F');
	}
	
	public  char getName(HashMap<Point,Object> tile){
		if(tile == null){
			return '*';
		}
		return (char) tile.get(new Point(3,3));
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
	
	public HashMap<Point, Object> getTile(char c){ // this still holds with the addition of the tiles,  will only return A1 through X1, however.
		return get_tiles().get(c - 'A');
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
