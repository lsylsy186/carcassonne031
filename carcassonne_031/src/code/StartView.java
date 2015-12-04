package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartView implements Runnable{
	private View _view;
	private Board _board;
	ArrayList<String> _players = new ArrayList<String>();
	private JButton _num1,_num2,_num3,_num4,num1,num2,num3,num4,_confirm;
	private JLabel _selectText,_typeText;
	private JTextField _name;
	private int _numCounts;
	private Font _font;
	private Color Purple = new Color(126,73,133);//Mauve:¡¡R124 G80 B157, Lavender: R166 G136 B177, Amethyst: R126 G73 B133, Purple: R146 G61 B146, Mineral violet: R197 G175 B192
	private Color Red = new Color(220,91,111);//Rose-red: R230 G28 B100, Camellia: R220 G91 B111, Ruby: R200 G8 B82, Carmine: R215 G0 B64
	private Color Blue = new Color(177,212,219);//Baby-blue:R177 G212, B219 Saxe-blue: R139 G176 B205, Aquamarine: R41 G131 B177, Sky-blue: R148 G198 B221
	private Color DarkGoldenrod = new Color(184,134,11);
	private Color MidnightBlue = new Color(25,25,112);
	private Color borderColor = new Color(205,51,51);
	private JFrame _startWindow;
	private JPanel _content;
	private JButton _start;
	private JButton _load;
	private String _acceptPlayerName;
	
	/**
	 * Variables are created for the View and Board classes so that their methods can be accessed.
	 */

	static String color;
	public static String[] colors= {"Red", "Yellow", "Green", "Blue", "Purple"};
	public static String player;

	public static int[] scores = new int[5];
	public static String firstline;

	private int _timesOfGame = 0;

	/**
	 * Variable for the ArrayList which holds the player names from the main method in the Driver
	 */
//	private ArrayList<String> _players;
	
	/**
	 * Used inside of the state machine to reference the player whose turn is currently happening
	 */
	public static int _gameTurn;
	public static int gameTurnIndex;
	
	
	public StartView(){
		_startWindow = new JFrame("Carcassonne");
		java.net.URL imgURL = getClass().getResource("/resources/startWindow3.png");
		ImageIcon icon = new ImageIcon(imgURL);
		JLabel temp = new JLabel();
		JLabel startText = new JLabel("New Game");
		JLabel loadText = new JLabel("Load Game");
		JLabel titleText = new JLabel("Carcassonne");
		
		_font = new Font("Segoe Print", Font.BOLD, 40);
		startText.setFont(_font);
		loadText.setFont(_font);
		startText.setForeground(new Color(54,54,54));
		loadText.setForeground(new Color(54,54,54));
		_font = new Font("hakuyoxingshu7000", Font.BOLD, 140);
		titleText.setFont(_font);
		titleText.setForeground(new Color(54,54,54));
		ImageIcon image = new ImageIcon(getClass().getResource("/resources/gameButton2.png"));
		_start = new JButton(image);
		_load = new JButton(image);
		JButton title = new JButton();
		_start.add(startText);
		_start.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				_content.remove(_start);
				_content.remove(_load);
				selectNumberOfPlayersView();
				_content.repaint();
			}
		});
		_load.add(loadText);
		_load.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
