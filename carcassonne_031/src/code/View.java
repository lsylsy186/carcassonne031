package code;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * View creates the GUI for the game and updates it as changes are made in the underlying data model. 
 * 
 * @author Katie
 *
 */
public class View {
	
	/**
	 * Variable that holds a reference to the JFrame that the GUI is in
	 */
	private JFrame _window;
	/**
	 * Variables that hold references to the panel that hold the Tile buttons, and the panel that hold the turn information
	 */
	private JPanel _gameplay;
	private JPanel _turn;
	/**
	 * Variable that holds a reference to the Board that is passed into the View
	 */
	private Board _board;
	/**
	 * Variable that holds a reference to a HashMap<JButton, Point> that maps the points at which JButtons are located in the board to the JButtons themselves
	 */
	private HashMap<JButton, Point> _buttons;
	/**
	 * Variable that holds a reference to an ArrayList<JButton> of all of the JButtons in the _gameplay JPanel
	 */
	private ArrayList<JButton> _list;
	/**
	 * Variable holds a reference to the GridLayout object that is added to the _gameplay JPanel which is updated each time new tiles are placed
	 */
	private GridLayout _grid;
	/**
	 * Variables of type int that keep track of the number of columns and rows on each of the starting tile
	 */
	private int _minX;
	private int _maxX;
	private int _minY;
	private int _maxY;
	/**
	 * Variable that holds a reference to the ActionListener that is added to all of the JButtons in the _gameplay panel
	 */
	private EventHandler _event;
	/**
	 * Variable that holds a reference to the tile that was picked from the ArrayList in TileTypes for the next tile placement
	 */
	private Tile _newTile;
	/**
	 * Variable that holds the index of the starting tile in the _list
	 */
	private int _startTile;
	/**
	 * Variable that holds a reference to the JButton that is in the _turns panel and displays the image of the tile that can be placed next
	 */
	private JButton _nextTileButton;
	/**
	 * Variable that holds a reference to the ImageIcon of the tile that can be placed next
	 */
	private ImageIcon _image;
	/**
	 * Variable that holds a reference to the tile that was last placed
	 */
	private Tile _oldTile;
	/**
	 * Variable that holds a reference to an ArrayList that holds all of the JButtons in the JFrame that appears when someone wants to place a follower
	 */
	private ArrayList<JButton> _followerList;
	/**
	 * Variable that holds a reference to the JButton onto which the a tile is being placed
	 */
	private JButton _button;
	/**
	 * Variable that holds a reference to the JPanel that holds a JLabel for each player that displays their score and number of followers. This JPanel is
	 * is placed in the _turn JPanel
	 */
	private JPanel _players;
	/**
	 * Variables that hold references to JLabels that are located in the _turn JPanel and which hold the information on the player whose turn is currently in progress
	 */
	private JLabel _followers;
	private JLabel _score;
	private JLabel _player;
	/**
	 * When the View is instantiated, it creates a JFram that holds two JPanels. The _gameplay JPanel has a GridLayout and holds 9 JButtons, one of which displays the image of 
	 * the starting tile. The _turn JPanel has a BorderLayout that holds 3 JLabels that show the current player's name, followers and score, the _button JButton and the _players
	 * JPanel. All of these are added to the _window, laid out according to a GridBagLayout, which is packed and set to visible.
	 * 
	 * @param b		Takes in a reference to the Board from which it is accessing the data to display
	 */
	public View(Board b){
		_board = b;
		_window = new JFrame("Carcassonne");
		JPanel whole = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		//GridBagConstraints c = new GridBagConstraints();
		whole.setLayout(gridbag);
		_gameplay = new JPanel();
		_grid = new GridLayout(3,3);
		_gameplay.setLayout(_grid);
		_buttons = new HashMap<JButton, Point>();
		_list = new ArrayList<JButton>();
		_minX = 70;
		_maxX = 72;
		_minY = 70;
		_maxY = 72;
		_startTile = 4;
		_event = new EventHandler(this, _board);
		//creates all of the JButtons that are located in the _gameplay panel
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				JButton a = new JButton();
				a.setPreferredSize(new Dimension(80,80));
				a.addActionListener(_event);
				if((i==1) && (j==1)){
					ImageIcon img = new ImageIcon(getClass().getResource("/resources/11.png"));
					a.setIcon(img);
				}
				_gameplay.add(a);
				_list.add(a);
				_buttons.put(a, new Point(j+70,72-i));
			}
		}
		_turn = new JPanel();
		BorderLayout border = new BorderLayout();
		border.setHgap(20);
		_turn.setLayout(border);
		_newTile = _board.pickTile();
		_image = _newTile.getImage();
		_nextTileButton = new JButton(_image);
		_nextTileButton.setPreferredSize(new Dimension(80,80));
		_nextTileButton.addActionListener(new Rotate(this, _nextTileButton));
		_turn.add(_nextTileButton, BorderLayout.WEST);
		_followers = new JLabel("Followers");
		_turn.add(_followers, BorderLayout.CENTER);
		_score = new JLabel("Score: 0");
		_score.setHorizontalAlignment(JLabel.CENTER);
		_turn.add(_score, BorderLayout.EAST);
		_player = new JLabel();
		_turn.add(_player, BorderLayout.NORTH);
		ArrayList<String> playerList = _board.getPlayers();
		_players = new JPanel();
		GridLayout grid = new GridLayout(1, playerList.size());
		grid.setHgap(10);
		_players.setLayout(grid);
		_turn.add(_players, BorderLayout.SOUTH);
		//this.updateTurn(playerList.get(0));
		whole.add(_gameplay);
		whole.add(_turn);
		_window.add(whole);
		_window.pack();
		_window.setLocationRelativeTo(null);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	/**
	 * This method updates the View if a tile is placed on a JButton located on the right most edge of the _gameplay JPanel. When it updates it, it adds
	 * another column of JButtons on the right side of the _gameplay JPanel. It also sets the image of the placed tile onto the JButton that was clicked.
	 * 
	 * @param t		Takes in a references to the Tile that is being placed
	 * @param x		Takes in the x-coordinate at which it was placed in the board
	 * @param y		takes in the y-coordinate at which it was placed in the board
	 */
	public void updateRight(Tile t, int x, int y){
		//getting the size of the GridLayout of _gameplay
		int columns = _grid.getColumns();
		int rows = _grid.getRows();
		ArrayList<JButton> temporary = new ArrayList<>();
		int ytemp = _maxY;
		//making a copy of _list in temporary
		for(int i = 0; i<_list.size();i++){
			temporary.add(_list.get(i));
		}
		//adding the image to the button that the tile is being added to
		_button = temporary.get(_startTile + (x-71)+((71-y)*(columns)));
		_button.setIcon(_image);
		int counter = 0;
		//re-indexing all of the JButtons in _list to accommodate for the new column of JButtons
		for(int j = 0; j <= _list.size(); j++){
			if((j>0) && (j%(columns) == 0)){
				JButton a = new JButton();
				a.setPreferredSize(new Dimension(80,80));
				a.addActionListener(_event);
				_buttons.put(a,  new Point(_maxX + 1, ytemp));
				ytemp--;
				if(j < _list.size()-counter){
					temporary.set(j+counter, a);
				}else{
					temporary.add(j+counter,a);
				}
				counter++;
				if(j+counter < _list.size()){
					JButton c = _list.get(j);
					temporary.set(j+counter, c);
				}else{
					if(j<_list.size()){
						JButton c = _list.get(j);
						temporary.add(j+counter, c);
					}
				}
			}else{
				if(j + counter < _list.size()){
					JButton c = _list.get(j);
					temporary.set(j+counter, c);
				}else{
					JButton c = _list.get(j);
					temporary.add(j+counter, c);
				}
			}
		}
		//incrementing the maximum distance a tile is placed to the right of the starting tile
		_maxX = _maxX+1;
		//storing the new index of the starting tile
		_startTile = _startTile + (_maxY - 71);
		//adjusting _grid to accommodate the new column
		_grid = new GridLayout(rows, columns+1);
		_gameplay.setLayout(_grid);
		//clearing the _list and _gameplay
		_list.clear();
		_gameplay.removeAll();
		//adding each JButton from temporary to _list and to _gameplay
		for(int i=0; i<temporary.size(); i++){
			JButton b = temporary.get(i);
			_gameplay.add(b);
			_list.add(temporary.get(i));
		} 
		//storing the tile that was just placed in _oldTile
		_oldTile = _newTile;
		_window.pack();
	}		
	
	/**
	 * This method updates the View if a tile is placed on a JButton located on the left most edge of the _gameplay JPanel. When it updates it, it adds
	 * another column of JButtons on the left side of the _gameplay JPanel. It also sets the image of the placed tile onto the JButton that was clicked.
	 * 
	 * @param t		Takes in a references to the Tile that is being placed
	 * @param x		Takes in the x-coordinate at which it was placed in the board
	 * @param y		takes in the y-coordinate at which it was placed in the board
	 */
	public void updateLeft(Tile t, int x, int y){
		int columns = _grid.getColumns();
		int rows = _grid.getRows();
		ArrayList<JButton> temporary = new ArrayList<>();
		int ytemp = _maxY;
		for(int i = 0; i<_list.size();i++){
			temporary.add(_list.get(i));
		}
		_button = temporary.get(_startTile + (x-71)+((71-y)*(columns)));
		_button.setIcon(_image);
		int counter = 0;
		for(int j = 0; j < _list.size(); j++){
			if(j%(columns) == 0){
				JButton a = new JButton();
				a.setPreferredSize(new Dimension(80,80));
				a.addActionListener(_event);
				_buttons.put(a,  new Point(_minX - 1, ytemp));
				ytemp--;
				if(j < _list.size()-counter){
					temporary.set(j+counter, a);
				}else{
					temporary.add(j+counter,a);
				}
				counter++;
				if(j+counter < _list.size()){
					JButton c = _list.get(j);
					temporary.set(j+counter, c);
				}else{
					if(j<_list.size()){
						JButton c = _list.get(j);
						temporary.add(j+counter, c);
					}
				}
			}else{
				if(j + counter < _list.size()){
					JButton c = _list.get(j);
					temporary.set(j+counter, c);
				}else{
					JButton c = _list.get(j);
					temporary.add(j+counter, c);
				}
			}
		}
		_minX = _minX-1;
		_startTile = _startTile + (_maxY - 70);
		_grid = new GridLayout(rows, columns+1);
		_gameplay.setLayout(_grid);
		_list.clear();
		_gameplay.removeAll();
		for(int i=0; i<temporary.size(); i++){
			JButton b = temporary.get(i);
			_gameplay.add(b);
			_list.add(temporary.get(i));
		} 
		_oldTile = _newTile;
		_window.pack();
	}
	
	/**
	 * This method updates the View if a tile is placed on a JButton located on the upper most edge of the _gameplay JPanel. When it updates it, it adds
	 * another row of JButtons at the top of the _gameplay JPanel. It also sets the image of the placed tile onto the JButton that was clicked.
	 * 
	 * @param t		Takes in a references to the Tile that is being placed
	 * @param x		Takes in the x-coordinate at which it was placed in the board
	 * @param y		takes in the y-coordinate at which it was placed in the board
	 */
	public void updateUp(Tile t, int x, int y){
		int columns = _grid.getColumns();
		int rows = _grid.getRows();
		ArrayList<JButton> temporary = new ArrayList<>();
		for(int i = 0; i < _list.size(); i++){
			temporary.add(_list.get(i));
		}
		_button = temporary.get(_startTile + (x-71)+((71-y)*(columns)));
		_button.setIcon(_image);    
		for(int j = 0; j < columns; j++){
			JButton a = new JButton();
			a.setPreferredSize(new Dimension(80,80));
			a.addActionListener(_event);
			_buttons.put(a, new Point(j+_minX, _maxY+1));
			temporary.add(j,a);
		}
		_maxY = _maxY + 1;
		_startTile = _startTile+columns;
		_grid = new GridLayout(rows+1, columns);
		_list.clear();
		_gameplay.removeAll();
		_gameplay.setLayout(_grid);
		for(int i = 0; i < temporary.size();i++){
			JButton b = temporary.get(i);
			_list.add(b);
			_gameplay.add(b);
		}
		_oldTile = _newTile;
		_window.pack();
	}
	
	/**
	 * This method updates the View if a tile is placed on a JButton located on the lowest edge of the _gameplay JPanel. When it updates it, it adds
	 * another row of JButtons at the bottom of the _gameplay JPanel. It also sets the image of the placed tile onto the JButton that was clicked.
	 * 
	 * @param t		Takes in a references to the Tile that is being placed
	 * @param x		Takes in the x-coordinate at which it was placed in the board
	 * @param y		takes in the y-coordinate at which it was placed in the board
	 */
	public void updateDown(Tile t, int x, int y){
		int columns = _grid.getColumns();
		int rows = _grid.getRows();
		ArrayList<JButton> temporary = new ArrayList<>();
		for(int i = 0; i < _list.size(); i++){
			temporary.add(_list.get(i));
		}
		_button = temporary.get(_startTile + (x-71)+((71-y)*(columns)));
		_button.setIcon(_image);    
		for(int j = 0; j < columns; j++){
			JButton a = new JButton();
			a.setPreferredSize(new Dimension(80,80));
			a.addActionListener(_event);
			_buttons.put(a, new Point(j+_minX, _minY-1));
			temporary.add(j+_list.size(),a);
		}
		_minY = _minY - 1;
		_grid = new GridLayout(rows+1, columns);
		_list.clear();
		_gameplay.removeAll();
		_gameplay.setLayout(_grid);
		for(int i = 0; i < temporary.size();i++){
			JButton b = temporary.get(i);
			_list.add(b);
			_gameplay.add(b);
		}
		_oldTile = _newTile;
		_window.pack();
	}
	
	/**
	 * This method updates the view if a tile is placed on a JButton that is not on any edge of _gameplay. It sets the image of the tile being placed
	 * onto the JButton that it is being placed onto.
	 * 
	 * @param t		Takes in a references to the Tile that is being placed
	 * @param x		Takes in the x-coordinate at which it was placed in the board
	 * @param y		takes in the y-coordinate at which it was placed in the board
	 */
	public void update(Tile t, int x, int y){
		int columns = _grid.getColumns();
		_button = _list.get((_startTile + (x-71))+((71-y)*(columns)));
		_button.setIcon(_image);
		_oldTile = _newTile;
		_window.pack();
	}
	
	/**
	 * This method updates the _turn JPanel. In the NORTH position of the BorderLayout of _turn is the player's name whose turn it currently is. In the CENTER position
	 * is the number of followers the current player has and in the EAST position is the score of the current player. The SOUTH position holds the _players JPanel that has
	 * a JPanel for each player which holds three JLabels, one for the player name, the followers the player has and their current score. All of these values are updated
	 * in this method at the beginning of each turn.
	 * 
	 * @param player	A reference to the name of the player whose turn it is currently
	 */
	public void updateTurn(String player){
		_player.setHorizontalAlignment(JLabel.CENTER);
		_player.setVerticalAlignment(JLabel.CENTER);
		_player.setText(player);
		_followers.setText("Followers: "+_board.getHash(player));
		_players.removeAll();
		for(int i = 0; i < _board.getPlayers().size(); i++){
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			JLabel label1 = new JLabel(""+_board.getPlayers().get(i));
			panel.add(label1);
			JLabel label2 = new JLabel("Followers: "+_board.getHash(_board.getPlayers().get(i)));
			panel.add(label2);
			JLabel label3 = new JLabel("Score: 0");
			panel.add(label3);
			_players.add(panel);
		}
		_window.pack();
	}
	/**
	 * This method picks a new tile from the ArrayList in TileTypes and places that tile's image on the JButton in the WEST position of _turns.
	 */
	public void nextTile() {
		_newTile = _board.pickTile();
		_image = _newTile.getImage();
		_nextTileButton.setIcon(_image);
		_window.pack();
	}
	
	/**
	 * This method returns the coordinates of the JButton in the Board that is stored in the HashMap buttons.
	 * 
	 * @param b		A JButton 
	 * @return		The coordinates of the JButton that was passed in
	 */
	public Point getButtonCoordinates(JButton b){
		return _buttons.get(b);
	}
	
	/**
	 * This method creates the JFrame that pops up when a player wants to place a follower. This JFrame holds a panel that holds 9 JButtons that
	 * are labeled with "city", "road", "field", "cloister" or "road end" that are arranged in order to resemble the arrangement of the areas on
	 * the tile that was just placed. These are determined by comparing the Strings stored in the sides of the tile.The player can click on one of
	 * these buttons to place a follower in that area of the tile. When the player clicks on a button it closes the JFrame.  
	 */
	public void followerFrame(){
		JFrame frame = new JFrame("Follower Placement");
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		PlaceFollower handler = new PlaceFollower(this, _button, frame, _board);
		_followerList = new ArrayList<JButton>();
		for(int i = 0; i < 9; i++){
			JButton b = new JButton();
			b.addActionListener(handler);
			_followerList.add(b);
			String[] s1 = _oldTile.accessSides(1);
			String[] s2 = _oldTile.accessSides(2);
			String[] s3 = _oldTile.accessSides(3);
			String[] s4 = _oldTile.accessSides(4);
			if(i==0){
				if(!(s1[0].equals(s4[2]))){
					b.setText("field");
				}else{
					b.setText(s1[0]);
				}
			}
			if(i==1){
				b.setText(s1[1]);
			}
			if(i==2){
				if(!(s1[2].equals(s2[0]))){
					b.setText("field");
				}else{
					b.setText(s1[2]);
				}
			}
			if(i==3){
				b.setText(s4[1]);
			}
			if(i==4){
				b.setText(_oldTile.accessCenter());
			}
			if(i==5){
				b.setText(s2[1]);
			}
			if(i==6){
				if(!(s3[2].equals(s4[0]))){
					b.setText("field");
				}else{
					b.setText(s3[2]);
				}
			}
			if(i==7){
				b.setText(s3[1]);
			}
			if(i==8){
				if(!(s2[2].equals(s3[0]))){
					b.setText("field");
				}else{
					b.setText(s2[2]);
				}
			}
			panel.add(b);
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * This method returns an int between 0 and 9, inclusive, that describes the position of the follower on the tile that is on a JButton.
	 * 
	 * @param b		The JButton on which a tile is placed
	 * @return		The int that represents the position of the follower
	 */
	public int getFollowerPosition(JButton b){
		return _followerList.indexOf(b);
	}
	
	/**
	 * This method returns the tile that can be placed next.
	 * 
	 * @return		The next tile that can be placed
	 */
	public Tile getTile(){
		return _newTile;
	}
	
	/**
	 * This method assigns the next tile that was picked from the ArrayList of tiles in TileTypes to the instance variable _newTile.
	 * 
	 * @param t		A reference to the next tile that can be placed
	 */
	public void updateTile(Tile t){
		_newTile = t;
	}
	
	/**
	 * This method returns the image of the Tile that can next be placed.
	 * 
	 * @return		The ImageIcon of the tile that can be placed next
	 */
	public ImageIcon getImage(){
		return _image;
	}
	
	/**
	 * This method takes in the image of the tile that was just picked and puts it on the button in the _turn JPanel
	 * 
	 * @param i		The ImageIcon of the tile that was just picked
	 */
	public void updateImage(ImageIcon i){
		_image = i;
		_nextTileButton.setIcon(_image);
	}
	
	/**
	 * This method creates a pop up at the end of the game which tells the players that the game is over. If a player closes this window, it terminates
	 * the program.
	 */
	public void gameOver(){
		JFrame window = new JFrame();
		window.setSize(400, 300);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel();
		label.setText("Game complete!");
		panel.add(label, BorderLayout.CENTER);
		window.add(panel);
		window.setVisible(true);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
