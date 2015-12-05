package code;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * This is the class which controls the turns during gameplay. It is called in the driver and 
 * contols all other code functionality. It implements Runnable, and uses a state machine in 
 * the run() method to determine what happens for each player's turn.
 * 
 * 
 */
public class PlayerTurns implements Runnable{
	
	/**
	 * Variables are created for the View and Board classes so that their methods can be accessed.
	 */
	private View _view;
	private Board _board;
	static String color;
	public static String[] colors= {"Red", "Yellow", "Green", "Blue", "Purple"};
	public static String player;

	public static int[] scores = new int[5];
	public static String firstline;

	private int _timesOfGame = 0;

	/**
	 * Variable for the ArrayList which holds the player names from the main method in the Driver
	 */
	private ArrayList<String> _players;
	
	/**
	 * Used inside of the state machine to reference the player whose turn is currently happening
	 */
	public static int _gameTurn;
	public static int gameTurnIndex;
	/**
	 * PlayerTurns constructor which initializes the instance variables and passes in a reference to
	 * the ArrayList<String> from the Driver.
	 * 
	 * @param a	This passes in the command line arguments for the player names which is in the form of
	 * 			an ArrayList.
	 */
	public PlayerTurns(ArrayList<String> a){
		_players = a;
		_board = new Board(_players);
		_view = new View(_board);
		_board.setView(_view); //makes sure the same View is used consistently throughout
		_view.setPlayersTurn(this);
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
}