/**
 *  Add load method
 */
			}
		});
		title.add(titleText);
		_start.setBounds(525, 570, 240, 100);
		_load.setBounds(525, 370, 240, 100);
		title.setBounds(200,80,900,200);
		_start.setMargin(new Insets(0,0,0,0));
		_load.setMargin(new Insets(0,0,0,0));
		title.setContentAreaFilled(false);
		_start.setContentAreaFilled(false);
		_load.setContentAreaFilled(false);
		title.setBorderPainted(false);
		
		temp.setIcon(icon);	
		temp.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		_content = new JPanel();
		_content=(JPanel) _startWindow.getContentPane(); 
		_content.setOpaque(false);
		_content.setLayout(null);
		_startWindow.getLayeredPane().setLayout(null);
		_startWindow.getLayeredPane().add(temp, new Integer(Integer.MIN_VALUE));
		_startWindow.setSize(icon.getIconWidth(), icon.getIconHeight());
		_startWindow.setResizable(false);
		_content.add(_start);
		_content.add(_load);
		_content.add(title);
		_startWindow.setLocationRelativeTo(null);
		_startWindow.setVisible(true);
		_startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void selectNumberOfPlayersView(){
		_selectText = new JLabel("Select Number of Players:...");
		_font = new Font("Georgia",Font.PLAIN,50);
		_selectText.setFont(_font);
		_selectText.setForeground(Color.BLACK);
		ImageIcon image = new ImageIcon(getClass().getResource("/resources/gameButton2.png"));
		num1 = new JButton("2");
		num2 = new JButton("3");
		num3 = new JButton("4");
		num4 = new JButton("5");
		num1.setForeground(Color.BLACK);
		num2.setForeground(Color.BLACK);
		num3.setForeground(Color.BLACK);
		num4.setForeground(Color.BLACK);
		_font = new Font("Georgia",Font.PLAIN,50);
		num1.setFont(_font);
		num2.setFont(_font);
		num3.setFont(_font);
		num4.setFont(_font);
		_num1 = new JButton(image);
		_num2 = new JButton(image);
		_num3 = new JButton(image);
		_num4 = new JButton(image);

		num1.setContentAreaFilled(false);
		num2.setContentAreaFilled(false);
		num3.setContentAreaFilled(false);
		num4.setContentAreaFilled(false);
		num1.setBorderPainted(false);
		num2.setBorderPainted(false);
		num3.setBorderPainted(false);
		num4.setBorderPainted(false);
//		_num1.setBorder(BorderFactory.createRaisedBevelBorder());
//		_num2.setBorder(BorderFactory.createRaisedBevelBorder());
//		_num3.setBorder(BorderFactory.createRaisedBevelBorder());
//		_num4.setBorder(BorderFactory.createRaisedBevelBorder());
		_num1.setBackground(Color.ORANGE);
		_num2.setBackground(Color.ORANGE);
		_num3.setBackground(Color.orange);
		_num4.setBackground(Color.orange);
		
		num1.setBounds(350, 420, 100, 100);
		num2.setBounds(500, 420, 100, 100);
		num3.setBounds(650, 420, 100, 100);
		num4.setBounds(800, 420, 100, 100);
		_num1.setBounds(350, 500, 100, 100);
		_num2.setBounds(500, 500, 100, 100);
		_num3.setBounds(650, 500, 100, 100);
		_num4.setBounds(800, 500, 100, 100);
		_selectText.setBounds(350,350,900,100);
		
		_content.add(_selectText);
		_content.add(_num1);
		_content.add(_num2);
		_content.add(_num3);
		_content.add(_num4);
		_content.add(num1);
		_content.add(num2);
		_content.add(num3);
		_content.add(num4);
		
		_num1.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				removeAll1();
				typeInPlayersNameView(2);
				_content.repaint();
//				_startWindow.setVisible(false);
//				_window.setVisible(true);
			}
		});
		_num2.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				removeAll1();
				typeInPlayersNameView(3);
				_content.repaint();
//				_startWindow.setVisible(false);
//				_window.setVisible(true);
			}
		});
		_num3.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				removeAll1();
				typeInPlayersNameView(4);
				_content.repaint();
//				_startWindow.setVisible(false);
//				_window.setVisible(true);
			}
		});
		_num4.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				removeAll1();
				typeInPlayersNameView(5);
				_content.repaint();
