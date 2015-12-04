package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

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
	private JFrame _startWindow;
	/**
	 * Variables that hold references to the panel that hold the Tile buttons, and the panel that hold the turn information
	 */
	private GameboardView _gameplay;
	private JPanel _turn;
	/**
	 * Variables that hold references to the panel that hold the name, score and followers of currentPlayer
	 */
	private JPanel _allPlayers;
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
	private JFrame _followerFrame;
	private Boolean pressed;
	private Boolean savePressed;
	
	private Font _font;
	private Color Purple = new Color(126,73,133);//Mauve:¡¡R124 G80 B157, Lavender: R166 G136 B177, Amethyst: R126 G73 B133, Purple: R146 G61 B146, Mineral violet: R197 G175 B192
	private Color Red = new Color(220,91,111);//Rose-red: R230 G28 B100, Camellia: R220 G91 B111, Ruby: R200 G8 B82, Carmine: R215 G0 B64
	private Color Blue = new Color(177,212,219);//Baby-blue:R177 G212, B219 Saxe-blue: R139 G176 B205, Aquamarine: R41 G131 B177, Sky-blue: R148 G198 B221
	private Color DarkGoldenrod = new Color(184,134,11);
	private Color MidnightBlue = new Color(25,25,112);
	private Color borderColor = new Color(205,51,51);
	
	private Color[] _colors = {Red, Color.YELLOW, Color.GREEN, Blue, Purple};
	
	private PlayerTurns _playerTurns;
	public static JMenuItem newMenuItem;
	public static JMenuItem saveMenuItem;
	public static JMenuItem loadMenuItem;
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
		_startWindow = new JFrame("Carcassonne");
		
		JPanel whole = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		//GridBagConstraints c = new GridBagConstraints();
		whole.setLayout(gridbag);
		
		_gameplay = new GameboardView();
		_grid = new GridLayout(3,3);
		_gameplay.setLayout(_grid);
		_gameplay.setBorder(new LineBorder(Color.DARK_GRAY, 5));
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
				a.setOpaque(false);
				a.setBackground(Color.CYAN); 
				a.setBorder(BorderFactory.createRaisedBevelBorder());
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
		_turn.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		_allPlayers = new JPanel();
		_allPlayers.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		BorderLayout border = new BorderLayout();
		border.setHgap(20);
		_turn.setLayout(gridbag);
		
		_allPlayers.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		_newTile = _board.pickTile();
		_image = _newTile.getImage();
		_nextTileButton = new JButton(_image);
		
		_nextTileButton.setPreferredSize(new Dimension(120,120));
		_nextTileButton.addActionListener(new Rotate(this, _nextTileButton));
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		gbc.anchor = GridBagConstraints.CENTER;
		Insets titleInsets = new Insets(3, 10, 6, 10) ; // top, left, bottom, right
		gbc.insets = titleInsets;
		
		_turn.add(_nextTileButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
//		gbc.ipady = 3;
//		gbc.ipadx = 30;
		gbc.anchor = GridBagConstraints.CENTER;
		titleInsets = new Insets(3, 20, 1, 20) ; // top, left, bottom, right
		gbc.insets = titleInsets;
		_font = new Font("Segoe Print",Font.BOLD,16);
		JLabel a = new JLabel("CURRENT TILE");
		a.setForeground(DarkGoldenrod);
		a.setFont(_font);
		_turn.add(a,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		a = new JLabel("Click tile to rotate.");
		_font = new Font("Georgia",Font.PLAIN,12);
		a.setFont(_font);
		a.setForeground(Color.BLACK);
		titleInsets = new Insets(2, 1, 5, 1) ; // top, left, bottom, right
		gbc.insets = titleInsets;
		_turn.add(a, gbc);

		ArrayList<String> playerList = _board.getPlayers();
		//_players = new JPanel();
		GridLayout grid = new GridLayout(1, playerList.size());
		grid.setHgap(10);
		JLabel gameboardTitle = new JLabel("GAME BOARD");
		_font = new Font("Segoe Print", Font.BOLD, 20);
		gameboardTitle.setFont(_font);
		gameboardTitle.setForeground(MidnightBlue);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 0;
		gbc.ipadx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.weightx = 1;
		gbc.weighty = 1;
		titleInsets = new Insets(20, 30, 10, 30) ; // top, left, bottom, right
		gbc.insets = titleInsets;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		whole.add(gameboardTitle,gbc);
		
		gbc.ipady = 0;
		gbc.ipadx = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.NONE;
		titleInsets = new Insets(5, 30, 30, 30) ; // top, left, bottom, right
		gbc.insets = titleInsets;
		whole.add(_gameplay,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		titleInsets = new Insets(0, 5, 5, 40) ; // top, left, bottom, right
		gbc.insets = titleInsets;
		whole.add(_turn,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		//gbc.anchor = GridBagConstraints.EAST;
		titleInsets = new Insets(5, 30, 20, 30) ; // top, left, bottom, right
		gbc.insets = titleInsets;
		whole.add(_allPlayers,gbc);
		
		//start window initialization
//		java.net.URL imgURL = getClass().getResource("/resources/startWindow3.png");
//		ImageIcon icon = new ImageIcon(imgURL);
//		JLabel temp = new JLabel();
//		JLabel startText = new JLabel("New Game");
//		JLabel loadText = new JLabel("Load Game");
//		JLabel titleText = new JLabel("Carcassonne");
//		
//		_font = new Font("Segoe Print", Font.BOLD, 40);
//		startText.setFont(_font);
//		loadText.setFont(_font);
//		_font = new Font("hakuyoxingshu7000", Font.BOLD, 140);
//		titleText.setFont(_font);
//		
//		ImageIcon image = new ImageIcon(getClass().getResource("/resources/gameButton2.png"));
//		JButton start = new JButton(image);
//		JButton load = new JButton(image);
//		JButton title = new JButton();
//		start.add(startText);
//		start.addActionListener(new ActionListener(){
//			@Override public void actionPerformed(ActionEvent e){
//				_startWindow.setVisible(false);
//				_window.setVisible(true);
//			}
//		});
//		load.add(loadText);
//		load.addActionListener(new ActionListener(){
//			@Override public void actionPerformed(ActionEvent e){
///**
// *  Add load method
// */
//			}
//		});
//		title.add(titleText);
//		start.setBounds(525, 570, 240, 100);
//		load.setBounds(525, 370, 240, 100);
//		title.setBounds(200,80,900,200);
//		start.setMargin(new Insets(0,0,0,0));
//		load.setMargin(new Insets(0,0,0,0));
//		title.setContentAreaFilled(false);
//		start.setContentAreaFilled(false);
//		load.setContentAreaFilled(false);
//		title.setBorderPainted(false);
//		
//		temp.setIcon(icon);	
//		temp.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//		JPanel content = new JPanel();
//		content=(JPanel) _startWindow.getContentPane(); 
//		content.setOpaque(false);
//		content.setLayout(null);
//		_startWindow.getLayeredPane().setLayout(null);
//		_startWindow.getLayeredPane().add(temp, new Integer(Integer.MIN_VALUE));
//		_startWindow.setSize(icon.getIconWidth(), icon.getIconHeight());
//		_startWindow.setResizable(false);
//		content.add(start);
//		content.add(load);
//		content.add(title);
//		_startWindow.setLocationRelativeTo(null);
//		_startWindow.setVisible(true);
//		_startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		newMenuItem = new JMenuItem("New");
		saveMenuItem = new JMenuItem("Save");
		loadMenuItem = new JMenuItem("load");
		//add action...
		saveMenuItem.addActionListener(new SaveMenuListner());
		//
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		_window.add(whole);
		_window.setJMenuBar(menuBar);
		_window.pack();
		_window.setLocationRelativeTo(null);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		_followerFrame = new JFrame("Follower Placement");
		_followerFrame.setLocationRelativeTo(null);	
		_followerFrame.pack();
		_followerFrame.setVisible(false);
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
//		_player.setHorizontalAlignment(JLabel.CENTER);
//		_player.setVerticalAlignment(JLabel.CENTER);
//		_player.setText(player);
		System.out.println("Player:  "+ player);
		setBColorOfCurrentTile(_playerTurns.getTimesOfGame());
		_allPlayers.removeAll();
		GridBagConstraints gbt = new GridBagConstraints();
		for(int i = 0; i < _board.getPlayers().size(); i++){
			JButton button = new JButton();
			button.setLayout(new BoxLayout(button, BoxLayout.Y_AXIS));
//			JPanel panel = new JPanel();
//			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			JLabel label1 = new JLabel(""+_board.getPlayers().get(i));
			button.add(label1);
			JLabel label2 = new JLabel("Followers: "+_board.getHash(_board.getPlayers().get(i)));
			button.add(label2);
			JLabel label3 = new JLabel("Score: 0");
			button.add(label3);
			button.setBackground(_colors[i]); 
			button.setBorderPainted(false);
			
			button.setBorder(BorderFactory.createLineBorder(borderColor,3));
			if(i == (_playerTurns.getTimesOfGame()-1) % _board.getPlayers().size()){
				button.setBorderPainted(true);
			}
//			button.setBorder(thickBorder);
			
			gbt.gridx = i;
			gbt.gridy = 1;
			gbt.weightx = 1;
			gbt.weighty = 1;
			gbt.gridwidth = 1;
			gbt.gridheight = 1;
			Insets titleInsets = new Insets(2, 2, 2, 2) ; // top, left, bottom, right
			gbt.insets = titleInsets;
			gbt.fill = GridBagConstraints.HORIZONTAL;
			gbt.anchor = GridBagConstraints.WEST;

			_allPlayers.add(button,gbt);
		}
		gbt.gridx = 0;
		gbt.gridy = 0;
		gbt.weightx = 1;
		gbt.weighty = 1;
		gbt.gridwidth = 1;
		gbt.gridheight = 1;
		//gbt.fill = GridBagConstraints.HORIZONTAL;
		gbt.anchor = GridBagConstraints.WEST;
		Insets titleInsets = new Insets(5, 1, 1, 1) ; // top, left, bottom, right
		gbt.insets = titleInsets;
		JLabel titleOfPlayersArea1 = new JLabel("Carcassonne-");
		JLabel titleOfPlayersArea2 = new JLabel("Players : ");
		_font = new Font("Segoe Print",Font.BOLD,16);
		titleOfPlayersArea1.setFont(_font);
		titleOfPlayersArea2.setFont(_font);
		_allPlayers.add(titleOfPlayersArea1,gbt);
		gbt.gridx = 1;
		gbt.gridy = 0;
		_allPlayers.add(titleOfPlayersArea2,gbt);
		_window.pack();
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
				a.setOpaque(false);
				a.setBackground(Color.CYAN); 
				a.setBorder(BorderFactory.createRaisedBevelBorder());
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
				a.setOpaque(false);
				a.setBackground(Color.CYAN); 
				a.setBorder(BorderFactory.createRaisedBevelBorder());
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
			a.setOpaque(false);
			a.setBackground(Color.CYAN); 
			a.setBorder(BorderFactory.createRaisedBevelBorder());
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
			a.setOpaque(false);
			a.setBackground(Color.CYAN); 
			a.setBorder(BorderFactory.createRaisedBevelBorder());
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
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		PlaceFollower handler = new PlaceFollower(this, _button, _followerFrame, _board);
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
		_followerFrame.getContentPane().removeAll();
		_followerFrame.add(panel);
		_followerFrame.pack();
		_followerFrame.setVisible(true);
		
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
	 * This method returns a String that defines where the follower is being placed.
	 * @param b 	The JButton on which the user clicks.
	 * 
	 * @return  	The text at the location of the button click. 
	 */
	public String getFollowerType(JButton b) {
		return b.getText();
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
	
	public void setBColorOfCurrentTile(int i){
		i = i %_board.getPlayers().size();
		if(_board.getPlayers().size() == 2){
			switch(i){
			case 0:_nextTileButton.setBackground(_colors[1]);break;
			case 1:_nextTileButton.setBackground(_colors[0]);break;
			}
		}
		if(_board.getPlayers().size() == 3){
			switch(i){
			case 0:_nextTileButton.setBackground(_colors[2]);break;
			case 1:_nextTileButton.setBackground(_colors[0]);break;
			case 2:_nextTileButton.setBackground(_colors[1]);break;
			}
		}
		if(_board.getPlayers().size() == 4){
			switch(i){
			case 0:_nextTileButton.setBackground(_colors[3]);break;
			case 1:_nextTileButton.setBackground(_colors[0]);break;
			case 2:_nextTileButton.setBackground(_colors[1]);break;
			case 3:_nextTileButton.setBackground(_colors[2]);break;
			}
		}
		if(_board.getPlayers().size() == 5){
			switch(i){
			case 0:_nextTileButton.setBackground(_colors[4]);break;
			case 1:_nextTileButton.setBackground(_colors[0]);break;
			case 2:_nextTileButton.setBackground(_colors[1]);break;
			case 3:_nextTileButton.setBackground(_colors[2]);break;
			case 4:_nextTileButton.setBackground(_colors[3]);break;
		}
		}
		
		
	}
	public void setPressed(Boolean b){
		pressed = b;
	}
	
	public Boolean getPressed(){
		return pressed;
	}
	public void setPlayersTurn(PlayerTurns a){
		_playerTurns = a;
	}

	public boolean getSavePressed() {
		// TODO Auto-generated method stub
		return savePressed;
	}

	public void setSavePressed(Boolean savePressed) {
		this.savePressed = savePressed;
	}
	
	public class SaveMenuListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			_board.saveCurrentState();
			setSavePressed(true);
		}
		
	}
}
