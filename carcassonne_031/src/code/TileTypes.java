package code;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * The TileTypes class creates the correct number of the 24 tile types to reach a total of 71
 * Tile objects in the ArrayList<Tile> named _tileList. The starting tile is not included in this
 * list because it is initialized in the Board constructor.
 * 
 * @author Maggie
 */
public class TileTypes {
	
	/**
	 * ArrayList named _tileList which will hold all of the tiles that need to be created for gameplay
	 */
	private ArrayList<Tile> _tileList;
	private ArrayList<Tile> _riverTileList;
	
	/**
	 * Constructor initializes the _tileList as a new ArrayList<Tile>
	 */
	public TileTypes() {
		_tileList = new ArrayList<Tile>();
		_riverTileList = new ArrayList<Tile>();
	}
	

	/**
	 * Method which creates all of the tiles in the _tileList at the start of the game. Runs a for loop
	 * which works through each tile type based on a number from 1-24. Each type number is taken into an
	 * if statement which holds the String[] for each side, the inside qualifier, a boolean which is true
	 * if a shield is present, the image based on the TileSet.jpg file which was given, and an int which 
	 * refers to a follower placement.
	 */
	public void createTiles() {
		for (int type = 1; type<25; type++) {
			if (type == 1) {
				for (int i=0; i<5; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"field", "field","field"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "field","field"};
					
					//inside must be mentioned for scoring and follower placement purposes:
					//	=field, =city, =road, =road end, =cloister
					String inside = "field";
					
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/1.png"));
					
					//all follower int values are initialized to 9 which means no follower placement
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "A");
					_tileList.add(t);
				}
			}
			if (type == 2) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "field";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/2.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "B");
					_tileList.add(t);
				}
			}
			if (type == 3) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"field", "field","field"};
					String[] s2 = {"city", "city", "city"};
					String[] s3 = {"field", "field","field"};
					String inside = "field";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/3.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "C");
					_tileList.add(t);
				}
			}
			if (type == 4) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "field";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/4.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "D");
					_tileList.add(t);
				}
			}
			if (type == 5) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "field";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/5.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, true, img, 9,  "E");
					_tileList.add(t);
				}
			}
			if (type == 6) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"city", "city", "city"};
					String inside = "city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/6.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "F");
					_tileList.add(t);
				}
			}
			if (type == 7) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"city", "city", "city"};
					String inside = "city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/7.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, true, img, 9, "G");
					_tileList.add(t);
				}
			}
			if (type == 8) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"city", "city", "city"};
					String[] s3 = {"city", "city", "city"};
					String inside = "city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/8.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, true, img, 9, "H");
					_tileList.add(t);
				}
			}
			if (type == 9) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"city", "city", "city"};
					String inside = "city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/9.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"I");
					_tileList.add(t);
				}
			}
			if (type == 10) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"city", "city", "city"};
					String inside = "city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/10.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, true, img, 9, "J");
					_tileList.add(t);
				}
			}
			if (type == 11) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"field", "road", "field"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/11.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "K");
					_tileList.add(t);
				}
			}
			if (type == 12) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"field", "field", "field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/12.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "L");
					_tileList.add(t);
				}
			}
			if (type == 13) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"field", "road","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/13.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"M");
					_tileList.add(t);
				}
			}
			if (type == 14) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/14.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9, "N");
					_tileList.add(t);
				}
			}
			if (type == 15) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/15.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, true, img, 9,"P");
					_tileList.add(t);
				}
			}
			if (type == 16) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"city", "city", "city"};
					String inside = "city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/16.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"Q");
					_tileList.add(t);
				}
			}
			if (type == 17) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"city", "city", "city"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"city", "city", "city"};
					String inside = "city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/17.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, true, img, 9,"S");
					_tileList.add(t);
				}
			}
			if (type == 18) {
				for (int i=0; i<3; i++) {
					String[] s0 = {"city", "city", "city"};
					String[] s1 = {"field", "road","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road end";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/18.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"T");
					_tileList.add(t);
				}
			}
			if (type == 19) {
				for (int i=0; i<4; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"field", "field","field"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "cloister";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/19.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"U");
					_tileList.add(t);
				}
			}
			if (type == 20) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"field", "field","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "cloister";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/20.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"V");
					_tileList.add(t);
				}
			}
			if (type == 21) {
				for (int i=0; i<8; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"field", "road","field"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/21.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"W");
					_tileList.add(t);
				}
			}
			if (type == 22) {
				for (int i=0; i<9; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"field", "field","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/22.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"X");
					_tileList.add(t);
				}
			}
			if (type == 23) {
				for (int i=0; i<4; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"field", "road","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road end";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/23.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"Y");
					_tileList.add(t);
				}
			}
			if (type == 24) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "road","field"};
					String[] s1 = {"field", "road","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "road end";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/24.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"Z");
					_tileList.add(t);
				}
			}
			
		}
			
			for (int typeRiver = 1; typeRiver<10; typeRiver++) {
			
			if (typeRiver == 1) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"field", "field","field"};
					String[] s2 = {"field", "river","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "river";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/25.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RA");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver == 2) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"field", "river","field"};
					String[] s1 = {"field", "field","field"};
					String[] s2 = {"field", "river","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "river";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/26.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RB");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver == 3) {
				for (int i=0; i<2; i++) {
					String[] s0 = {"field", "river","field"};
					String[] s1 = {"field", "river","field"};
					String[] s2 = {"field", "field","field"};
					String[] s3 = {"field", "field","field"};
					String inside = "river";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/27.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RC");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver == 4) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "field","field"};
					String[] s1 = {"field", "river","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "river","field"};
					String inside = "river cloister";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/28.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RD");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver ==5) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "river","field"};
					String[] s1 = {"field", "river","field"};
					String[] s2 = {"city", "city","city"};
					String[] s3 = {"city", "city","city"};
					String inside = "river city";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/29.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RE");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver == 6) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "road","field"};
					String[] s1 = {"field", "river","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "river","field"};
					String inside = "river road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/30.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RF");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver ==7) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "river","field"};
					String[] s1 = {"city", "city","city"};
					String[] s2 = {"field", "river","field"};
					String[] s3 = {"city", "city","city"};
					String inside = "river";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/31.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RG");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver ==8) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "river","field"};
					String[] s1 = {"field", "river","field"};
					String[] s2 = {"field", "road","field"};
					String[] s3 = {"field", "road","field"};
					String inside = "river";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/32.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RH");
					_riverTileList.add(t);
				}
			}
			
			if (typeRiver == 9) {
				for (int i=0; i<1; i++) {
					String[] s0 = {"field", "river","field"};
					String[] s1 = {"field", "road","field"};
					String[] s2 = {"field", "river","field"};
					String[] s3 = {"city", "city","city"};
					String inside = "river road";
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/33.png"));
					Tile t = new Tile(s0,s1,s2,s3, inside, false, img, 9,"RI");
					_riverTileList.add(t);
				}
			}
			
		}
	}
	
	/**
	 * getTileList() is an accessor method which is used to return the _tileList for use in other classes
	 * 
	 * @return	_tileList which returns an ArrayList of all of the tiles left at the time the method is called.
	 */
	public ArrayList<Tile> getTileList() {
		return _tileList;
	}		
	
	public ArrayList<Tile> getRiverTileList() {
		return _riverTileList;
	}		
}