//				_startWindow.setVisible(false);
//				_window.setVisible(true);
			}
		});
	}
	
	public void typeInPlayersNameView(int numOfPlayers){
		
		_numCounts = 1;
		_typeText = new JLabel("Type in player's name:...");
		_font = new Font("Georgia",Font.PLAIN,50);
		_typeText.setFont(_font);
		_confirm = new JButton("OK");
		_confirm.setBackground(DarkGoldenrod);
		_confirm.setForeground(Color.white);
		_confirm.setBorder(BorderFactory.createRaisedBevelBorder());
		_font = new Font("Georgia",Font.BOLD,25);
		_confirm.setFont(_font);
		_confirm.setBounds(930,450,80,80);
		_typeText.setForeground(Color.BLACK);
		_name=new JTextField(30);
		_name.setBounds(300, 450, 600, 80);
		_font = new Font("Georgia",Font.PLAIN,30);
		_name.setFont(_font);
		
		_typeText.setBounds(300,350,900,100);
		_content.add(_typeText);
		_content.add(_name);
		_content.add(_confirm);
		
		_confirm.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				if(_numCounts >= numOfPlayers){
					_board = new Board(_players);
					_view = new View(_board);
					_board.setView(_view);
					//_view.setStartView(this);
					
					run();
					_startWindow.setVisible(false);
					
				}
						_acceptPlayerName = _name.getText();
						//System.out.println(_acceptPlayerName);
						_players.add(_acceptPlayerName);
						System.out.println(_players.get(_numCounts-1));
						_numCounts++;
						_name.setText(" ");
			}
		});
		
	}
	
	public void removeAll1(){
		_content.remove(_num1);
		_content.remove(_num2);
		_content.remove(_num3);
		_content.remove(_num4);
		_content.remove(num1);
		_content.remove(num2);
		_content.remove(num3);
		_content.remove(num4);
		_content.remove(_selectText);
	}
	
	/**
	 * This method is created as a method of the implemented class Runnable. Consists of a state machine which
	 * changes state when a part of a players turn has been completed. The state machine is held within a while
	 * loop which exits when there are no longer any tiles left in the ArrayList<Tile> created in the TileTypes
	 * class.
	 */
	@Override
	public void run(){
		int state = 0; //initializes the state to 0

		gameTurnIndex = 0; //int used to determine the player for the turn

		_view.setPressed(false);
		
		while(_board.getTileList()>=0) {
			switch(state) {
			case 0:
				//gets the player name and places it on the view

				_gameTurn = gameTurnIndex %_players.size();
				player = _players.get(_gameTurn);
				//first line for saving 
				firstline = "";
				firstline = firstline + "[" + _players.get(_gameTurn) +"," + colors[_gameTurn] + "," + scores[_gameTurn] + "]";
				for(int i = 1 ; i < _players.size(); i++){
					int index = (_gameTurn +i) % _players.size(); 
					firstline =firstline + "," + "[" + _players.get(index) +"," + colors[index] + "," + scores[index] + "]";
				}
				color = colors[_gameTurn];
				

				 //increments the player number
				
				_view.updateTurn(player);
				
				//displays the tile which the player can place
				_view.nextTile();
				
				state = 1;
				break;
			case 1:
				View.saveMenuItem.setEnabled(true);
				
				state = 3;
				break;
			
			case 3:
				//does not move on until a tile is placed legally in the board
				if(!_board.tilePlaced()){
					
					state = 3;
				}else{
					View.saveMenuItem.setEnabled(false);
					state = 4;
				}
				break;
			case 4:
				//checks that the player has at least 1 follower, if not returns to case 0
				//asks user if they want to place a follower on the board
				//'yes' --> the state changes so follower code can run
				//'no' --> returns to case 0 for next turn
				if(_board.getHash(_players.get(_gameTurn)) > 0){
					if (JOptionPane.showConfirmDialog(null, "Would you like to place a follower?") == 0){
						state = 5;
					} else {

						state = 7;

					}
				}else{

						state = 7;

				}
					break;
			case 5:
				//shows player where they can place follower and waits for JButton click
				_view.followerFrame();
				_board.placeFollower(_gameTurn);
				state  = 6;
				break;
			case 6:
				if(_view.getPressed()){

					_view.setPressed(false);
					state = 7;
				}else{
				state = 6;
				}
				break;
			case 7:
				calculateScores();
				
				gameTurnIndex++;
				state = 0;
				break;
			}
		}
		
		//once the while exits after all tiles placed gameOver() tells the player game is done
		_view.gameOver();
	}


	private void calculateScores() {
		scores[_gameTurn] = _board.getScore();
	}

	public int getTimesOfGame(){
		return gameTurnIndex + 1;

	}
	public void setView(View v){
		_view = v;
	}
	public View getView(){
		return _view;
	}
	public Board getBoard(){
		return _board;
	}
	public void setBoard(Board b){
		_board = b;
	}
}
